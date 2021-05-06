package com.projetosoftware2.resercoworking.config;

import com.projetosoftware2.resercoworking.security.JWTAuthenticationFilter;
import com.projetosoftware2.resercoworking.security.JWTAuthorizationFilter;
import com.projetosoftware2.resercoworking.security.JWTUtil;
import com.projetosoftware2.resercoworking.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.text.ParseException;
import java.util.Arrays;

/**
 * Created by Filipe.Tobias on 01/08/2018.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private Environment env;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instantiateDatabase() throws ParseException {

        if (!"create".equals(strategy)){
            return false;
        }

        dbService.instantiateTestDatabase();
        return true;
    }

    private static final String[] PUBLIC_MATCHERS = {
         "/h2-console/**",
    };

    private static final String[] PUBLIC_MATCHERS_GET = {
            "/usuario/**",
            "/perfil/**",
            "/premiacao/**",
            "/modalidadeEspaco/**",
            "/espaco/**",
            "/feedbackEspaco/**",
            "/pais/**",
            "/endereco/**",
            "/estado/**",
            "/cidade/**",
            "/bairro/**",
    };

    private static final String[] PUBLIC_MATCHERS_POST = {
            "/login",
            "/auth/forgot/**",
            "/usuario/**",
            "/perfil/**",
            "/premiacao/**",
            "/modalidadeEspaco/**",
            "/espaco/**",
            "/feedbackEspaco/**",
            "/pais/**",
            "/endereco/**",
            "/estado/**",
            "/cidade/**",
            "/bairro/**",
    };

    private static final String[] PUBLIC_MATCHERS_DELETE = {
            "/usuario/**",
            "/perfil/**",
            "/premiacao/**",
            "/modalidadeEspaco/**",
            "/espaco/**",
            "/feedbackEspaco/**",
            "/pais/**",
            "/endereco/**",
            "/estado/**",
            "/cidade/**",
            "/bairro/**",
    };

    private static final String[] PUBLIC_MATCHERS_PUT = {
            "/usuario/**",
            "/perfil/**",
            "/premiacao/**",
            "/modalidadeEspaco/**",
            "/espaco/**",
            "/feedbackEspaco/**",
            "/pais/**",
            "/endereco/**",
            "/estado/**",
            "/cidade/**",
            "/bairro/**",
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.cors().and().csrf().disable();
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
                .antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
                .antMatchers(HttpMethod.DELETE, PUBLIC_MATCHERS_DELETE).permitAll()
                .antMatchers(HttpMethod.PUT, PUBLIC_MATCHERS_PUT).permitAll()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .anyRequest().authenticated();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
        http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
        configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
