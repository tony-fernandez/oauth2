package com.avaloq.oauth.repository;

import org.springframework.data.repository.CrudRepository;

import com.avaloq.oauth.model.UserAuthority;

public interface UserAuthorityRepository extends CrudRepository<UserAuthority, Long> {

}
