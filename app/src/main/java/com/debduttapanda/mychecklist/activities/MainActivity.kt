package com.debduttapanda.mychecklist.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.debduttapanda.mychecklist.screens.AddTaskPage
import com.debduttapanda.mychecklist.screens.HomePage
import com.debduttapanda.mychecklist.screens.SplashPage
import com.debduttapanda.mychecklist.ui.theme.MyChecklistTheme
import com.debduttapanda.mychecklist.viewModels.AddTaskViewModel
import com.debduttapanda.mychecklist.viewModels.HomeViewModel
import com.debduttapanda.mychecklist.viewModels.SplashViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashViewModel: SplashViewModel by viewModels()
        val introViewModel: HomeViewModel by viewModels()
        val addTaskViewModel: AddTaskViewModel by viewModels()
        setContent {
            MyChecklistTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    SideEffect {
                        splashViewModel.setNavigator(navController)
                        introViewModel.setNavigator(navController)
                    }
                    NavHost(navController = navController, startDestination = "splash") {
                        composable("splash") { SplashPage(splashViewModel) }
                        composable("home") { HomePage(introViewModel) }
                        composable("addTask") { AddTaskPage(addTaskViewModel) }
                    }
                }
            }
        }
    }
}

