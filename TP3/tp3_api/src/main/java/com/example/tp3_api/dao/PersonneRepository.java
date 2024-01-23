package com.example.tp3_api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tp3_api.entity.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
