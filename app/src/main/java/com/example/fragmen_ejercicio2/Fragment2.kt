package com.example.fragmen_ejercicio2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import java.lang.RuntimeException


class Fragment2 : Fragment() {

    interface CommunicationFragments{
        fun ReturnsData(data:String)
    }
    private  var activityContainer: CommunicationFragments ? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CommunicationFragments)
        activityContainer = context
        else throw RuntimeException(
            context.toString() + "Debe Implementar CommunicationFragments"
        )
    }

    override fun onDetach() {
        super.onDetach()
        activityContainer = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val button: Button = view!!.findViewById(R.id.btn_enviar2)
        button.setOnClickListener{
            val et:EditText = view!!.findViewById(R.id.editText2)
            activityContainer?.ReturnsData(et.text.toString())
        }
    }
}