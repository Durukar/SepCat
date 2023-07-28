package br.com.SepCatServer.Backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "sep_inssues")
public class Inssue implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    public Inssue() {
    }

    public Inssue(Long id, Instant moment, User author) {
        this.id = id;
        this.moment = moment;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inssue inssue = (Inssue) o;
        return Objects.equals(id, inssue.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
