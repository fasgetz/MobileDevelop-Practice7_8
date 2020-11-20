package com.example.practice_7

import android.os.Bundle
//import android.vi
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    var Calculation = Calcul() // Логика


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tested)





    }



    fun Calc(view: View) {
        //aInput.setText("32423")

        val a = aInput.text.toString()
        val b = bInput.text.toString()
        val c = cInput.text.toString()

        if (a.toIntOrNull() != null && b.toIntOrNull() != null  && c.toIntOrNull() != null) {

            // Применяем класс
            var items = Calculation.EquationSquare(a.toInt(), b.toInt(), c.toInt())

            discr.setText("Дискриминант: ${Calculation.Discr}")
            if (items.roots.count() == 0) {
                val myToast = Toast.makeText(this, "Корней нет", Toast.LENGTH_SHORT)
                myToast.show()
            }
            else if (items.roots.count() == 1) {
                x1ress.setText("x1: ${items.roots[0]}")
            }
            else {
                x1ress.setText("x1: ${items.roots[0]}")
                x2resss.setText("x2: ${items.roots[1]}")
            }

        }
        else {
            val myToast = Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT)
            myToast.show()
        }
    }



}