package com.screenbite.backend.repository;

import com.screenbite.backend.model.User;

public interface UserRepository{

    User findById(int id);

    User findByEmail(String email);

    User save(User user);
}
