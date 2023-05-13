package mapp.test.core.mappers

import mapp.test.FetchIntentionTypesQuery
import mapp.test.core.data.IntentionModel


fun FetchIntentionTypesQuery.FetchLeadIntentionType.toIntentionTypeModel(): IntentionModel {
    return IntentionModel(
        id = this.id, title = this.title
    )
}

fun List<FetchIntentionTypesQuery.FetchLeadIntentionType>.mapToIntentionTypeModelList(): List<IntentionModel> {
    return this.map {
        it.toIntentionTypeModel()
    }
}
