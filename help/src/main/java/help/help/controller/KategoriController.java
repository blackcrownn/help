package help.help.controller;

import help.help.dto.KategoriDto;
import help.help.service.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kategori")
public class KategoriController {

    @Autowired
    private KategoriService kategoriService;

    @PostMapping("/savekategori")
    @CrossOrigin
    public ResponseEntity<KategoriDto> saveKategori(@RequestBody KategoriDto kategoriDto) {
        KategoriDto savedKategori = kategoriService.save(kategoriDto);
        return ResponseEntity.ok(savedKategori);
    }

    @GetMapping("/all")
    @CrossOrigin
    public ResponseEntity<List<KategoriDto>> getAllKategoriler() {
        List<KategoriDto> kategoriler = kategoriService.findAll();
        return ResponseEntity.ok(kategoriler);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<KategoriDto> getKategoriById(@PathVariable Long id) {
        KategoriDto kategoriDto = kategoriService.getKategoriById(id);
        return ResponseEntity.ok(kategoriDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKategori(@PathVariable Long id) {
        kategoriService.deleteKategori(id);
        return ResponseEntity.noContent().build();
    }
}









































//package help.help.controller;
//import help.help.dto.KategoriDto;
//import help.help.dto.KategoriDtoConverter;
//import help.help.module.Kategori;
//import help.help.service.KategoriService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/kategori")
//public class KategoriController {
//
//    private final KategoriService kategoriService;
//
//    private final KategoriDtoConverter kategoriDtoConverter;
//
//    public KategoriController(KategoriService kategoriService, KategoriDtoConverter kategoriDtoConverter) {
//        this.kategoriService = kategoriService;
//        this.kategoriDtoConverter = kategoriDtoConverter;
//    }
//
//    @PostMapping("/savekategori")
//    public ResponseEntity<KategoriDto> save(@RequestBody KategoriDto kategoriDto) {
//        Kategori kategori = new Kategori(kategoriDto.getKategoriAdi());
//        Kategori parentKategori = new Kategori();
//        parentKategori.setId(kategoriDto.getParentId());
//        kategori.setParent(parentKategori);
//        KategoriDto savedKategori = kategoriService.save(kategori);
//        return new ResponseEntity<>(savedKategori, HttpStatus.CREATED);
//
//    }
//    @CrossOrigin
//    @GetMapping("/all")
//    public ResponseEntity<List<KategoriDto>> findAll() {
//        List<KategoriDto> kategoriler = kategoriService.findAll();
//        return new ResponseEntity<>(kategoriler, HttpStatus.OK);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<KategoriDto> update(@PathVariable Long id, @RequestBody KategoriDto kategoriDto) {
//        KategoriDto updatedKategori = kategoriService.updateKategori(id, kategoriDto);
//        return new ResponseEntity<>(updatedKategori, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        kategoriService.deleteKategori(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<KategoriDto> getKategoriById(@PathVariable Long id) {
//        Kategori kategori = kategoriService.getKategoriById(id);
//        KategoriDto kategoriDto = kategoriDtoConverter.convert(kategori);
//        return ResponseEntity.ok(kategoriDto);
//    }
//}


