package com.example.wishlistapp

import android.util.Log
import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wishlistapp.data.DummyWish
import com.example.wishlistapp.data.Wish

@Composable
fun HomeView(
    navController: NavController,
    viewModel: WishViewModel,
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            AppBarView(title = "Wishlist", onBackNavClicked = {
                Toast.makeText(context, "Button clicked", Toast.LENGTH_LONG).show()
            })
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(all = 20.dp),
                contentColor = Color.White,
                backgroundColor = Color.Black,
                onClick = {
                    // TODO Add navigation to add screen
                    navController.navigate(Screen.AddScreen.route)
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add button")
            }
        }

    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(DummyWish.wishList) {
                    wish -> WishItem(wish = wish) {}
            }
        }
    }
}

@Composable
fun WishItem(
    wish: Wish,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .clickable { onClick() },
        elevation = 10.dp,
        backgroundColor = Color.White
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = wish.title, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Spacer(Modifier.height(2.dp))
            Text(text = wish.description, fontWeight = FontWeight.Normal)
        }
    }
}