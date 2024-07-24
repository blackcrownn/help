package help.help.dto;

import help.help.module.Kategori;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class KategoriDtoConverter {
    public static KategoriDto convert(Kategori from) {
        return new KategoriDto(from.getId(),from.getKategoriAdi());
    }

    public static List<KategoriDto> convert(List<Kategori> fromList) {
        return fromList.stream().map(from ->new KategoriDto(
                from.getId(),
                from.getKategoriAdi()
        )).collect(Collectors.toList());
        //Akış Başlatma: fromList.stream() - fromList listesindeki elemanları işlemek için bir akış başlatılır.
        //Dönüştürme İşlemi: .map(from -> new UserDto(...)) - Akıştaki her Users nesnesi, UserDto nesnesine dönüştürülür.
        //Toplama İşlemi: .collect(Collectors.toList()) - Dönüştürülen UserDto nesneleri bir liste olarak toplanır ve döndürülür.
    }
}
