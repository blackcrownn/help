package help.help.dto;

public class UpdateYaziRequest {
    String baslik;
    String icerik;
    private String resimUrl;
    private String videoUrl;
    //private Long kategoriId;

    public UpdateYaziRequest() {
    }

    public UpdateYaziRequest(String baslik, String icerik, String resimUrl, String videoUrl) {
        this.baslik = baslik;
        this.icerik = icerik;
        this.resimUrl = resimUrl;
        this.videoUrl = videoUrl;
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
