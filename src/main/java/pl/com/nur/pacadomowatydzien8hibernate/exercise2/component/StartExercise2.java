package pl.com.nur.pacadomowatydzien8hibernate.exercise2.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.com.nur.pacadomowatydzien8hibernate.exercise2.model.Note;
import pl.com.nur.pacadomowatydzien8hibernate.exercise2.repository.NoteDbRepo;

@Component
public class StartExercise2 {

    private NoteDbRepo noteDbRepo;

    @Autowired
    public StartExercise2(NoteDbRepo noteDbRepo) {
        this.noteDbRepo = noteDbRepo;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void init() {
//        Note note1 = new Note("temat1 naszej notatki", "treść notatki która może być długa");
//        Note note2 = new Note("temat2 notatki", "treść notatki 2 która może być długa albo krótka");
//        noteDbRepo.save(note1);
//        noteDbRepo.save(note2);

//        noteDbRepo.findAll().stream().forEach(System.out::println);
    }

}
