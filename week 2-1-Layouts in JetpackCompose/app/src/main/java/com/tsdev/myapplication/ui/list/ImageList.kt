package com.tsdev.myapplication.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import kotlinx.coroutines.launch

@ExperimentalCoilApi
@Composable
fun ImageList() {
    val imageSize = 100
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberLazyListState()

    Column {
        Row {
            Button(onClick = {
                coroutineScope.launch {
                    scrollState.scrollToItem(0)
                }
            }) {
                Text(text = "Scroll On Top")
            }
            Button(onClick = {
                coroutineScope.launch {
                    scrollState.scrollToItem(imageSize - 1)
                }
            }) {
                Text(text = "Scroll On Bottom")
            }
        }
        LazyColumn(state = scrollState) {
            items(imageSize) {
                ImageListItem(index = it)
            }
        }
    }

}

@ExperimentalCoilApi
@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {

        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text("Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}