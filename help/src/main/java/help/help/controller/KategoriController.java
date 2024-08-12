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
    @CrossOrigin(origins = "http://localhost:3000") 
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
    @PutMapping("/update/{id}")
    public ResponseEntity<KategoriDto> updateKategori(@PathVariable Long id, @RequestBody KategoriDto kategoriDto) {
        KategoriDto updatedKategori = kategoriService.updateKategori(id, kategoriDto);
        return ResponseEntity.ok(updatedKategori);
    }
}




