package com.example.practice_7

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.*
import kotlinx.android.synthetic.main.tested.*
import kotlinx.coroutines.*


class tested : AppCompatActivity() {

    var Calculation = Calcul() // Логика
    var vm: MainViewModel? = null // вью модель


    fun OnStopDB() {
        runBlocking {
            launch(Dispatchers.Default) {

                try {
                    val db = Room.databaseBuilder(
                        applicationContext,
                        appDataBase::class.java, "appDataBase"
                    ).build()

                    var dao = db?.userDao()

                    vm?.aInput = aInput.text.toString().toIntOrNull()
                    vm?.bInput = bInput.text.toString().toIntOrNull()
                    vm?.cInput = cInput.text.toString().toIntOrNull()
                    vm?.x1res = x1res.text.toString().toDoubleOrNull()
                    vm?.x2res = x2res.text.toString().toDoubleOrNull()



                    dao?.insertNotification(vm)
                }
                catch (ex: Exception) {
                    //val myToast = Toast.makeText(this, ex.message, Toast.LENGTH_LONG)
                    //myToast.show()
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()


    }


    fun OnCreateDB() {
        try {

            val db = Room.databaseBuilder(
                applicationContext,
                appDataBase::class.java, "appDataBase"
            ).build()

            var dao = db?.userDao()

            //vm = MainViewModel()
            //vm?.setFie_id(100)
            //vm?.aInput = 123



            //val myToast = Toast.makeText(this, "${vm?.getFie_id()} - ${vm?.aInput}", Toast.LENGTH_LONG)
            //myToast.show()
            var counts: List<MainViewModel?>? = null

            runBlocking {
                launch(Dispatchers.Default) {

                    //dao?.insertNotification(vm)
                    vm = dao?.first
                    counts = dao?.all

                    if (vm?.aInput != null)
                        aInput.setText(vm?.aInput.toString())

                    if (vm?.bInput != null)
                        bInput.setText(vm?.bInput.toString())

                    if (vm?.cInput != null)
                        cInput.setText(vm?.cInput.toString())

                    if (vm?.x1res != null)
                        x1res.setText(vm?.x1res.toString())

                    if (vm?.x2res != null)
                        x2res.setText(vm?.x2res.toString())

                }
            }









            //vm?.value?.setFie_id(112)
            //dao?.insertNotification(vm)



            if (vm != null) {
                val myToast = Toast.makeText(this, "${counts?.count()} - Сущность загружена, ${vm?.aInput}, ${vm?.getFie_id()}", Toast.LENGTH_LONG)
                myToast.show()
            }
            else {
                val myToast = Toast.makeText(this, "Сущность не загружена!!!, ${vm?.getFie_id()}\"", Toast.LENGTH_LONG)
                myToast.show()


            }


        }
        catch (ex: Exception) {
            val myToast = Toast.makeText(this, ex.message, Toast.LENGTH_LONG)
            myToast.show()
        }
    }

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

            if (a.toInt() != 0) {
                // Применяем класс

                //discr.setText(Calculation.Discr)

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