package com.pl.primer_zone.controller;

import java.util.List;

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

import com.pl.primer_zone.model.player;
import com.pl.primer_zone.service.PlayerService;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {
	
	private final PlayerService service;
	
	public PlayerController(PlayerService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<player> getPlayers(player player){
		if (player.getClub() != null && player.getPosition() != null) {
			return service.getPlayerByClubAndPosition(player.getClub(), player.getPosition());
		}
		else if(player.getClub() != null) {
			return service.getPlayersFromClub(player.getClub());
		}
		else if(player.getName() != null) {
			return service.getPlayerByName(player.getName());
		}
		else if(player.getPosition() != null) {
			return service.getPlayerByPos(player.getPosition());
		}
		else if(player.getNationality() != null) {
			return service.getPlayerByNation(player.getNationality());
		}
		else {
			return service.getPlayer();		
		}	
	}
	
	@PostMapping
	public ResponseEntity<player> addPlayer( @RequestBody player player){
		player createdPlayer = service.addPlayer(player);
		return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<player> updatePlayer(player player){
		player resultPlayer = service.updatePlayer(player);
		if( resultPlayer != null) {
			return new ResponseEntity<>(resultPlayer, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{PlayerName}")
	ResponseEntity<Long> deletePlayer(@PathVariable String PlayerName){
		service.deletePlayer(PlayerName);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
