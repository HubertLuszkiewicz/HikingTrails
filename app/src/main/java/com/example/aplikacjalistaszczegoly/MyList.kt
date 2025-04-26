package com.example.aplikacjalistaszczegoly

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.aplikacjalistaszczegoly.ui.theme.darkBorder
import com.example.aplikacjalistaszczegoly.ui.theme.darkItemBackground
import com.example.aplikacjalistaszczegoly.ui.theme.darkItemHeader
import com.example.aplikacjalistaszczegoly.ui.theme.darkItemText
import com.example.aplikacjalistaszczegoly.ui.theme.darkItemTitle
import com.example.aplikacjalistaszczegoly.ui.theme.darkSurface
import com.example.aplikacjalistaszczegoly.ui.theme.lightBorder
import com.example.aplikacjalistaszczegoly.ui.theme.lightItemBackground
import com.example.aplikacjalistaszczegoly.ui.theme.lightItemHeader
import com.example.aplikacjalistaszczegoly.ui.theme.lightItemText
import com.example.aplikacjalistaszczegoly.ui.theme.lightItemTitle
import com.example.aplikacjalistaszczegoly.ui.theme.lightSurface

@Composable
fun MyList(
    navController: NavHostController,
    viewModel: TimerExampleViewModel,
    windowInfo: WindowInfo,
    darkThemeViewModel: DarkThemeViewModel) {
    val isDark by darkThemeViewModel.isDark.observeAsState()
    val backgroundColor = if (isDark == false) lightSurface else darkSurface
    Surface(Modifier.fillMaxSize(), color = backgroundColor) {
        LazyColumn {
            items(trails) { trail ->
                ListItem(
                    trail = trail,
                    onItemClick = { selectedTrail ->
                        // Navigate to a detail screen
                        navController.navigate(route = "Details/${selectedTrail.id}")
                    },
                    darkThemeViewModel)
            }
        }
    }


}

@Composable
fun ListItem(trail: Trail, onItemClick: (Trail) -> Unit, darkThemeViewModel: DarkThemeViewModel) {
    val windowInfo = rememberWindowInfo()
    val isDark by darkThemeViewModel.isDark.observeAsState()
    val surfaceColor = if (isDark == false) lightItemBackground else darkItemBackground
    val titleColor = if (isDark == false) lightItemTitle else darkItemTitle
    val borderColor = if (isDark == false) lightBorder else darkBorder

    val drawableResource = when (trail.id) {
        0 -> R.drawable.trail
        1 -> R.drawable.trail2
        2 -> R.drawable.trail3
        3 -> R.drawable.trail4
        4 -> R.drawable.trail5
        5 -> R.drawable.trail6
        6 -> R.drawable.trail7
        7 -> R.drawable.trail8
        8 -> R.drawable.trail9
        9 -> R.drawable.trail10
        10 -> R.drawable.trail11
        else -> R.drawable.trail
    }
    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Expanded) { //tablet
        Surface(
            shape = RoundedCornerShape(10),
            modifier = Modifier
                .padding(5.dp, 5.dp)
                .fillMaxWidth()
        ) {
            Column(verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .clickable { onItemClick(trail) }
                    .height(120.dp)
                    .border(width = 3.dp, color = borderColor, shape = RoundedCornerShape(10))
                    .background(surfaceColor)) {
                Text(
                    text = trail.name,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color= titleColor,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                ) {
                    TrailDetail(label = "Trudność", value = trail.difficulty, darkThemeViewModel = darkThemeViewModel)
                    TrailDetail(label = "Długość", value = "${trail.length} km", darkThemeViewModel = darkThemeViewModel)
                    TrailDetail(label = "Czas", value = trail.duration, darkThemeViewModel = darkThemeViewModel)
                }
            }
        }
    } else if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) { //phone
        Surface(shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Row(
                modifier = Modifier
                    .border(width = 2.dp, borderColor, shape = RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .clickable { onItemClick(trail) }
                    .height(100.dp)
                    .background(surfaceColor)
            ) {
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = drawableResource),
                    contentDescription = "Trail Image",
                    modifier = Modifier
                        .weight(2f)
                        .clip(RoundedCornerShape(10.dp)).fillMaxHeight()
                )
                Spacer(modifier = Modifier.width(5.dp))
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .weight(5f)
                        .fillMaxHeight()) {
                    Text(
                        text = trail.name,
                        fontSize = 20.sp,
                        modifier = Modifier,
                        fontWeight = FontWeight.Bold,
                        color = titleColor
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()) {
                        TrailDetail(label = "Trudność", value = trail.difficulty, darkThemeViewModel = darkThemeViewModel)
                        TrailDetail(label = "Długość", value = "${trail.length} km", darkThemeViewModel = darkThemeViewModel)
                        TrailDetail(label = "Czas", value = trail.duration, darkThemeViewModel = darkThemeViewModel)
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))

            }
        }
    } else { // medium
        Surface(shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 5.dp)
        ) {
            Row(
                modifier = Modifier
                    .border(width = 2.dp, borderColor, shape = RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .clickable { onItemClick(trail) }
                    .height(180.dp)
                    .background(surfaceColor)
            ) {
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = drawableResource),
                    contentDescription = "Trail Image",
                    modifier = Modifier
                        .weight(2f)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxHeight()
                )
                Spacer(modifier = Modifier.width(5.dp))
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .weight(5f)
                        .fillMaxHeight()) {
                    Text(
                        text = trail.name,
                        fontSize = 40.sp,
                        modifier = Modifier,
                        fontWeight = FontWeight.Bold,
                        color = titleColor
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()) {
                        TrailDetail(label = "Trudność", value = trail.difficulty, darkThemeViewModel = darkThemeViewModel)
                        TrailDetail(label = "Długość", value = "${trail.length} km", darkThemeViewModel = darkThemeViewModel)
                        TrailDetail(label = "Czas", value = trail.duration, darkThemeViewModel = darkThemeViewModel)
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))

            }
        }
    }

}

@Composable
fun TrailDetail(label: String, value: String, darkThemeViewModel: DarkThemeViewModel) {
    val isDark by darkThemeViewModel.isDark.observeAsState()
    val headerColor = if (isDark == false) lightItemHeader else darkItemHeader
    val textColor = if (isDark == false) lightItemText else darkItemText
    val windowInfo = rememberWindowInfo()
    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Expanded) { //tablet
        Column {
            Text(
                text = label,
                color = headerColor,
                fontSize = 20.sp
            )
            Text(
                text = value,
                color = textColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    } else if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) { // Phone
        Column {
            Text(
                text = label,
                color = headerColor,
                fontSize = 14.sp
            )
            Text(
                text = value,
                color = textColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    } else {
        Column {
            Text(
                text = label,
                color = headerColor,
                fontSize = 25.sp
            )
            Text(
                text = value,
                color = textColor,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}

@Preview
@Composable
fun PreviewMyList() {
    ListItem(
        trail = trails[6],
        onItemClick = {},
        darkThemeViewModel = DarkThemeViewModel()
    )
}