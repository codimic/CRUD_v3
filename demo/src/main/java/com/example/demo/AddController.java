package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddController {

    private final OsobaRepo osobaRepo;

    public AddController(OsobaRepo osobaRepo) {
        this.osobaRepo = osobaRepo;
    }

    @GetMapping("/formularz")
    public String pokazFormularz() {
        return "formularz";
    }

    @PostMapping("/dodaj")
    public String dodajemyDane(
            @RequestParam("imie") String imie,
            @RequestParam("nazwisko") String nazwisko,
            @RequestParam("telefon") String telefon,
            @RequestParam("email") String email,
            @RequestParam("opis") String opis,
            Model model) {

        Osoba osoba = new Osoba(imie, nazwisko, telefon, email, opis, true);

        osobaRepo.save(osoba);

        model.addAttribute("osoba", osoba);

        return "Widok";
    }
}