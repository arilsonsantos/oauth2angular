package br.com.orion.oauth2angular.infra.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orion.oauth2angular.model.User;
import br.com.orion.oauth2angular.model.dto.UserDto;
import br.com.orion.oauth2angular.service.IUserService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserResource {

    private IUserService service;
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto dto) {
        User user = service.fromDto(dto);
        service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto dto) {
        User user = service.fromDto(dto);
        service.update(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> users = service.findAll();
        List<UserDto> dtos = users.stream().map(u -> mapper.map(u, UserDto.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id){
        User user = service.findById(id);
        UserDto dto = service.toDto(user);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }



    // @ResponseStatus(code = HttpStatus.OK)
    // @GetMapping(name = "page")
    // public Page<User> findAll(Pageable pageRequest){
    // Page<User> result = service.findAll(pageRequest);

    // List<User> list = result.getContent();

    // return new PageImpl<>(list, pageRequest, result.getTotalElements());
    // }
}