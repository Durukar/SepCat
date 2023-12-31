package br.com.SepCatServer.Backend.entities;

import br.com.SepCatServer.Backend.entities.enums.InssueStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "sep_inssues")
public class Inssue implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;


    private Integer inssueStatus;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @OneToMany(mappedBy = "id.inssue")
    private Set<InssueItem> items = new HashSet<>();

    @OneToOne(mappedBy = "inssue", cascade = CascadeType.ALL)
    private FinishInssue finishInssue;

    public Inssue() {
    }

    public Inssue(Long id, Instant moment,InssueStatus inssueStatus, User author) {
        this.id = id;
        this.moment = moment;
        setInssueStatus(inssueStatus);
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

    public InssueStatus getInssueStatus() {
        return InssueStatus.valueOf(inssueStatus);
    }

    public void setInssueStatus(InssueStatus inssueStatus) {
        if (inssueStatus != null) {
            this.inssueStatus = inssueStatus.getCode();
        }
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public FinishInssue getFinishInssue() {
        return finishInssue;
    }

    public void setFinishInssue(FinishInssue finishInssue) {
        this.finishInssue = finishInssue;
    }

    public Set<InssueItem> getItems() {
        return items;
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