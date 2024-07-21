package help.help.dto;

import help.help.module.Kategori;
import org.springframework.stereotype.Component;

@Component
public class KategoriDtoConverter {
    public  KategoriDto convert(Kategori from) {
        return new KategoriDto(from.getId(), from.getKategoriAdi());
    }
}
