package NoteApp.App;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    @Id
    private String id;
    @Indexed
    private String username;
    private String name;

    public User(){}

    public User(String username, String name){
        this.username = username;
        this.name = name;
    }

    public String getId(){
        return this.id;
    }

    public String getUsername(){
        return this.username;
    }

    public String getName(){
        return this.name;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public  void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, username='%s', name='%s']",
                this.id, this.username, this.name
        );
    }
}
