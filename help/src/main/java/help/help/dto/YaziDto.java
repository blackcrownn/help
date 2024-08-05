package help.help.dto;

public class YaziDto {
    long id;
    String baslik;
    String icerik;
    private KategoriDto kategori;



    public YaziDto() {
    }

    public YaziDto(Long id, String baslik, String icerik, KategoriDto kategoriDto) {
        this.id = id;
        this.baslik = baslik;
        this.icerik = icerik;
        this.kategori = kategoriDto;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public KategoriDto getKategori() {
        return kategori;
    }

    public void setKategori(KategoriDto kategori) {
        this.kategori = kategori;
    }
}
