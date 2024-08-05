package help.help.module;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "yazilar")
public class Yazi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private Long id;

    private String baslik;

    //@Lob
    @Column(columnDefinition = "text")
    private String icerik;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "kategori_id")
    @JsonBackReference
    private Kategori kategori;


    public Yazi() {
    }

    public Yazi(String baslik, String icerik, Kategori kategori) {
        this.baslik = baslik;
        this.icerik = icerik;
        this.kategori = kategori;
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
    public String toString() {
        return "Yazi{" +
                "id=" + id +
                ", baslik='" + baslik + '\'' +
                ", icerik='" + icerik + '\'' +
                ", kategori=" + (kategori != null ? kategori.getId() : null) +
                '}';
    }


}
