package com.example.practice_7

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.aInput
import kotlinx.android.synthetic.main.activity_main.bInput
import kotlinx.android.synthetic.main.activity_main.cInput
import kotlinx.android.synthetic.main.activity_main.x1ress
import kotlinx.android.synthetic.main.activity_main.x2resss
import kotlinx.android.synthetic.main.tested.*


class tested : AppCompatActivity() {

    var Calculation = Calcul() // Логика


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tested)
        //setSupportActionBar(toolbar)
        //toolbars = findViewById(R.id.)

    }

    fun Calc(view: View) {
        //aInput.setText("32423")

        val a = aInput.text.toString()
        val b = bInput.text.toString()
        val c = cInput.text.toString()

        if (a.toIntOrNull() != null && b.toIntOrNull() != null  && c.toIntOrNull() != null) {

            if (a.toInt() != 0) {
                // Применяем класс
                var items = Calculation.EquationSquare(a.toInt(), b.toInt(), c.toInt())

                if (items.roots.count() == 0) {
                    val myToast = Toast.makeText(this, "Корней нет", Toast.LENGTH_SHORT)
                    myToast.show()
                }
                else if (items.roots.count() == 1) {
                    x1res.setText("${items.roots[0]}")
                }
                else {
                    x1res.setText("${items.roots[0]}")
                    x2res.setText("${items.roots[1]}")
                }
            }

            else {
                val myToast = Toast.makeText(this, "a не может быть = 0", Toast.LENGTH_SHORT)
                myToast.show()
            }

        }
        else {
            val myToast = Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT)
            myToast.show()
        }
    }


}