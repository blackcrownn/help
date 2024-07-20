package help.help.config;

import help.help.module.Kullanicilar;
import help.help.repository.KullanicilarRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private final KullanicilarRepository kullanicilarRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DataLoader(KullanicilarRepository kullanicilarRepository, PasswordEncoder passwordEncoder) {
        this.kullanicilarRepository = kullanicilarRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    private void loadData() {
        if (kullanicilarRepository.findByKullaniciAdi("admin") == null) {
            Kullanicilar admin = new Kullanicilar();
            admin.setKullaniciAdi("admin");
            admin.setKullaniciSifre(passwordEncoder.encode("admin_password"));
            admin.setEmail("admin@example.com");
            kullanicilarRepository.save(admin);
        }
    }
}
