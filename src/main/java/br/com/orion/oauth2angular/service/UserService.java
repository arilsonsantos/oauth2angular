package br.com.orion.oauth2angular.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.orion.oauth2angular.infra.repository.UserRepository;
import br.com.orion.oauth2angular.model.User;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private  UserRepository repository;

    public User save(User user) {
        
        return repository.save(user);
    }

	public Page<User> findAll(Pageable pageable) {
		return null;
	}

}
