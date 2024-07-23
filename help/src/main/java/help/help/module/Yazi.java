package help.help.module;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
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

    @OneToMany(mappedBy = "yazi", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Media> mediaList;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "kategori_id")
    private Kategori kategori;

    public Yazi() {
    }
    public Yazi(String baslik, String icerik, Kategori kategori) {
        this.baslik = baslik;
        this.icerik = icerik;
        this.kategori = kategori;
    }

    public List<Media> getMediaList() {
        return mediaList;
    }

    public void setMediaList(List<Media> mediaList) {
        this.mediaList = mediaList;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Yazi yazi = (Yazi) o;
        return Objects.equals(id, yazi.id) && Objects.equals(baslik, yazi.baslik) && Objects.equals(icerik, yazi.icerik) && Objects.equals(mediaList, yazi.mediaList) && Objects.equals(kategori, yazi.kategori);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, baslik, icerik, mediaList, kategori);
    }

    @Override
    public String toString() {
        return "Yazi{" +
                "id=" + id +
                ", baslik='" + baslik + '\'' +
                ", icerik='" + icerik + '\'' +
                ", mediaList=" + mediaList +
                ", kategori=" + kategori +
                '}';
    }


}
