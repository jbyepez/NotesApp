package NoteApp.App;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Note {
    @Id
    private String id;
    private String text;
    private Date date;
    private User user;

    public Note(String text, Date date, User user){
        this.text = text;
        this.date = date;
        this.user = user;
    }

    public String getId(){
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public Date getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString(){
        return String.format(
                "Note[id=%s, text='%s', date=%s, user=%s]",
                this.id, this.text, this.date.toString(), this.user.toString());
    }
}
