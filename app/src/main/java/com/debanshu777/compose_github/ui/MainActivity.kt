package com.debanshu777.compose_github.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.debanshu777.compose_github.network.dataSource.githubViewModel
import com.debanshu777.compose_github.ui.base.MainScreen
import com.debanshu777.compose_github.ui.theme.ComposeGithubTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeGithubTheme {
                val viewModel:githubViewModel= hiltViewModel()
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen(viewModel)
                }
            }
        }
    }
}