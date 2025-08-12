package com.ayman.nindemo.repository;

import com.ayman.nindemo.model.entity.NIN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NinRepository extends JpaRepository<NIN, Long> {
    Optional<NIN> findNinById(Long NinId);
    Optional<NIN> findNinByNin(String nin);
}
