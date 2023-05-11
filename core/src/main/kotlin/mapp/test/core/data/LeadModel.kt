package mapp.test.core.data

data class LeadModel(
    val firstName: String = "",
    val lastName: String = "",
    val fullName: String = "",
    val countryEmoji: String = "",
    val avatarUrl: String = "",
    val avatarName: String = "",
    val createdAt: String = "",
    val updatedAt: String = "",
    val intention: AdditionalModel? = null,
    val status: AdditionalModel? = null,
    val adSource: AdditionalModel? = null,
    val channelSource: AdditionalModel? = null,
)

data class AdditionalModel(
    val id: Int,
    val title: String
)
