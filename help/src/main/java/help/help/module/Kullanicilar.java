package help.help.module;

import jakarta.persistence.*;

@Entity
public class Kullanicilar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column()
    private String kullaniciAdi;

    @Column()
    private String kullaniciSifre;

    @Column
    private String email;

    public Kullanicilar(int id, String kullaniciAdi, String kullaniciSifre, String email) {
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
