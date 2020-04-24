package pl.com.nur.pacadomowatydzien8hibernate.exercise2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.com.nur.pacadomowatydzien8hibernate.exercise2.model.Note;

import java.util.List;

@Repository
public interface NoteDbRepo  extends JpaRepository<Note, Long> {

    List<Note> findByTitleContains(String search);

    void deleteById(Long id);

}
