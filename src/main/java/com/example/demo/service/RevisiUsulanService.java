package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RevisiUsulan;
import com.example.demo.repository.RevisiUsulanRepository;

@Service
public class RevisiUsulanService {

    private final RevisiUsulanRepository revisiUsulanRepository;

    @Autowired
    public RevisiUsulanService(RevisiUsulanRepository revisiUsulanRepository) {
        this.revisiUsulanRepository = revisiUsulanRepository;
    }
    public List<RevisiUsulan> getAllRevisiUsulan() {
        return revisiUsulanRepository.findAll();
    }

    public RevisiUsulan createRevisiUsulan(RevisiUsulan revisiUsulan) {
        return revisiUsulanRepository.save(revisiUsulan);
    }

    public RevisiUsulan getRevisiUsulanById(Long id) {
        return revisiUsulanRepository.findById(id).orElse(null);
    }

    public RevisiUsulan updateRevisiUsulan(Long id, RevisiUsulan revisiUsulan) {
        RevisiUsulan existingRevisiUsulan = revisiUsulanRepository.findById(id).orElse(null);
        if (existingRevisiUsulan != null) {
            revisiUsulan.setId_revisi_usulan(existingRevisiUsulan.getId_revisi_usulan());
            return revisiUsulanRepository.save(revisiUsulan);
        }
        return null;
    }

    public boolean deleteRevisiUsulan(Long id) {
        RevisiUsulan existingRevisiUsulan = revisiUsulanRepository.findById(id).orElse(null);
        if (existingRevisiUsulan != null) {
            revisiUsulanRepository.delete(existingRevisiUsulan);
            return true;
        }
        return false;
    }
}
