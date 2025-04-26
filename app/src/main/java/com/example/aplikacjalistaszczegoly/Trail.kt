package com.example.aplikacjalistaszczegoly

import java.util.Date

data class Trail(
    val id: Int,
    val name: String,
    val description: String,
    val route: List<String>,
    val length: Double,
    val difficulty: String,
    val duration: String,
    val landmarks: List<String>,
    val elevationLevels: Pair<Int, Int>,
    val weatherConditions: String,
    val amenities: List<String>,
    val safetyRecommendations: String,
    val accessPoints: List<String>,
    val photos: List<String>,
    val reviews: List<String>,
    val lastUpdated: Date,
)


val trails = listOf(
    Trail(
        id = 0,
        name = "Szlak Orlej Perci",
        description = "Szlak Orlej Perci prowadzi wokół szczytu Orla Perć w Tatrach Wysokich. Jest to jedna z najbardziej wymagających tras w polskich górach, z licznymi punktami widokowymi i niebezpiecznymi odcinkami.",
        route = listOf("Zakopane", "Schronisko na Hali Ornak", "Orla Perć", "Kozi Wierch", "Czarny Staw Gąsienicowy", "Zakopane"),
        length = 5.2,
        difficulty = "Trudny",
        duration = "8-10 godzin",
        landmarks = listOf("Schronisko na Hali Ornak", "Przełęcz Zawrat", "Kozi Wierch", "Czarny Staw Gąsienicowy"),
        elevationLevels = Pair(1000, 2495), // minimalna i maksymalna wysokość n.p.m.
        weatherConditions = "Zmienna, należy unikać szlaku przy złych warunkach pogodowych",
        amenities = listOf("Schronisko na Hali Ornak: noclegi, posiłki", "Czarny Staw Gąsienicowy: miejsce na piknik"),
        safetyRecommendations = "Należy zachować ostrożność na odcinkach eksponowanych, stosować odpowiedni ekwipunek (lina, kask) oraz unikać szlaku w złych warunkach pogodowych.",
        accessPoints = listOf("Droga na Kalatówki", "Droga na Dolinę Gąsienicową"),
        photos = listOf("https://example.com/photo1.jpg", "https://example.com/photo2.jpg"),
        reviews = listOf("Fantastyczne widoki!", "Bardzo trudny szlak, ale warto"),
        lastUpdated = Date(),
    ),
    Trail(
        id = 1,
        name = "Szlak Gubałówka",
        description = "Łatwy szlak spacerowy prowadzący z Zakopanego na Gubałówkę. Zapewnia piękne widoki na Tatry Zachodnie oraz panoramę Zakopanego.",
        route = listOf("Zakopane", "Gubałówka"),
        length = 2.5, // długość szlaku w kilometrach
        difficulty = "Łatwy",
        duration = "1-1.5 godziny",
        landmarks = listOf("Widok na Tatry", "Widok na Zakopane"),
        elevationLevels = Pair(900, 1126), // minimalna i maksymalna wysokość n.p.m.
        weatherConditions = "Zróżnicowane, należy unikać szlaku przy złych warunkach pogodowych",
        amenities = listOf("Punkt widokowy na Gubałówce", "Kawiarnie, restauracje"),
        safetyRecommendations = "Można spacerować przez cały rok, należy zachować ostrożność na odcinkach z dużym ruchem turystycznym.",
        accessPoints = listOf("Krupówki", "Polana Szymoszkowa"),
        photos = listOf("https://example.com/photo3.jpg", "https://example.com/photo4.jpg"),
        reviews = listOf("Łatwy i przyjemny spacer dla całej rodziny"),
        lastUpdated = Date() // data ostatniej aktualizacji informacji o szlaku
    ),
    Trail(
        id = 2,
        name = "Szlak Morskie Oko",
        description = "Popularny szlak wiodący z Palenicy Białczańskiej do Morskiego Oka w Tatrzańskim Parku Narodowym. Zapewnia piękne widoki na najwyższe szczyty Tatr.",
        route = listOf("Palenica Białczańska", "Morskie Oko"),
        length = 9.5, // długość szlaku w kilometrach
        difficulty = "Średni",
        duration = "3-4 godziny",
        landmarks = listOf("Wodospady Siklawica", "Morskie Oko"),
        elevationLevels = Pair(1000, 1400), // minimalna i maksymalna wysokość n.p.m.
        weatherConditions = "Zmienna, należy unikać szlaku przy złych warunkach pogodowych",
        amenities = listOf("Schronisko na Hali Ornak: noclegi, posiłki", "Czarny Staw Gąsienicowy: miejsce na piknik"),
        safetyRecommendations = "Należy zachować ostrożność na odcinkach eksponowanych, stosować odpowiedni ekwipunek (lina, kask) oraz unikać szlaku w złych warunkach pogodowych.",
        accessPoints = listOf("Palenica Białczańska"),
        photos = listOf("https://example.com/photo5.jpg", "https://example.com/photo6.jpg"),
        reviews = listOf("Niesamowite widoki, ale trzeba się liczyć z dużym tłokiem"),
        lastUpdated = Date() // data ostatniej aktualizacji informacji o szlaku
    ),
    Trail(
        id = 3,
        name = "Szlak Rysy",
        description = "Jeden z najwyższych szczytów Tatr Wysokich. Szlak prowadzi z polskiej strony Tatr do szczytu Rysy. Jest to trasa bardzo wymagająca technicznie i fizycznie.",
        route = listOf("Morskie Oko", "Przełęcz pod Chłopkiem", "Rysy"),
        length = 20.3, // długość szlaku w kilometrach
        difficulty = "Bardzo trudny",
        duration = "10-12 godzin",
        landmarks = listOf("Morskie Oko", "Przełęcz pod Chłopkiem", "Szczyt Rysy"),
        elevationLevels = Pair(1400, 2499), // minimalna i maksymalna wysokość n.p.m.
        weatherConditions = "Bardzo zmienna, należy unikać szlaku przy złych warunkach pogodowych",
        amenities = listOf("Schronisko PTTK nad Morskim Okiem", "Chatka Puchatka"),
        safetyRecommendations = "Szlak wymaga doświadczenia w górach, należy być przygotowanym na zmienne warunki pogodowe, stosować odpowiedni sprzęt oraz unikać go w przypadku braku doświadczenia",
        accessPoints = listOf("Morskie Oko"),
        photos = listOf("https://example.com/photo7.jpg", "https://example.com/photo8.jpg"),
        reviews = listOf("Wspaniałe wrażenia, ale wymaga dużej kondycji fizycznej i doświadczenia w górach"),
        lastUpdated = Date() // data ostatniej aktualizacji informacji o szlaku
    ),
    Trail(
        id = 4,
        name = "Szlak Białki",
        description = "Łatwy szlak spacerowy w Beskidach, prowadzący wzdłuż rzeki Białki. Zapewnia piękne widoki na okoliczne góry i lasy.",
        route = listOf("Biała Woda", "Stacja Narciarska Kotelnica Białczańska"),
        length = 5.8, // długość szlaku w kilometrach
        difficulty = "Łatwy",
        duration = "2-3 godziny",
        landmarks = listOf("Biała Woda", "Kotelnica Białczańska"),
        elevationLevels = Pair(550, 730), // minimalna i maksymalna wysokość n.p.m.
        weatherConditions = "Zróżnicowane, idealny szlak na spacer w każdą porę roku",
        amenities = listOf("Restauracje w okolicy Kotelnicy Białczańskiej"),
        safetyRecommendations = "Szlak jest bezpieczny dla wszystkich grup wiekowych, należy jednak zachować ostrożność na brzegach rzeki",
        accessPoints = listOf("Biała Woda", "Kotelnica Białczańska"),
        photos = listOf("https://example.com/photo9.jpg", "https://example.com/photo10.jpg"),
        reviews = listOf("Przyjemny spacer wśród pięknej przyrody"),
        lastUpdated = Date() // data ostatniej aktualizacji informacji o szlaku
    ),
    Trail(
        id = 5,
        name = "Szlak Ojców",
        description = "Popularny szlak turystyczny w Ojcowskim Parku Narodowym, prowadzący przez malownicze skałki, jaskinie i doliny.",
        route = listOf("Ojców", "Skała Czarownic", "Maczuga Herkulesa", "Dolina Prądnika", "Ojców"),
        length = 10.0, // długość szlaku w kilometrach
        difficulty = "Średni",
        duration = "4-5 godzin",
        landmarks = listOf("Skała Czarownic", "Maczuga Herkulesa", "Jaskinia Ciemna"),
        elevationLevels = Pair(250, 400), // minimalna i maksymalna wysokość n.p.m.
        weatherConditions = "Zróżnicowane, ale szlak jest dostępny przez cały rok",
        amenities = listOf("Restauracje w Ojcowie"),
        safetyRecommendations = "Szlak jest stosunkowo bezpieczny, ale należy uważać na strome zbocza i skalne wychodnie",
        accessPoints = listOf("Ojców"),
        photos = listOf("https://example.com/photo11.jpg", "https://example.com/photo12.jpg"),
        reviews = listOf("Piękna trasa przez malownicze tereny"),
        lastUpdated = Date() // data ostatniej aktualizacji informacji o szlaku
    ),
    Trail(
        id = 6,
        name = "Szlak Słowiańskie Wzgórza",
        description = "Szlak prowadzący przez Słowiańskie Wzgórza wzdłuż doliny rzeki Notec. Zapewnia piękne widoki na okoliczne lasy i łąki.",
        route = listOf("Wronki", "Słowiańskie Wzgórza", "Złotów"),
        length = 15.5, // długość szlaku w kilometrach
        difficulty = "Średni",
        duration = "6-7 godzin",
        landmarks = listOf("Dolina Noteci", "Wzgórza Słowiańskie"),
        elevationLevels = Pair(50, 150), // minimalna i maksymalna wysokość n.p.m.
        weatherConditions = "Zróżnicowane, szlak dostępny przez cały rok",
        amenities = listOf("Restauracje w okolicy Wronki i Złotowa"),
        safetyRecommendations = "Szlak jest stosunkowo łatwy, ale należy uważać na zmieniające się warunki terenowe i pogodowe",
        accessPoints = listOf("Wronki", "Złotów"),
        photos = listOf("https://example.com/photo13.jpg", "https://example.com/photo14.jpg"),
        reviews = listOf("Piękna trasa wśród natury"),
        lastUpdated = Date() // data ostatniej aktualizacji informacji o szlaku
    ),
    Trail(
        id = 7,
        name = "Szlak Babia Góra",
        description = "Szlak górski prowadzący na szczyt Babiej Góry, najwyższego szczytu Beskidu Żywieckiego. Trasa oferuje widoki na Tatry, Gorce i Babiogórski Park Narodowy.",
        route = listOf("Zawoja", "Przełęcz Brona", "Babia Góra"),
        length = 13.0, // długość szlaku w kilometrach
        difficulty = "Trudny",
        duration = "7-9 godzin",
        landmarks = listOf("Przełęcz Brona", "Szczawiny Przełęcz", "Markowe Szczawiny"),
        elevationLevels = Pair(550, 1725), // minimalna i maksymalna wysokość n.p.m.
        weatherConditions = "Zmienna, należy unikać szlaku przy złych warunkach pogodowych",
        amenities = listOf("Schronisko na Markowych Szczawinach"),
        safetyRecommendations = "Szlak wymaga dobrej kondycji fizycznej i doświadczenia w górach, należy być przygotowanym na zmienne warunki pogodowe",
        accessPoints = listOf("Zawoja"),
        photos = listOf("https://example.com/photo15.jpg", "https://example.com/photo16.jpg"),
        reviews = listOf("Wyczerpujące podejście, ale widoki rekompensują trudności"),
        lastUpdated = Date() // data ostatniej aktualizacji informacji o szlaku
    ),
    Trail(
        id = 8,
        name = "Szlak Wdzydze",
        description = "Szlak turystyczny w okolicach Wdzydz, prowadzący przez malownicze jeziora, lasy i pola.",
        route = listOf("Kościerzyna", "Jezioro Wdzydze", "Wdzydze Kiszewskie"),
        length = 18.5, // długość szlaku w kilometrach
        difficulty = "Średni",
        duration = "5-6 godzin",
        landmarks = listOf("Jezioro Wdzydze", "Muzeum Etnograficzne", "Jezioro Wdzydze Wielkie"),
        elevationLevels = Pair(50, 150), // minimalna i maksymalna wysokość n.p.m.
        weatherConditions = "Zróżnicowane, szlak dostępny przez cały rok",
        amenities = listOf("Restauracje w Kościerzynie i Wdzydzach Kiszewskich"),
        safetyRecommendations = "Szlak jest stosunkowo łatwy, należy jednak uważać na zmienne warunki terenowe",
        accessPoints = listOf("Kościerzyna", "Wdzydze Kiszewskie"),
        photos = listOf("https://example.com/photo17.jpg", "https://example.com/photo18.jpg"),
        reviews = listOf("Przyjemna trasa wśród przyrody, idealna na rodzinne wycieczki"),
        lastUpdated = Date() // data ostatniej aktualizacji informacji o szlaku
    ),
    Trail(
        id = 9,
        name = "Szlak Świętokrzyskie Trasy",
        description = "Szlak turystyczny w Górach Świętokrzyskich, prowadzący przez najważniejsze szczyty i atrakcje regionu.",
        route = listOf("Łysica", "Święty Krzyż", "Zakrzowska Góra", "Kadzielnia", "Łysica"),
        length = 30.0, // długość szlaku w kilometrach
        difficulty = "Średni",
        duration = "10-12 godzin",
        landmarks = listOf("Łysica", "Święty Krzyż", "Zakrzowska Góra", "Kadzielnia"),
        elevationLevels = Pair(300, 612), // minimalna i maksymalna wysokość n.p.m.
        weatherConditions = "Zmienna, szlak dostępny przez cały rok",
        amenities = listOf("Restauracje w okolicach szczytów", "Punkty widokowe"),
        safetyRecommendations = "Szlak jest stosunkowo trudny, należy zachować ostrożność na stromych odcinkach",
        accessPoints = listOf("Łysica", "Święty Krzyż", "Kadzielnia"),
        photos = listOf("https://example.com/photo19.jpg", "https://example.com/photo20.jpg"),
        reviews = listOf("Wspaniała trasa dla miłośników górskich wędrówek"),
        lastUpdated = Date() // data ostatniej aktualizacji informacji o szlaku
    ),
    Trail(
        id = 10,
        name = "Szlak Jezior Mazurskich",
        description = "Szlak turystyczny wokół najpiękniejszych jezior na Mazurach, oferujący możliwość żeglugi, kąpieli i zwiedzania historycznych miejsc.",
        route = listOf("Giżycko", "Mikołajki", "Węgorzewo", "Ruciane-Nida", "Giżycko"),
        length = 150.0, // długość szlaku w kilometrach
        difficulty = "Łatwy",
        duration = "7-10 dni",
        landmarks = listOf("Jezioro Niegocin", "Jezioro Śniardwy", "Twierdza Boyen", "Jezioro Mamry"),
        elevationLevels = Pair(80, 150), // minimalna i maksymalna wysokość n.p.m.
        weatherConditions = "Zmienna, szlak dostępny od wiosny do jesieni",
        amenities = listOf("Przystanie żeglarskie", "Restauracje i pensjonaty w okolicach jezior"),
        safetyRecommendations = "Szlak jest łatwy, należy jednak pamiętać o bezpieczeństwie podczas żeglugi i kąpieli",
        accessPoints = listOf("Giżycko", "Mikołajki", "Węgorzewo", "Ruciane-Nida"),
        photos = listOf("https://example.com/photo21.jpg", "https://example.com/photo22.jpg"),
        reviews = listOf("Niesamowite widoki i spokojna atmosfera, idealne miejsce na wakacyjną wyprawę"),
        lastUpdated = Date() // data ostatniej aktualizacji informacji o szlaku
    )
)