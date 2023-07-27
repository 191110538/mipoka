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

@RestController
public class GenerateDocxController {
    @PostMapping("/generate-usulan-kegiatan")
    public String generateUsulanKegiatan(@RequestBody Usulan usulan) {
        // URL endpoint untuk request generate docx link usulan kegiatan
        String url = "http://localhost:3000/usulan-kegiatan"; // Ganti sesuai URL server Anda

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

        // Lakukan pengolahan selanjutnya atau tampilkan URL file docx yang telah
        // disimpan
        System.out.println("URL file docx: " + fileUrl);

        return fileUrl; // Anda dapat mengembalikan URL file docx sebagai respons dari endpoint ini
    }
}