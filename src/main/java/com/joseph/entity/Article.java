package com.joseph.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "quantity")
    private int quantity;

    @OneToMany(mappedBy = "article")
    private List<CommandArticle> commandArticles;

    public Article() {
    }

    public Article(String libelle, int quantity) {
        this.libelle = libelle;
        this.quantity = quantity;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getLibelle() { return libelle; }

    public void setLibelle(String libelle) { this.libelle = libelle; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public List<CommandArticle> getCommandArticles() { return commandArticles; }

    public void setCommandArticles(List<CommandArticle> commandArticles) { this.commandArticles = commandArticles; }
}

