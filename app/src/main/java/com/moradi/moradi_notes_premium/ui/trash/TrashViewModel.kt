package com.moradi.moradi_notes_premium.ui.trash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TrashViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is a TrashCan"
    }
    val text: LiveData<String> = _text
}