package com.debduttapanda.mychecklist.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel:ViewModel() {
    private lateinit var nav: NavHostController

    init {
        delayAndGo()
    }

    private fun delayAndGo() {
        viewModelScope.launch {
            delay(2000)
            goToNextPage()
        }
    }

    private fun goToNextPage() {
        nav.navigate("home"){
            popUpTo("splash"){inclusive=true}
        }
    }

    fun setNavigator(navController: NavHostController) {
        this.nav = navController
    }
}