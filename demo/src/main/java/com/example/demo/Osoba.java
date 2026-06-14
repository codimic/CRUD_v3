package com.example.demo;

import jakarta.persistence.*;
//import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Entity
@Table(name="KsiazkaTelefoniczna")
public class Osoba {

//    @jakarta.persistence.Id
//    private Long id1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String imie;
    private String nazwisko;
    @Column(name ="numer", nullable=false)
    private String telefon;
    private String email;
    @Transient
    boolean  nowy;

    public Osoba(Integer id, String imie, String nazwisko, String telefon, String email, boolean nowy) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.email = email;
        this.nowy = nowy;
    }

    public Osoba() {

    }

    public Osoba(String imie, String nazwisko, String telefon, String email, String opis, boolean nowy) {

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

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                ", nowy=" + nowy +
                '}';
    }


    @Repository
    public interface OsobaRepo extends JpaRepository <Osoba, Integer> {
    }

    @Controller
    public class addControler {
        @Autowired
        private OsobaRepo osobaRepo;

        @RequestMapping("/formularz")
        public String pokazFormularz() {
            return "formularz";
        }

        @RequestMapping("/dodaj")
        public String dodajemyDane(
                @RequestParam("imie") String imie,
                @RequestParam("nazwisko") String nazwisko,
                @RequestParam("telefon") String telefon,
                @RequestParam("email") String email,
                @RequestParam("opis") String opis,
                Model model)
                throws Exception {
            Osoba osoba = new Osoba(imie, nazwisko, telefon, email, opis, true);
            System.out.println(osoba);
            osobaRepo.save(osoba); // ZAPIS DO BAZY !!!!
            model.addAttribute("osoba", osoba);
            return "Widok";
        }
    }
}
