package com.avaloq.oauth.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.avaloq.oauth.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("select distinct u from User u inner join fetch u.authorities as authorities where u.username = :username")
	User findByUsername(@Param("username") String username);

}
