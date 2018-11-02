package com.avaloq.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.avaloq.oauth.model.Authority;
import com.avaloq.oauth.model.User;
import com.avaloq.oauth.model.UserAuthority;
import com.avaloq.oauth.repository.AuthorityRepository;
import com.avaloq.oauth.repository.UserAuthorityRepository;
import com.avaloq.oauth.repository.UserRepository;

@SpringBootApplication
public class AuthorisationServerApplication implements CommandLineRunner {

  @Autowired
  private AuthorityRepository authorityRepository;

  @Autowired
  private UserAuthorityRepository userAuthorityRepository;

  @Autowired
  private UserRepository userRepository;

  public static void main(String[] args) {
    SpringApplication.run(AuthorisationServerApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

  }

  private static AuthorityBuilder anAuthority() {
    return new AuthorityBuilder();
  }

  private static UserAuthorityBuilder aUserAuthority() {
    return new UserAuthorityBuilder();
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

  private static class UserAuthorityBuilder {

    private final UserAuthority instance;

    public UserAuthorityBuilder() {
      instance = new UserAuthority();
    }

    public UserAuthority build() {
      return this.instance;
    }

    public UserAuthorityBuilder authority(Authority authority) {
      instance.setAuthority(authority);
      return this;
    }

    public UserAuthorityBuilder user(User user) {
      instance.setUser(user);
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

    public UserBuilder userName(String userName) {
      this.instance.setUserName(userName);
      return this;
    }

  }

}
