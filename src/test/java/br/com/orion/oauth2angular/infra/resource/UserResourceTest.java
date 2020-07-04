package br.com.orion.oauth2angular.infra.resource;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.orion.oauth2angular.AbstractTest;
import br.com.orion.oauth2angular.model.User;
import br.com.orion.oauth2angular.service.UserService;

public class UserResourceTest extends AbstractTest {

    private static final String USER_URI = "/users";

    @Autowired
    ObjectMapper mapper;

    @Autowired 
    MockMvc mockMvc;

    @MockBean
    UserService service;

    @Test
    @DisplayName("Validate create user CREATED")
    public void validate_create_user() throws Exception {
        User user = User.builder().fisrtName("Joao").email("joao@email.com").build();

        BDDMockito.given(service.save(Mockito.any(User.class))).willReturn(user);
        
        String json = mapper.writeValueAsString(user);

        var request = MockMvcRequestBuilders.post(USER_URI).contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON).content(json);

        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isCreated());
        
    }

    @Test
    @DisplayName("Validade find all OK")
    public void validate_findAll() throws Exception {
        User user1 = User.builder().fisrtName("Joao").email("joao@email.com").build();
        User user2 = User.builder().fisrtName("Maria").email("maria@email.com").build();

        List<User> users = List.of(user1, user2);

        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<User> page = new PageImpl<User>(users, pageRequest, 1);

        BDDMockito.given(service.findAll(Mockito.any(Pageable.class)))
        .willReturn(page);

        String queryString = "?/page=0&size=100";
        var request = MockMvcRequestBuilders.get(USER_URI.concat(queryString)).contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("content", Matchers.hasSize(2)));
    }
    
}