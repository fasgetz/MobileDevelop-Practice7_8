package com.example.practice_7

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Entity(tableName = "notifications")
class MainViewModel {
    @PrimaryKey(autoGenerate = true)
    private var fie_id: Long = 0

    fun getFie_id(): Long? {
        return fie_id
    }

    fun setFie_id(fie_id: Long) {
        this.fie_id = fie_id
    }

    var aInput: Int? = null
    var bInput: Int? = null
    var cInput: Int? = null
    var x1res: Double? = null
    var x2res: Double? = null
    var Discr: Int? = null
}

@Dao
interface NotificationDao {
    @get:Query("SELECT * FROM notifications")
    val all: List<MainViewModel?>?

    @get:Query("SELECT * FROM notifications limit 1")
    val first: MainViewModel?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotification(vm: MainViewModel?)


    @Update
    fun updateNotification(notificationDetail: MainViewModel?)

    @Delete
    fun delete(vm: MainViewModel?)
}

@Database(entities = [MainViewModel::class], version = 1)
abstract class appDataBase : RoomDatabase() {
    abstract fun userDao(): NotificationDao?


    companion object {
        private const val DATABASE_NAME = "appDataBase"
        private var INSTANCE: appDataBase? = null

        // is migration really needed?


        fun getAppDatabase(context: Context): appDataBase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    appDataBase::class.java, DATABASE_NAME
                ) // allow queries on the main thread.
                    // Don't do this on a real app! See PersistenceBasicSample for an example.
                    .allowMainThreadQueries()
                    //.fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}