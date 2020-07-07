package br.com.orion.oauth2angular.model;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "firstName")
@EqualsAndHashCode(of = "id")
@Document("USER")
public class User {



    @Id
    private String id;

    private String firstName;

    private String email;

    @DBRef (lazy = true)
    private List<Role> roles;
    
}
