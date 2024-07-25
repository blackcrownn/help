package help.help.module;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "kategoriler")
public class Kategori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private Long id;

    @Column(unique = true,nullable = false)
    private String kategoriAdi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private Kategori parent;

    public Kategori() {
    }

    public Kategori(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
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

    public Kategori(String kategoriAdi, Kategori parent) {
        this.kategoriAdi = kategoriAdi;
        this.parent = parent;
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
