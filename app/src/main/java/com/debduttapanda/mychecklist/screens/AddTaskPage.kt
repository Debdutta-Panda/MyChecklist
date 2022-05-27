package com.debduttapanda.mychecklist.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.debduttapanda.mychecklist.viewModels.AddTaskViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddTaskPage(addTaskViewModel: AddTaskViewModel) {
    SideEffect {
        addTaskViewModel
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Add New",
                        style = MaterialTheme.typography.h5
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            addTaskViewModel.onBack()
                        },
                    ) {
                        Icon(
                            Icons.Rounded.KeyboardArrowLeft,
                            contentDescription = ""
                        )
                    }
                }
            )
        }
    ) {
        var title by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(24.dp)
        ){
            item{
                TextField(
                    value = title,
                    onValueChange = {
                        title = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent
                    ),
                    label = {
                        Text("Title")
                    },
                    placeholder = {
                        Text("Give a name")
                    }
                )
            }
            item{
                Spacer(Modifier.height(24.dp))
            }
            item{
                OutlinedTextField(
                    value = description,
                    onValueChange = {
                        description = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent
                    ),
                    label = {
                        Text("Description")
                    },
                    placeholder = {
                        Text("Please describe")
                    },
                    maxLines = 3
                )
            }
            item{
                Spacer(Modifier.height(24.dp))
            }
            item{
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colors.onSurface.copy(alpha = TextFieldDefaults.UnfocusedIndicatorLineOpacity),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    IconButton(onClick = {

                    }) {
                        Icon(imageVector = Icons.Default.EditCalendar, contentDescription = "Date")
                    }
                }
            }
        }
    }
}