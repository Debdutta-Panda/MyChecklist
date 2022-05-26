package com.debduttapanda.mychecklist.viewModels

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController

class HomeViewModel: ViewModel() {
    private var nav: NavController? = null
    fun setNavigator(navController: NavHostController) {
        this.nav = navController
    }

    fun addTask() {
        nav?.navigate("addTask")
    }
}