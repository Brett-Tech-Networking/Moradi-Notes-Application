package com.moradi.moradinotespro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.moradi.moradinotespro.database.NotesDatabase
import com.moradi.moradinotespro.entities.Notes
import kotlinx.android.synthetic.main.fragment_create_note.*
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class CreateNoteFragment : BaseFragment() {
    var currentDate:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_note, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CreateNoteFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sdf = SimpleDateFormat("dd/m/yyyy hh:m:ss")
        currentDate = sdf.format(Date())

        tvDateTime.text = currentDate

        imgDone.setOnClickListener {
            //Save Note
            saveNote()
        }

        imgBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }
    private fun saveNote() {
        if (etNoteTitle.text.isNullOrEmpty()) {
            Toast.makeText(context, "Title Required", Toast.LENGTH_SHORT).show()
        }
        if (etNoteSubTitle.text.isNullOrEmpty()) {
            Toast.makeText(context, "SubTitle Required", Toast.LENGTH_SHORT).show()
        }

        if (etNoteDesc.text.isNullOrEmpty()) {
            Toast.makeText(context, "Note Required", Toast.LENGTH_SHORT).show()
        }



        launch {
        val notes = Notes()
            notes.title = etNoteTitle.text.toString()
            notes.subTitle = etNoteSubTitle.text.toString()
            notes.noteText = etNoteDesc.text.toString()
            notes.dateTime = currentDate
            context?.let {
            NotesDatabase.getDatabase(it).noteDao().insertNotes(notes)
                etNoteTitle.setText("")
                etNoteSubTitle.setText("")
                etNoteDesc.setText("")
            }

        }
    }

    private fun replaceFragment(fragment: Fragment, istransition: Boolean) {
        val fragmentTransition = activity!!.supportFragmentManager.beginTransaction()

        if (istransition) {
            fragmentTransition.setCustomAnimations(
                android.R.anim.slide_out_right,
                android.R.anim.slide_in_left
            )
        }
        fragmentTransition.replace(R.id.frame_layout, fragment)
            .addToBackStack(fragment.javaClass.simpleName)
    }
}