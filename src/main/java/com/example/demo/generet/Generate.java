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

import com.example.demo.entity.Usulan;


import com.example.demo.repository.UsulanRepository; // Ganti dengan lokasi repository yang sesuai

@RestController
public class Generate {
    private final UsulanRepository usulanRepository;

    public Generate(UsulanRepository usulanRepository) {
        this.usulanRepository = usulanRepository;
    }

    @PostMapping("/usulan")
    public ResponseEntity<?> generateUsulanKegiatan(@RequestBody Usulan usulan) {
        // Simpan data usulan ke database
        usulanRepository.save(usulan);

        // Jika semua properti telah terisi, baru jalankan generate dan POST ke server
        if (isAllPropertiesFilled(usulan)) {
            // URL endpoint untuk request generate docx link usulan kegiatan
            String url = "https://generate-mbogddtpiq-et.a.run.app/usulan-kegiatan"; // Ganti sesuai URL server Anda

            // Membuat headers untuk request
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // Membuat entity untuk request dengan data usulan kegiatan
            HttpEntity<Usulan> requestEntity = new HttpEntity<>(usulan, headers);

            // Membuat RestTemplate
            RestTemplate restTemplate = new RestTemplate();

            // Melakukan request POST ke endpoint '/usulan-kegiatan' di server
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

            // Mendapatkan response dari server (berupa URL file docx yang telah disimpan)
            String fileUrl = responseEntity.getBody();

            // Set properti "file_usulan_kegiatan" dengan nilai fileUrl
            usulan.setFile_usulan_kegiatan(fileUrl);

            // Update data usulan dengan properti "file_usulan_kegiatan" yang telah terisi
            usulanRepository.save(usulan);

            // Tampilkan URL file docx yang telah disimpan
            return ResponseEntity.ok("Usulan berhasil disimpan. URL file docx: " + fileUrl);
        } else {
            // Jika ada properti yang kosong, tampilkan pesan sukses tanpa generate file
            return ResponseEntity.ok("Usulan berhasil disimpan.");
        }
    }

    // Method untuk mengecek apakah semua properti telah terisi
    private boolean isAllPropertiesFilled(Usulan usulan) {
        // Cek semua properti yang ingin dicek
        return !usulan.getPenutup().isEmpty();
    }
}