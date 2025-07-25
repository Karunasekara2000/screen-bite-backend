package com.screenbite.backend.model.mapper;

import com.screenbite.backend.model.Token;
import com.screenbite.backend.model.User;
import com.screenbite.backend.model.enumeration.Role;
import com.screenbite.backend.model.enumeration.TokenType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TokenMapper implements RowMapper<Token> {

    @Override
    public Token mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setRole(Role.valueOf(rs.getString("role")));

        return Token.builder()
                .id(rs.getInt("id"))
                .token(rs.getString("token"))
                .tokenType(TokenType.valueOf(rs.getString("token_type")))
                .revoked(rs.getBoolean("revoked"))
                .expired(rs.getBoolean("expired"))
                .user(user)
                .build();
    }
}
