package com.example.tp1.dao;
import com.example.tp1.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LivreRepository extends JpaRepository<Livre, Long> {
}