package help.help.controller;

import help.help.dto.KategoriDto;
import help.help.module.Kategori;
import help.help.service.KategoriService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kategori")
public class KategoriController {

    private final KategoriService kategoriService;

    public KategoriController(KategoriService kategoriService) {
        this.kategoriService = kategoriService;
    }

    @PostMapping("/save")
    public ResponseEntity<KategoriDto> save(@RequestBody KategoriDto kategoriDto) {
        Kategori kategori = new Kategori(kategoriDto.getKategoriAdi());
        KategoriDto savedKategori = kategoriService.save(kategori);
        return new ResponseEntity<>(savedKategori, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<KategoriDto>> findAll() {
        List<KategoriDto> kategoriler = kategoriService.findAll();
        return new ResponseEntity<>(kategoriler, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<KategoriDto> update(@PathVariable Long id, @RequestBody KategoriDto kategoriDto) {
        KategoriDto updatedKategori = kategoriService.updateKategori(id, kategoriDto);
        return new ResponseEntity<>(updatedKategori, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        kategoriService.deleteKategori(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
