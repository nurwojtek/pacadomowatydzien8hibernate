package pl.com.nur.pacadomowatydzien8hibernate.exercise2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.nur.pacadomowatydzien8hibernate.exercise2.model.Note;
import pl.com.nur.pacadomowatydzien8hibernate.exercise2.repository.NoteDbRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteList {

    private List<Note> noteList;
    private NoteDbRepo noteDbRepo;

    @Autowired
    public NoteList(NoteDbRepo noteDbRepo) {
        this.noteDbRepo = noteDbRepo;
        noteList = new ArrayList<>();
        getLikeTitle("notatki");
    }

    public List<Note> getLikeTitle(String searchesTitle){
        return noteDbRepo.findByTitleContains(searchesTitle);
    }


    public List<Note> getNoteList() {
        return noteDbRepo.findAll();
    }

    public void addNote(Note note) {
            noteDbRepo.save(note);
    }

    public void modNote(Note note){
        noteDbRepo.saveAndFlush(note);
    }

    public void delNote(Long id){
        noteDbRepo.deleteById(id);
    }
}
