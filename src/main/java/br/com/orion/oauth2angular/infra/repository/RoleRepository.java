package br.com.orion.oauth2angular.infra.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.orion.oauth2angular.model.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    
    Optional<Role> findByName(String name);
}