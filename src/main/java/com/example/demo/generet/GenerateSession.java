package com.example.demo.generet;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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

        // Jika semua properti telah terisi, baru jalankan generate dan POST ke server
        if (isAllPropertiesFilled(session)) {
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
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

            // Mendapatkan response dari server (berupa URL file docx yang telah disimpan)
            String fileUrl = responseEntity.getBody();

            // Set properti "file_session" dengan nilai fileUrl
            session.setFile_session(fileUrl);

            // Update data sesi dengan properti "file_session" yang telah terisi
            sessionRepository.save(session);

            // Tampilkan URL file docx yang telah disimpan
            return ResponseEntity.ok("Sesi berhasil disimpan. URL file docx: " + fileUrl);
        } else {
            // Jika ada properti yang kosong, tampilkan pesan sukses tanpa generate file
            return ResponseEntity.ok("Sesi berhasil disimpan.");
        }
    }

    // Method untuk mengecek apakah semua properti telah terisi
    private boolean isAllPropertiesFilled(Session session) {
        // Cek semua properti yang ingin dicek
        return session.getUser() != null && session.getUser().getId_user() != null
                && session.getOrmawa() != null && session.getOrmawa().getId_ormawa() != null
                && session.getTanggal_mulai() != null && !session.getTanggal_mulai().isEmpty()
                && session.getTanggal_selesai() != null && !session.getTanggal_selesai().isEmpty()
                && session.getWaktu_mulai_penggunaan() != null && !session.getWaktu_mulai_penggunaan().isEmpty()
                && session.getWaktu_selesai_penggunaan() != null && !session.getWaktu_selesai_penggunaan().isEmpty()
                && session.getRuangan() != null && !session.getRuangan().isEmpty()
                && session.getGedung() != null && !session.getGedung().isEmpty()
                && session.getKegiatan() != null && !session.getKegiatan().isEmpty();
                // Lanjutkan dengan properti-properti lain yang ingin Anda cek di sini
                // ...
    }
}