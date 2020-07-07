package br.com.orion.oauth2angular.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.orion.oauth2angular.exceptions.ResourceNotFoundException;
import br.com.orion.oauth2angular.infra.repository.UserRepository;
import br.com.orion.oauth2angular.model.User;
import br.com.orion.oauth2angular.model.dto.UserDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private UserRepository repository;

    public User save(User user) {
        return repository.save(user);
    }

    public User update(User user){
        User userToUpdate = findByUser(user);

        userToUpdate = User.builder()
            .id(userToUpdate.getId())
            .firstName(user.getFirstName())
            .email(user.getEmail())
            .build();

        return  save(userToUpdate);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException("Resource not found."));
    }

    @Override
    public User findByUser(User user) {
        Optional<User> userFound = repository.findById(user.getId());
        return userFound.orElseThrow(() -> new ResourceNotFoundException("Resource not found."));
    }

    public User fromDto(UserDto dto){
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(dto, User.class);
        return user;
    }

    public UserDto toDto(User user){
        ModelMapper mapper = new ModelMapper();
        UserDto userDto = mapper.map(user, UserDto.class);
        return userDto;
    }

    @Override
    public void deleteById(String id) {
        User userToDelete = findById(id);
        repository.delete(userToDelete);
    }

}
