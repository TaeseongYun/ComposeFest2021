package com.tsdev.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toolbar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.tsdev.myapplication.ui.appbar.MyAppBar
import com.tsdev.myapplication.ui.custom.MyColumn
import com.tsdev.myapplication.ui.custom.firstBaselineToTop
import com.tsdev.myapplication.ui.list.ImageList
import com.tsdev.myapplication.ui.navi.MyBottomNavigation
import com.tsdev.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

@ExperimentalCoilApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Scaffold(
                    topBar = { MyAppBar() },
                    bottomBar = { MyBottomNavigation() }
                ) { BodyContent() }
                // A surface container using the 'background' color from the theme
            }
        }
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    MyColumn(modifier.padding(8.dp)) {
        Text("MyOwnColumn")
        Text("places items")
        Text("vertically.")
        Text("We've done it by hand!")
    }
}

/***
 * provides -> 중위함수
 * compositionLocalOf -> 무엇 ?? LocalContentAlpha
 ***/
@Composable
fun PhotographerCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp)
    ) {
        Text("Alfred Sisley", fontWeight = FontWeight.Bold)
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(text = "3 minutes ago", style = MaterialTheme.typography.body2)
        }
    }
}

/***
 * Modifier -> 함수 체이닝 효과
 ***/
@Composable
fun SurfaceCardView(modifier: Modifier = Modifier) {
    Row(
        modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colors.surface)
            .clickable { }
            .padding(16.dp)
    ) {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            //todo Image
        }
        PhotographerCard()
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
    }
}