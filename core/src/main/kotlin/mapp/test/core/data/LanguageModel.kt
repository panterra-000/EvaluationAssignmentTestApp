package mapp.test.core.data

data class LanguageModel(
    val id: Int,
    val shortCode: String,
    val title: String
)


fun List<LanguageModel>.getIds(): List<Int> {
    val list = ArrayList<Int>()
    this.forEach {
        list.add(it.id)
    }
    return list
}