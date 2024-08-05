package help.help.module;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "kategoriler")
public class Kategori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String kategoriAdi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private Kategori parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Kategori> subCategories;

    @OneToMany(mappedBy = "kategori", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Yazi> yazilar;

    public Kategori() {}

    public Kategori(String kategoriAdi, Kategori parent) {
        this.kategoriAdi = kategoriAdi;
        this.parent = parent;
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

    public Kategori getParent() {
        return parent;
    }

    public void setParent(Kategori parent) {
        this.parent = parent;
    }

    public List<Kategori> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Kategori> subCategories) {
        this.subCategories = subCategories;
    }

    public List<Yazi> getYazilar() {
        return yazilar;
    }

    public void setYazilar(List<Yazi> yazilar) {
        this.yazilar = yazilar;
    }

    @Override
    public String toString() {
        return "Kategori{" +
                "id=" + id +
                ", kategoriAdi='" + kategoriAdi + '\'' +
                ", parent=" + (parent != null ? parent.getId() : null) +
                '}';
    }
}
