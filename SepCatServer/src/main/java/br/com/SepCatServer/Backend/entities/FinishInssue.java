package br.com.SepCatServer.Backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "sep_finish_inssue")
public class FinishInssue implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    @OneToOne
    @MapsId
    private Inssue inssue;

    public FinishInssue() {
    }

    public FinishInssue(Long id, Instant moment, Inssue inssue) {
        this.id = id;
        this.moment = moment;
        this.inssue = inssue;
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

    public Inssue getInssue() {
        return inssue;
    }

    public void setInssue(Inssue inssue) {
        this.inssue = inssue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinishInssue that = (FinishInssue) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
