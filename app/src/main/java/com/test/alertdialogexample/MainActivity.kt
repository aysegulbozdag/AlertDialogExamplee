package com.test.alertdialogexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.alertdialogexample.ui.theme.AlertDialogExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlertDialogExampleTheme {
                val openAlertDialog = remember { mutableStateOf(false) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->

                    if (openAlertDialog.value)
                        DialogExamples(openAlertDialog)

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Button(onClick = {
                            openAlertDialog.value = true
                        }) { Text("Open Alert Dialog") }

                    }


                }
            }
        }
    }
}


@Composable
fun DialogExamples(openAlertDialog: MutableState<Boolean>) {

    if (openAlertDialog.value)
        AlertDialogExample(
            onDismissRequest = { openAlertDialog.value = false },
            onConfirmation = {
                openAlertDialog.value = false
                println("Confirmation registered")
            },
            dialogTitle = "Is alert dialog open?",
            dialogText = "Alert Dialog is open. Do you want to close it?",
            icon = androidx.compose.material.icons.Icons.Default.Info
        )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AlertDialogExampleTheme {
        val openAlertDialog = remember { mutableStateOf(false) }

        if (openAlertDialog.value)
            DialogExamples(openAlertDialog)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(onClick = {
                openAlertDialog.value = true
            }) { Text("Open Alert Dialog") }

        }
    }
}