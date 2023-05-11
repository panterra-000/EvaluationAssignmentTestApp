package mapp.test.core.mappers

import mapp.test.FetchLeadsQuery
import mapp.test.core.data.AdditionalModel
import mapp.test.core.data.LeadModel
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

fun FetchLeadsQuery.Intention.toModel(): AdditionalModel? {
    return if (this.id != null && this.title != null) {
        return AdditionalModel(title = this.title, id = this.id)
    } else null
}

fun FetchLeadsQuery.Status.toModel(): AdditionalModel? {
    return if (this.id != null && this.title != null) {
        return AdditionalModel(title = this.title, id = this.id)
    } else null
}

fun FetchLeadsQuery.AdSource.toModel(): AdditionalModel? {
    return if (this.id != null && this.title != null) {
        return AdditionalModel(title = this.title, id = this.id)
    } else null
}

fun FetchLeadsQuery.ChannelSource.toModel(): AdditionalModel? {
    return if (this.id != null && this.title != null) {
        return AdditionalModel(title = this.title, id = this.id)
    } else null
}
