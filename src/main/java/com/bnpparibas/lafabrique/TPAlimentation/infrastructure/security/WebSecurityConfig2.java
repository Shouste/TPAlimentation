package com.bnpparibas.lafabrique.TPAlimentation.infrastructure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

//VERSION SEBASTIEN
@Configuration
@EnableWebSecurity
public class WebSecurityConfig2 extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource datasource;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(passwordEncoder())
                .dataSource(datasource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, name from users_role ru left join users u on u.id = ru.users_id right join role r on ru.roles_id = r.id where username=?")
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                        .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/food/*").hasRole("ADMIN")
                .and()
                .csrf().disable()   //permet d'éviter les attaques CRSF
        ;
        //.formLogin().disable();  //désactive la possibilité de s'authent par formulaire
    }

    // Important : Bean -> accessible partout, et instance unique qui crypte les mdp
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // pour récupérer un mdp et le stocker dans la bdd (pour tester)
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("password admin :" + encoder.encode("admin"));
        return new BCryptPasswordEncoder();
    }

}
