package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;


import javax.persistence.NonUniqueResultException;

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
//tes
    public User updateUser(String id, User updatedUser) {
        User user = getUserById(id);
        //user.setId_user(updatedUser.getId_user());
        user.setOrmawa(updatedUser.getOrmawa());
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
        user.setRole(updatedUser.getRole());
        user.setUpdated_at(updatedUser.getUpdated_at());
        user.setUpdated_by(updatedUser.getUpdated_by());

        return userRepository.save(user);
    }

    // public void deleteUser(Long id) {
    // userRepository.deleteById(id);
    // }
    public boolean deleteUser(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public User getUserByNim(String nim) {
        try {
            return userRepository.findByNim(nim).stream().findFirst().orElse(null);
        } catch (NonUniqueResultException ex) {
            return null;
        }
    }

}
