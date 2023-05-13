package mapp.test.core.data

data class CountryModel(
    val id: Int,
    val name: String,
    val phoneCode: String = "",
    val emoji: String = "",
)
