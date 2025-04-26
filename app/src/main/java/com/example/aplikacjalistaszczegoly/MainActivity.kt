package com.example.aplikacjalistaszczegoly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.unit.dp
import com.example.aplikacjalistaszczegoly.ui.theme.AplikacjaListaSzczegolyTheme
import com.example.aplikacjalistaszczegoly.ui.theme.darkSurface
import com.example.aplikacjalistaszczegoly.ui.theme.lightSurface

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val timerViewModel: TimerExampleViewModel by viewModels()
        val isDarkViewModel: DarkThemeViewModel by viewModels()
        super.onCreate(savedInstanceState)
        setContent {
            var darkTheme by remember { mutableStateOf(false)}
            val navControler = rememberNavController()

            AplikacjaListaSzczegolyTheme(darkTheme = darkTheme) {
                Navig(
                    navController = navControler,
                    timerViewModel,
                    isDarkViewModel
                )
            }
        }
    }
}

@Composable
fun Main (
    navController: NavHostController,
    viewModel: TimerExampleViewModel,
    darkThemeViewModel: DarkThemeViewModel
) {
    val windowInfo = rememberWindowInfo()
    var trailId by rememberSaveable { mutableStateOf(0) }
    val isDark by darkThemeViewModel.isDark.observeAsState()
    val backgroundColor = if (isDark == false) lightSurface else darkSurface
    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact ||
        windowInfo.screenWidthInfo is WindowInfo.WindowType.Medium) { // Phone
        Column {
            MyAppBar(
                text = "Szlaki turystyczne",
                useBackArrow = false,
                navController = navController,
                darkThemeViewModel = darkThemeViewModel
            )
            MyList(
                navController,
                viewModel,
                windowInfo,
                darkThemeViewModel
            )
        }
    } else { // Tablet
        Column {
            MyAppBar(
                text = "Szlaki turystyczne",
                useBackArrow = false,
                navController = navController,
                darkThemeViewModel = darkThemeViewModel
            )
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(color = backgroundColor)) {
                // List
                LazyColumn(modifier = Modifier
                    .weight(3f)
                    .padding(start = 5.dp)) {
                    items(trails) { trail ->
                        ListItem(trail, onItemClick = { selectedTrail ->
                            trailId = selectedTrail.id
                        },
                            darkThemeViewModel = darkThemeViewModel)
                    }
                }

                Box(modifier = Modifier
                    .weight(5f)
                    .padding(end = 5.dp)) {
                    DetailsScreen(
                        trailId = trailId,
                        viewModel = viewModel,
                        navController = navController,
                        darkThemeViewModel = darkThemeViewModel
                    )
                }
            }
        }

    }
}

