package br.com.orion.oauth2angular.infra.config;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import br.com.orion.oauth2angular.infra.repository.RoleRepository;
import br.com.orion.oauth2angular.infra.repository.UserRepository;
import br.com.orion.oauth2angular.model.Role;
import br.com.orion.oauth2angular.model.User;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        roleRepository.deleteAll();
        userRepository.deleteAll();

        Role admin = Role.builder().name("ROLE_ADMIN").build();
        Role user = Role.builder().name("ROLE_USER").build();
        createRoleIfNotFound(admin);
        createRoleIfNotFound(user);

        List<Role> joao_role = Arrays.asList(admin);
        List<Role> maria_role = Arrays.asList(admin, user);
        List<Role> jose_role = Arrays.asList(user);

        User user1 = User.builder().firstName("Joao").email("joao@email.com").roles(joao_role).build();
        User user2 = User.builder().firstName("Maria").email("maria@email.com").roles(maria_role).build();
        User user3 = User.builder().firstName("Jose").email("jose@email.com").roles(jose_role).build();

        createUserIfNotFound(user1);
        createUserIfNotFound(user2);
        createUserIfNotFound(user3);


    }

    private void createUserIfNotFound(final User user) {
        Optional<User> obj = userRepository.findByEmail(user.getEmail());
        if (obj.isPresent()){
            return;
        }
        userRepository.save(user);
    }

    private void createRoleIfNotFound(final Role role) {
        Optional<Role> obj = roleRepository.findByName(role.getName());
        if (obj.isPresent()){
            return;
        }
        roleRepository.save(role);
    }

}