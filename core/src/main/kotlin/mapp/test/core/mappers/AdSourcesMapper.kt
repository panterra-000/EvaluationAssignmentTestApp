package mapp.test.core.mappers

import mapp.test.FetchAdSourcesQuery
import mapp.test.core.data.AdSourceModel

fun FetchAdSourcesQuery.FetchAdSource.toAdSourceModel(): AdSourceModel {
    return AdSourceModel(
        title = this.title, id = this.id
    )
}

fun List<FetchAdSourcesQuery.FetchAdSource>.mapToAdSourceModelList(): List<AdSourceModel> {
    return this.map {
        it.toAdSourceModel()
    }
}
