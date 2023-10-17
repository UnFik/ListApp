package com.example.uts_mobcom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uts_mobcom.ui.theme.UTS_MobcomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UTS_MobcomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        HeaderTitle(title = "Aplikasi List Mata Kuliah")
                        LazyVerticalGridDemo()
                    }
                }
            }
        }
    }
}

@Composable
fun LazyVerticalGridDemo(){
    val list = (1..10).map { it.toString() }
    val matkul = listOf(
        "Animasi Komputer", "Pengantar Kecerdasan Buatan", "Komputer Grafik", "Teori Bahasa Automata", "Informasi Manajemen", "Mobile Computing", "Pengajaran Berbantuan", "Pengolahan Citra", "Kewirausahaan", "E-commerce & Startup"
    ).map { it.toString() }
    val sks = listOf(
        3,3,2,3,2,3,2,2,3,2
    ).map {it.toString()}

    LazyVerticalGrid(
        columns = GridCells.Adaptive(200.dp),

        // content padding
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 10.dp
        ),
        content = {
            items(list.size) { index ->
                Card(
                    modifier = Modifier
                        .padding(2.dp)
                        .height(80.dp)
                        .fillMaxWidth()
                        .border(1.dp, Color.Black, RoundedCornerShape(10.dp)),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                    ),
                ) {
                    LazyRow(modifier = Modifier.fillMaxSize()){
                        item {
                            Image(
                                painter = painterResource(R.drawable.unj),
                                contentDescription = "UNJ LOGO",
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        item {
                            LazyColumn(modifier = Modifier.fillMaxHeight()){
                                item {
                                    Text(
                                        text = matkul[index],
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp,
                                        color = Color.Black,
                                        textAlign = TextAlign.Start,
                                        lineHeight = 15.sp,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 10.dp, start = 10.dp)
                                    )
                                }
                                item {
                                    Text(
                                        text = "SKS : " + sks[index],
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp,
                                        color = Color.Black,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderTitle(title: String){
    TopAppBar(title = {
        Text(title)
    })
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UTS_MobcomTheme {
        Column {
            HeaderTitle(title = "Aplikasi List Mata Kuliah")
            LazyVerticalGridDemo()
        }
    }
}