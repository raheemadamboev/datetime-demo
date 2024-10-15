package xyz.teamgravity.datetimedemo

import kotlinx.datetime.TimeZone

enum class City(
    val label: String,
    val timezone: TimeZone
) {
    Berlin(
        label = "Berlin",
        timezone = TimeZone.of("Europe/Berlin")
    ),
    London(
        label = "London",
        timezone = TimeZone.of("Europe/London")
    ),
    NewYork(
        label = "New York",
        timezone = TimeZone.of("America/New_York")
    ),
    LosAngeles(
        label = "Los Angeles",
        timezone = TimeZone.of("America/Los_Angeles")
    ),
    Tokyo(
        label = "Tokyo",
        timezone = TimeZone.of("Asia/Tokyo")
    ),
    Sydney(
        label = "Sydney",
        timezone = TimeZone.of("Australia/Sydney")
    ),
    Tashkent(
        label = "Tashkent",
        timezone = TimeZone.of("Asia/Tashkent")
    ),
    Urgench(
        label = "Urgench",
        timezone = TimeZone.of("Asia/Tashkent")
    );
}
