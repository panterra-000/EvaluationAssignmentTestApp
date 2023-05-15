package mapp.test.core.data.request

data class CreateLeadInputModel(
    val firstName: String,
    val lastName: String,
    val intentionId: Int,
    val languages: List<Int>,
    val adSourceId: Int,
    val countryId: Int,
    val cityId: Int,
    val email: String,
    val phone: String,
    val telegramId: String? = null,
    val telegramUserName: String? = null
)
