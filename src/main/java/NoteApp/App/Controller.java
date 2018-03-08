package NoteApp.App;

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
        this.userRepository.insert(user);
    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable("id") String id){
        this.userRepository.deleteById(id);
    }

    @GetMapping("/users/{username}")
    public User getUserById(@PathVariable("username") String username){
        return this.userRepository.findByUsername(username);
    }

    @GetMapping("/users/{username}/notes")
    public List<Note> getUserNotes(@PathVariable("username") String username){
        return this.noteRepository.findByUser(this.userRepository.findByUsername(username));
    }

    @GetMapping("/notes")
    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    @PostMapping("/notes/insert")
    public void insertNote(@RequestBody Note note){
        this.noteRepository.insert(note);
    }

    @DeleteMapping("/notes/delete/{id}")
    public void deleteNote(@PathVariable("id") String id){
        this.noteRepository.deleteById(id);
    }
}
