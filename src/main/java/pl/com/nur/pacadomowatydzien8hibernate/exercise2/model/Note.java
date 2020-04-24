package pl.com.nur.pacadomowatydzien8hibernate.exercise2.model;

import javax.persistence.*;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "note")
    private String myNote;

    public Note() {
    }

    public Note(String title, String myNote) {
        this.title = title;
        this.myNote = myNote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMyNote() {
        return myNote;
    }

    public void setMyNote(String myNote) {
        this.myNote = myNote;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", myNote='" + myNote + '\'' +
                '}';
    }
}
