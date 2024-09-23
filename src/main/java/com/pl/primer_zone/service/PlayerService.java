package com.pl.primer_zone.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pl.primer_zone.model.player;
import com.pl.primer_zone.repository.PlayerRepository;



@Service
@Component
public class PlayerService {
	
	private final PlayerRepository repo;
	
	
	public PlayerService(PlayerRepository repo) {
		this.repo = repo;
	}
	
	public List<player> getPlayer(){
		return repo.findAll();
		}

	public List<player>getPlayersFromClub(String clubName){
		return repo.findAll().stream().filter(player -> clubName.equals(player.getClub()))
	 			.collect(Collectors.toList());
	}
	
	public List<player> getPlayerByName( String searchName){
		return repo.findAll().stream().filter(player -> player.getName().toLowerCase().contains(searchName.toLowerCase()))
				.collect(Collectors.toList());
	}
	
	public List<player>getPlayerByPos(String searchText){
		return repo.findAll().stream().filter(player -> player.getPosition().toLowerCase()
				.contains(searchText.toLowerCase())).collect(Collectors.toList());
	}
	
	public List<player>getPlayerByNation(String searchText){
		return repo.findAll().stream().filter(player -> player.getNationality().toLowerCase()
				.contains(searchText.toLowerCase())).collect(Collectors.toList());
	}
	
	public List<player>getPlayerByClubAndPosition(String team, String position){
		return repo.findAll().stream().filter(player -> player.equals(player.getClub()) && 
				position.equals(player.getPosition())).collect(Collectors.toList());
	}
	
	public player addPlayer(player player) {
		return repo.save(player);
	}
	
	public player updatePlayer(player updatePlayer) {
		Optional<player> existingPlayer = repo.findById(updatePlayer.getName());
		
		if(existingPlayer.isPresent()) {
			player playerToUpdate = existingPlayer.get();
			playerToUpdate.setName(updatePlayer.getName());
			playerToUpdate.setClub(updatePlayer.getClub());
			playerToUpdate.setPosition(updatePlayer.getPosition());
			playerToUpdate.setNationality(updatePlayer.getNationality());
		
			repo.save(updatePlayer);
			return playerToUpdate;
		}
		return null;
	}
	
	@Transactional
	public void deletePlayer(String Name) {
		repo.deleteById(Name);
	}
	
	
}
