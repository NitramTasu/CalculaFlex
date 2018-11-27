package br.com.martinsch.calculaflex

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        btCalculate.setOnClickListener {
            val proximaTela = Intent(this, ResultActivity::class.java)
            proximaTela.putExtra("GAS_PRICE","")
            proximaTela.putExtra("ETHANOL_PRICE","")
            proximaTela.putExtra("GAS_AVERAGE","")
            proximaTela.putExtra("ETHANOL_AVERAGE","")
            startActivity(proximaTela)
        }
    }
}
