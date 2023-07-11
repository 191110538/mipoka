package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Endpoint untuk menyimpan data admin baru
     @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = adminService.saveAdmin(admin);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }
    // Endpoint untuk mendapatkan data admin berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Jika diperlukan, Anda bisa menambahkan endpoint lain untuk keperluan bisnis logika lainnya
    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> adminList = adminService.getAllAdmins();
        return new ResponseEntity<>(adminList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin updatedAdmin) {
        Admin admin = adminService.getAdminById(id);
        if (admin != null) {
            admin.setEmail(updatedAdmin.getEmail());
            admin.setNama_lengkap(updatedAdmin.getNama_lengkap());
            admin.setNip(updatedAdmin.getNip());
            admin.setImage(updatedAdmin.getImage());
            admin.setNo_hp(updatedAdmin.getNo_hp());
            admin.setRole(updatedAdmin.getRole());
            admin.setCreated_at(updatedAdmin.getCreated_at());
            admin.setCreated_by(updatedAdmin.getCreated_by());
            admin.setUpdated_at(updatedAdmin.getUpdated_at());
            admin.setUpdated_by(updatedAdmin.getUpdated_by());

            Admin updatedAdminEntity = adminService.saveAdmin(admin);
            return ResponseEntity.ok(updatedAdminEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        if (admin != null) {
            adminService.deleteAdmin(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
