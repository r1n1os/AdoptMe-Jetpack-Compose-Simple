package com.example.adoptme.ui.composable_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.adoptme.data.Dog
import com.example.adoptme.data.DogSampleData
import com.example.adoptme.utils.Screens
import com.example.adoptme.utils.colors.CustomColors
import com.example.adoptme.utils.images.CustomIcons

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