package br.com.orion.oauth2angular.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.orion.oauth2angular.model.User;

@Service
public interface IUserService {

    public User save(User user);

    public List<User> findAll();
}
