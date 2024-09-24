package com.example.servizio_clienti.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente {
    private int id;
    private String nome;
    private String cognome;
    private LocalDate nascita;
    private String CF;
    private String mail;
    private String indirizzo;

    public Cliente(int id,String nome,String cognome,LocalDate nascita,String CF,String mail,String indirizzo)  {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.nascita = nascita;
        this.CF = CF;
        this.mail = mail;
        this.indirizzo = indirizzo;
    }

    public Cliente(String nome,String cognome,LocalDate nascita,String CF,String mail,String indirizzo)  {
        this.nome = nome;
        this.cognome = cognome;
        this.nascita = nascita;
        this.CF = CF;
        this.mail = mail;
        this.indirizzo = indirizzo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    @Override
    public boolean equals(Object obj){
        boolean ret = false;
        if(obj instanceof Cliente temp)
            ret = temp.id == this.id;
        return ret;
    }

    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return id + "," + nome+ "," + cognome+ ","+ nascita.format(format) + "," + CF + "," + mail + "," + indirizzo + "\n";
    }
}
