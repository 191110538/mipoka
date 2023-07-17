package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.MhsPerPeriodeMpt;
import com.example.demo.repository.MhsPerPeriodeMptRepository;

@Service
public class MhsPerPeriodeMptService {

    private MhsPerPeriodeMptRepository mhsPerPeriodeMptRepository;

    public MhsPerPeriodeMptService(MhsPerPeriodeMptRepository mhsPerPeriodeMptRepository) {
        this.mhsPerPeriodeMptRepository = mhsPerPeriodeMptRepository;
    }

    public MhsPerPeriodeMpt createMhsPerPeriodeMpt(MhsPerPeriodeMpt mhsPerPeriodeMpt) {
        return mhsPerPeriodeMptRepository.save(mhsPerPeriodeMpt);
    }

    public MhsPerPeriodeMpt updateMhsPerPeriodeMpt(Long id, MhsPerPeriodeMpt updatedMhsPerPeriodeMpt) {
        MhsPerPeriodeMpt mhsPerPeriodeMpt = mhsPerPeriodeMptRepository.findById(id).orElse(null);
        if (mhsPerPeriodeMpt != null) {
            mhsPerPeriodeMpt.setUser(updatedMhsPerPeriodeMpt.getUser());
            mhsPerPeriodeMpt.setPeriode_mpt(updatedMhsPerPeriodeMpt.getPeriode_mpt());
            //mhsPerPeriodeMpt.setKegiatan_per_periode_mpt(updatedMhsPerPeriodeMpt.getKegiatan_per_periode_mpt());
            mhsPerPeriodeMpt.setCreated_at(updatedMhsPerPeriodeMpt.getCreated_at());
            mhsPerPeriodeMpt.setCreated_by(updatedMhsPerPeriodeMpt.getCreated_by());
            mhsPerPeriodeMpt.setUpdated_at(updatedMhsPerPeriodeMpt.getUpdated_at());
            mhsPerPeriodeMpt.setUpdated_by(updatedMhsPerPeriodeMpt.getUpdated_by());
            // Set other updated fields
            return mhsPerPeriodeMptRepository.save(mhsPerPeriodeMpt);
        } else {
            throw new IllegalArgumentException("MhsPerPeriodeMpt with ID " + id + " does not exist");
        }
    }

    public void deleteMhsPerPeriodeMpt(Long id) {
        mhsPerPeriodeMptRepository.deleteById(id);
    }

    public MhsPerPeriodeMpt getMhsPerPeriodeMptById(Long id) {
        return mhsPerPeriodeMptRepository.findById(id).orElse(null);
    }

    public List<MhsPerPeriodeMpt> getAllMhsPerPeriodeMpt() {
        return mhsPerPeriodeMptRepository.findAll();
    }
}