package com.backend.internshipsystem;


import com.backend.internshipsystem.domain.entities.User;
import com.backend.internshipsystem.infra.security.TokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class SecurityRoutesTest {

    @Autowired
    private MockMvc api;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    private static final String APPLICATION_URL = "/application";
    private static final String INTERNSHIP_URL = "/internship";
    private static final String INTERNSHIP_VIEW_URL = "/internship/1";

    private String token;


    private String performLoginAndGetToken(String username, String password) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(username, password);
            var auth = this.authenticationManager.authenticate(usernamePassword);

            return tokenService.generateToken((User)auth.getPrincipal());
        } catch (Exception e) {
            System.out.println("Failed to authenticate user: " + e.getMessage());
            return null;
        }
    }

    @BeforeEach
    void setUp() {
        token = performLoginAndGetToken("admin", "password");
    }

    @Test
    void anonymousUserCannotAccessApplications() throws Exception {
        api.perform(MockMvcRequestBuilders.get(APPLICATION_URL))
                .andExpect(status().isForbidden());
    }

    @Test
    void anonymousUserCanAccessInternships() throws Exception {
        api.perform(MockMvcRequestBuilders.get(INTERNSHIP_URL))
                .andExpect(status().isOk());
    }

    @Test
    void anonymousUserCanViewInternships() throws Exception {
        api.perform(MockMvcRequestBuilders.get(INTERNSHIP_VIEW_URL))
                .andExpect(status().isOk());
    }

    @Test
    void loggedInUserCanAccessApplications() throws Exception {
        api.perform(MockMvcRequestBuilders.get(APPLICATION_URL)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }

    @Test
    void loggedInUserCanAccessInternships() throws Exception {
        api.perform(MockMvcRequestBuilders.get(INTERNSHIP_URL)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }

    @Test
    void loggedInUserCanViewInternships() throws Exception {
        api.perform(MockMvcRequestBuilders.get(INTERNSHIP_VIEW_URL)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }
}

