package help.help.dto;

import help.help.module.Kategori;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class KategoriDtoConverter {

    public KategoriDto convertToDto(Kategori kategori) {
        List<SimpleYaziTwoDto> yazilar = kategori.getYazilar().stream()
                .map(yazi -> new SimpleYaziTwoDto(yazi.getId(), yazi.getBaslik()))
                .collect(Collectors.toList());
        return new KategoriDto(
                kategori.getId(),
                kategori.getKategoriAdi(),
                kategori.getParent() != null ? kategori.getParent().getId() : null,
                yazilar
        );
    }

    public List<KategoriDto> convertToDtoList(List<Kategori> kategoriList) {
        return kategoriList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Kategori convertToEntity(KategoriDto dto, Kategori parent) {
        return new Kategori(dto.getKategoriAdi(), parent);
    }

    public List<Kategori> convertToEntityList(List<KategoriDto> dtoList) {
        return dtoList.stream()
                .map(dto -> convertToEntity(dto, null))
                .collect(Collectors.toList());
    }
}
