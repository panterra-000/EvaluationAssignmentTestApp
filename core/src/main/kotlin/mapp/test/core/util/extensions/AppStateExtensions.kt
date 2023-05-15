package mapp.test.core.util.extensions

import androidx.compose.runtime.MutableState
import mapp.test.core.data.LanguageModel

fun <T> MutableState<List<T>>.addNewItem(item: T) {
    val list = ArrayList<T>()
    list.addAll(this.value)
    if (!item.checkAvailability(list)) list.add(item)
    this.value = list
}

fun <T> MutableState<List<T>>.addOrRemoveItem(item: T) {
    val list = ArrayList<T>()
    list.addAll(this.value)
    if (item.checkAvailability(list)) list.remove(item)
    else list.add(item)
    this.value = list
}

fun <T> T.checkAvailability(list: List<T>): Boolean {
    var isAvailable = false
    list.forEach {
        if (this == it) {
            isAvailable = true
        }
    }
    return isAvailable
}

fun LanguageModel.checkAvailability(list:List<LanguageModel>):Boolean{
    var isAvailable = false
    list.forEach {
        if (this.id == it.id) {
            isAvailable = true
        }
    }
    return isAvailable
}