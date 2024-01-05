package bj.ifri.tpbanque23.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "banque")
public class Banque {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String numero_banque;

    @Column
    private float capital;

    @Column(name = "adresse_siege")
    private String adresseSiege;


    @Column(name = "num_salaries")
    private int[] numSalaries;

    @Column(name = "ville_agences")
    private String[] villeAgences;

    @OneToMany(cascade = CascadeType.DETACH, fetch =  FetchType.LAZY, mappedBy = "banque")
    private List<Agence> agencies = new ArrayList<Agence>();

    public Banque(String numero_banque, float capital, String adresseSiege, int[] numSalaries, String[] villeAgences) {
        this.numero_banque = numero_banque;
        this.capital = capital;
        this.adresseSiege = adresseSiege;
        this.numSalaries = numSalaries;
        this.villeAgences = villeAgences;
    }

    public Banque() {
        super();
    }
}
