package help.help.module;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "yazilar")
public class Kategori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private Long id;
    private String kategoriAdi;

    @OneToMany(mappedBy = "kategori", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Yazi> yazilar;

    public Kategori() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKategoriAdi() {
        return kategoriAdi;
    }

    public void setKategoriAdi(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }

    public List<Yazi> getYazilar() {
        return yazilar;
    }

    public void setYazilar(List<Yazi> yazilar) {
        this.yazilar = yazilar;
    }

    public Kategori(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }

    @Override
    public String toString() {
        return "Kategori{" +
                "id=" + id +
                ", kategoriAdi='" + kategoriAdi + '\'' +
                '}';
    }
}
