package mx.tec.segundoexamen.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import mx.tec.segundoexamen.model.Recordatorio

@Dao
interface RecordatorioDao {
    @Query("SELECT * FROM Recordatorio")
    fun obtenerRecordatorios(): List<Recordatorio>

    @Insert
    fun insertarRecordatorio(recordatorio: Recordatorio)

    @Query("DELETE FROM Recordatorio")
    fun deleteAll()
}