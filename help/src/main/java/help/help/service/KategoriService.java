package help.help.service;

import help.help.dto.KategoriDto;
import help.help.dto.KategoriDtoConverter;
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

    public KategoriDto save(KategoriDto kategoriDto) {
        if (kategoriDto.getKategoriAdi() == null || kategoriDto.getKategoriAdi().isEmpty()) {
            throw new IllegalArgumentException("Kategori adı boş olamaz");
        }

        Kategori parentKategori = null;
        if (kategoriDto.getParentId() != null) {
            parentKategori = kategoriRepository.findById(kategoriDto.getParentId())
                    .orElseThrow(() -> new IllegalArgumentException("Parent kategori bulunamadı"));
        }

        Kategori kategori = kategoriDtoConverter.convertToEntity(kategoriDto, parentKategori);
        Kategori savedKategori = kategoriRepository.save(kategori);
        return kategoriDtoConverter.convertToDto(savedKategori);
    }

    public List<KategoriDto> findAll() {
        return kategoriRepository.findAll()
                .stream()
                .map(kategoriDtoConverter::convertToDto)
                .collect(Collectors.toList());
    }

    public KategoriDto updateKategori(Long id, KategoriDto kategoriDto) {
        Kategori kategori = kategoriRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));
        kategori.setKategoriAdi(kategoriDto.getKategoriAdi());
        if (kategoriDto.getParentId() != null) {
            Kategori parentKategori = kategoriRepository.findById(kategoriDto.getParentId())
                    .orElseThrow(() -> new IllegalArgumentException("Parent kategori bulunamadı"));
            kategori.setParent(parentKategori);
        } else {
            kategori.setParent(null);
        }
        Kategori updatedKategori = kategoriRepository.save(kategori);
        return kategoriDtoConverter.convertToDto(updatedKategori);
    }

    public void deleteKategori(Long id) {
        kategoriRepository.deleteById(id);
    }

    public KategoriDto getKategoriById(Long id) {
        Kategori kategori = kategoriRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));
        return kategoriDtoConverter.convertToDto(kategori);
    }


}
