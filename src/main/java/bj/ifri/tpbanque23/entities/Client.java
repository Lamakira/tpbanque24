package bj.ifri.tpbanque23.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String numero_client;

    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private String adresse;

    @Column(name = "nom_conseiller")
    private String nomConseiller;

    @Column(name = "prenom_conseiller")
    private String prenomConseiller;

    @Column(name = "nom_agence")
    private String nomAgence;

    @ManyToOne
    @JoinColumn(name = "employe_id")
    private Employe employe_id;

    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;

    @OneToMany(cascade = CascadeType.DETACH, fetch =  FetchType.LAZY, mappedBy = "client_id")
    private List<CompteBancaire> compte_bancaires = new ArrayList<CompteBancaire>();


    public Client(String numero_client, String nom, String prenom, String adresse, String nomConseiller, String prenomConseiller, String nomAgence) {
        this.numero_client = numero_client;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.nomConseiller = nomConseiller;
        this.prenomConseiller = prenomConseiller;
        this.nomAgence = nomAgence;
    }

    public Client() {
        super();
    }
}
