package bd.himu.himon.classschedule;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Design on 8/12/2018.
 */
@Database(entities = {NotesModel.class}, version = 1)
public abstract class AppsDatabase extends  RoomDatabase {


    public abstract ClassDao classDao();
}


