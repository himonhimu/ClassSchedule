package bd.himu.himon.classschedule;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Design on 8/11/2018.
 */
@Entity (tableName = "ClassTable")
public class NotesModel {

    public NotesModel(String titleText, String bodyText) {
        this.titleText = titleText;
        this.bodyText = bodyText;
    }


    @PrimaryKey (autoGenerate =  true)
    private int id;
    @ColumnInfo (name = "title")
    private String titleText;
    @ColumnInfo (name = "body")
    private String bodyText;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        titleText = titleText;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        bodyText = bodyText;
    }
}
