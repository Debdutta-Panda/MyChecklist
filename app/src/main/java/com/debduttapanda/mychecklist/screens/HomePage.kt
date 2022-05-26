package com.debduttapanda.mychecklist.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.debduttapanda.mychecklist.R
import com.debduttapanda.mychecklist.ui.theme.typography
import com.debduttapanda.mychecklist.viewModels.HomeViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomePage(homeViewModel: HomeViewModel) {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(id = R.string.app_name),
                        style = typography.app_name
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {

                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        },
                    ) {
                        Icon(
                            Icons.Rounded.Menu,
                            contentDescription = ""
                        )
                    }
                }
            )
        },

        drawerContent = {

        }
    ){
        val pages = listOf(
            "Pending",
            "Done",
            "All"
        )
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){

            val pagerState = rememberPagerState()
            Column(){
                TabRow(
                    selectedTabIndex = pagerState.currentPage,
                    indicator = { tabPositions ->
                        TabRowDefaults.Indicator(
                            Modifier
                                .fillMaxWidth()
                                .pagerTabIndicatorOffset(pagerState, tabPositions)
                        )
                    }
                ) {
                    pages.forEachIndexed { index, title ->
                        Tab(
                            text = { Text(title) },
                            selected = pagerState.currentPage == index,
                            onClick = {
                                scope.launch {
                                    pagerState.animateScrollToPage(index)
                                }

                            },
                        )
                    }
                }
                HorizontalPager(
                    count = pages.size,
                    modifier = Modifier.fillMaxSize(),
                    state = pagerState
                ) { page ->
                    when(page){
                        0-> PendingTasks()
                        1-> DoneTasks()
                        2-> AllTasks()
                    }
                }
            }
            FloatingActionButton(
                modifier = Modifier.padding(24.dp).align(Alignment.BottomEnd),
                onClick = {
                    homeViewModel.addTask()
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add task")
            }
        }
    }

}