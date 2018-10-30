package com.trpgim.trpgim;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

import com.trpgim.game.GameController;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class GameControllerTest {
	
	@LocalServerPort
    private int port;
	
	@Autowired
    private MockMvc mockMvc;
    
    @Autowired
	private GameController controller;
    
    @Test
    @WithMockUser(username = "test", password = "test")
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.controller.hello()).contains("Game API.");
        this.mockMvc.perform(get("/game"))
                           .andDo(print())
                           .andExpect(status().isOk())
                           .andExpect(content().string(containsString("Game API.")));
    }

}
