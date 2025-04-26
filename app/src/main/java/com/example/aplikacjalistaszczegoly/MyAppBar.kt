package com.example.aplikacjalistaszczegoly

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.aplikacjalistaszczegoly.ui.theme.darkBarColor
import com.example.aplikacjalistaszczegoly.ui.theme.darkBarIcon
import com.example.aplikacjalistaszczegoly.ui.theme.darkBarText
import com.example.aplikacjalistaszczegoly.ui.theme.lightBarColor
import com.example.aplikacjalistaszczegoly.ui.theme.lightBarIcon
import com.example.aplikacjalistaszczegoly.ui.theme.lightBarText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(
    text: String,
    useBackArrow: Boolean,
    navController: NavHostController,
    darkThemeViewModel: DarkThemeViewModel
) {
    val isDark by darkThemeViewModel.isDark.observeAsState()
    val barColor = if (isDark == false) lightBarColor else darkBarColor
    val titleColor = if (isDark == false) lightBarText else darkBarText
    val iconColor = if (isDark == false) lightBarIcon else darkBarIcon

    if (useBackArrow) {
        Surface(shadowElevation = 10.dp) {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = barColor,
                    titleContentColor = titleColor,
                    navigationIconContentColor = iconColor,
                    actionIconContentColor = iconColor,
                ),
                title = { Text(
                    text = text,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Go back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { darkThemeViewModel.updateIsDark() }) {
                        Icon(Icons.Default.Edit, contentDescription = "Change theme")
                    }
                }
            )
        }


    } else {
        Surface(shadowElevation = 10.dp) {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = barColor,
                    titleContentColor = titleColor,
                    navigationIconContentColor = iconColor,
                    actionIconContentColor = iconColor,
                ),
                title = { Text(
                    text = text,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp) },
                actions = {
                    IconButton(onClick = { darkThemeViewModel.updateIsDark() }) {
                        Icon(Icons.Default.Edit, contentDescription = "Change theme")
                    }
                }
            )
        }

    }

}

@Preview
@Composable
fun showBar() {
    MyAppBar(
        "Szlaki turystyczne",
        true,
        navController = rememberNavController(),
        darkThemeViewModel = DarkThemeViewModel())
}