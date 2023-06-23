package mapp.test.core.mappers

import mapp.test.FetchLeadQuery
import mapp.test.core.data.LanguageModel


fun FetchLeadQuery.Language.toLanguageModel(): LanguageModel {
    return LanguageModel(
        title = this.title, id = this.id, shortCode = this.shortCode
    )
}


fun List<FetchLeadQuery.Language>.mapToLanguageModelList(): List<LanguageModel> {
    return this.map {
        it.toLanguageModel()
    }
}