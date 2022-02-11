package com.example.adoptme.ui.composable_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.adoptme.utils.colors.CustomColors
import com.example.adoptme.utils.images.CustomIcons
import com.example.adoptme.utils.showToast

@Composable
fun DetailsScreen(name: String, navController: NavController) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

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