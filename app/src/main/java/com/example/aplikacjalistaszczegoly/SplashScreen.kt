package com.example.aplikacjalistaszczegoly

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.aplikacjalistaszczegoly.ui.theme.lightBarColor
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    var visible by remember { mutableStateOf(true) }

    // Trigger navigation after a delay
    LaunchedEffect(Unit) {
        delay(300)
        visible = false
        navController.navigate("main") {
            popUpTo("splash") { inclusive = true }
        }
    }

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(lightBarColor),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Wybierzmy się na wyprawę!",
                color = Color.White, fontSize = 40.sp,
                lineHeight = 40.sp, textAlign = TextAlign.Center
            )
        }
    }
}