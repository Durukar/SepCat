package br.com.SepCatServer.Backend.entities.pk;

import br.com.SepCatServer.Backend.entities.Form;
import br.com.SepCatServer.Backend.entities.Inssue;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@Embeddable
public class InssueItemPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "inssue_id")
    private Inssue inssue;

    @ManyToOne
    @JoinColumn(name = "form_id")
    private Form form;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InssueItemPK that = (InssueItemPK) o;
        return Objects.equals(inssue, that.inssue) && Objects.equals(form, that.form);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inssue, form);
    }
}
