package com.example.tp2.dao;
import com.example.tp2.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PersonneRepository extends JpaRepository<Personne, Long> {
}