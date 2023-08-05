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

import com.example.demo.entity.Usulan;
import com.example.demo.repository.UsulanRepository; // Ganti dengan lokasi repository yang sesuai

@RestController
public class Generate {
    private final UsulanRepository usulanRepository;

    public Generate(UsulanRepository usulanRepository) {
        this.usulanRepository = usulanRepository;
    }

    @PostMapping("/generate_usulan")
    public String generateUsulanKegiatan(@RequestBody Usulan usulan) {
        // Cek apakah properti "file_usulan_kegiatan" sudah terisi atau masih kosong
        if (usulan.getFile_usulan_kegiatan() == null || usulan.getFile_usulan_kegiatan().isEmpty()) {
            // Jika masih kosong, maka tidak perlu melakukan generate
            System.out.println("Properti file_usulan_kegiatan masih kosong. Tidak perlu melakukan generate.");
            return null; // Atau Anda bisa mengembalikan respons lain sesuai kebutuhan Anda
        }

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

        // Simpan data usulan ke database
        usulanRepository.save(usulan);

        // Lakukan pengolahan selanjutnya atau tampilkan URL file docx yang telah
        // disimpan
        System.out.println("URL file docx: " + fileUrl);

        return fileUrl; // Anda dapat mengembalikan URL file docx sebagai respons dari endpoint ini
    }
}