package br.com.orion.oauth2angular.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.orion.oauth2angular.model.User;

@Service
public class UserService {

    public User save(User user) {
        return null;
    }

	public Page<User> findAll(Pageable pageable) {
		return null;
	}

}
