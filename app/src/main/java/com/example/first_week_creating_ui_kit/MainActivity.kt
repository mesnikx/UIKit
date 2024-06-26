package com.example.first_week_creating_ui_kit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.first_week_creating_ui_kit.ui.components.MyApp
import com.example.first_week_creating_ui_kit.ui.components.MyApp2
import com.example.first_week_creating_ui_kit.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                MyApp()
            }
        }
    }
}




