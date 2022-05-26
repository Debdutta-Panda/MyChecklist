package com.debduttapanda.mychecklist.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.debduttapanda.mychecklist.R
import com.debduttapanda.mychecklist.viewModels.SplashViewModel
import com.debduttapanda.mychecklist.ui.theme.typography
import com.debduttapanda.mychecklist.views.LottieView

@Composable
fun SplashPage(splashViewModel: SplashViewModel) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LottieView(
                json = R.raw.checklist2,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Text(
                stringResource(id = R.string.app_name),
                style = typography.app_name
            )
        }
    }    
}