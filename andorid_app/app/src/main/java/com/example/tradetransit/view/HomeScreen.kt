package com.example.tradetransit.view

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.tradetransit.R
import com.example.tradetransit.utils.Constants
import com.example.tradetransit.utils.Routes
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, navigate: (Routes) -> Unit, popBackStack: () -> Unit ) {

    val currentLocation = LatLng(55.852993, -4.266255)
    val currentMarketState = rememberMarkerState(position = currentLocation)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(currentLocation, 15f)
    }

    val scaffoldState = rememberBottomSheetScaffoldState()

    BackHandler {
        popBackStack()
    }

    BottomSheetScaffold(

        scaffoldState = scaffoldState,
        sheetContent = {
            BottomSheet()
        },
        sheetPeekHeight = 100.dp
    ) { paddingValues ->

        Box(modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
        ) {
            // GoogleMap content
            GoogleMap(
                modifier = modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                properties = MapProperties( mapType =  MapType.TERRAIN)
            ) {
                Marker(
                    state = currentMarketState
                )
            }

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.TopCenter),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    shape = CircleShape,
                    elevation = ButtonDefaults.buttonElevation(10.dp),
                    colors = ButtonDefaults.buttonColors(Color.White),
                    modifier = Modifier
                        .size(80.dp),
                    onClick = { /* Handle button 1 click */ }) {
                    Icon( Icons.Default.Menu, contentDescription ="",
                        modifier = Modifier.size(50.dp),
                        tint = Color.Black
                    )
                }

            }

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    shape = CircleShape,
                    elevation = ButtonDefaults.buttonElevation(10.dp),
                    colors = ButtonDefaults.buttonColors(Color.White),
                    modifier = Modifier
                        .size(80.dp),
                    onClick = { /* Handle button 1 click */ }) {
                    Icon(painter = painterResource(id = R.drawable.baseline_security_24), contentDescription ="",
                        modifier = Modifier.size(40.dp),
                        tint = Color.Black
                    )
                }
                Button(
                    //shape = CircleShape,
                    elevation = ButtonDefaults.buttonElevation(30.dp),
                    //colors = ,
                    modifier = Modifier
                        .size(110.dp),
                    onClick = { /* Handle button 2 click */ }) {
                    Text(
                        "GO",
                        fontSize = 22.sp
                    )
                }
                Button(
                    shape = CircleShape,
                    //colors = ButtonDefaults.,
                    elevation = ButtonDefaults.buttonElevation(10.dp),
                    colors = ButtonDefaults.buttonColors(Color.White),
                    modifier = Modifier
                        .size(80.dp),
                    onClick = { /* Handle button 2 click */ }) {
                    Icon(painter = painterResource(id = R.drawable.baseline_gps_fixed_24), contentDescription ="",
                        modifier = Modifier.size(40.dp),
                        tint = Color.Black
                    )
                }
            }
        }

    }
}

@Composable
fun BottomSheet(){
    Column(modifier =
    Modifier
        .padding(10.dp, bottom = 20.dp)
        .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp, bottom = 5.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,

        ){

            Icon(
                Icons.Default.Edit,
                contentDescription = Constants.PREF_SETTING,
                modifier = Modifier
                    .size(30.dp)

            )

            Text(text = Constants.OFFLINE,
                modifier = Modifier,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold
            )

            Icon(
                Icons.Default.Menu,
                contentDescription = Constants.PREF_SETTING,
                modifier = Modifier
                    .size(30.dp)
            )

        }

    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    //HomeScreen()
}
