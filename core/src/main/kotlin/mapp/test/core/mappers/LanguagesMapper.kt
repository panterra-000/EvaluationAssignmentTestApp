package mapp.test.core.mappers

import mapp.test.FetchLanguagesQuery
import mapp.test.core.data.LanguageModel

fun FetchLanguagesQuery.Language.toLanguageModel(): LanguageModel {
    return LanguageModel(
        title = this.title, id = this.id, shortCode = this.shortCode
    )
}

fun List<FetchLanguagesQuery.Language>.mapToLanguageModelList(): List<LanguageModel> {
    return this.map {
        it.toLanguageModel()
    }
}
