package help.help.controller;

import help.help.dto.KullaniciDto;
import help.help.dto.KullaniciDtoConverter;
import help.help.dto.YaziDto;
import help.help.dto.YaziDtoConverter;
import help.help.module.Kullanicilar;
import help.help.module.Yazi;
import help.help.service.KullaniciService;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kullanici")
public class KullaniciController {
    private final   KullaniciService kullaniciService;
    private PasswordEncoder passwordEncoder;

    public KullaniciController(KullaniciService kullaniciService, PasswordEncoder passwordEncoder) {
        this.kullaniciService = kullaniciService;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/kullanici-ekle")
    public ResponseEntity<String> postKullaniciEkle(@Valid @RequestBody KullaniciDto kullaniciDto, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Kullanıcı ekleme sırasında hata oluştu", HttpStatus.BAD_REQUEST);
        }
        Kullanicilar kullanici = new Kullanicilar();
        kullanici.setKullaniciAdi(kullaniciDto.getKullaniciAdi());
        kullanici.setKullaniciSifre(passwordEncoder.encode(kullaniciDto.getKullaniciSifre()));
        kullanici.setEmail(kullaniciDto.getEmail());
        kullaniciService.kaydet(kullanici);
        return new ResponseEntity<>("Kullanıcı başarıyla eklendi", HttpStatus.CREATED);
    }


    @GetMapping("/kullanicilar")
    public String kullanicilar(Model model) {
        model.addAttribute("kullanicilar", kullaniciService.findAll());
        return "kullanicilar";
    }

//    @GetMapping("/kullanici-ekle")
//    public String kullaniciEkleFormu(Model model) {
//        model.addAttribute("kullanici", new KullaniciDto());
//        return "kullanici-ekle";
//    }





    //
//    @PostMapping("/save")
//    public ResponseEntity<KullaniciDto> save(@RequestBody Kullanicilar kullanicilar) {
//        Kullanicilar kullanicilarr=kullaniciService.save(kullanicilar);
//        KullaniciDto kullaniciDto= KullaniciDtoConverter.convert(kullanicilarr);
//        return ResponseEntity.ok(kullaniciDto);
//    }
}
