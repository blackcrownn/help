package help.help.service;

import help.help.dto.KategoriDto;
import help.help.dto.KategoriDtoConverter;
import help.help.exception.KategoriNotFoundException;
import help.help.exception.YaziNotFoundException;
import help.help.module.Kategori;
import help.help.repository.KategoriRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KategoriService {

    private final KategoriRepository kategoriRepository;
    private final KategoriDtoConverter kategoriDtoConverter;

    public KategoriService(KategoriRepository kategoriRepository, KategoriDtoConverter kategoriDtoConverter) {
        this.kategoriRepository = kategoriRepository;
        this.kategoriDtoConverter = kategoriDtoConverter;
    }

    public KategoriDto save(Kategori kategori) {
        Kategori savedKategori = kategoriRepository.save(kategori);
        return kategoriDtoConverter.convert(savedKategori);
    }

    public List<KategoriDto> findAll() {
        return kategoriRepository.findAll()
                .stream()
                .map(y -> KategoriDtoConverter.convert(y))
                .collect(Collectors.toList());
    }

    public KategoriDto updateKategori(Long id, KategoriDto kategoriDto) {
        Kategori kategori = kategoriRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kategori not found"));
        kategori.setKategoriAdi(kategoriDto.getKategoriAdi());
        Kategori updatedKategori = kategoriRepository.save(kategori);
        return kategoriDtoConverter.convert(updatedKategori);
    }

    public void deleteKategori(Long id) {
        kategoriRepository.deleteById(id);
    }

    public Kategori getKategoriById(Long id) {
        return kategoriRepository.findById(id)
                .orElseThrow(()->new KategoriNotFoundException("BOYLE BİR KATEGORİ MEVCUT DEGİL " + id));
    }


}