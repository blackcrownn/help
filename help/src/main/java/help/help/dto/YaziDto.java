package help.help.dto;

public class YaziDto {
    long id;
    String baslik;
    String icerik;

    public YaziDto() {
    }

    public YaziDto(long id, String baslik, String icerik) {
        this.id = id;
        this.baslik = baslik;
        this.icerik = icerik;
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
}
