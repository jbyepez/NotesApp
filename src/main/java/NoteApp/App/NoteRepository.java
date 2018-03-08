package NoteApp.App;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note,String> {
    public List<Note> findByUser(User user);
}
