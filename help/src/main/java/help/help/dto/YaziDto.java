package help.help.dto;

public class YaziDto {
    long id;
    String baslik;
    String icerik;
    private String resimUrl;
    private String videoUrl;
   // private Long kategoriId;

    public YaziDto(long id, String baslik, String icerik, String resimUrl, String videoUrl) {
        this.id = id;
        this.baslik = baslik;
        this.icerik = icerik;
        this.resimUrl = resimUrl;
        this.videoUrl = videoUrl;

    }

    public YaziDto() {
    }

    public YaziDto(Long id, String baslik, String icerik, String resimUrl) {
    }

    public YaziDto(Long id, String baslik, String icerik) {
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

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getResimUrl() {
        return resimUrl;
    }

    public void setResimUrl(String resimUrl) {
        this.resimUrl = resimUrl;
    }


}
