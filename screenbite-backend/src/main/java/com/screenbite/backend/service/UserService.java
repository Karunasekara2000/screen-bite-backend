package com.screenbite.backend.service;

import com.screenbite.backend.model.User;

public interface UserService {
    User findByEmail(String email);
}
