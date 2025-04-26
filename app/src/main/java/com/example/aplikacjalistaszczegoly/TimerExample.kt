package com.example.aplikacjalistaszczegoly

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.aplikacjalistaszczegoly.ui.theme.darkBarText
import com.example.aplikacjalistaszczegoly.ui.theme.darkButton
import com.example.aplikacjalistaszczegoly.ui.theme.darkTimerText
import com.example.aplikacjalistaszczegoly.ui.theme.lightBarText
import com.example.aplikacjalistaszczegoly.ui.theme.lightButton
import com.example.aplikacjalistaszczegoly.ui.theme.lightTimerText
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

class TimerExampleViewModel : ViewModel() {
    var time by mutableStateOf<List<Long>>(emptyList())
    var isRunning by mutableStateOf<List<Boolean>>(emptyList())
    var startTime by mutableStateOf<List<Long>>(emptyList())

    // Method to initialize the lists with a specific length
    fun initializeLists(length: Int) {
        time = MutableList(length) { 0L }
        isRunning = MutableList(length) { false }
        startTime = MutableList(length) { 0L }
    }
}

@Composable
fun formatTime(timeMi: Long): String {
    val hours = TimeUnit.MILLISECONDS.toHours(timeMi)
    val min = TimeUnit.MILLISECONDS.toMinutes(timeMi) % 60
    val sec = TimeUnit.MILLISECONDS.toSeconds(timeMi) % 60

    return String.format("%02d:%02d:%02d", hours, min, sec)
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TimerExample(
    viewModel: TimerExampleViewModel,
    trackId: Int,
    darkThemeViewModel: DarkThemeViewModel) {
    val windowInfo = rememberWindowInfo()
    val fontSizeButton : Int
    val timerFontSize : Int
    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Expanded) {
        fontSizeButton = 30
        timerFontSize = 40
    } else if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact){
        fontSizeButton = 15
        timerFontSize = 25
    } else {
        fontSizeButton = 30
        timerFontSize = 40
    }
    val isDark by darkThemeViewModel.isDark.observeAsState()
    val textColor = if (isDark == false) lightTimerText else darkTimerText
    val buttonTextColor = if (isDark == false) lightBarText else darkBarText
    val buttonColor = if (isDark == false) lightButton else darkButton
    if (viewModel.time.isEmpty()) {
        viewModel.initializeLists(length = trails.size)
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = formatTime(timeMi = viewModel.time[trackId]),
            style= MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(9.dp),
            color = textColor,
            fontWeight = FontWeight.Bold,
            fontSize = timerFontSize.sp
        )

        Row {
            Button(
                shape = RoundedCornerShape(15),
                onClick = {
                    if (viewModel.isRunning[trackId]) {
                        viewModel.isRunning = viewModel.isRunning.toMutableList().apply {
                            set(trackId, false)
                        }

                    } else {
                        viewModel.startTime = viewModel.startTime.toMutableList().apply {
                            set(trackId, System.currentTimeMillis() - viewModel.time[trackId])
                        }
                        viewModel.isRunning = viewModel.isRunning.toMutableList().apply { set(trackId, true) }
                        keyboardController?.hide()
                    }
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor
                ), modifier = Modifier.weight(1f)) {
                Text(
                    text = if (viewModel.isRunning[trackId]) "Pause" else "Start",
                    color = buttonTextColor,
                    fontSize = fontSizeButton.sp
                )

            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                shape = RoundedCornerShape(15),
                onClick = {
                    viewModel.time = viewModel.time.toMutableList().apply { set(trackId, 0) }
                    viewModel.isRunning = viewModel.isRunning.toMutableList().apply { set(trackId, false) }
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor
                ), modifier = Modifier.weight(1f)) {
                Text(
                    text = "Reset",
                    color = buttonTextColor,
                    fontSize = fontSizeButton.sp)
            }
        }
    }
    LaunchedEffect(viewModel.isRunning) {
        while (viewModel.isRunning[trackId]) {
            delay(10)
            viewModel.time = viewModel.time.toMutableList().apply {
                set(trackId, System.currentTimeMillis() - viewModel.startTime[trackId])
            }
        }
    }
}