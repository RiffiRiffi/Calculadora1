package com.example.calculadora1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnUno.setOnClickListener { numeroPresionado( digito = "1") }
        btnDos.setOnClickListener { numeroPresionado( digito = "2") }
        btnTres.setOnClickListener { numeroPresionado( digito = "3") }
        btnCuatro.setOnClickListener { numeroPresionado( digito = "4") }
        btnCinco.setOnClickListener { numeroPresionado( digito = "5") }
        btnSeis.setOnClickListener { numeroPresionado( digito = "6") }
        btnSiete.setOnClickListener { numeroPresionado( digito = "7") }
        btnOcho.setOnClickListener { numeroPresionado( digito = "8") }
        btnNueve.setOnClickListener { numeroPresionado( digito = "9") }
        btnCero.setOnClickListener { numeroPresionado( digito = "0") }
        btnPunto.setOnClickListener { numeroPresionado( digito = ".") }

        btnSuma.setOnClickListener { operacionPresionada(Suma) }
        btnResta.setOnClickListener { operacionPresionada(Resta) }
        btnMultiplicacion.setOnClickListener { operacionPresionada(Multiplicacion) }
        btnDivision.setOnClickListener { operacionPresionada(Division) }

        btnClear.setOnClickListener {
            num1 = 0.0
            num2 = 0.0
            resultadoPantalla.text = "0"
            operacion = noOperacion
        }
        btnIgual.setOnClickListener {
        var resultado = when(operacion){
            Suma -> num1 + num2
            Resta -> num1 - num2
            Multiplicacion -> num1 * num2
            Division -> num1 / num2
            else -> 0
            }
            resultadoPantalla.text = resultado.toString()
                num1 = resultadoPantalla.text.toString().toDouble()
            resultadoPantalla.text = if("$resultado".endsWith(".0")) { "$resultado".replace(".0","") } else { "%.2f".format(resultado) }

        }
    }
    private fun numeroPresionado(digito: String){

        if(resultadoPantalla.text == "0" && digito != ".") {
            resultadoPantalla.text = "$digito"
        } else {
            resultadoPantalla.text = "${resultadoPantalla.text}$digito"
        }
        if (operacion == noOperacion){
            num1 = resultadoPantalla.text.toString().toDouble()
        }
        else{
            num2 = resultadoPantalla.text.toString().toDouble()
        }
    }
    private fun operacionPresionada(operacion: Int){
        this.operacion = operacion


        resultadoPantalla.text = "0"

    }
    companion object{
        const val Suma = 1
        const val Resta = 2
        const val Multiplicacion = 3
        const val Division = 4
        const val noOperacion = 0
    }
}