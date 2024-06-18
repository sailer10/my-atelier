package me.sailer.my_atelier.repository;

import me.sailer.my_atelier.domain.AtelierManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtelierManagerRepository extends JpaRepository<AtelierManager, Long> {
}
