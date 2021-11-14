package com.tsdev.myapplication.ui.navi

import android.util.Log
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable

@Composable
fun MyBottomNavigation() {
    BottomNavigation {
        IconButton(
            onClick = {
                Log.e("click", "favorite")
            }

        ) {
            Icon(Icons.Filled.Favorite, contentDescription = null)
        }
        IconButton(
            onClick = {
                Log.e("click", "favorite")
            }

        ) {
            Icon(Icons.Filled.Add, contentDescription = null)
        }
        IconButton(
            onClick = {
                Log.e("click", "favorite")
            }

        ) {
            Icon(Icons.Filled.ArrowBack, contentDescription = null)
        }
    }
}