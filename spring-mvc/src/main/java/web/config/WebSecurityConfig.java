package web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index.htm").permitAll()
                .antMatchers("/css/**", "/images/**").permitAll()
                .antMatchers("/ProductController.htm").hasAnyRole("USER","ADMIN")
                .antMatchers("/PersonController.htm**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
        .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User.withDefaultPasswordEncoder().username("miekem").password("1234").roles("USER").build());
        manager.createUser(User.withDefaultPasswordEncoder().username("admin").password("t").roles("ADMIN").build());
        return manager;
    }
}
