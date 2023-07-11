package com.example.demo.service;

import com.example.demo.entity.Session;
import com.example.demo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public Session getSessionById(Long id) {
        return sessionRepository.findById(id).orElse(null);
    }

    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    public Session updateSession(Long id, Session updatedSession) {
        Session session = sessionRepository.findById(id).orElse(null);
        if (session != null) {
            session.setTanggal_mulai(updatedSession.getTanggal_mulai());
            session.setTanggal_selesai(updatedSession.getTanggal_selesai());
            session.setRuangan(updatedSession.getRuangan());
            session.setGedung(updatedSession.getGedung());
            session.setWaktu_mulai_penggunaan(updatedSession.getWaktu_mulai_penggunaan());
            session.setWaktu_selesai_penggunaan(updatedSession.getWaktu_selesai_penggunaan());
            session.setKegiatan(updatedSession.getKegiatan());
            session.setProyektor(updatedSession.getProyektor());
            session.setLaptop(updatedSession.getLaptop());
            session.setMikrofon(updatedSession.getMikrofon());
            session.setSpeaker(updatedSession.getSpeaker());
            session.setMeja(updatedSession.getMeja());
            session.setKursi(updatedSession.getKursi());
            session.setPapan_tulis(updatedSession.getPapan_tulis());
            session.setSpidol(updatedSession.getSpidol());
            session.setLain_lain(updatedSession.getLain_lain());
            session.setStatus(updatedSession.getStatus());
            session.setKeterangan(updatedSession.getKeterangan());
            session.setUpdated_at(updatedSession.getUpdated_at());
            session.setCreated_at(updatedSession.getCreated_at());
            session.setUpdated_by(updatedSession.getUpdated_by());
            session.setCreated_by(updatedSession.getCreated_by());
            return sessionRepository.save(session);
        } else {
            return null;
        }
    }

    public boolean deleteSession(Long id) {
        Session session = sessionRepository.findById(id).orElse(null);
        if (session != null) {
            sessionRepository.delete(session);
            return true;
        } else {
            return false;
        }
    }
}
