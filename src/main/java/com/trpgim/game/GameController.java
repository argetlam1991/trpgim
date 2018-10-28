package com.trpgim.game;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
	
	@GetMapping("/game")
	public @ResponseBody String hello() {
		return "Game API.";
   }
	

}
