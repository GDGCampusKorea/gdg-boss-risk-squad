package com.gdg_market.app.product.controller;

import com.gdg_market.app.bible.exception.InvalidRequestException;
import com.gdg_market.app.bible.exception.NotFoundException;
import com.gdg_market.app.bible.exception.TooManyRequestsException;
import com.gdg_market.app.product.dto.ProductRequestDTO;
import com.gdg_market.app.product.dto.ProductResponseDTO;
import com.gdg_market.app.product.model.Product;
import com.gdg_market.app.product.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    // 토큰 개수를 업데이트
    // DB를 트래킹

    // 빈은 멀티스레드 -> 내가 뭔가 잘못하고 있다면 CS를 처리하고 있다.
    // db는 커넥션 하나를 가지고
    // lru 캐시 가장 최근의 몇건에 대해선 메모리를 관리한다.


    private final ProductService productService;
    private final ProductRateLimitStorage productRateLimitStorage;


    @GetMapping("")
    public ResponseEntity<Page<ProductResponseDTO>> getAllProducts(Pageable pageable) {
        Page<Product> products = productService.getAllProducts(pageable);
        Page<ProductResponseDTO> responseDTOs = products.map(this::convertToResponseDTO);
        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ProductResponseDTO> createProduct(HttpServletRequest servletRequest, @RequestBody ProductRequestDTO productRequestDTO) {

        Long userId = 1L; // 세션으로부터 가져온다고 설정
        productRateLimitStorage.validateRateLimitAvailable(userId);
        Product product = productService.createProduct(productRequestDTO);
        ProductResponseDTO responseDTO = convertToResponseDTO(product);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        ProductResponseDTO responseDTO = convertToResponseDTO(product);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id, @RequestBody ProductRequestDTO productRequestDTO) {
        Product product = productService.updateProduct(id, productRequestDTO);
        ProductResponseDTO responseDTO = convertToResponseDTO(product);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<String> handleInvalidRequestException(InvalidRequestException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TooManyRequestsException.class)
    public ResponseEntity<String> handleTooManyReqeustRequestException(TooManyRequestsException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.TOO_MANY_REQUESTS);
    }

    private ProductResponseDTO convertToResponseDTO(Product product) {
        ProductResponseDTO responseDTO = new ProductResponseDTO();

        responseDTO.setId(product.getId());
        responseDTO.setName(product.getName());
        responseDTO.setImageURL(product.getImageURL());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setDescription(product.getDescription());

        responseDTO.setCreatedAt(product.getCreatedAt());
        responseDTO.setModifiedAt(product.getModifiedAt());

        return responseDTO;
    }
}
