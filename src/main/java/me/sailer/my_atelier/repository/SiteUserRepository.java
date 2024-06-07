package me.sailer.my_atelier.repository;


import me.sailer.my_atelier.domain.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {

}
