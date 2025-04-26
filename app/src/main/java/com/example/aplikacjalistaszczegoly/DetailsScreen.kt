package com.example.aplikacjalistaszczegoly
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.aplikacjalistaszczegoly.ui.theme.darkBarColor
import com.example.aplikacjalistaszczegoly.ui.theme.darkBarText
import com.example.aplikacjalistaszczegoly.ui.theme.darkBorder
import com.example.aplikacjalistaszczegoly.ui.theme.darkDetailsHeaderColor
import com.example.aplikacjalistaszczegoly.ui.theme.darkDetailsTextColor
import com.example.aplikacjalistaszczegoly.ui.theme.darkItemBackground
import com.example.aplikacjalistaszczegoly.ui.theme.darkSurface
import com.example.aplikacjalistaszczegoly.ui.theme.lightBarColor
import com.example.aplikacjalistaszczegoly.ui.theme.lightBarText
import com.example.aplikacjalistaszczegoly.ui.theme.lightBorder
import com.example.aplikacjalistaszczegoly.ui.theme.lightDetailsHeaderColor
import com.example.aplikacjalistaszczegoly.ui.theme.lightDetailsTextColor
import com.example.aplikacjalistaszczegoly.ui.theme.lightItemBackground
import com.example.aplikacjalistaszczegoly.ui.theme.lightSurface

@Composable
fun DetailsScreen(
    trailId: Int?,
    viewModel: TimerExampleViewModel,
    navController: NavHostController,
    darkThemeViewModel: DarkThemeViewModel
){
    val foundTrail = trails[trailId!!]
    var showText by rememberSaveable { mutableStateOf(false) }
    val windowInfo = rememberWindowInfo()
    val isDark by darkThemeViewModel.isDark.observeAsState()
    val backgroundColor = if (isDark == false) lightSurface else darkSurface
    val fabBackgroundColor = if (isDark == false) lightBarColor else darkBarColor
    val fabTextColor = if (isDark == false) lightBarText else darkBarText
    val drawableResource = when (trailId) {
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
    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Expanded) { // Tablet
        Surface(color= backgroundColor) {
            Box {
                LazyColumn(
                    modifier = Modifier
                        .padding(10.dp, bottom = 5.dp)
                ) {
                    item {
                        Box {
                            Image(
                                painter = painterResource(id = drawableResource),
                                contentDescription = "Trail Image",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp)
                            )
                            Text(
                                text = foundTrail.name,
                                color = Color.White,
                                fontSize = 55.sp,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                    item {
                        TimerExample(
                            viewModel = viewModel,
                            trackId = trailId,
                            darkThemeViewModel = darkThemeViewModel
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    item {
                        HeaderAndDescription(
                            header = "Opis szlaku",
                            description = foundTrail.description,
                            center = true,
                            darkThemeViewModel = darkThemeViewModel
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    item {
                        HeaderAndDescription(
                            header = "Poziom trudności",
                            description = foundTrail.difficulty,
                            darkThemeViewModel = darkThemeViewModel
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    item {
                        HeaderAndDescription(
                            header = "Długość",
                            description = "${foundTrail.length} km",
                            darkThemeViewModel = darkThemeViewModel
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    item {
                        HeaderAndDescription(
                            header = "Szacowany czas wędrówki",
                            description = foundTrail.duration,
                            darkThemeViewModel = darkThemeViewModel
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    item {
                        HeaderAndDescription(
                            header = "Najniżej położony punkt na trasie",
                            description = "${foundTrail.elevationLevels.first} m n.p.m.",
                            darkThemeViewModel = darkThemeViewModel
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    item {
                        HeaderAndDescription(
                            header = "Najwyżej położony punkt na trasie" ,
                            description = "${foundTrail.elevationLevels.second} m n.p.m.",
                            darkThemeViewModel = darkThemeViewModel
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    item {
                        HeaderAndDescription(
                            header = "Zalecenia dot. bezpieczeństwa",
                            description = foundTrail.safetyRecommendations,
                            darkThemeViewModel = darkThemeViewModel
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    item {
                        HeaderAndDescription(
                            header = "Pogoda",
                            description = foundTrail.weatherConditions,
                            darkThemeViewModel = darkThemeViewModel
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    item {
                        HeaderAndDescription(header = "Trasa", description = foundTrail.landmarks.joinToString(" --> "),
                            darkThemeViewModel = darkThemeViewModel)
                    }
                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    item {
                        HeaderAndDescription(
                            header = "Udogodnienia",
                            description = "--> " + foundTrail.amenities.joinToString("\n--> "),
                            darkThemeViewModel = darkThemeViewModel
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    item {
                        HeaderAndDescription(
                            header = "Miejsca z których można rozpocząć/zakończyć szlak",
                            description = "--> " + foundTrail.accessPoints.joinToString("\n--> "),
                            darkThemeViewModel = darkThemeViewModel
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    item {
                        HeaderAndDescription(
                            header = "Recenzje i oceny",
                            description = foundTrail.reviews.joinToString("\n--> "),
                            darkThemeViewModel = darkThemeViewModel
                        )
                    }
                }
                FloatingActionButton(
                    containerColor = fabBackgroundColor,
                    contentColor = fabTextColor,
                    onClick = { showText = !showText },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .height(90.dp)
                        .width(90.dp)
                        .padding(15.dp)
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Dodaj zdjęcie",
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp)
                        )
                }
                if (showText) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(end = 15.dp, bottom = 85.dp)
                            .clip(RoundedCornerShape(15))
                    ) {
                        Text(
                            text = "Dodaj zdjęcie",
                            color = fabTextColor,
                            fontSize = 30.sp,
                            modifier = Modifier
                                .background(fabBackgroundColor)
                                .padding(15.dp)
                        )
                    }
                }
            }

        }
    } else { // Phone
        Surface(color=backgroundColor) {
            Scaffold(
                topBar = {
                    MyAppBar(
                        text = foundTrail.name,
                        useBackArrow = true,
                        navController = navController,
                        darkThemeViewModel = darkThemeViewModel
                    )
                },
                content = { paddingValues ->
                    LazyColumn(
                        modifier = Modifier
                            .padding(paddingValues)
                            .background(color = backgroundColor)
                    ) {
                        item {
                            Box {
                                Image(
                                    painter = painterResource(id = drawableResource),
                                    contentDescription = "Trail Image",
                                    contentScale = ContentScale.FillBounds,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp)
                                )
                                Text(
                                    text = foundTrail.name,
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                    fontSize = 40.sp,
                                    lineHeight = 40.sp,
                                    modifier = Modifier
                                        .align(Alignment.BottomCenter)
                                        .padding(10.dp)
                                )
                            }
                        }
                        item {
                            TimerExample(viewModel, trailId, darkThemeViewModel)
                        }
                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                        item {
                            HeaderAndDescription(
                                header = "Opis Szlaku",
                                description = foundTrail.description,
                                center = true,
                                darkThemeViewModel = darkThemeViewModel
                            )
                        }

                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                        item {
                            HeaderAndDescription(
                                header = "Najniżej położony punkt na trasie",
                                description = "${foundTrail.elevationLevels.first} m n.p.m.",
                                center = true,
                                darkThemeViewModel = darkThemeViewModel
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                        item {
                            HeaderAndDescription(
                                header = "Najwyżej położony punkt na trasie",
                                description = "${foundTrail.elevationLevels.second} m n.p.m.",
                                center = true,
                                darkThemeViewModel = darkThemeViewModel
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                        item {
                            HeaderAndDescription(
                                header = "Zalecenia dot. bezpieczeństwa",
                                description = foundTrail.safetyRecommendations,
                                center = true,
                                darkThemeViewModel = darkThemeViewModel
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                        item {
                            HeaderAndDescription(
                                header = "Pogoda",
                                description = foundTrail.weatherConditions,
                                center = true,
                                darkThemeViewModel = darkThemeViewModel
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                        item {
                            HeaderAndDescription(
                                header = "Trasa",
                                description = "--> " + foundTrail.landmarks.joinToString("\n--> "),
                                center = true,
                                darkThemeViewModel = darkThemeViewModel
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                        item {
                            HeaderAndDescription(
                                header = "Udogodnienia",
                                description = "--> " + foundTrail.amenities.joinToString("\n--> "),
                                center = true,
                                darkThemeViewModel = darkThemeViewModel
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                        item {
                            HeaderAndDescription(
                                header = "Miejsca z których można rozpocząć/zakończyć szlak",
                                description = "--> " + foundTrail.accessPoints.joinToString("\n--> "),
                                center = true,
                                darkThemeViewModel = darkThemeViewModel
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                        item {
                            HeaderAndDescription(
                                header = "Recenzje i oceny",
                                description = foundTrail.reviews.joinToString("\n--> "),
                                center = true,
                                darkThemeViewModel = darkThemeViewModel
                            )
                        }
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        containerColor = fabBackgroundColor,
                        contentColor = fabTextColor,
                        onClick = {showText = !showText }
                    ) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = "Add"
                        )
                    }
                }
            )
        }
    }

}

@Composable
fun HeaderAndDescription(
    header: String,
    description: String,
    center: Boolean = true,
    darkThemeViewModel: DarkThemeViewModel
) {
    val windowInfo = rememberWindowInfo()
    val fontSizeHeader : Int
    val fontSizeDescription : Int
    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Expanded) {
        fontSizeHeader = 30
        fontSizeDescription = 20
    } else if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
        fontSizeHeader = 20
        fontSizeDescription = 15
    } else {
        fontSizeHeader = 30
        fontSizeDescription = 20
    }
    val isDark by darkThemeViewModel.isDark.observeAsState()
    val headerColor = if (isDark == false) lightDetailsHeaderColor else darkDetailsHeaderColor
    val textColor = if (isDark == false) lightDetailsTextColor else darkDetailsTextColor
    val backgroundColor = if (isDark == false) lightSurface else darkSurface
    val borderColor = if (isDark == false) lightBorder else darkBorder
    val itemBackgroundColor = if (isDark == false) lightItemBackground else darkItemBackground
    Surface(
        Modifier
            .padding(horizontal = 5.dp),
        color = backgroundColor,
        shape = RoundedCornerShape(10)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .border(width = 3.dp, color = borderColor, shape = RoundedCornerShape(10))
            .background(itemBackgroundColor)
            .padding(10.dp)
        ) {
            if (center) {
                Text(
                    text = header,
                    fontWeight = FontWeight.Bold,
                    fontSize = fontSizeHeader.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    color = headerColor
                )
                if (description.isNotEmpty()) {
                    Text(
                        text = description,
                        fontSize = fontSizeDescription.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        color = textColor
                    )
                }
            } else {
                Text(
                    text = header,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = headerColor,
                    textAlign = TextAlign.Center
                )
                if (description.isNotEmpty()) {
                    Text(
                        text = description,
                        fontSize = 20.sp,
                        color = textColor,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewDetails() {
    DetailsScreen(
        trailId = 10,
        viewModel = TimerExampleViewModel(),
        navController =  rememberNavController(),
        darkThemeViewModel = DarkThemeViewModel()
    )
}

