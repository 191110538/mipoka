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

    @PutMapping("/laporan/{id}")
    public ResponseEntity<?> updateLaporanKegiatan(@PathVariable Long id, @RequestBody Laporan updatedLaporan) {
        // Cari data laporan berdasarkan ID
        Optional<Laporan> laporanOptional = laporanRepository.findById(id);

        if (laporanOptional.isPresent()) {
            Laporan laporan = laporanOptional.get();
            laporan.setRevisi_laporan(updatedLaporan.getRevisi_laporan());
            laporan.setUsulan(updatedLaporan.getUsulan());
            laporan.setPencapaian(updatedLaporan.getPencapaian());
            laporan.setPeserta_kegiatan_laporan(updatedLaporan.getPeserta_kegiatan_laporan());
            laporan.setRincian_biaya_kegiatan(updatedLaporan.getRincian_biaya_kegiatan());
            laporan.setTotal_usulan(updatedLaporan.getTotal_usulan());
            laporan.setTotal_realisasi(updatedLaporan.getTotal_realisasi());
            laporan.setTotal_selisih(updatedLaporan.getTotal_selisih());
            laporan.setLatar_belakang(updatedLaporan.getLatar_belakang());
            laporan.setHasil_kegiatan(updatedLaporan.getHasil_kegiatan());
            laporan.setPenutup(updatedLaporan.getPenutup());
            laporan.setFoto_postingan_kegiatan(updatedLaporan.getFoto_postingan_kegiatan());
            laporan.setFoto_dokumentasi_kegiatan(updatedLaporan.getFoto_dokumentasi_kegiatan());
            laporan.setFoto_tabulasi_hasil(updatedLaporan.getFoto_tabulasi_hasil());
            laporan.setFoto_faktur_pembayaran(updatedLaporan.getFoto_faktur_pembayaran());
            laporan.setFile_laporan_kegiatan(updatedLaporan.getFile_laporan_kegiatan());
            laporan.setValidasi_pembina(updatedLaporan.getValidasi_pembina());
            laporan.setStatus_laporan(updatedLaporan.getStatus_laporan());
            laporan.setCreated_at(updatedLaporan.getCreated_at());
            laporan.setCreated_by(updatedLaporan.getCreated_by());
            laporan.setUpdated_at(updatedLaporan.getUpdated_at());
            laporan.setUpdated_by(updatedLaporan.getUpdated_by());

            // Simpan data laporan yang telah diupdate ke database
            laporanRepository.save(laporan);

            // Check conditions for generating docx
            String fileUrl = null;
            if ("Disetujui".equals(updatedLaporan.getValidasi_pembina())
                    && "Tertunda".equals(updatedLaporan.getStatus_laporan())) {
                // Generate file docx and get the URL
                fileUrl = generateDocx(laporan);
            }

            if (fileUrl != null) {
                // Set property "file_laporan_kegiatan" with the fileUrl value
                laporan.setFile_laporan_kegiatan(fileUrl);

                // Update the laporan data with the filled property
                laporanRepository.save(laporan);

                // Display the URL of the saved docx file
                return ResponseEntity.ok("Laporan dengan ID " + id
                        + " berhasil diupdate dan file docx telah digenerate. URL file docx: " + fileUrl);
            } else {
                return ResponseEntity.ok("Laporan dengan ID " + id + " berhasil diupdate.");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Method untuk mengecek apakah semua properti telah terisi
    private boolean isAllPropertiesFilled(Laporan laporan) {
        // Cek semua properti yang ingin dicek
        return laporan.getUsulan() != null && !laporan.getPenutup().isEmpty();
        // Lanjutkan dengan properti-properti lain yang ingin Anda cek di sini
        // ...
    }

    private String generateDocx(Laporan laporan) {
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
        return responseEntity.getBody();
    }
}