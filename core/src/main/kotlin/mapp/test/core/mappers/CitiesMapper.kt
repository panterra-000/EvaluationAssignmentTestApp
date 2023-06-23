package mapp.test.core.mappers

import mapp.test.FetchCitiesQuery
import mapp.test.FetchLeadQuery
import mapp.test.core.data.CityModel

fun FetchCitiesQuery.City.toCityModel(): CityModel {
    return CityModel(
        title = this.title, id = this.id, offset = this.offset
    )
}

fun List<FetchCitiesQuery.City>.mapToCityModelList(): List<CityModel> {
    return this.map {
        it.toCityModel()
    }
}

fun FetchLeadQuery.City.toModel(): CityModel {
    return CityModel(
        title = this.title, id = this.id, offset = this.offset
    )
}
