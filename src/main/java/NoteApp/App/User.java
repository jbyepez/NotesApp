package NoteApp.App;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String id;
    private String username;
    private String name;

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

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, username='%s']",
                this.id, this.username);
    }
}
