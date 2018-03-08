package NoteApp.App;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private UserRepository userRepository;
    private NoteRepository noteRepository;

    public Controller(UserRepository userRepository, NoteRepository noteRepository){
        this.userRepository = userRepository;
        this.noteRepository = noteRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/users/insert")
    public void insertUser(@RequestBody User user){
        //Username should not exist
        User user1 = userRepository.findByUsername(user.getUsername());
        if(user1!=null){
            System.out.println("insertUser with already existent username");
            return;
        }

        this.userRepository.insert(user);
    }

    @GetMapping("/users/username/{username}")
    public User getUserByUsername(@PathVariable("username") String username){
        return this.userRepository.findByUsername(username);
    }

    @GetMapping("/users/username/{username}/notes")
    public List<Note> getUserNotesByUsername(@PathVariable("username") String username){
        return this.noteRepository.findByUser(this.userRepository.findByUsername(username));
    }

    @PostMapping("/users/username/{username}/notes/insert")
    public void insertNoteOfUserByUsername(@PathVariable("username") String username, @RequestBody Note note){
        note.setUser(this.userRepository.findByUsername(username));
        this.noteRepository.insert(note);
    }

    @DeleteMapping("/users/username/{username}/delete")
    public void deleteUserByUsername(@PathVariable("username") String username){
        this.userRepository.deleteByUsername(username);
    }

    @GetMapping("/users/id/{id}")
    public User getUserById(@PathVariable("id") String id){
        return this.userRepository.findById(id).orElse(null);
    }

    @GetMapping("/users/id/{id}/notes")
    public List<Note> getUserNotesById(@PathVariable("username") String id){
        return this.noteRepository.findByUser(this.userRepository.findById(id).orElse(null));
    }

    @PostMapping("/users/id/{id}/notes/insert")
    public void insertNoteOfUserById(@PathVariable("id") String id, @RequestBody Note note){
        note.setUser(this.userRepository.findById(id).orElse(null));
        this.noteRepository.insert(note);
    }

    @DeleteMapping("/users/id/{id}/delete")
    public void deleteUserById(@PathVariable("id") String id){
        this.userRepository.deleteById(id);
    }

    @GetMapping("/notes")
    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    @PostMapping("/notes/insert")
    public void insertNote(@RequestBody Note note){
        //User should exist
        User user = userRepository.findByUsername(note.getUser().getUsername());
        if(user == null){
            System.out.println("insertNote with non-existent user");
            return;
        }

        //Names of users should be equals
        if(!note.getUser().getName().equals(user.getName())){
            System.out.println("insertNote with not-equal name of user");
            return;
        }

        //Assuring the same user Id
        if(note.getUser().getId() == null) note.setUser(user);
        else if(!note.getUser().getId().equals(user.getId())){
            System.out.println("insertNote with non-equal id of user");
            return;
        }

        this.noteRepository.insert(note);
    }

    @DeleteMapping("/notes/{id}/delete")
    public void deleteNote(@PathVariable("id") String id){
        this.noteRepository.deleteById(id);
    }

    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable("id") String id){
        return this.noteRepository.findById(id).orElse(new Note());
    }
}
