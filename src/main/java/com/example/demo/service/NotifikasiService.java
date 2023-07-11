package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Notifikasi;
import com.example.demo.repository.NotifikasiRepository;

import java.util.List;

@Service
public class NotifikasiService {
    private final NotifikasiRepository notifikasiRepository;

    @Autowired
    public NotifikasiService(NotifikasiRepository notifikasiRepository) {
        this.notifikasiRepository = notifikasiRepository;
    }

    public Notifikasi createNotifikasi(Notifikasi notifikasi) {
        return notifikasiRepository.save(notifikasi);
    }

    public Notifikasi getNotifikasiById(Long id) {
        return notifikasiRepository.findById(id).orElse(null);
    }

    public List<Notifikasi> getAllNotifikasi() {
        return notifikasiRepository.findAll();
    }

    public Notifikasi updateNotifikasi(Long id, Notifikasi updatedNotifikasi) {
        Notifikasi notifikasi = notifikasiRepository.findById(id).orElse(null);
        if (notifikasi != null) {
            notifikasi.setTeks_notifikasi(updatedNotifikasi.getTeks_notifikasi());
            notifikasi.setTgl_notifikasi(updatedNotifikasi.getTgl_notifikasi());
            notifikasi.setCreated_at(updatedNotifikasi.getCreated_at());
            notifikasi.setCreated_by(updatedNotifikasi.getCreated_by());
            notifikasi.setUpdated_at(updatedNotifikasi.getUpdated_at());
            notifikasi.setUpdated_by(updatedNotifikasi.getUpdated_by());
            return notifikasiRepository.save(notifikasi);
        } else {
            return null;
        }
    }

    public boolean deleteNotifikasi(Long id) {
        Notifikasi notifikasi = notifikasiRepository.findById(id).orElse(null);
        if (notifikasi != null) {
            notifikasiRepository.delete(notifikasi);
            return true;
        } else {
            return false;
        }
    }
}
