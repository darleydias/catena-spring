package com.github.darleydias.domain.repository;

import com.github.darleydias.domain.entity.Comarca;
import com.github.darleydias.domain.entity.Promotor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface Promotores extends JpaRepository<Promotor,Integer> {
    Set<Promotor> findByComarca(Comarca comarca);
}
