package com.moradi.moradi_notes_premium.ui.lockednotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LockedNotesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is a Locked Note "
    }
    val text: LiveData<String> = _text
}