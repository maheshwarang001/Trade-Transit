package com.example.tradetransit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tradetransit.utils.Home
import com.example.tradetransit.utils.Login
import com.example.tradetransit.utils.Routes
import com.example.tradetransit.view.HomeScreen
import com.example.tradetransit.view.LoginScreen
import com.example.tradetransit.viewmodel.TradeViewModelFactory
import com.example.tradetransit.viewmodel.UserViewModel
import javax.inject.Inject


class MainActivity : ComponentActivity() {


    lateinit var userViewModel: UserViewModel

    @Inject
    lateinit var viewModelProviderFactory: TradeViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        (application as TradeTransitApplication).applicationComponent.inject(this)
        userViewModel = ViewModelProvider(this,viewModelProviderFactory).get(UserViewModel::class.java)

        setContent {
            AppNavHost(userViewModel)
        }
    }
}


@Composable
fun AppNavHost(vmf : UserViewModel) {
    val navController = rememberNavController()

    val popBackStack: () -> Unit = {
        navController.popBackStack()
    }

    val navigate: (Routes) -> Unit = { route ->
        navController.navigate(route) {
            launchSingleTop = true
        }
    }

    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(userViewModel = vmf, navigate)
        }
        composable<Home> {
            HomeScreen(navigate = navigate, popBackStack = popBackStack)
        }
    }

}