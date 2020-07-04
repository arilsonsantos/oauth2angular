package br.com.orion.oauth2angular.infra.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orion.oauth2angular.model.User;
import br.com.orion.oauth2angular.service.IUserService;

@RestController
@RequestMapping("users")
public class UserResource {

    @Autowired
    IUserService service;
    
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = service.findAll();

        return ResponseEntity.ok().body(users);
    }

    // @ResponseStatus(code = HttpStatus.OK)
    // @GetMapping(name = "page")
    // public Page<User> findAll(Pageable pageRequest){
    //     Page<User> result = service.findAll(pageRequest);

    //     List<User> list = result.getContent();

    //     return new PageImpl<>(list, pageRequest, result.getTotalElements());
    // }
}