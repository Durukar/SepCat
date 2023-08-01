package br.com.SepCatServer.Backend.entities;

import br.com.SepCatServer.Backend.entities.pk.InssueItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "sep_inssue_item")
public class InssueItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private InssueItemPK id = new InssueItemPK();

    @Getter
    private Integer quantity;

    @Getter
    private Integer priority;

    public InssueItem(){
    }

    public InssueItem(Inssue inssue, Form form, Integer quantity, Integer priority) {
        id.setInssue(inssue);
        id.setForm(form);
        this.quantity = quantity;
        this.priority = priority;
    }

    @JsonIgnore
    public Inssue getInssue() {
        return id.getInssue();
    }

    public void setInssue(Inssue inssue) {
        id.setInssue(inssue);
    }

    public Form getForm() {
        return id.getForm();
    }

    public void setForm(Form form) {
        id.setForm(form);
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InssueItem inssueItem = (InssueItem) o;
        return Objects.equals(id, inssueItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
