package com.pl.primer_zone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pl.primer_zone.model.player;


@Repository
public interface PlayerRepository extends JpaRepository<player, String>{

}
