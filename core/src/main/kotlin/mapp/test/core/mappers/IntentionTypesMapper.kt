package mapp.test.core.mappers

import mapp.test.FetchIntentionTypesQuery
import mapp.test.core.data.IntentionTypeModel


fun FetchIntentionTypesQuery.FetchLeadIntentionType.toIntentionTypeModel(): IntentionTypeModel {
    return IntentionTypeModel(
        id = this.id, title = this.title
    )
}

fun List<FetchIntentionTypesQuery.FetchLeadIntentionType>.mapToIntentionTypeModelList(): List<IntentionTypeModel> {
    return this.map {
        it.toIntentionTypeModel()
    }
}
