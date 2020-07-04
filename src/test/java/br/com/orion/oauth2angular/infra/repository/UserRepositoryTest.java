package br.com.orion.oauth2angular.infra.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.orion.oauth2angular.model.User;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    TestEntityManager entityManager;
    

    @Test
    public void veriry_save(){
        User user = User.builder().fisrtName("Joao").email("joao@email.com").build();
        user = entityManager.persist(user);
        
        Assertions.assertThat(user.getId()).isNotNull(); 
    }
}