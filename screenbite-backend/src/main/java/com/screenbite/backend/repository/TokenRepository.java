package com.screenbite.backend.repository;

import com.screenbite.backend.model.Token;

import java.util.List;

public interface TokenRepository  {


  List<Token> findAllValidTokenByUser(Integer id);
  Token findByToken(String token);
  Token save(Token token);
  List<Token> saveAll(List<Token> tokenList);
   void batchUpdateTokensAsRevoked(List<Token> tokens);
}
