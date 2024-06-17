package me.sailer.my_atelier.repository;

import me.sailer.my_atelier.domain.MemberAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberAddressRepository extends JpaRepository<MemberAddress, Short> {
}
