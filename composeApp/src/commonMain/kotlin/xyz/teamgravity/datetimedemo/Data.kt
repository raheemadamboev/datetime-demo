package xyz.teamgravity.datetimedemo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.isActive
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeFormat
import kotlinx.datetime.format.char
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Duration.Companion.seconds

object Data {

    private val FORMAT_TIME: DateTimeFormat<LocalDateTime> = LocalDateTime.Format {
        hour()
        char(':')
        minute()
        char(':')
        second()
    }

    private val FORMAT_DATE: DateTimeFormat<LocalDateTime> = LocalDateTime.Format {
        dayOfMonth()
        char('/')
        monthNumber()
        char('/')
        year()
    }

    val data: Flow<List<TimeModel>> = flow {
        while (currentCoroutineContext().isActive) {
            val data = City.entries.map { city ->
                val time = Clock.System.now().toLocalDateTime(city.timezone)
                TimeModel(
                    city = city,
                    time = time.format(FORMAT_TIME),
                    date = time.format(FORMAT_DATE)
                )
            }
            emit(data)
            delay(1.seconds)
        }
    }.flowOn(Dispatchers.Default)
}