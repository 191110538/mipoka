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
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
                    String.class);

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

    private String generateDocx(Usulan usulan) {
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
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
                String.class);

        // Mendapatkan response dari server (berupa URL file docx yang telah disimpan)
        return responseEntity.getBody();
    }

    @PutMapping("/usulan/{id}")
    public ResponseEntity<?> updateUsulanKegiatan(@PathVariable Long id, @RequestBody Usulan updatedUsulan) {
        // Cari data usulan berdasarkan ID
        Optional<Usulan> usulanOptional = usulanRepository.findById(id);

        if (usulanOptional.isPresent()) {
            Usulan usulan = usulanOptional.get();
            // Update data usulan dengan data dari updatedUsulan
            usulan.setUser(updatedUsulan.getUser());
            usulan.setOrmawa(updatedUsulan.getOrmawa());
            usulan.setRevisi_usulan(updatedUsulan.getRevisi_usulan());
            usulan.setPembiayaan(updatedUsulan.getPembiayaan());
            usulan.setNama_kegiatan(updatedUsulan.getNama_kegiatan());
            usulan.setBentuk_kegiatan(updatedUsulan.getBentuk_kegiatan());
            usulan.setKategori_bentuk_kegiatan(updatedUsulan.getKategori_bentuk_kegiatan());
            usulan.setDeskripsi_kegiatan(updatedUsulan.getDeskripsi_kegiatan());
            usulan.setTanggal_mulai_kegiatan(updatedUsulan.getTanggal_mulai_kegiatan());
            usulan.setTanggal_selesai_kegiatan(updatedUsulan.getTanggal_selesai_kegiatan());
            usulan.setWaktu_mulai_kegiatan(updatedUsulan.getWaktu_mulai_kegiatan());
            usulan.setWaktu_selesai_kegiatan(updatedUsulan.getWaktu_selesai_kegiatan());
            usulan.setTempat_kegiatan(updatedUsulan.getTempat_kegiatan());
            usulan.setTanggal_keberangkatan(updatedUsulan.getTanggal_keberangkatan());
            usulan.setTanggal_kepulangan(updatedUsulan.getTanggal_kepulangan());
            usulan.setJumlah_partisipan(updatedUsulan.getJumlah_partisipan());
            usulan.setKategori_jumlah_partisipan(updatedUsulan.getKategori_jumlah_partisipan());
            usulan.setTarget_kegiatan(updatedUsulan.getTarget_kegiatan());
            usulan.setTotal_pendanaan(updatedUsulan.getTotal_pendanaan());
            usulan.setKategori_total_pendanaan(updatedUsulan.getKategori_total_pendanaan());
            usulan.setKeterangan(updatedUsulan.getKeterangan());
            usulan.setTanda_tangan_ormawa(updatedUsulan.getTanda_tangan_ormawa());
            usulan.setPartisipan(updatedUsulan.getPartisipan());
            usulan.setBiaya_kegiatan(updatedUsulan.getBiaya_kegiatan());
            usulan.setLatar_belakang(updatedUsulan.getLatar_belakang());
            usulan.setTujuan_kegiatan(updatedUsulan.getTujuan_kegiatan());
            usulan.setManfaat_kegiatan(updatedUsulan.getManfaat_kegiatan());
            usulan.setBentuk_pelaksanaan_kegiatan(updatedUsulan.getBentuk_pelaksanaan_kegiatan());
            usulan.setTarget_pencapaian_kegiatan(updatedUsulan.getTarget_pencapaian_kegiatan());
            usulan.setWaktu_dan_tempat_pelaksanaan(updatedUsulan.getWaktu_dan_tempat_pelaksanaan());
            usulan.setRencana_anggaran_kegiatan(updatedUsulan.getRencana_anggaran_kegiatan());
            usulan.setTotal_biaya(updatedUsulan.getTotal_biaya());
            usulan.setTertib_acara(updatedUsulan.getTertib_acara());
            usulan.setPerlengkapan_dan_peralatan(updatedUsulan.getPerlengkapan_dan_peralatan());
            usulan.setPenutup(updatedUsulan.getPenutup());
            usulan.setFoto_postingan_kegiatan(updatedUsulan.getFoto_postingan_kegiatan());
            usulan.setFoto_surat_undangan_kegiatan(updatedUsulan.getFoto_surat_undangan_kegiatan());
            usulan.setFoto_linimasa_kegiatan(updatedUsulan.getFoto_linimasa_kegiatan());
            usulan.setFoto_tempat_kegiatan(updatedUsulan.getFoto_tempat_kegiatan());
            usulan.setFile_usulan_kegiatan(updatedUsulan.getFile_usulan_kegiatan());
            usulan.setValidasi_pembina(updatedUsulan.getValidasi_pembina());
            usulan.setTanda_tangan_pembina(updatedUsulan.getTanda_tangan_pembina());
            usulan.setStatus_usulan(updatedUsulan.getStatus_usulan());
            usulan.setRoles(updatedUsulan.getRoles());
            usulan.setCreated_at(updatedUsulan.getCreated_at());
            usulan.setUpdated_at(updatedUsulan.getUpdated_at());
            usulan.setCreated_by(updatedUsulan.getCreated_by());
            usulan.setUpdated_by(updatedUsulan.getUpdated_by());
            // Lanjutkan dengan mengupdate properti lain sesuai kebutuhan

            // Simpan data usulan yang telah diupdate ke database
            usulanRepository.save(usulan);

            // Check conditions for generating the docx file
            String fileUrl = null;
            if ("Disetujui".equals(updatedUsulan.getValidasi_pembina())
                    && "Tertunda".equals(updatedUsulan.getStatus_usulan())) {
                // Generate docx file and get the URL
                fileUrl = generateDocx(usulan);
            }

            if (fileUrl != null) {
                // Set property "file_usulan_kegiatan" with the fileUrl value
                usulan.setFile_usulan_kegiatan(fileUrl);

                // Update the usulan data with the filled property
                usulanRepository.save(usulan);

                // Display the URL of the saved docx file
                return ResponseEntity.ok("Usulan dengan ID " + id
                        + " berhasil diupdate dan file docx telah digenerate. URL file docx: " + fileUrl);
            } else {
                return ResponseEntity.ok("Usulan dengan ID " + id + " berhasil diupdate.");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}