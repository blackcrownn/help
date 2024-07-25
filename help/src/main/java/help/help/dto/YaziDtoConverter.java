package help.help.dto;
import help.help.module.Yazi;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class YaziDtoConverter {
    public static YaziDto convert(Yazi from) {
        KategoriDto kategoriDto = from.getKategori() != null ? new KategoriDto(from.getKategori().getId(), from.getKategori().getKategoriAdi()) : null;
        return new YaziDto(from.getId(), from.getBaslik(), from.getIcerik(), kategoriDto);
        //Users nesnesinin mail, firstName, lastName ve middleName alanlarını
        // kullanarak yeni bir UserDto nesnesi oluşturur ve döndürür.
    }


//        public static List<YaziDto> convert(List<Yazi> fromList) {
//        return fromList.stream()
//                .map(YaziDtoConverter::convert)
//                .collect(Collectors.toList());
//    }
public static List<YaziDto> convert(List<Yazi> fromList) {
    return fromList.stream().map(from -> new YaziDto(
            from.getId(),
            from.getBaslik(),
            from.getIcerik(),
            KategoriDtoConverter.convert(from.getKategori())
    )).collect(Collectors.toList());
    //Akış Başlatma: fromList.stream() - fromList listesindeki elemanları işlemek için bir akış başlatılır.
    //Dönüştürme İşlemi: .map(from -> new UserDto(...)) - Akıştaki her Users nesnesi, UserDto nesnesine dönüştürülür.
    //Toplama İşlemi: .collect(Collectors.toList()) - Dönüştürülen UserDto nesneleri bir liste olarak toplanır ve döndürülür.
}



}

