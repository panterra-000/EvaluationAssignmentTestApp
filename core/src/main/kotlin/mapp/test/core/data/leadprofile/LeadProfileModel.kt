package mapp.test.core.data.leadprofile

import mapp.test.core.data.AdSourceModel
import mapp.test.core.data.ChannelSourceModel
import mapp.test.core.data.IntentionTypeModel
import mapp.test.core.data.StatusModel

data class LeadProfileModel(
    val id: Int,
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
