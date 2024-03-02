package mx.tec.segundoexamen.utility

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import mx.tec.segundoexamen.dao.RecordatorioDao
import mx.tec.segundoexamen.model.Recordatorio

@Database(entities = [Recordatorio::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDataBase: RoomDatabase() {
    abstract fun recordatorioDao(): RecordatorioDao

    companion object {
        private var INSTANCE: AppDataBase? = null
        fun getInstance(context: Context): AppDataBase? {
            if (INSTANCE == null) {
                synchronized(AppDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDataBase::class.java, "app_database")
                        .build()
                }
            }
            return INSTANCE as AppDataBase
        }
    }
}