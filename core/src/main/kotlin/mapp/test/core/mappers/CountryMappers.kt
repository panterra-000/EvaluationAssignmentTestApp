package mapp.test.core.mappers

import mapp.test.FetchCountriesQuery
import mapp.test.FetchLeadsQuery
import mapp.test.core.data.CountryViewData
import mapp.test.core.data.LeadModel

fun FetchCountriesQuery.FetchCountry.toCountryModel(): CountryViewData {
    return CountryViewData(
        name = this.title, code = this.phoneCode, emoji = this.emoji.toString()
    )
}

fun List<FetchCountriesQuery.FetchCountry>.mapToCountryModelList(): List<CountryViewData> {
    return this.map {
        it.toCountryModel()
    }
}
