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
    public ResponseEntity<?> updateUsulanKegiatan(@PathVariable Long id, @RequestBody Usulan usulanData) {
        // Cari data usulan berdasarkan ID
        Optional<Usulan> usulanOptional = usulanRepository.findById(id);

        if (usulanOptional.isPresent()) {
            Usulan usulan = usulanOptional.get();

            // Update data usulan dengan data dari updatedUsulan
            usulan.setUser(usulanData.getUser());
            usulan.setOrmawa(usulanData.getOrmawa());
            usulan.setRevisi_usulan(usulanData.getRevisi_usulan());
            usulan.setPembiayaan(usulanData.getPembiayaan());
            usulan.setNama_kegiatan(usulanData.getNama_kegiatan());
            usulan.setBentuk_kegiatan(usulanData.getBentuk_kegiatan());
            usulan.setKategori_bentuk_kegiatan(usulanData.getKategori_bentuk_kegiatan());
            usulan.setDeskripsi_kegiatan(usulanData.getDeskripsi_kegiatan());
            usulan.setTanggal_mulai_kegiatan(usulanData.getTanggal_mulai_kegiatan());
            usulan.setTanggal_selesai_kegiatan(usulanData.getTanggal_selesai_kegiatan());
            usulan.setWaktu_mulai_kegiatan(usulanData.getWaktu_mulai_kegiatan());
            usulan.setWaktu_selesai_kegiatan(usulanData.getWaktu_selesai_kegiatan());
            usulan.setTempat_kegiatan(usulanData.getTempat_kegiatan());
            usulan.setTanggal_keberangkatan(usulanData.getTanggal_keberangkatan());
            usulan.setTanggal_kepulangan(usulanData.getTanggal_kepulangan());
            usulan.setJumlah_partisipan(usulanData.getJumlah_partisipan());
            usulan.setKategori_jumlah_partisipan(usulanData.getKategori_jumlah_partisipan());
            usulan.setTarget_kegiatan(usulanData.getTarget_kegiatan());
            usulan.setTotal_pendanaan(usulanData.getTotal_pendanaan());
            usulan.setKategori_total_pendanaan(usulanData.getKategori_total_pendanaan());
            usulan.setKeterangan(usulanData.getKeterangan());
            usulan.setTanda_tangan_ormawa(usulanData.getTanda_tangan_ormawa());
            usulan.setPartisipan(usulanData.getPartisipan());
            usulan.setBiaya_kegiatan(usulanData.getBiaya_kegiatan());
            usulan.setLatar_belakang(usulanData.getLatar_belakang());
            usulan.setTujuan_kegiatan(usulanData.getTujuan_kegiatan());
            usulan.setManfaat_kegiatan(usulanData.getManfaat_kegiatan());
            usulan.setBentuk_pelaksanaan_kegiatan(usulanData.getBentuk_pelaksanaan_kegiatan());
            usulan.setTarget_pencapaian_kegiatan(usulanData.getTarget_pencapaian_kegiatan());
            usulan.setWaktu_dan_tempat_pelaksanaan(usulanData.getWaktu_dan_tempat_pelaksanaan());
            usulan.setRencana_anggaran_kegiatan(usulanData.getRencana_anggaran_kegiatan());
            usulan.setTotal_biaya(usulanData.getTotal_biaya());
            usulan.setTertib_acara(usulanData.getTertib_acara());
            usulan.setPerlengkapan_dan_peralatan(usulanData.getPerlengkapan_dan_peralatan());
            usulan.setPenutup(usulanData.getPenutup());
            usulan.setFoto_postingan_kegiatan(usulanData.getFoto_postingan_kegiatan());
            usulan.setFoto_surat_undangan_kegiatan(usulanData.getFoto_surat_undangan_kegiatan());
            usulan.setFoto_linimasa_kegiatan(usulanData.getFoto_linimasa_kegiatan());
            usulan.setFoto_tempat_kegiatan(usulanData.getFoto_tempat_kegiatan());
            usulan.setFile_usulan_kegiatan(usulanData.getFile_usulan_kegiatan());
            usulan.setValidasi_pembina(usulanData.getValidasi_pembina());
            usulan.setTanda_tangan_pembina(usulanData.getTanda_tangan_pembina());
            usulan.setStatus_usulan(usulanData.getStatus_usulan());
            usulan.setRoles(usulanData.getRoles());
            usulan.setCreated_at(usulanData.getCreated_at());
            usulan.setUpdated_at(usulanData.getUpdated_at());
            usulan.setCreated_by(usulanData.getCreated_by());
            usulan.setUpdated_by(usulanData.getUpdated_by());
            // Lanjutkan dengan mengupdate properti lain sesuai kebutuhan

            // Simpan data usulan yang telah diupdate ke database
            usulanRepository.save(usulan);

            // Jika semua properti telah terisi, baru jalankan generate dan POST ke server
            if (isAllPropertiesFilled(usulan)) {
                // Generate file docx dan dapatkan URL file docx
                String fileUrl = generateDocx(usulan);

                // Set properti "file_usulan_kegiatan" dengan nilai fileUrl
                usulan.setFile_usulan_kegiatan(fileUrl);

                // Update kembali data usulan dengan properti "file_usulan_kegiatan" yang telah
                // terisi
                usulanRepository.save(usulan);

                // Tampilkan URL file docx yang telah disimpan
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