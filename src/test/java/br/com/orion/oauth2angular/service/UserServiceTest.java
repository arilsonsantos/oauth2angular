package br.com.orion.oauth2angular.service;

import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.orion.oauth2angular.infra.repository.UserRepository;
import br.com.orion.oauth2angular.model.User;

@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class UserServiceTest {

    IUserService service;

    @MockBean
    UserRepository repository;

    @BeforeAll
    private void setUp() {
        service = new UserService(repository);
    }

    @Test
    public void valida_save_ok() {

        User user = User.builder().firstName("Joao").email("joao@email.com").build();
        User savedUser = User.builder().id("1").firstName("Joao").email("joao@email.com").build();

        when(service.save(user)).thenReturn(savedUser);
        savedUser = service.save(user); 

        Assertions.assertThat(savedUser.getId()).isEqualTo("1");

    }
}