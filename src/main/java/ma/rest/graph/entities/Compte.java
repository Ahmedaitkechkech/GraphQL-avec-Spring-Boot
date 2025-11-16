package ma.rest.graph.entities;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.Temporal;

import java.util.Date;

@Entity

public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double solde;


    private Date dateCreation;

    @Enumerated(EnumType.STRING)
    private TypeCompte type;

    public Compte() {
    }

    public Compte( double solde, Date dateCreation, TypeCompte type) {

        this.solde = solde;
        this.dateCreation = dateCreation;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public TypeCompte getType() {
        return type;
    }

    public void setType(TypeCompte type) {
        this.type = type;
    }
}
