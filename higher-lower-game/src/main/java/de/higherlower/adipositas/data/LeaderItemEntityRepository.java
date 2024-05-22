package de.higherlower.adipositas.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LeaderItemEntityRepository extends JpaRepository<LeaderItemEntity, UUID> {
}
