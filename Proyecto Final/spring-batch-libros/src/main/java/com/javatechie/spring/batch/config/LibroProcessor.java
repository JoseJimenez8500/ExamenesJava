package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Libro;
import org.springframework.batch.item.ItemProcessor;

public class LibroProcessor implements ItemProcessor<Libro,Libro> {

    @Override
    public Libro process(Libro libro) throws Exception {
            return libro;
    }
}
