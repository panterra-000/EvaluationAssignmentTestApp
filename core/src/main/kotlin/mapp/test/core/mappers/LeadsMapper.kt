package mapp.test.core.mappers

import mapp.test.FetchLeadsQuery
import mapp.test.core.data.AdSourceModel
import mapp.test.core.data.ChannelSourceModel
import mapp.test.core.data.IntentionModel
import mapp.test.core.data.LeadModel
import mapp.test.core.data.StatusModel
import mapp.test.core.util.changeDateFormat

fun FetchLeadsQuery.Data1.toLeadViewData(): LeadModel {
    return LeadModel(
        fullName = this.displayName ?: "",
        firstName = this.firstName ?: "",
        lastName = this.lastName ?: "",
        avatarUrl = this.avatar?.path ?: "",
        avatarName = "${this.firstName?.get(0)}${this.lastName?.get(0)}",
        countryEmoji = this.country?.emoji ?: "",
        createdAt = this.createdAt.toString().changeDateFormat(),
        updatedAt = this.updatedAt.toString().changeDateFormat(),
        intention = this.intention?.toModel(),
        status = this.status?.toModel(),
        adSource = this.adSource?.toModel(),
        channelSource = this.channelSource?.toModel()
    )
}

fun FetchLeadsQuery.FetchLeads.mapToLeadsModelList(): List<LeadModel> {
    return this.data.map {
        it.toLeadViewData()
    }
}

fun FetchLeadsQuery.Intention.toModel(): IntentionModel? {
    return if (this.id != null && this.title != null) {
        return IntentionModel(title = this.title, id = this.id)
    } else null
}

fun FetchLeadsQuery.Status.toModel(): StatusModel? {
    return if (this.id != null && this.title != null) {
        return StatusModel(title = this.title, id = this.id)
    } else null
}

fun FetchLeadsQuery.AdSource.toModel(): AdSourceModel? {
    return if (this.id != null && this.title != null) {
        return AdSourceModel(title = this.title, id = this.id)
    } else null
}

fun FetchLeadsQuery.ChannelSource.toModel(): ChannelSourceModel? {
    return if (this.id != null && this.title != null) {
        return ChannelSourceModel(title = this.title, id = this.id)
    } else null
}
