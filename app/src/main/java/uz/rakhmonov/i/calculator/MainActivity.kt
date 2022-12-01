package uz.rakhmonov.i.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    var number1 = 0.0
    var number2 = 1.0
    var amall = -1
    var hasAmal = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        off.setOnClickListener { ekran_txt.text = "" }
        AC.setOnClickListener { ekran_txt.text = "0" }
        backspace.setOnClickListener { delete() }
        vergul.setOnClickListener { vergulYoz() }
        plus.setOnClickListener { amalYoz(0) }
        minus.setOnClickListener { amalYoz(1) }
        kopaytir.setOnClickListener { amalYoz(2) }
        boluv.setOnClickListener { amalYoz(3) }
        tenglik.setOnClickListener { xisobla() }
        foiz.setOnClickListener { foizOl() }
        ildiz.setOnClickListener { ildizOl()  }
        bir.setOnClickListener { raqamYoz("1") }
        ikki.setOnClickListener { raqamYoz("2") }
        uch.setOnClickListener { raqamYoz("3") }
        tort.setOnClickListener { raqamYoz("4") }
        besh.setOnClickListener { raqamYoz("5") }
        olti.setOnClickListener { raqamYoz("6") }
        yetti.setOnClickListener { raqamYoz("7") }
        sakkiz.setOnClickListener { raqamYoz("8") }
        toqqiz.setOnClickListener { raqamYoz("9") }
        nol.setOnClickListener { raqamYoz("0") }

    }

    fun raqamYoz(raqam: String) {
        var ekran = ekran_txt.text.toString()
        if (ekran_txt.text != "") {
            if (ekran == "0" || hasAmal) {
                ekran = raqam
                hasAmal = false
            } else {
                ekran += raqam
            }
            ekran_txt.text = ekran
        }
    }

    fun delete() {
        val ekran = ekran_txt.text.toString()
        if (ekran_txt.text != "") {
            if (ekran.length == 1) {
                ekran_txt.text = "0"
            } else {
                ekran_txt.text = ekran.substring(0, ekran.length - 1)
            }
        }
    }

    private fun amalYoz(amal: Int) {
        if (ekran_txt.text != "") {
            amall = amal
            number1 = ekran_txt.text.toString().toDouble()
            hasAmal = true
        }
    }

    @SuppressLint("SetTextI18n")
    private fun xisobla() {
        if (ekran_txt.text != "") {
            number2 = ekran_txt.text.toString().toDouble()
            hasAmal = true

        }
        when (amall) {
            0 -> {
                ekran_txt.text = (number1 + number2).toString()
            }
            1 -> {
                ekran_txt.text = (number1 - number2).toString()
            }
            2 -> {
                ekran_txt.text = (number1 * number2).toString()
            }
            3 -> {
                ekran_txt.text = (number1 / number2).toString()
            }
        }

        amall = -1
        hasAmal = true
        number1 = 0.0
    }


    fun vergulYoz() {
        var ekran = ekran_txt.text.toString()
        if (ekran_txt.text != "") {
            if (!ekran.contains('.')) {
                ekran += ('.')
            }
            ekran_txt.text = ekran
        }
    }

    fun foizOl() {

        if (ekran_txt.text != "") {
            number2 = ekran_txt.text.toString().toDouble()

            var ekran = 0.0

            if (number1 != 0.0) {
                ekran = number1 * number2 * 0.01
            } else {
                ekran = number2 * 0.01
            }
            hasAmal = true

            ekran_txt.text = ekran.toString()

        }

    }

    fun ildizOl() {
        number1=0.0

        if (ekran_txt.text != "") {
            number1 = ekran_txt.text.toString().toDouble()
            var ekran = 0.0
            ekran= sqrt(number1)
            ekran_txt.text = ekran.toString()

        }
        hasAmal=true

    }
}

