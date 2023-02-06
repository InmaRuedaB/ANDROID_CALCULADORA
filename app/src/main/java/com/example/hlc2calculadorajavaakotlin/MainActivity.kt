package com.example.hlc2calculadorajavaakotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var tv: TextView? = null
    var tvm: TextView? = null
    var operacion = 0
    var n1 = 0.0f
    var n2 = 0.0f
    var resul = 0.0f
    var mem = 0.0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.textView)
        tvm = findViewById(R.id.textViewMen)
        val btn0 = findViewById<Button>(R.id.btn0)
        btn0.setOnClickListener(imprimeNum)
        val btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener(imprimeNum)
        val btn2 = findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener(imprimeNum)
        val btn3 = findViewById<Button>(R.id.btn3)
        btn3.setOnClickListener(imprimeNum)
        val btn4 = findViewById<Button>(R.id.btn4)
        btn4.setOnClickListener(imprimeNum)
        val btn5 = findViewById<Button>(R.id.btn5)
        btn5.setOnClickListener(imprimeNum)
        val btn6 = findViewById<Button>(R.id.btn6)
        btn6.setOnClickListener(imprimeNum)
        val btn7 = findViewById<Button>(R.id.btn7)
        btn7.setOnClickListener(imprimeNum)
        val btn8 = findViewById<Button>(R.id.btn8)
        btn8.setOnClickListener(imprimeNum)
        val btn9 = findViewById<Button>(R.id.btn9)
        btn9.setOnClickListener(imprimeNum)
        val btnPun = findViewById<Button>(R.id.btnPun)
        btnPun.setOnClickListener(imprimeNum)
        val btnAc = findViewById<Button>(R.id.btnAc)
        btnAc.setOnClickListener(borrar)
        val btnC = findViewById<Button>(R.id.btnC)
        btnC.setOnClickListener(borrar)
        val btnSetMem = findViewById<Button>(R.id.btnSetMem)
        btnSetMem.setOnClickListener(memoria)
        val btnGetMem = findViewById<Button>(R.id.btnGetMem)
        btnGetMem.setOnClickListener(memoria)
        val btnDiv = findViewById<Button>(R.id.btnDiv)
        btnDiv.setOnClickListener(recibeOperacion)
        val btnMul = findViewById<Button>(R.id.btnMul)
        btnMul.setOnClickListener(recibeOperacion)
        val btnRes = findViewById<Button>(R.id.btnRes)
        btnRes.setOnClickListener(recibeOperacion)
        val btnSum = findViewById<Button>(R.id.btnSum)
        btnSum.setOnClickListener(recibeOperacion)
        val btnIgu = findViewById<Button>(R.id.btnIgu)
        btnIgu.setOnClickListener(realizaOperacion)
    }

    private val imprimeNum = View.OnClickListener { view ->
        if (tv!!.text as String === "0") tv!!.text = ""
        when (view.id) {
            R.id.btn0 -> tv!!.text = tv!!.text.toString() + "0"
            R.id.btn1 -> tv!!.text = tv!!.text.toString() + "1"
            R.id.btn2 -> tv!!.text = tv!!.text.toString() + "2"
            R.id.btn3 -> tv!!.text = tv!!.text.toString() + "3"
            R.id.btn4 -> tv!!.text = tv!!.text.toString() + "4"
            R.id.btn5 -> tv!!.text = tv!!.text.toString() + "5"
            R.id.btn6 -> tv!!.text = tv!!.text.toString() + "6"
            R.id.btn7 -> tv!!.text = tv!!.text.toString() + "7"
            R.id.btn8 -> tv!!.text = tv!!.text.toString() + "8"
            R.id.btn9 -> tv!!.text = tv!!.text.toString() + "9"
            R.id.btnPun -> {
                if (tv!!.text as String === "") tv!!.text = "0"
                tv!!.text = tv!!.text.toString() + "."
            }
        }
    }
    private val borrar = View.OnClickListener { view ->
        if (view.id == R.id.btnAc) {
            n1 = 0.0f
            n2 = 0.0f
            mem = 0.0f
            tvm!!.text = ""
        } else if (n1 != 0f && n2 == 0f && tv!!.text as String === "0") {
            n1 = 0.0f
        } else if (n1 != 0f && n2 != 0f) {
            n2 = 0.0f
        }
        resul = 0.0f
        tv!!.text = "0"
    }
    private val memoria = View.OnClickListener { view ->
        when (view.id) {
            R.id.btnSetMem -> {
                mem = tv!!.text.toString().toFloat()
                tvm!!.text = "M"
            }
            R.id.btnGetMem -> {
                asignarMemoria()
                tv!!.text = mem.toString()
                mem = 0.0f
                tvm!!.text = ""
            }
        }
    }

    private fun asignarMemoria() {
        if (n1 != 0f && n2 == 0f) n2 = mem else n1 = mem
    }

    private val recibeOperacion = View.OnClickListener { view ->
        n1 = tv!!.text.toString().toFloat()
        tv!!.text = "0"
        when (view.id) {
            R.id.btnSum -> operacion = 1
            R.id.btnRes -> operacion = 2
            R.id.btnMul -> operacion = 3
            R.id.btnDiv -> operacion = 4
        }
    }
    private val realizaOperacion = View.OnClickListener {
        n2 = tv!!.text.toString().toFloat()
        when (operacion) {
            1 -> resul = n1 + n2
            2 -> resul = n1 - n2
            3 -> resul = n1 * n2
            4 -> resul = n1 / n2
        }
        tv!!.text = java.lang.Float.toString(resul)
        n1 = 0.0f
        n2 = 0.0f
    }
}