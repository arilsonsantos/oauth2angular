package br.com.orion.oauth2angular.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.orion.oauth2angular.model.User;
import br.com.orion.oauth2angular.model.dto.UserDto;

@Service
public interface IUserService {

    public User save(User user);

    public User update(User user);

    public User findById(String id);

    public User findByUser(User user);

    public void deleteById(String id);

    public List<User> findAll();

    public User fromDto(UserDto dto);

    public UserDto toDto(User user);


}
