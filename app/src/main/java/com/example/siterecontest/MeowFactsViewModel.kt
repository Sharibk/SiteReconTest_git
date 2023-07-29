package com.example.siterecontest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MeowFactsViewModel : ViewModel() {
    private val _meowFacts = MutableLiveData<List<String>>()
    val meowFacts : LiveData<List<String>>
        get() = _meowFacts

    init {
        fetechMeowFacts()
    }

    fun fetechMeowFacts(){
            viewModelScope.launch {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://meowfacts.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val api = retrofit.create(MeowInterface::class.java)
                val response = api.getMeowFacts(20)

                if (response.isSuccessful && response.body()!=null){
                    val facts = response.body()
                    Log.i("facts",facts.toString())
                    _meowFacts.value = facts?.data ?: emptyList()
                }
            }
    }

}