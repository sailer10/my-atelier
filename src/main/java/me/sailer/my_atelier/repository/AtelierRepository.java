package me.sailer.my_atelier.repository;

import me.sailer.my_atelier.domain.Atelier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtelierRepository extends JpaRepository<Atelier, Long> {
}
