package mapp.test.core.mappers

import mapp.test.FetchCountriesQuery
import mapp.test.FetchLeadQuery
import mapp.test.core.data.CountryModel

fun FetchCountriesQuery.FetchCountry.toCountryModel(): CountryModel {
    return CountryModel(
        name = this.title, phoneCode = this.phoneCode, emoji = this.emoji.toString(), id = this.id
    )
}

fun List<FetchCountriesQuery.FetchCountry>.mapToCountryModelList(): List<CountryModel> {
    return this.map {
        it.toCountryModel()
    }
}

fun FetchLeadQuery.Country.toModel(): CountryModel {
    return CountryModel(
        name = this.title, phoneCode = this.phoneCode, emoji = this.emoji.toString(), id = this.id
    )
}
