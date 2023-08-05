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
        return usulan.getNama_kegiatan() != null && !usulan.getNama_kegiatan().isEmpty()
        && usulan.getDeskripsi_kegiatan() != null && !usulan.getDeskripsi_kegiatan().isEmpty()
        && usulan.getTanggal_mulai_kegiatan() != null && !usulan.getTanggal_mulai_kegiatan().isEmpty()
        && usulan.getTanggal_selesai_kegiatan() != null && !usulan.getTanggal_selesai_kegiatan().isEmpty()
        && usulan.getWaktu_mulai_kegiatan() != null && !usulan.getWaktu_mulai_kegiatan().isEmpty()
        && usulan.getWaktu_selesai_kegiatan() != null && !usulan.getWaktu_selesai_kegiatan().isEmpty()
        && usulan.getTempat_kegiatan() != null && !usulan.getTempat_kegiatan().isEmpty()
        && usulan.getTanggal_keberangkatan() != null && !usulan.getTanggal_keberangkatan().isEmpty()
        && usulan.getTanggal_kepulangan() != null && !usulan.getTanggal_kepulangan().isEmpty()
        && usulan.getJumlah_partisipan() != null && !usulan.getJumlah_partisipan().isEmpty()
        && usulan.getKategori_jumlah_partisipan() != null && !usulan.getKategori_jumlah_partisipan().isEmpty()
        && usulan.getTarget_kegiatan() != null && !usulan.getTarget_kegiatan().isEmpty()
        && usulan.getTotal_pendanaan() != null && !usulan.getTotal_pendanaan().isEmpty()
        && usulan.getKategori_total_pendanaan() != null && !usulan.getKategori_total_pendanaan().isEmpty()
        && usulan.getKeterangan() != null && !usulan.getKeterangan().isEmpty()
        && usulan.getTanda_tangan_ormawa() != null && !usulan.getTanda_tangan_ormawa().isEmpty()
        && usulan.getLatar_belakang() != null && !usulan.getLatar_belakang().isEmpty()
        && usulan.getTujuan_kegiatan() != null && !usulan.getTujuan_kegiatan().isEmpty()
        && usulan.getManfaat_kegiatan() != null && !usulan.getManfaat_kegiatan().isEmpty()
        && usulan.getBentuk_pelaksanaan_kegiatan() != null && !usulan.getBentuk_pelaksanaan_kegiatan().isEmpty()
        && usulan.getTarget_pencapaian_kegiatan() != null && !usulan.getTarget_pencapaian_kegiatan().isEmpty()
        && usulan.getWaktu_dan_tempat_pelaksanaan() != null && !usulan.getWaktu_dan_tempat_pelaksanaan().isEmpty()
        && usulan.getRencana_anggaran_kegiatan() != null && !usulan.getRencana_anggaran_kegiatan().isEmpty()
        && usulan.getPerlengkapan_dan_peralatan() != null && !usulan.getPerlengkapan_dan_peralatan().isEmpty()
        && usulan.getPenutup() != null && !usulan.getPenutup().isEmpty();
    }
}