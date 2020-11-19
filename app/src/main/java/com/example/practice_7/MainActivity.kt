package com.example.practice_7

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import androidx.appcompat.app.AlertDialog

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.text.set

import androidx.fragment.app.DialogFragment
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {


    var Calculation = Calcul() // Логика

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




    }



    fun Calc(view: View) {
        //aInput.setText("32423")

        val a = aInput.text.toString()
        val b = bInput.text.toString()
        val c = cInput.text.toString()

        if (a.toIntOrNull() != null && b.toIntOrNull() != null  && c.toIntOrNull() != null) {

            // Применяем класс
            var items = Calculation.EquationSquare(a.toInt(), b.toInt(), c.toInt())

            if (items.count() == 0) {
                val myToast = Toast.makeText(this, "Корней нет", Toast.LENGTH_SHORT)
                myToast.show()
            }
            else if (items.count() == 1) {
                x1res.setText("x1: ${items[0]}")
            }
            else {
                x1res.setText("x1: ${items[0]}")
                x2res.setText("x2: ${items[1]}")
            }

        }
        else {
            val myToast = Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT)
            myToast.show()
        }
    }



}