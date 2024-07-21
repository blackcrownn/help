package help.help.module;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Entity
@Table(name = "yazilar")
public class Yazi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private Long id;
    private String baslik;
    private String icerik;
    private String resimUrl;
    private String videoUrl;

    @Override
    public String toString() {
        return "Yazi{" +
                "id=" + id +
                ", baslik='" + baslik + '\'' +
                ", icerik='" + icerik + '\'' +
                ", resimUrl='" + resimUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", kategori=" + kategori +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Yazi yazi = (Yazi) o;
        return Objects.equals(id, yazi.id) && Objects.equals(baslik, yazi.baslik) && Objects.equals(icerik, yazi.icerik) && Objects.equals(resimUrl, yazi.resimUrl) && Objects.equals(videoUrl, yazi.videoUrl) && Objects.equals(kategori, yazi.kategori);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, baslik, icerik, resimUrl, videoUrl, kategori);
    }

    public String getResimUrl() {
        return resimUrl;
    }

    public void setResimUrl(String resimUrl) {
        this.resimUrl = resimUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Yazi(Long id, String baslik, String icerik, String resimUrl, String videoUrl, Kategori kategori) {
        this.id = id;
        this.baslik = baslik;
        this.icerik = icerik;
        this.resimUrl = resimUrl;
        this.videoUrl = videoUrl;
        this.kategori = kategori;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kategori_id")
    private Kategori kategori;



    public Yazi() {
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

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }


}
