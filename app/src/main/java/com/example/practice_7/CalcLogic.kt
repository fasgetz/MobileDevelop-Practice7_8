package com.example.practice_7

import java.lang.Math.sqrt

class Calcul {

    public var Discr: Int = 0


    fun EquationSquare(a: Int, b: Int, c: Int): List<Double> {
        Discr = (b*b) - (4 * a * c)


        val numbers = arrayListOf<Double>()
        if (Discr == 0) {

            val x: Double = (-b / 2 * a).toDouble()

            numbers.add(x)
        }
        else if (Discr > 0) {

            val x1 = (-b + sqrt(Discr.toDouble())) / 2 * a
            val x2 = (-b - sqrt(Discr.toDouble())) / 2 * a

            numbers.add(x1)
            numbers.add(x2)
        }
        else {
            // Корней нет
        }

        return numbers
    }
}