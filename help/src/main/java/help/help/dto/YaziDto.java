package help.help.dto;

import help.help.module.Kategori;
import help.help.module.Media;

import java.util.List;

public class YaziDto {
    long id;
    String baslik;
    String icerik;
    private List<Media> mediaList;
    private Kategori kategori;

    public YaziDto(long id, String baslik, String icerik, List<Media> mediaList, Kategori kategori) {
        this.id = id;
        this.baslik = baslik;
        this.icerik = icerik;
        this.mediaList = mediaList;
        this.kategori = kategori;
    }

    public YaziDto() {
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

    public List<Media> getMediaList() {
        return mediaList;
    }

    public void setMediaList(List<Media> mediaList) {
        this.mediaList = mediaList;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }
}
