package br.com.orion.oauth2angular.model;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "firstName")
@EqualsAndHashCode(of = "id")
@Document("ROLE")
public class Role {

    @Id
    private String id;

    private String name;
}
