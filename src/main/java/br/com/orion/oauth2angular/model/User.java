package br.com.orion.oauth2angular.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = "firstName")
@Document("USER")
public class User {


    @Id
    private String id;

    private String firstName;

    private String email;

}
