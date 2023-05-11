package mapp.test.core.mappers

import mapp.test.FetchLeadsQuery
import mapp.test.core.data.LeadModel

fun FetchLeadsQuery.Data1.toLeadViewData(): LeadModel {
    return LeadModel(
        fullName = this.displayName ?: "",
        avatar = this.avatar?.path ?: "",
        countryEmoji = this.country?.emoji ?: "",
        createdAt = this.createdAt.toString(),
        updatedAt = this.updatedAt.toString()
    )
}

fun FetchLeadsQuery.FetchLeads.mapToLeadsModelList(): List<LeadModel> {
    return this.data.map {
        it.toLeadViewData()
    }
}

