package com.example.ta1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var importe = findViewById<TextView>(R.id.txtImporte)
        val ckb = arrayListOf<CheckBox>(
            findViewById(R.id.ckDolares),
            findViewById(R.id.ckEuros),
            findViewById(R.id.ckYenes)
        )

        for (checkBox in ckb) {
            checkBox.setOnClickListener {
                if (importe.text != null){
                    convertir(checkBox.tag.toString().toFloat(),importe.text.toString().toFloat())
                }
                for (otherCheckBox in ckb) {
                    if (otherCheckBox != checkBox) {
                        otherCheckBox.isChecked = false
                    }
                }
            }
        }
    }

    fun convertir(cambio:Float, importe:Float) {
        var total = findViewById<TextView>(R.id.txtTotal)
        total.text = (importe / cambio).toString()
    }
}