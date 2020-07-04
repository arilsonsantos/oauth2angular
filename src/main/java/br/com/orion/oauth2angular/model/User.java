package br.com.orion.oauth2angular.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = "firsName")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String fisrtName;

    private String email;

}
