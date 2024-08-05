package help.help.module;

import jakarta.persistence.*;

@Entity
public class Kullanicilar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String kullaniciAdi;

    @Column()
    private String kullaniciSifre;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKullaniciSifre() {
        return kullaniciSifre;
    }

    public void setKullaniciSifre(String kullaniciSifre) {
        this.kullaniciSifre = kullaniciSifre;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(unique=true)
    private String email;

    public Kullanicilar(Long id, String kullaniciAdi, String kullaniciSifre, String email) {
        this.id = id;
        this.kullaniciAdi = kullaniciAdi;
        this.kullaniciSifre = kullaniciSifre;
        this.email = email;
    }

    public Kullanicilar() {
    }

    @Override
    public String toString() {
        return "Kullanicilar{" +
                "id=" + id +
                ", kullaniciAdi='" + kullaniciAdi + '\'' +
                ", kullaniciSifre='" + kullaniciSifre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
