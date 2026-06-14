package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/lista")
    public String pokazListe(Model model) {
        model.addAttribute("osoby", osobaRepo.findAll());
        return "lista";
    }

    @PostMapping("/usun/{id}")
    public String usunOsobe(@PathVariable Integer id) {
        osobaRepo.deleteById(id);
        return "redirect:/lista";
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