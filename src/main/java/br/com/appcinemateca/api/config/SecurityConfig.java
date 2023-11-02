package br.com.appcinemateca.api.config;

/**@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer {
    @Autowired
    private UserServiceDatailsImpl usuarioService;

    @Bean
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(usuarioService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .requestMatchers(
                        "/auth/signin",
                        "/auth/refresh",
                        "/api-docs/**",
                        "/swagger-ui/**",
                        "/v3/**",
                        "/filmes/**")
                .permitAll()
                .requestMatchers("/**").authenticated()
                .requestMatchers("/users").denyAll();

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}**/