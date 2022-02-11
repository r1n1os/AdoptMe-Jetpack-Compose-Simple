package com.example.adoptme.utils

import android.content.Context
import android.util.Log
import android.widget.Space
import android.widget.Toast
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.adoptme.R
import com.example.adoptme.data.Dog
import com.example.adoptme.data.DogSampleData
import com.example.adoptme.data.DogSampleData.dogs
import com.example.adoptme.ui.composable_screens.DetailsScreen
import com.example.adoptme.ui.composable_screens.HomeScreen
import com.example.adoptme.utils.colors.CustomColors
import com.example.adoptme.utils.images.CustomIcons

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screens.DetailsScreen.route + "/{name}", arguments = listOf(
            navArgument("name") {
                type = NavType.StringType
                defaultValue = "Evagoras"
            }
        )) { entry ->
            DetailsScreen(
                name = entry.arguments?.getString("name").toString(),
                navController = navController
            )
        }
    }
}

fun showToast(context: Context, msg: String){
    Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
}

