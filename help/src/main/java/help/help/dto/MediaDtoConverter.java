package help.help.dto;

import help.help.module.Media;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MediaDtoConverter {
    public static MediaDto convert(Media from) {
        return new MediaDto(from.getFileName(), from.getFilePath(), from.getFileType());
        //Users nesnesinin mail, firstName, lastName ve middleName alanlarını
        // kullanarak yeni bir UserDto nesnesi oluşturur ve döndürür.
    }

    public static List<MediaDto> convert(List<Media> fromList) {
        return fromList.stream().map(from ->new MediaDto(
                from.getFileName(),
                from.getFilePath(),
                from.getFileType()

        )).collect(Collectors.toList());
        //Akış Başlatma: fromList.stream() - fromList listesindeki elemanları işlemek için bir akış başlatılır.
        //Dönüştürme İşlemi: .map(from -> new UserDto(...)) - Akıştaki her Users nesnesi, UserDto nesnesine dönüştürülür.
        //Toplama İşlemi: .collect(Collectors.toList()) - Dönüştürülen UserDto nesneleri bir liste olarak toplanır ve döndürülür.
    }
}
