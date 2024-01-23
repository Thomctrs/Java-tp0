package com.example.tp1.dao;
import com.example.tp1.entity.Emprunteur;

import org.springframework.data.jpa.repository.JpaRepository;
public interface LocationRepository extends JpaRepository<Emprunteur, Long> {
}