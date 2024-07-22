package com.gdg.boss.presentation.registration

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdg.boss.R
import com.gdg.boss.presentation.ui.theme.GdgbossTheme

class ProductRegistrationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GdgbossTheme {
                RegistrationScreen()
            }
        }
    }
}

@Preview
@Composable
fun RegistrationScreen() {
    ProductRegistrationScaffold()

}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductRegistrationScaffold() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "내 물건 팔기") },
                navigationIcon = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_back),
                            contentDescription = "뒤로가기"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            item {
                GalleryContainer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 16.dp,
                            bottom = 16.dp
                        )
                )
            }
            item {
                TitleContainer()
            }
            item {
                ExplainContainer()
            }
            item {
                PriceContainer()
            }
            item {
                AdditionalInfo()
            }
            item {
                AmountContainer()
            }
        }
    }
}


@Composable
fun GalleryContainer(modifier: Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        item {
            Button(
                onClick = { /*TODO*/ },
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFC8C8C8)
                ),
                modifier = Modifier
                    .width(76.dp)
                    .height(76.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                    )
                    Text(
                        text = "0/10",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF939090),
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleContainer() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "제목",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
        )
        Spacer(modifier = Modifier.height(12.dp))
        var text = remember {
            mutableStateOf(TextFieldValue(""))
        }
        OutlinedTextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExplainContainer(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ){
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "설명",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
        )
        Spacer(modifier = Modifier.height(12.dp))

        var text by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(12.dp))
                .background(Color.White, shape = RoundedCornerShape(12.dp))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                BasicTextField(
                    value = text,
                    onValueChange = {
                            text = it
                    },
                    textStyle = TextStyle(fontSize = 18.sp),
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(Color.Transparent) // 배경 투명
                        .padding(16.dp) // 내부 여백 추가
                )

                Text(
                    text = "0/2000",
                    style = TextStyle(fontSize = 14.sp, color = Color.Gray),
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PriceContainer(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ){
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "가격",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
        )

        Spacer(modifier = Modifier.height(12.dp))

        var text = remember {
            mutableStateOf(TextFieldValue(""))
        }

        OutlinedTextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )
    }
}

@Composable
fun AdditionalInfo(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "추가정보",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
        )
        Spacer(modifier = Modifier.height(12.dp))

        Row {
            Text(
                text = "직거래",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
            )

            Spacer(modifier = Modifier.width(100.dp))

            RoundCheckBox()
            Text(
                text = "가능",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
            )

            RoundCheckBox()
            Text(
                text = "불가능",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
            )
        }
    }
}

@Composable
fun RoundCheckBox() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(24.dp) // 체크박스 크기
            .border(2.dp, Color.Gray, CircleShape)
    ) {
    }
}

@Composable
fun AmountContainer(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "수량",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
        )


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GdgbossTheme {
        RegistrationScreen()
    }
}