package bj.ifri.tpbanque23.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "agence")
public class Agence {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String numero_agence;

    @Column
    private String nom;

    @Column
    private String adresse;

    @Column
    private String ville;

    @Column(name = "code_postal")
    private String codePostal;

    @Column(name = "nom_directeur")
    private  String nomDirecteur;

    @Column(name = "numero_banque")
    private String numeroBanque;

    @ManyToOne
    @JoinColumn(name = "banque_id")
    private  Banque banque;

    @OneToMany(cascade = CascadeType.DETACH, fetch =  FetchType.LAZY, mappedBy = "agence")
    private List<Employe> employees = new ArrayList<Employe>();

    @OneToMany(cascade = CascadeType.DETACH, fetch =  FetchType.LAZY, mappedBy = "agence")
    private List<CompteBancaire> compte_bancaires = new ArrayList<CompteBancaire>();

    @OneToMany(cascade = CascadeType.DETACH, fetch =  FetchType.LAZY, mappedBy = "agence")
    private List<Client> clients = new ArrayList<Client>();
    public Agence(String numero_agence, String nom, String adresse, String ville, String codePostal, String nomDirecteur, String numeroBanque) {
        this.numero_agence = numero_agence;
        this.nom = nom;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.nomDirecteur = nomDirecteur;
        this.numeroBanque = numeroBanque;
    }

    public Agence() {
        super();
    }
}
