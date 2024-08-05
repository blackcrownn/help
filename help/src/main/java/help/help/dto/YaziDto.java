package help.help.dto;

public class YaziDto {
    private Long id;
    private String baslik;
    private String icerik;
    private Long kategoriId;

    public YaziDto() {}

    public YaziDto(Long id, String baslik, String icerik, Long kategoriId) {
        this.id = id;
        this.baslik = baslik;
        this.icerik = icerik;
        this.kategoriId = kategoriId;
    }

    public YaziDto(String baslik, String icerik, Long kategoriId) {
        this.baslik = baslik;
        this.icerik = icerik;
        this.kategoriId = kategoriId;
    }

    public YaziDto(Long id, String baslik) {
        this.id = id;
        this.baslik = baslik;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(Long kategoriId) {
        this.kategoriId = kategoriId;
    }
}
