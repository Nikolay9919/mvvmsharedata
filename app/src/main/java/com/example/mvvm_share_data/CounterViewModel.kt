package com.example.mvvm_share_data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private val counter = MutableLiveData<Int>()

    init {
        this.counter.value = 0
    }

    fun increment() {
        this.counter.value = this.counter.value!! + 1
    }

    fun decrement() {
        this.counter.value = this.counter.value!! - 1
    }

    fun getCounter(): LiveData<Int> = this.counter
}