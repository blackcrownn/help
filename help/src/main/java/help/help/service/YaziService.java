package help.help.service;

import help.help.dto.YaziDto;
import help.help.dto.YaziDtoConverter;
import help.help.module.Kategori;
import help.help.module.Yazi;
import help.help.repository.KategoriRepository;
import help.help.repository.YaziRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class YaziService {

    private final YaziRepository yaziRepository;
    private final KategoriRepository kategoriRepository;
    private final YaziDtoConverter yaziDtoConverter;

    public YaziService(YaziRepository yaziRepository, KategoriRepository kategoriRepository, YaziDtoConverter yaziDtoConverter) {
        this.yaziRepository = yaziRepository;
        this.kategoriRepository = kategoriRepository;
        this.yaziDtoConverter = yaziDtoConverter;
    }

    public YaziDto save(YaziDto yaziDto) {
        if (yaziDto.getBaslik() == null || yaziDto.getBaslik().isEmpty()) {
            throw new IllegalArgumentException("Başlık boş olamaz");
        }

        Kategori kategori = null;
        if (yaziDto.getKategoriId() != null) {
            kategori = kategoriRepository.findById(yaziDto.getKategoriId())
                    .orElseThrow(() -> new IllegalArgumentException("Kategori bulunamadı"));
        }

        Yazi yazi = yaziDtoConverter.convertToEntity(yaziDto, kategori);
        Yazi savedYazi = yaziRepository.save(yazi);
        return yaziDtoConverter.convertToDto(savedYazi);
    }

    public List<YaziDto> findAll() {
        return yaziRepository.findAll()
                .stream()
                .map(yaziDtoConverter::convertToDto)
                .collect(Collectors.toList());
    }

    public YaziDto updateYazi(Long id, YaziDto yaziDto) {
        Yazi yazi = yaziRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Yazi bulunamadı"));
        yazi.setBaslik(yaziDto.getBaslik());
        yazi.setIcerik(yaziDto.getIcerik());
        if (yaziDto.getKategoriId() != null) {
            Kategori kategori = kategoriRepository.findById(yaziDto.getKategoriId())
                    .orElseThrow(() -> new IllegalArgumentException("Kategori bulunamadı"));
            yazi.setKategori(kategori);
        }
        Yazi updatedYazi = yaziRepository.save(yazi);
        return yaziDtoConverter.convertToDto(updatedYazi);
    }

    public void deleteYazi(Long id) {
        yaziRepository.deleteById(id);
    }

    public YaziDto getYaziById(Long id) {
        Yazi yazi = yaziRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Yazi bulunamadı"));
        return yaziDtoConverter.convertToDto(yazi);
    }
}
