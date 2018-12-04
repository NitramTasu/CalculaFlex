package br.com.martinsch.calculaflex.extensions

fun Double.format(digits: Int) = String.format("%.${digits}f", this)