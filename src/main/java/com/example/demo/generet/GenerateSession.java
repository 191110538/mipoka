package com.example.demo.generet;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Session;
import com.example.demo.repository.SessionRepository;

@RestController
public class GenerateSession {
    private final SessionRepository sessionRepository;

    public GenerateSession(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @PostMapping("/session")
    public ResponseEntity<?> generateSession(@RequestBody Session session) {
        // Simpan data session ke database
        sessionRepository.save(session);

        // Periksa jika tanda_tangan_sa tidak kosong
        if (session.getTanda_tangan_sa() != null && !session.getTanda_tangan_sa().isEmpty()) {
            // URL endpoint untuk request generate docx link sesi kegiatan
            String url = "https://generate-mbogddtpiq-et.a.run.app/session"; // Ganti sesuai URL server Anda

            // Membuat headers untuk request
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // Membuat entity untuk request dengan data sesi kegiatan
            HttpEntity<Session> requestEntity = new HttpEntity<>(session, headers);

            // Membuat RestTemplate
            RestTemplate restTemplate = new RestTemplate();

            // Melakukan request POST ke endpoint '/session-kegiatan' di server
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
                    String.class);

            // Mendapatkan response dari server (berupa URL file docx yang telah disimpan)
            String fileUrl = responseEntity.getBody();

            // Set properti "file_session" dengan nilai fileUrl
            session.setFile_session(fileUrl);

            // Update data sesi dengan properti "file_session" yang telah terisi
            sessionRepository.save(session);

            // Tampilkan URL file docx yang telah disimpan
            return ResponseEntity.ok("Sesi berhasil disimpan dan file docx telah dihasilkan. URL file docx: " + fileUrl);
        }

        // Tampilkan URL file docx yang telah disimpan tanpa hasil generate
        return ResponseEntity.ok("Sesi berhasil disimpan. URL file docx: " + session.getFile_session());
    }

    @PutMapping("/session/{id}")
    public ResponseEntity<?> updateSession(@PathVariable Long id, @RequestBody Session updatedSession) {
        // Cari data sesi berdasarkan ID
        Optional<Session> sessionOptional = sessionRepository.findById(id);

        if (sessionOptional.isPresent()) {
            Session session = sessionOptional.get();
            session.setUser(updatedSession.getUser());
            session.setOrmawa(updatedSession.getOrmawa());
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
            session.setTanda_tangan_sa(updatedSession.getTanda_tangan_sa());
            session.setFile_session(updatedSession.getFile_session());
            session.setUpdated_at(updatedSession.getUpdated_at());
            session.setCreated_at(updatedSession.getCreated_at());
            session.setUpdated_by(updatedSession.getUpdated_by());
            session.setCreated_by(updatedSession.getCreated_by());

            // Simpan data sesi yang telah diupdate ke database
            sessionRepository.save(session);

            if (updatedSession.getTanda_tangan_sa() != null && !updatedSession.getTanda_tangan_sa().isEmpty()) {
                // URL endpoint untuk request generate docx link sesi kegiatan
                String url = "https://generate-mbogddtpiq-et.a.run.app/session"; // Ganti sesuai URL server Anda
    
                // Membuat headers untuk request
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
    
                // Membuat entity untuk request dengan data sesi kegiatan
                HttpEntity<Session> requestEntity = new HttpEntity<>(session, headers);
    
                // Membuat RestTemplate
                RestTemplate restTemplate = new RestTemplate();
    
                // Melakukan request POST ke endpoint '/session-kegiatan' di server
                ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
                        String.class);
    
                // Mendapatkan response dari server (berupa URL file docx yang telah disimpan)
                String fileUrl = responseEntity.getBody();
    
                // Set properti "file_session" dengan nilai fileUrl
                session.setFile_session(fileUrl);
            }
    
            // Update data sesi dengan properti "tanda_tangan_sa" yang telah diubah dan (opsional) "file_session" yang telah terisi
            session.setTanda_tangan_sa(updatedSession.getTanda_tangan_sa());
            session.setUpdated_at(updatedSession.getUpdated_at());
            session.setUpdated_by(updatedSession.getUpdated_by());
    
            // Simpan data sesi yang telah diupdate ke database
            sessionRepository.save(session);
    
            return ResponseEntity.ok("Sesi dengan ID " + id + " berhasil diupdate.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
