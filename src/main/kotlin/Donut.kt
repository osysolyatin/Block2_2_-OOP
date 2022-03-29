data class Donut(
    val isDonut: Boolean = false, // запись доступна только платным подписчикам VK Donut
    val paidDuration: UInt = 60U, // время, в течение которого запись будет доступна только платным подписчикам VK Donut
    val placeholder: Any = Any(), // заглушка для пользователей, которые не оформили подписку VK Donut. Отображается вместо содержимого записи
    val canPublishFreeCopy: Boolean = false, // можно ли открыть запись для всех пользователей, а не только подписчиков VK Donut
    val editMode: EditMode = EditMode.ALL// информация о том, какие значения VK Donut можно изменить в записи
)

enum class EditMode {
    ALL, DURATION
}
