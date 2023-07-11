package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String id, User updatedUser) {
        User user = getUserById(id);
        user.setEmail(updatedUser.getEmail());
        user.setNama_lengkap(updatedUser.getNama_lengkap());
        user.setNim(updatedUser.getNim());
        user.setNo_hp(updatedUser.getNo_hp());
        user.setImage(updatedUser.getImage());
        user.setPoint_mpt(updatedUser.getPoint_mpt());
        user.setSemester(updatedUser.getSemester());
        user.setKelas(updatedUser.getKelas());
        user.setPeriode_mpt(updatedUser.getPeriode_mpt());
        user.setStatus_mpt(updatedUser.getStatus_mpt());
        user.setProdi(updatedUser.getProdi());
        user.setUpdated_at(updatedUser.getUpdated_at());
        user.setUpdated_by(updatedUser.getUpdated_by());

        return userRepository.save(user);
    }

    // public void deleteUser(Long id) {
    //     userRepository.deleteById(id);
    // }
    public boolean deleteUser(String id) {
    if (userRepository.existsById(id)) {
        userRepository.deleteById(id);
        return true;
    } else {
        return false;
    }
}

    
}
