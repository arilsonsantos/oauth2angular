package br.com.orion.oauth2angular.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.orion.oauth2angular.model.User;

public interface IUserService {

    public User save(User user);

    public Page<User> findAll(Pageable pageable);
}
