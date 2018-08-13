package bd.himu.himon.classschedule;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Design on 8/12/2018.
 */

@Dao
public abstract class ClassDao {
    @Query("SELECT * FROM ClassTable")
    abstract List<NotesModel> getAllClass();


    @Insert
    abstract void insertAll(NotesModel... users);

    @Delete
    abstract void deletenow(NotesModel id);

   @Update
    abstract void update(NotesModel notesModel);

}
