package com.gdg.boss.presentation

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.gdg.boss.R
import com.gdg.boss.domain.Product
import com.gdg.boss.presentation.theme.Background
import com.gdg.boss.presentation.theme.GDGTheme
import com.gdg.boss.presentation.theme.White
import dagger.hilt.android.AndroidEntryPoint
import org.w3c.dom.Text

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val product: MutableList<Product> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GDGTheme {
                MainScreen(product.apply {
                    add(Product("Used Bicycle", "100,000", "https://picsum.photos"))
                    add(Product("Laptop for Sale", "200,000", "https://picsum.photos"))
                    add(Product("Vintage Watch", "300,000", "https://picsum.photos"))
                    add(Product("Desk Chair", "400,000", "https://picsum.photos"))
                    add(Product("Smartphone", "500,000", "https://picsum.photos"))
                    add(Product("Bookshelf", "600,000", "https://picsum.photos"))
                    add(Product("Electric Guitar", "700,000", "\"https://picsum.photos\""))
                })
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(product: MutableList<Product>) {
    Scaffold(
        topBar = { TopToolBar() },
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        ProductList(
            modifier = Modifier.padding(paddingValues),
            productList = product
        )
    }
}


@Composable
private fun TopToolBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(color = White),
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .height(36.dp)
                    .width(36.dp)
                    .padding(start = 16.dp, top = 10.dp, bottom = 10.dp),
                painter = painterResource(id = R.drawable.ic_gdg_logo),
                contentDescription = "topBar logo"
            )
        }


    }
}

@Composable
private fun ProductListItem(item: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .width(108.dp),
                model = "https://picsum.photos",
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "sample Image"
            )

            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
            ) {
                Text(
                    text = item.title,
                    fontSize = 16.sp
                )
                Text(
                    modifier = Modifier.padding(
                        top = 32.dp
                    ),
                    text = item.description,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun ProductList(
    modifier: Modifier = Modifier,
    productList: List<Product>
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Background),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(
            items = productList,
            itemContent = { ProductListItem(item = it) }
        )
    }
}

private fun AddProductList(product: MutableList<Product>) {
    product.apply {
        add(Product("Used Bicycle", "100,000", "https://picsum.photos"))
        add(Product("Laptop for Sale", "200,000", "https://picsum.photos"))
        add(Product("Vintage Watch", "300,000", "https://picsum.photos"))
        add(Product("Desk Chair", "400,000", "https://picsum.photos"))
        add(Product("Smartphone", "500,000", "https://picsum.photos"))
        add(Product("Bookshelf", "600,000", "https://picsum.photos"))
        add(Product("Electric Guitar", "700,000", "\"https://picsum.photos\""))
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    val product: MutableList<Product> = mutableListOf()
    AddProductList(product)
    GDGTheme {
        MainScreen(product = product)
    }
}