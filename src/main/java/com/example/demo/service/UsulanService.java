package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Usulan;
import com.example.demo.repository.UsulanRepository;
import com.example.demo.service.UsulanService;

@Service
public class UsulanService {

    private final UsulanRepository usulanRepository;
   

    @Autowired
    public UsulanService(UsulanRepository usulanRepository) {
        this.usulanRepository = usulanRepository;
    }

    public Usulan createUsulan(Usulan usulan) {
        return usulanRepository.save(usulan);
    }

    public List<Usulan> getAllUsulan() {
        return usulanRepository.findAll();
    }

    public Usulan getUsulanById(Long id) {
        return usulanRepository.findById(id).orElse(null);
    }

    public Usulan updateUsulan(Usulan usulan) {
        return usulanRepository.save(usulan);
    }

    public void deleteUsulan(Long id) {
        usulanRepository.deleteById(id);
    }
}