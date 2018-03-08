package NoteApp.App;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/notes")
public class NotesController {
    private NoteRepository noteRepository;

    public NotesController(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    @GetMapping("/all")
    public List<Note> getAll(){
        return noteRepository.findAll();
    }
}
