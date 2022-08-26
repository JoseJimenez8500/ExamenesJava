package com.javatechie.spring.batch.repository;

import com.javatechie.spring.batch.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository  extends JpaRepository<Libro,Integer> {
}
