package bj.ifri.tpbanque23.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "compte_bancaire")
public class CompteBancaire {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String numero_compte;

    @Column
    private float solde;

    @Column(name = "date_ouverture")
    private float dateOuverture;

    @Column(name = "nom_client")
    private String nomClient;

    @Column(name = "prenom_client")
    private String prenomClient;

    @Column(name = "numero_agence")
    private String numeroAgence;

    @Column(name = "numero_banque")
    private String numeroBanque;

    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client_id;

    public CompteBancaire(String numero_compte, float solde, float dateOuverture, String nomClient, String prenomClient, String numeroAgence, String numeroBanque) {
        this.numero_compte = numero_compte;
        this.solde = solde;
        this.dateOuverture = dateOuverture;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.numeroAgence = numeroAgence;
        this.numeroBanque = numeroBanque;
    }

    public CompteBancaire() {
        super();
    }

}
