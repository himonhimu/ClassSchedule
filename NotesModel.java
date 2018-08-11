package bd.himu.himon.classschedule;

/**
 * Created by Design on 8/11/2018.
 */

public class NotesModel {
    String TitleText, BodyText;

    public NotesModel() {
    }

    public NotesModel(String titleText, String bodyText) {
        TitleText = titleText;
        BodyText = bodyText;
    }

    public String getTitleText() {
        return TitleText;
    }

    public void setTitleText(String titleText) {
        TitleText = titleText;
    }

    public String getBodyText() {
        return BodyText;
    }

    public void setBodyText(String bodyText) {
        BodyText = bodyText;
    }
}
