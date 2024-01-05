package bj.ifri.tpbanque23.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "employe")
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employe_id")
    private Long employeId;
    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private String adresse;

    @Column
    private float salaire;

    @Column(name = "num_insee")
    private int numINSEE;

    @Column(name = "nom_banque")
    private String nomBanque;

    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;

    @OneToMany(cascade = CascadeType.DETACH, fetch =  FetchType.LAZY, mappedBy = "employe_id")
    private List<Client> clients = new ArrayList<Client>();

    public Employe(String nom, String prenom, String adresse, float salaire, int numINSEE, String nomBanque) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.salaire = salaire;
        this.numINSEE = numINSEE;
        this.nomBanque = nomBanque;
    }

    public Employe() {
        super();
    }
}
