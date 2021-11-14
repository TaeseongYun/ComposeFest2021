package com.tsdev.myapplication.ui.appbar

import android.util.Log
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable

@Composable
fun MyAppBar() {
    TopAppBar(
        title = {
            Text(text = "Code Lab 2-1")
        },
        actions = {
            IconButton(
                onClick = {
                    Log.e("click", "favorite")
                }

            ) {
                Icon(Icons.Filled.Favorite, contentDescription = null)
            }
        }

    )
}
