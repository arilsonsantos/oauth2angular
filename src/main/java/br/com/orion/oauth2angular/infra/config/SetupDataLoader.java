package br.com.orion.oauth2angular.infra.config;

import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import br.com.orion.oauth2angular.infra.repository.UserRepository;
import br.com.orion.oauth2angular.model.User;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository repository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        User user1 = User.builder().firstName("Joao").email("joao@email.com").build();
        User user2 = User.builder().firstName("Maria").email("maria@email.com").build();

        createUserIfNotFound(user1);
        createUserIfNotFound(user2);
    }

    private User createUserIfNotFound(final User user) {
        Optional<User> obj = repository.findByEmail(user.getEmail());
        return obj.orElse(repository.save(user));
    }

}