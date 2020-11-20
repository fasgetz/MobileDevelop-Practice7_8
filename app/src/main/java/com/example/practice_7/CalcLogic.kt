package com.example.practice_7

import java.lang.Math.sqrt

class Calcul {

    public var Discr: Int = 0


    fun EquationSquare(a: Int, b: Int, c: Int): MyEnum {


        Discr = (b*b) - (4 * a * c)

        val numbers = arrayListOf<Double>()
        var enum = MyEnum(numbers, "")

        // Если a == 0, то уравнение не квадратное
        if (a != 0)
            if (Discr == 0) {

                val x: Double = (-b / (2 * a)).toDouble()

                numbers.add(x)
                enum = MyEnum(numbers, "Один корень")
            }
            else if (Discr > 0) {

                val x1 = (-b + sqrt(Discr.toDouble())) / (2 * a)
                val x2 = (-b - sqrt(Discr.toDouble())) / (2 * a)

                numbers.add(x1)
                numbers.add(x2)
                enum = MyEnum(numbers, "Два корня")
            }
            else {
                enum = MyEnum(numbers, "Нет корней")
            }
        else {
            enum = MyEnum(numbers, "а не может быть = 0")
        }

        return enum
    }
}


data class MyEnum(val roots: List<Double>, val message: String) {

}