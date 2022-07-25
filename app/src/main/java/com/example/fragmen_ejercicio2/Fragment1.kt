package com.example.fragmen_ejercicio2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

class Fragment1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        esta es la accion para mostrar los datos recibidos em el fragment
        if (arguments != null){
            val NumFragments = arguments!!.getInt("number")
            val et: EditText = view!!.findViewById(R.id.editText1)
            et.setText("Capturando $NumFragments")
        }
    }
}