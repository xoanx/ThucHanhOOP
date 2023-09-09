package com.example.accmanager.AccRepository;

import com.example.accmanager.AccEntity.AccEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccRepository extends JpaRepository<AccEntity, UUID> {
}
