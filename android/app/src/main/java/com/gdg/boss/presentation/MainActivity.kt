package com.gdg.boss.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.gdg.boss.R
import dagger.hilt.android.AndroidEntryPoint
import java.text.DecimalFormat

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DetailScreen()
        }
    }
}

@Composable
fun DetailScreen() {
    val scrollState = rememberScrollState()
    val title = "유모차 나눔 합니다"
    val myFormatter = DecimalFormat("###,###")
    val price = 100000
    val directTransaction = false
    val itemCount = 1
    val contents = "안녕하세요. 안녕. 안녕. 유모차 나눔 합니다. 아아아아아아ㅏ아아아아아아아아아아ㅏㅇㅇ아ㅏ아아아아" +
            "ㅇ아아ㅏ앙아아ㅏ아아아앙ㅇ이이이ㅣ이잉이잉아아아아아아ㅏ아아아아아아아아아아아아앙아ㅏ아아아아아아" +
            "ㅇ아아ㅏ아아아아아아아ㅏ아아아아ㅏ아아아"
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.84f)
            .verticalScroll(scrollState)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
            contentDescription = "back",
            modifier = Modifier.padding(
                vertical = 20.dp,
                horizontal = 15.dp
            )
        )

        AsyncImage(
            model = "https://picsum.photos/200",
            placeholder = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Img",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            title,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 15.dp, top = 17.5.dp)
        )

        Text(
            myFormatter.format(price) + "원",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 15.dp, top = 10.dp)
        )

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp, bottom = 20.dp)
        ) {
            drawLine(
                color = Color.LightGray,
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                strokeWidth = 25f
            )
        }

        Row {
            Text(
                text = "직거래",
                modifier = Modifier.padding(start = 15.dp),
                fontSize = 16.sp
            )
            Text(
                text = if (directTransaction) "가능" else "불가",
                modifier = Modifier.padding(start = 20.dp),
                fontSize = 16.sp
            )
        }

        Row(modifier = Modifier.padding(top = 10.dp)) {
            Text(
                text = "수량",
                modifier = Modifier.padding(start = 15.dp),
                fontSize = 16.sp
            )
            Text(
                text = "${itemCount}개",
                modifier = Modifier.padding(start = 35.dp),
                fontSize = 16.sp
            )
        }

        Text(
            text = contents,
            modifier = Modifier.padding(top = 20.dp, start = 15.dp),
            fontSize = 16.sp
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.16f) // 원하는 높이 설정
                .drawBehind {
                    drawLine(color = Color.LightGray,
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = 2.dp.toPx()
                    )
                }
        ) {
            TextButton(onClick = { /*TODO*/ },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 10.dp)
                    .fillMaxHeight(0.5f),
                colors = ButtonDefaults.buttonColors(Color.Red)
            ) {
                Text(text = "수정하기",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold)
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    DetailScreen()
}