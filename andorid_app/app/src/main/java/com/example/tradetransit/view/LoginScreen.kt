package com.example.tradetransit.view

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tradetransit.ui.theme.Facebook
import com.example.tradetransit.ui.theme.Twitter
import com.example.tradetransit.utils.Constants
import com.example.tradetransit.utils.Home
import com.example.tradetransit.utils.Routes
import com.example.tradetransit.viewmodel.UserViewModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(userViewModel: UserViewModel, navigateTo: (route: Routes) -> Unit) {

    val username by userViewModel.usernameState.collectAsState()
    val password by userViewModel.password.collectAsState()
    val loginError by userViewModel.uiLoginError.collectAsState()
    val loading by userViewModel.loading.collectAsState()
    val buttonDisable by userViewModel.buttonDisable.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()


    val loggedIn by userViewModel.loggedIn.collectAsState()


    val context = LocalContext.current


    SideEffect {

        if(loggedIn == true){
            navigateTo(Home)
        }
        else if (loggedIn == false) {
            Log.d("GOOO", "TOAST LIVE")
            Toast.makeText(context, "FAILED", Toast.LENGTH_LONG).show()
        }

    }


    LaunchedEffect(loginError) {
        if(loginError!= null){
            coroutineScope.launch {
                snackbarHostState.showSnackbar(

                    message = loginError ?: "Unknown error occurred",
                    actionLabel = "Dismiss"
                )
                userViewModel.clearError()
            }
        }
    }

    Column(
        Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally
    ) {

        Text(
            text = "Trade Transit",
            style = androidx.compose.ui.text.TextStyle(fontSize = 40.sp),
            fontWeight = FontWeight.Bold,

        )


        Box(
            modifier = Modifier
                .padding(top = 50.dp)
                .padding(horizontal = 32.dp)
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                TextField(
                    shape = RectangleShape,
                    label = { Text(text = Constants.USERNAME) },
                    value = username,
                    onValueChange = { userViewModel.updateUsername(it)  },
                    modifier = Modifier
                        .fillMaxWidth()
                    ,
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(5.dp))

                TextField(
                    shape = RectangleShape,
                    label = { Text(text = Constants.PASSWORD) },
                    value = password,
                    maxLines = 1,
                    onValueChange = { userViewModel.updatePassword(it)  },
                    modifier = Modifier
                        .fillMaxWidth()

                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    enabled = !buttonDisable,
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black, contentColor = Color.White),
                    modifier = Modifier
                        .fillMaxWidth()

                    ,
                    onClick = {

                        Log.d("Login", "Login button clicked")


                        coroutineScope.launch {

                            Log.d("Login", "Login COROUTINES clicked")


                            userViewModel.loginButtonClicked()
                        }
                    }) {
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = Constants.LOGIN
                        )
                }

                Spacer(modifier = Modifier.height(16.dp))



                Text(
                    text = "Forgot Password?",
                    //color = Color.Blue,
                    modifier = Modifier.clickable {

                    }
                )


                if(loading){
                    CircularProgressIndicator()
                }


            }
        }
        Spacer(modifier = Modifier.padding(top = 100.dp))

        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ){

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Icon(
                    imageVector = Facebook,
                    contentDescription = "",
                    tint = Color.Gray,
                    modifier = Modifier
                        .size(40.dp)
                    )
                Spacer(modifier = Modifier.width(50.dp))
                Icon(
                    imageVector = Twitter,
                    contentDescription = "",
                    tint = Color.Gray,
                    modifier = Modifier

                        .size(40.dp)
                )
            }
        }

    }


}

@Preview
@Composable
fun PreviewLoginScreen() {
    //LoginScreen()
}

