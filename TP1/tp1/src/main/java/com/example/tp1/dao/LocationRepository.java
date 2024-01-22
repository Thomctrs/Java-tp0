package com.example.tp1.dao;
import com.example.tp1.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LocationRepository extends JpaRepository<Livre, Long> {
}