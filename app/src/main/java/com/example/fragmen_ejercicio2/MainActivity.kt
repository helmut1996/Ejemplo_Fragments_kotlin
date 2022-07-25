package com.example.fragmen_ejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.fragmen_ejercicio2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),
    Fragment2.CommunicationFragments{

    lateinit var binding: ActivityMainBinding
    var NumberFragments = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener{
            //se crada para pasar el tipo de dato en el fragments
            var bundle = Bundle()
            bundle.putInt("number",++NumberFragments)

             val  transacction = supportFragmentManager.beginTransaction()
              val fragment1 = Fragment1()
            // Aqui se captura los argumentos que se estan tomando
            fragment1.arguments = bundle
            transacction.replace(R.id.Contenedor,fragment1)
            transacction.addToBackStack(null)
            transacction.commit()
        }

        binding.button2.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            val fragment2 = Fragment2()
            transaction.replace(R.id.Contenedor,fragment2)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.button3.setOnClickListener{
            val transaction3  = supportFragmentManager.beginTransaction()
            val fragment3 = Fragment3()
            transaction3.replace(R.id.Contenedor, fragment3)
            transaction3.addToBackStack(null)
            transaction3.commit()
        }
    }

    // se captura el dato en  la activity principal y se muestra
    override fun ReturnsData(data: String) {
        binding.texto.setText(data)
    }
}