package com.moradi.moradi_notes_premium

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.moradi.moradi_notes_premium.database.NotesDatabase
import com.moradi.moradi_notes_premium.entities.Notes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseFragment : Fragment(),CoroutineScope{
    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = job +Dispatchers.Main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()

    }




    override fun onDestroy() {
        super.onDestroy()
        job.cancel()


    }


}
