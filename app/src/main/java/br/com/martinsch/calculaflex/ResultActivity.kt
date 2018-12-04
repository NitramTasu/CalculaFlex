package br.com.martinsch.calculaflex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.martinsch.calculaflex.extensions.format
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        calculate()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun calculate() {
        val gasPrice = intent.extras.getDouble(getString(R.string.gas_price_key), 0.0)
        val ethanolPrice = intent.extras.getDouble(getString(R.string.ethanol_price_key), 0.0)
        val gasAverage = intent.extras.getDouble(getString(R.string.gas_average_price_key), 0.0)
        val ethanolAverage = intent.extras.getDouble(getString(R.string.ethanol_average_price_key), 0.0)

        val performanceMyCar = ethanolAverage / gasAverage
        val priceIndice = ethanolPrice / gasPrice

        if (priceIndice <= performanceMyCar) {
            tvSuggestion.text = getString(R.string.etanol)
        } else {
            tvSuggestion.text = getString(R.string.gasolina)
        }

        tvGasAverageResult.text = (gasPrice / gasAverage).format(2)
        tvEthanolAverageResult.text = (ethanolPrice / ethanolAverage).format(2)

        tvFuelRatio.text = getString(R.string.label_ration_label, performanceMyCar.format(2))
    }

}
