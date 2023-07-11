package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // Method to save an admin
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Method to get an admin by ID
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    // Method to get all admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Method to delete an admin by ID
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}