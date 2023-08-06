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

import com.example.demo.entity.Laporan;
import com.example.demo.repository.LaporanRepository;
//tes
@RestController
public class GenerateLaporan {
    private final LaporanRepository laporanRepository;

    public GenerateLaporan(LaporanRepository laporanRepository) {
        this.laporanRepository = laporanRepository;
    }

    @PostMapping("/laporan")
    public ResponseEntity<?> generateLaporanKegiatan(@RequestBody Laporan laporan) {
        // Simpan data laporan ke database
        laporanRepository.save(laporan);

        // Jika semua properti telah terisi, baru jalankan generate dan POST ke server
        if (isAllPropertiesFilled(laporan)) {
            // URL endpoint untuk request generate docx link laporan kegiatan
            String url = "https://generate-mbogddtpiq-et.a.run.app/laporan"; // Ganti sesuai URL server Anda

            // Membuat headers untuk request
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // Membuat entity untuk request dengan data laporan kegiatan
            HttpEntity<Laporan> requestEntity = new HttpEntity<>(laporan, headers);

            // Membuat RestTemplate
            RestTemplate restTemplate = new RestTemplate();

            // Melakukan request POST ke endpoint '/laporan-kegiatan' di server
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
                    String.class);

            // Mendapatkan response dari server (berupa URL file docx yang telah disimpan)
            String fileUrl = responseEntity.getBody();

            // Set properti "file_laporan_kegiatan" dengan nilai fileUrl
            laporan.setFile_laporan_kegiatan(fileUrl);

            // Update data laporan dengan properti "file_laporan_kegiatan" yang telah terisi
            laporanRepository.save(laporan);

            // Tampilkan URL file docx yang telah disimpan
            return ResponseEntity.ok("Laporan berhasil disimpan. URL file docx: " + fileUrl);
        } else {
            // Jika ada properti yang kosong, tampilkan pesan sukses tanpa generate file
            return ResponseEntity.ok("Laporan berhasil disimpan.");
        }
    }

    // Method untuk mengecek apakah semua properti telah terisi
    private boolean isAllPropertiesFilled(Laporan laporan) {
        // Cek semua properti yang ingin dicek
        return laporan.getUsulan()!= null && !laporan.getPenutup().isEmpty();
        // Lanjutkan dengan properti-properti lain yang ingin Anda cek di sini
        // ...
    }
}