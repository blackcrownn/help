package help.help.service;

import help.help.module.Kullanicilar;
import help.help.repository.KullanicilarRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class KullaniciService implements UserDetailsService {

    private final KullanicilarRepository kullanicilarRepository;

    public KullaniciService(KullanicilarRepository kullanicilarRepository) {
        this.kullanicilarRepository = kullanicilarRepository;
    }

    public void kaydet(Kullanicilar kullanicilar) {
        kullanicilarRepository.save(kullanicilar);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Kullanicilar kullanici = kullanicilarRepository.findByKullaniciAdi(username);
        if (kullanici == null) {
            throw new UsernameNotFoundException("Kullanıcı bulunamadı");
        }
        return new org.springframework.security.core.userdetails.User(kullanici.getKullaniciAdi(), kullanici.getKullaniciSifre(), Collections.emptyList());
    }

    public List<Kullanicilar> findAll() {
        return kullanicilarRepository.findAll();
    }


    //    public Kullanicilar save(Kullanicilar kullanicilar) {
//        return kullanicilarRepository.save(kullanicilar);
//    }
}
