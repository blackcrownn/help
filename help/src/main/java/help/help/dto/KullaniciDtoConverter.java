//package help.help.dto;
//
//import help.help.module.Kullanicilar;
//import help.help.module.Yazi;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class KullaniciDtoConverter {
//    public static KullaniciDto convert(Kullanicilar from) {
//        return new KullaniciDto(from.getId(), from.getKullaniciAdi(), from.getKullaniciSifre(),from.getEmail());
//        //Users nesnesinin mail, firstName, lastName ve middleName alanlarını
//        // kullanarak yeni bir UserDto nesnesi oluşturur ve döndürür.
//    }
//
//    public static List<YaziDto> convert(List<Yazi> fromList) {
//        return fromList.stream().map(from ->new YaziDto(
//                from.getId(),
//                from.getBaslik(),
//                from.getIcerik())).collect(Collectors.toList());
//        //Akış Başlatma: fromList.stream() - fromList listesindeki elemanları işlemek için bir akış başlatılır.
//        //Dönüştürme İşlemi: .map(from -> new UserDto(...)) - Akıştaki her Users nesnesi, UserDto nesnesine dönüştürülür.
//        //Toplama İşlemi: .collect(Collectors.toList()) - Dönüştürülen UserDto nesneleri bir liste olarak toplanır ve döndürülür.
//    }
//}
