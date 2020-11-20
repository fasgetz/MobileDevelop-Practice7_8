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

        assertEquals(2, roots.roots.count())
        assertEquals("Два корня", roots.message)
    }

    @Test
    fun OneRoot() {
        var Calculation = Calcul() // Логика
        var roots = Calculation.EquationSquare(2,-4,2)


        assertEquals(1, roots.roots.count())
        assertEquals("Один корень", roots.message)
    }

    @Test
    fun NotRoot() {
        var Calculation = Calcul() // Логика
        var roots = Calculation.EquationSquare(1,1,1)

        assertEquals(0, roots.roots.count())
        assertEquals("Нет корней", roots.message)
    }


    @Test
    fun NotSquare() {
        var Calculation = Calcul() // Логика
        val a: Int = 0
        val b: Int = 5
        val c: Int = 10

        var roots = Calculation.EquationSquare(a,b,c)

        assertEquals("а не может быть = 0", roots.message)
    }

    // a = 0
    // 2 4 2 = -1
}