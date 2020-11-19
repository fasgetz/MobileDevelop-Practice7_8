package com.example.practice_7

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }





}


class CalculationTest {


    @Test
    fun ThoRoots() {
        var Calculation = Calcul() // Логика
        var roots = Calculation.EquationSquare(1,17,-18)

        assertEquals(2, roots.count())
    }

    @Test
    fun OneRoot() {
        var Calculation = Calcul() // Логика
        var roots = Calculation.EquationSquare(2,-4,2)

        assertEquals(1, roots.count())
    }

    @Test
    fun NotRoot() {
        var Calculation = Calcul() // Логика
        var roots = Calculation.EquationSquare(1,1,1)

        assertEquals(0, roots.count())
    }
}