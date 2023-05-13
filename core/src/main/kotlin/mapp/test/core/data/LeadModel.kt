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
    val intention: IntentionTypeModel? = null,
    val status: StatusModel? = null,
    val adSource: AdSourceModel? = null,
    val channelSource: ChannelSourceModel? = null,
)
