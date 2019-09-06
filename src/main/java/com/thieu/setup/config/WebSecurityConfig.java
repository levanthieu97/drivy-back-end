package com.thieu.setup.config;


import com.thieu.setup.security.JwtAuthenticationEntryPoint;
import com.thieu.setup.security.JwtAuthenticationFilter;
import com.thieu.setup.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(myUserDetailsService)
                .passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/public/**")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/api/suppliers/**")
                .permitAll()
                .antMatchers("/api/admin/**")
                .hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/api/products/**")
                .permitAll()
                .antMatchers("/api/all/**")
                .permitAll()
                .antMatchers("/api/category/**")
                .permitAll()
                .antMatchers("/api/cate-detail/**")
                .permitAll()
                .antMatchers("/api/category-catalog/**")
                .permitAll()
                .antMatchers("/api/suggest-category/**")
                .permitAll()
                .antMatchers("/api/image/**")
                .permitAll()
                .antMatchers("/api/catalog-product/**")
                .permitAll()
                .antMatchers("/api/supplier-product/**")
                .permitAll()
                .antMatchers("/api/shopping-cart/**")
                .permitAll()
                .antMatchers("/api/address/**")
                .permitAll()
                .antMatchers("/api/order-product/**")
                .permitAll()
                .antMatchers("/api/payment/**")
                .permitAll()
                .antMatchers("/api/supplier-order/**")
                .permitAll()
                .antMatchers("/api/mail/**")
                .permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/sign-in").permitAll()
                .anyRequest()
                .authenticated();
        // Add our custom JWT security filter
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
