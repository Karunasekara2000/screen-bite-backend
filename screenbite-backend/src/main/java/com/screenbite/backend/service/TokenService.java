package com.screenbite.backend.service;

import com.screenbite.backend.model.Token;

import java.util.List;

public interface TokenService {
    List<Token> findAllValidTokenByUser(int id);

    Token findByToken(String token);
}
