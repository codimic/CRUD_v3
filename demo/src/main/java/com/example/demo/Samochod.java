package com.example.demo;

import jakarta.persistence.*;
//import org.springframework.data.annotation.Id;

@Entity
@Table(name="ListaSamochodow")
public class Samochod {

    //    @jakarta.persistence.Id
//    private Long id1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String marka;
    private String model;
    @Column(name ="numer", nullable=false)
    private String wlasciciel;
    private String waznoscPrzegladuDo;
    @Transient
    boolean  nowy;

    public Samochod(Integer id, String marka, String model, String wlasciciel, String waznoscPrzegladuDo, boolean nowy) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.wlasciciel = wlasciciel;
        this.waznoscPrzegladuDo = waznoscPrzegladuDo;
        this.nowy = nowy;
    }

    public Samochod() {

    }

//    public Long getId1() {
//        return id1;
//    }
//
//    public void setId1(Long id1) {
//        this.id1 = id1;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String imie) {
        this.marka = imie;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String nazwisko) {
        this.model = nazwisko;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(String telefon) {
        this.wlasciciel = telefon;
    }

    public String getWaznoscPrzegladuDo() {
        return waznoscPrzegladuDo;
    }

    public void setWaznoscPrzegladuDo(String email) {
        this.waznoscPrzegladuDo = email;
    }

    public boolean isNowy() {
        return nowy;
    }

    public void setNowy(boolean nowy) {
        this.nowy = nowy;
    }



    @Override
    public String toString() {
        return "Osoba{" +
                "id=" + id +
                ", imie='" + marka + '\'' +
                ", nazwisko='" + model + '\'' +
                ", telefon='" + wlasciciel + '\'' +
                ", email='" + waznoscPrzegladuDo + '\'' +
                ", nowy=" + nowy +
                '}';
    }












}

