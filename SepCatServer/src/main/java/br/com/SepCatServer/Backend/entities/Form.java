package br.com.SepCatServer.Backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "sep_forms")
public class Form implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String custumer;
    private String description;

    private Integer priority;
    private String comments;

    @ManyToMany
    @JoinTable(name = "tb_form_category",
            joinColumns = @JoinColumn(name = "form_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "id.form")
    private Set<InssueItem> items = new HashSet<>();

    public Form() {
    }

    public Form(Long id, String title, String custumer, String description, Integer priority) {
        this.id = id;
        this.title = title;
        this.custumer = custumer;
        this.description = description;
        this.priority = priority;
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

    public String getCustumer() {
        return custumer;
    }

    public void setCustumer(String custumer) {
        this.custumer = custumer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer  getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    @JsonIgnore
    public Set<Inssue> getInssues() {
        Set<Inssue> set = new HashSet<>();
        for(InssueItem x : items) {
            set.add(x.getInssue());
        }
        return set;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Form form = (Form) o;
        return Objects.equals(id, form.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
