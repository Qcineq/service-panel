package pl.coderslab.servicepanel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
class SpringSecurity {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                //.csrf().disable()
                .authorizeRequests()
                //.antMatchers("/**").authenticated()
                .antMatchers("/login").permitAll()
                .antMatchers("/reports/list").authenticated()
                .anyRequest().hasRole("ADMIN")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/report/list").and()
                .logout().logoutSuccessUrl("/login?test");

        return http.build();
    }
}