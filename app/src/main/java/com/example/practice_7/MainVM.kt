package com.example.practice_7

import android.content.Context
import androidx.room.*

/*


@Entity
class MainVM {
    var aInput: Double? = null
    var bInput: Double? = null
    var cInput: Double? = null
    var x1res: Double? = null
    var x2res: Double? = null


}

@Dao
interface MainVMDao {
    // Добавление
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vm: MainVM?)

    // Удаление vm из бд
    @Delete
    fun delete(vm: MainVM?)

    // Получение VM из бд
    @get:Query("SELECT * FROM MainVM")
    val getVm: MainVM?

}

@Database(entities = [MainVM::class /*, AnotherEntityType.class, AThirdEntityType.class */], version = 1)
abstract class AppDB : RoomDatabase() {
    abstract val mainVM_dao: MainVMDao?
}


@Database(entities = [MainVM::class /*, AnotherEntityType.class, AThirdEntityType.class */], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun MainVM_Dao(): MainVMDao

    companion object {
        var INSTANCE: AppDataBase? = null

        fun getAppDataBase(context: Context): AppDataBase? {
            if (INSTANCE == null){
                synchronized(AppDataBase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDataBase::class.java, "myDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}

 */

