package com.avaloq.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.avaloq.oauth.config.Encoders;
import com.avaloq.oauth.model.Authority;
import com.avaloq.oauth.model.User;
import com.avaloq.oauth.repository.AuthorityRepository;
import com.avaloq.oauth.repository.UserRepository;

@SpringBootApplication
@Import(Encoders.class)
public class AuthorisationServerApplication implements CommandLineRunner {

	@Autowired
	private AuthorityRepository authorityRepository;

	@Autowired
	private UserRepository userRepository;


    @Autowired
    @Qualifier("userPasswordEncoder")
    private PasswordEncoder userPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(AuthorisationServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Authority balanceAuthority = anAuthority()
				.name("GET_BALANCE")
				.build();
		Authority transactionsAuthority = anAuthority()
				.name("GET_TRANSACTIONS")
				.build();
		
		authorityRepository.save(balanceAuthority);
		authorityRepository.save(transactionsAuthority);
		
		User thomasLehman = aUser()
				.enabled(true)
				.username("thomas_lehman")
				.password(this.userPasswordEncoder.encode("thomas_lehman"))
				.authority(balanceAuthority)
				.authority(transactionsAuthority)				
				.build();
		User annaLehman = aUser()
				.enabled(true)
				.username("anna_lehman")
				.password(this.userPasswordEncoder.encode("anna_lehman"))
				.authority(balanceAuthority)
				.authority(transactionsAuthority)				
				.build();
		
		
		userRepository.save(thomasLehman);
		userRepository.save(annaLehman);		
	}

	private static AuthorityBuilder anAuthority() {
		return new AuthorityBuilder();
	}

	private static UserBuilder aUser() {
		return new UserBuilder();
	}

	private static class AuthorityBuilder {

		private final Authority instance;

		public AuthorityBuilder() {
			instance = new Authority();
		}

		public Authority build() {
			return this.instance;
		}

		public AuthorityBuilder name(String name) {
			instance.setName(name);
			return this;
		}

	}

	private static class UserBuilder {

		private final User instance;

		public UserBuilder() {
			this.instance = new User();
		}

		public User build() {
			return this.instance;
		}

		public UserBuilder accountExpired(boolean accountExpired) {
			this.instance.setAccountExpired(accountExpired);
			return this;
		}

		public UserBuilder accountLocked(boolean accountLocked) {
			this.instance.setAccountLocked(accountLocked);
			return this;
		}

		public UserBuilder credentialsExpired(boolean credentialsExpired) {
			this.instance.setCredentialsExpired(credentialsExpired);
			return this;
		}

		public UserBuilder enabled(boolean enabled) {
			this.instance.setEnabled(enabled);
			return this;
		}

		public UserBuilder password(String password) {
			this.instance.setPassword(password);
			return this;
		}

		public UserBuilder username(String username) {
			this.instance.setUsername(username);
			return this;
		}

		public UserBuilder authority(Authority authority) {
			this.instance.getAuthorities().add(authority);
			return this;
		}
		
	}

}
