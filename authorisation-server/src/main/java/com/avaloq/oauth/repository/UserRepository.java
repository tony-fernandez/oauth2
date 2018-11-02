package com.avaloq.oauth.repository;

import org.springframework.data.repository.CrudRepository;

import com.avaloq.oauth.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
