package com.soprasteria.jwtspringsecuritymongodbangular.securityConfig;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configurable
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Supprimer le formulaire d'authenification crée par Spring-security par defaut
        //super.configure(http);

        //Desactiver le token par defaut
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/categories/**").permitAll()
                                .antMatchers(HttpMethod.GET, "/products/**").permitAll()
                                .antMatchers("/categories/**").hasAuthority("ADMIN")
                                .antMatchers("/products/**").hasAuthority("USER")
                                .anyRequest().authenticated();
        http.addFilterBefore(new JWTAuthorizayionFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}