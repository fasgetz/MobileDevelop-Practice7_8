package com.example.practice_7

//import android.vi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    var Calculation = Calcul() // Логика



/*
    var db = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "populus-database"
    ).build()


            if (test != null) {
            val myToast = Toast.makeText(this, "Сущность не загружена", Toast.LENGTH_LONG)
            myToast.show()
        }
        else {
            val myToast = Toast.makeText(this, "Сущность загружена!!!", Toast.LENGTH_LONG)
            myToast.show()
        }

 */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tested)


        //var db = AppDatabase.getAppDataBase(this)
        //var dao = db?.MainVM_Dao()




    }



    fun Calc(view: View) {
        //aInput.setText("32423")

        val a = aInput.text.toString()
        val b = bInput.text.toString()
        val c = cInput.text.toString()

        if (a.toIntOrNull() != null && b.toIntOrNull() != null  && c.toIntOrNull() != null) {

            // Применяем класс
            var items = Calculation.EquationSquare(a.toInt(), b.toInt(), c.toInt())

            tvDiscr.setText("Дискриминант: ${Calculation.Discr}")
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