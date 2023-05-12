package mapp.test.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import mapp.test.core.domain.GetCountriesUseCase
import mapp.test.core.domain.GetLeadsUseCase
import javax.inject.Inject

@HiltViewModel
class CreateLeadViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getLeadsUseCase: GetLeadsUseCase
) : ViewModel() {

    val firstNameState = mutableStateOf("")
    val lastNameState = mutableStateOf("")
    val intentionTypeState = mutableStateOf("Type")
    val countryState = mutableStateOf("Country")
    val cityState = mutableStateOf("City")
    val languageState = mutableStateOf("Language")
    val phoneState = mutableStateOf("Number")
    val emailState = mutableStateOf("Email")
    val sourceState = mutableStateOf("Select Source")

}