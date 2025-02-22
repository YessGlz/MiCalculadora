package parra.mario.micalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //0->nada; 1->suma; 2->resta; 3->mult; 4->div
    var oper: Int = 0
    var numero1: Double = 0.0
    lateinit var tv_num1: TextView
    lateinit var tv_num2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIgual: Button = findViewById(R.id.btnIgual)
        val btnBorrar: Button = findViewById(R.id.btnBorrar)
        tv_num1 = findViewById(R.id.tv_num1)
        tv_num2 = findViewById(R.id.tv_num2)

        btnIgual.setOnClickListener {
            var num2 = tv_num2.text.toString().toDouble()
            var res = 0.0
            when (oper) {
                1 -> res = numero1 + num2
                2 -> res = numero1 - num2
                3 -> res = numero1 * num2
                4 -> res = numero1 / num2
            }
            tv_num2.setText(res.toString())
            tv_num1.setText("")
        }

        btnBorrar.setOnClickListener {
            tv_num1.setText("")
            tv_num2.setText("")
            oper = 0
        }

        // Setup conversion buttons
        val btnMXNtoUSD: Button = findViewById(R.id.button13)
        val btnLtoML: Button = findViewById(R.id.button14)
        val btnMItoM: Button = findViewById(R.id.button15)
        val btnKMtoM: Button = findViewById(R.id.btnOval)  // Nuevo botón para KM a M

        btnMXNtoUSD.setOnClickListener { convertMXNtoUSD() }
        btnLtoML.setOnClickListener { convertLtoML() }
        btnMItoM.setOnClickListener { convertMItoM() }
        btnKMtoM.setOnClickListener { convertKMtoM() }  // Asignación de función al nuevo botón
    }

    fun clicNumero(view: View) {
        var num2 = tv_num2.text.toString()

        when (view.id) {
            R.id.btn0 -> tv_num2.setText(num2 + "0")
            R.id.btn1 -> tv_num2.setText(num2 + "1")
            R.id.btn2 -> tv_num2.setText(num2 + "2")
            R.id.btn3 -> tv_num2.setText(num2 + "3")
            R.id.btn4 -> tv_num2.setText(num2 + "4")
            R.id.btn5 -> tv_num2.setText(num2 + "5")
            R.id.btn6 -> tv_num2.setText(num2 + "6")
            R.id.btn7 -> tv_num2.setText(num2 + "7")
            R.id.btn8 -> tv_num2.setText(num2 + "8")
            R.id.btn9 -> tv_num2.setText(num2 + "9")
            R.id.btnPunto -> tv_num2.setText(num2 + ".")
        }
    }

    fun clicOperacion(view: View) {
        var num2 = tv_num2.text.toString()
        numero1 = num2.toString().toDouble()
        tv_num2.setText("")
        when (view.id) {
            R.id.btnSumar -> {
                tv_num1.setText(num2 + "+")
                oper = 1
            }
            R.id.btnRestar -> {
                tv_num1.setText(num2 + "-")
                oper = 2
            }
            R.id.btnMult -> {
                tv_num1.setText(num2 + "*")
                oper = 3
            }
            R.id.btnDividir -> {
                tv_num1.setText(num2 + "/")
                oper = 4
            }
        }
    }

    private fun convertMXNtoUSD() {
        val mxn = tv_num2.text.toString().toDoubleOrNull()
        if (mxn != null) {
            val usd = mxn * 0.057  // Aquí puedes ajustar el valor de conversión según sea necesario
            tv_num2.setText(usd.toString())
            tv_num1.setText("$mxn MXN = $usd USD")
        }
    }

    private fun convertLtoML() {
        val liters = tv_num2.text.toString().toDoubleOrNull()
        if (liters != null) {
            val milliliters = liters * 1000
            tv_num2.setText(milliliters.toString())
            tv_num1.setText("$liters L = $milliliters mL")
        }
    }

    private fun convertMItoM() {
        val miles = tv_num2.text.toString().toDoubleOrNull()
        if (miles != null) {
            val meters = miles * 1609.34
            tv_num2.setText(meters.toString())
            tv_num1.setText("$miles mi = $meters m")
        }
    }

    private fun convertKMtoM() {
        val kilometers = tv_num2.text.toString().toDoubleOrNull()
        if (kilometers != null) {
            val meters = kilometers * 1000
            tv_num2.setText(meters.toString())
            tv_num1.setText("$kilometers km = $meters m")
        }
    }
}
