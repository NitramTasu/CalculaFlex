package br.com.martinsch.calculaflex

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.martinsch.calculaflex.extensions.getDouble
import br.com.martinsch.calculaflex.watchers.DecimalTextWatcher
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        etGasPrice.addTextChangedListener(DecimalTextWatcher(etGasPrice, 1))
        etEthanolPrice.addTextChangedListener(DecimalTextWatcher(etEthanolPrice, 1))

        btCalculate.setOnClickListener {
            val proximaTela = Intent(this, ResultActivity::class.java)
            proximaTela.putExtra(getString(R.string.gas_price_key),etGasPrice.getDouble())
            proximaTela.putExtra(getString(R.string.ethanol_price_key),etEthanolPrice.getDouble())
            proximaTela.putExtra(getString(R.string.gas_average_price_key),etGasAverage.getDouble())
            proximaTela.putExtra(getString(R.string.ethanol_average_price_key),etEthanolAverage.getDouble())
            startActivity(proximaTela)
        }
    }
}
