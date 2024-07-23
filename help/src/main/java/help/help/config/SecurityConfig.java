//package help.help.config;
//
//
//
//
//public class SecurityConfig {
////
////    @Autowired
////    private final KullaniciService kullaniciService;
////
////    @Autowired
////    public SecurityConfig(KullaniciService kullaniciService) {
////        this.kullaniciService = kullaniciService;
////    }
////
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//////        http
//////                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
//////                        .requestMatchers("/api/kullanici/**").hasRole("ADMIN")
//////                        .requestMatchers("/api/yazi/**").hasRole("ADMIN")
//////                        .anyRequest().authenticated()
//////                ).cors(e -> e.disable())
//////                .csrf(e -> e.disable())
//////                .formLogin(formLogin -> formLogin
//////                        .permitAll()
//////                )
//////                .logout(logout -> logout
//////                        .permitAll()
//////                )
//////                .httpBasic(withDefaults());
////        http.authorizeHttpRequests(e -> e.anyRequest().permitAll());
////        return http.build();
////    }
////
////    @Bean
////    public UserDetailsService userDetailsService() {
////        return kullaniciService;
////    }
////
////    @Autowired
////    public void configure(AuthenticationManagerBuilder auth, DaoAuthenticationProvider authProvider) {
////        auth.authenticationProvider(authProvider);
////    }
//}
