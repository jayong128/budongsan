package com.hello.myproject.Repository;

import com.hello.myproject.entity.Cortar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CortarRepository extends JpaRepository<Cortar, String > {
}
