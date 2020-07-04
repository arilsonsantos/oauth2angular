package br.com.orion.oauth2angular.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.orion.oauth2angular.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
