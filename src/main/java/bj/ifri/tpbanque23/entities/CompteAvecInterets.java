package bj.ifri.tpbanque23.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "compte_avec_interets")
public class CompteAvecInterets extends CompteBancaire {

    @Column
    private float taux;

    public CompteAvecInterets() {
        super();
    }
}
