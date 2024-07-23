//package help.help.dto;
//
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
//
//public class KullaniciDto {
//    @NotBlank
//    @Size(min = 3, max = 20)
//    private String kullaniciAdi;
//
//    @NotBlank
//    @Size(min = 6, max = 100)
//    private String kullaniciSifre;
//
//    @NotBlank
//    @Email
//    private String email;
//
//    public KullaniciDto() {
//    }
//
//    public KullaniciDto(Long id, String kullaniciAdi, String kullaniciSifre, String email) {
//        this.kullaniciAdi = kullaniciAdi;
//        this.kullaniciSifre = kullaniciSifre;
//        this.email = email;
//    }
//
//    public String getKullaniciAdi() {
//        return kullaniciAdi;
//    }
//
//    public void setKullaniciAdi(String kullaniciAdi) {
//        this.kullaniciAdi = kullaniciAdi;
//    }
//
//    public String getKullaniciSifre() {
//        return kullaniciSifre;
//    }
//
//    public void setKullaniciSifre(String kullaniciSifre) {
//        this.kullaniciSifre = kullaniciSifre;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//}
