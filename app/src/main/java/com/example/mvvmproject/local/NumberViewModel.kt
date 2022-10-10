package com.example.mvvmproject.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmproject.local.responce.NumberResponce
import com.example.mvvmproject.util.Events
import com.example.mvvmproject.util.Result
import com.example.mvvmproject.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NumberViewModel @Inject constructor(private val repo: NumberRepo) : ViewModel() {

    private val _fact = MutableLiveData<Events<Result<NumberResponce>>>()
    val fact : LiveData<Events<Result<NumberResponce>>> = _fact

    fun getNumberFact(num : Int) = viewModelScope.launch {
        _fact.postValue(Events(Result(Status.LOADING, null, null)))
        _fact.postValue(Events(repo.getNumberFact(num)))
    }
}