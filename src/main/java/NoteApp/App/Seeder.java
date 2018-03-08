package NoteApp.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Component
public class Seeder implements CommandLineRunner {

    @Autowired
    private NoteRepository repository;

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        User Camilo = new User("camil0","Camilo");
        User John = new User("jojo","John");
        User Eliana = new User("eli","Eliana");
        User Mariana = new User("mari","Mariana");

        Note n1 = new Note(
                "Comer",
                new GregorianCalendar(2018, Calendar.MARCH,7,8,0,0).getTime(),
                John
        );
        Note n2 = new Note(
                "Alistarse para dormir",
                new GregorianCalendar(2018, Calendar.MARCH,7,7,30,0).getTime(),
                Mariana
        );

        // save a couple of customers
        repository.save(n1);
        repository.save(n2);

        // fetch all customers
        System.out.println("Notes found with findAll():");
        System.out.println("-------------------------------");
        for (Note note : repository.findAll()) {
            System.out.println(note);
        }
        System.out.println();

        System.out.println("Notes found with findByUser({User}):");
        System.out.println("--------------------------------");
        for (Note note : repository.findByUser(Mariana)) {
            System.out.println(note);
        }

    }
}
