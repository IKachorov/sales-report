package com.intracol.basecamp.homework3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http)
		throws Exception {

		http.csrf().disable();
		
		http.authorizeRequests()
			.regexMatchers(HttpMethod.OPTIONS, ".*").permitAll()
			.regexMatchers(HttpMethod.GET, "/cityreports").hasAuthority("MANAGER")
			.regexMatchers(HttpMethod.GET, "/storereports").hasAuthority("MANAGER")
			.regexMatchers(HttpMethod.GET, "/reports").hasAuthority("MANAGER")
			.regexMatchers(HttpMethod.POST, "/reports").hasAuthority("SALES")
			.anyRequest().authenticated();
		
		super.configure(http);
	}

	@SuppressWarnings("deprecation")
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User
                .withDefaultPasswordEncoder()
                .username("sales")
                .password("sales")
                .authorities("SALES")
                .build());
        
        manager.createUser(User
                .withDefaultPasswordEncoder()
                .username("manager")
                .password("manager")
                .authorities("MANAGER")
                .build());
        return manager;
    }
	
	
	
}
