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
import com.example.adoptme.utils.colors.CustomColors
import com.example.adoptme.utils.images.CustomIcons

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val context = LocalContext.current

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

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(CustomColors.lightGrey)
    ) {
        Row(modifier = Modifier.padding(start = 19.dp, top = 47.dp)) {
            Column {
                Text(
                    text = "Hey Spikey,",
                    fontSize = 20.sp,
                    color = CustomColors.greyBlue,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Adopt a new friend near you!",
                    fontSize = 16.sp,
                    color = CustomColors.greyBlue
                )
            }
            Spacer(modifier = Modifier.width(60.dp))
            Image(
                painter = painterResource(id = CustomIcons.themeModeIcon),
                "testing",
                modifier = Modifier.padding(top = 13.dp, end = 52.dp)
            )
        }
        Spacer(modifier = Modifier.height(35.dp))
        Text(
            modifier = Modifier.padding(start = 19.dp),
            text = "Nearby results",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = CustomColors.greyBlue
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn {
            items(DogSampleData.dogs) { dog ->
                DogsCard(navController, dog)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun DogsCard(navController: NavController, dog: Dog) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(start = 12.dp, end = 15.dp,)
            .clickable {
                navController.navigate(Screens.DetailsScreen.withArgs(dog.name))
            }, shape = RoundedCornerShape(16.dp), backgroundColor = Color.White
    ) {
        Row {
            Image(
                modifier = Modifier
                    .padding(start = 12.dp, top = 12.dp, bottom = 12.dp)
                    .width(93.dp)
                    .height(96.dp),
                painter = painterResource(id = CustomIcons.dogOne),
                contentDescription = null
            )
            Column(Modifier.padding(start = 18.dp, top = 22.dp, bottom = 22.dp)) {
                Text(
                    text = dog.name,
                    fontSize = 16.sp,
                    color = CustomColors.greyBlue,
                    fontStyle = FontStyle.Normal
                )
                Spacer(modifier = Modifier.height(9.dp))
                Text(
                    text = "${dog.age} yrs | Playful",
                    fontSize = 12.sp,
                    color = CustomColors.greyBlue,
                    fontStyle = FontStyle.Normal
                )
                Spacer(modifier = Modifier.height(14.dp))
                Row {
                    Image(
                        modifier = Modifier
                            .height(14.5.dp)
                            .width(11.dp),
                        painter = painterResource(id = CustomIcons.location_icons),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "381m away",
                        fontSize = 12.sp,
                        color = CustomColors.greyBlue,
                        fontStyle = FontStyle.Normal
                    )
                }
            }
            Column(
                modifier = Modifier.padding(
                    top = 18.dp,
                    bottom = 20.dp,
                    start = 39.dp,
                    end = 1.dp
                ), horizontalAlignment = Alignment.End
            ) {
                Card(shape = RoundedCornerShape(31.dp), backgroundColor = CustomColors.lightBlue) {
                    Text(
                        modifier = Modifier.padding(
                            start = 12.dp,
                            end = 12.dp,
                            top = 5.dp,
                            bottom = 5.dp
                        ),
                        textAlign = TextAlign.Start,
                        text = "Male",
                        fontSize = 12.sp,
                        color = CustomColors.blue,
                        fontStyle = FontStyle.Normal
                    )
                }
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = "12 min ago",
                    textAlign = TextAlign.Start,
                    fontSize = 12.sp,
                    color = CustomColors.blue,
                    fontStyle = FontStyle.Normal
                )
            }
        }
    }
}

@Composable
fun DetailsScreen(name: String, navController: NavController) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    showToast(context, name)
    Column(
        modifier = Modifier
            .verticalScroll(
                state = scrollState
            )
            .fillMaxHeight().padding(top = 0.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(346.dp)
        ) {
            Image(
                modifier = Modifier
                    .width(375.dp)
                    .height(346.dp),
                painter = painterResource(id = CustomIcons.dogOneBig),
                contentDescription = null
            )
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }

                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(36.dp))
        Text(
            text = name,
            textAlign = TextAlign.Start,
            fontSize = 24.sp,
            color = CustomColors.greyBlue,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 25.dp)
        )
        Box(
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 40.dp)
        ) {
            Card(shape = RoundedCornerShape(31.dp), backgroundColor = CustomColors.lightBlue) {
                Text(
                    modifier = Modifier.padding(
                        start = 12.dp,
                        end = 12.dp,
                        top = 5.dp,
                        bottom = 5.dp
                    ),
                    textAlign = TextAlign.Start,
                    text = "Male",
                    fontSize = 12.sp,
                    color = CustomColors.blue,
                    fontStyle = FontStyle.Normal
                )
            }
        }
        Spacer(modifier = Modifier.height(17.dp))
        Row(modifier = Modifier.padding(start = 27.dp)) {
            Image(
                modifier = Modifier
                    .height(14.5.dp)
                    .width(11.dp),
                painter = painterResource(id = CustomIcons.location_icons),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "381m away",
                fontSize = 12.sp,
                color = CustomColors.greyBlue,
                fontStyle = FontStyle.Normal
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.padding(start = 28.dp),
            text = "12 min ago",
            fontSize = 10.sp,
            color = CustomColors.greyBlue,
            fontStyle = FontStyle.Normal
        )
        Spacer(modifier = Modifier.height(37.dp))
        Text(
            modifier = Modifier.padding(start = 28.dp),
            text = "My Story",
            fontSize = 16.sp,
            color = CustomColors.greyBlue,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.padding(start = 28.dp),
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,",
            fontSize = 14.sp,
            color = CustomColors.greyBlue,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.W400,
        )
        Spacer(modifier = Modifier.height(37.dp))
        Text(
            modifier = Modifier.padding(start = 28.dp),
            text = "Quick Info",
            fontSize = 16.sp,
            color = CustomColors.greyBlue,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.padding(start = 28.dp, end = 18.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Card(
                modifier = Modifier
                    .width(91.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(12.dp),
                backgroundColor = CustomColors.lightGrey_dd
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "1.4 yrs",
                        fontSize = 16.sp,
                        color = CustomColors.blue,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W400
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Age",
                        fontSize = 10.sp,
                        color = CustomColors.grey,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W400
                    )
                }
            }
            Card(
                modifier = Modifier
                    .width(91.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(12.dp),
                backgroundColor = CustomColors.lightGrey_dd
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Brown",
                        fontSize = 16.sp,
                        color = CustomColors.blue,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W400
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Color",
                        fontSize = 10.sp,
                        color = CustomColors.grey,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W400
                    )
                }
            }
            Card(
                modifier = Modifier
                    .width(91.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(12.dp),
                backgroundColor = CustomColors.lightGrey_dd
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "14 kg",
                        fontSize = 16.sp,
                        color = CustomColors.blue,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W400
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Weight",
                        fontSize = 10.sp,
                        color = CustomColors.grey,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W400
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(37.dp))
        Text(
            modifier = Modifier.padding(start = 28.dp),
            text = "Owner Info",
            fontSize = 16.sp,
            color = CustomColors.greyBlue,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(24.dp))

        Row(modifier = Modifier
            .padding(start = 25.dp)
            .fillMaxWidth()) {
            Image(
                painter = painterResource(id = CustomIcons.dogOne),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(60.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    textAlign = TextAlign.Center,
                    text = "R1n1os Frang",
                    fontSize = 14.sp,
                    color = CustomColors.darkBlue,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.W400
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    textAlign = TextAlign.Center,
                    text = "Mobile Developer",
                    fontSize = 12.sp,
                    color = CustomColors.grey,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.W400
                )
            }
            Spacer(modifier = Modifier.width(61.dp))
            Box(modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .clip(CircleShape)
                .background(CustomColors.blue)) {
                Image(modifier = Modifier.align(Alignment.Center), alignment = Alignment.Center, painter = painterResource(id = CustomIcons.messagerIcon), contentDescription =null)
            }
        }

        Spacer(modifier = Modifier.height(56.dp))

        Button(modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .padding(start = 28.dp, end = 28.dp), colors = ButtonDefaults.buttonColors(backgroundColor = CustomColors.blue), shape = RoundedCornerShape(8.dp), onClick = {
            showToast(context, "Adoption Done!") }) {
            Text(
                textAlign = TextAlign.Center,
                text = "Adopt Me",
                fontSize = 16.sp,
                color = Color.White,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.W400
            )
        }
        Spacer(modifier = Modifier.height(77.dp))
    }
}

fun showToast(context: Context, msg: String){
    Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
}

