package help.help.dto;

import help.help.module.Kategori;
import help.help.module.Yazi;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import help.help.dto.KategoriDto;



@Component
public class YaziDtoConverter {
    public YaziDto convertToDto(Yazi yazi) {
        return new YaziDto(yazi.getId(), yazi.getBaslik(), yazi.getIcerik(), yazi.getKategori() != null ? yazi.getKategori().getId() : null);
    }

    public List<YaziDto> convertToDtoList(List<Yazi> yaziList) {
        return yaziList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Yazi convertToEntity(YaziDto dto, Kategori kategori) {
        return new Yazi(dto.getBaslik(), dto.getIcerik(), kategori);
    }

    public List<Yazi> convertToEntityList(List<YaziDto> dtoList) {
        return dtoList.stream()
                .map(dto -> convertToEntity(dto, null))
                .collect(Collectors.toList());
    }
}
