////package help.help.config;
//
////import help.help.service.KullaniciService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
////import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
////import org.springframework.security.crypto.password.PasswordEncoder;
//
////@Configuration
////public class DaoAuthenticationProviderConfig {
////    private final KullaniciService kullaniciService;
////    public DaoAuthenticationProviderConfig(KullaniciService kullaniciService) {
////        this.kullaniciService = kullaniciService;
////    }
////
////    @Bean
////    public DaoAuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder) {
////        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
////        authProvider.setUserDetailsService(kullaniciService);
////        authProvider.setPasswordEncoder(passwordEncoder);
////        return authProvider;
////    }
//}
