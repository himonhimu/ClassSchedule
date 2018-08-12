package bd.himu.himon.classschedule;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Design on 8/12/2018.
 */

@Dao
public abstract class ClassDao {
    @Query("SELECT * FROM ClassTable")
    abstract List<NotesModel> getAllClass();
    @Insert
    abstract void insetAll(NotesModel...users);

}
