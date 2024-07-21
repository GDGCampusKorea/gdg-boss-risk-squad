package com.gdg_market.app.config;

import com.gdg_market.app.product.interceptor.ProductInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new ProductInterceptor())
                .order(1)
                .addPathPatterns("/api/products");
    }
}
