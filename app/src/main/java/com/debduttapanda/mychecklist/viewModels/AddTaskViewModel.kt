package com.debduttapanda.mychecklist.viewModels

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController

class AddTaskViewModel:ViewModel() {
    private var nav: NavController? = null
    fun onBack() {
        nav?.navigateUp()
    }

    fun setNavigator(navController: NavHostController) {
        this.nav = navController
    }
}