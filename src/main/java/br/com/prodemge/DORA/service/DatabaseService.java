package br.com.prodemge.DORA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getCurrentDatabaseTime() {
        return jdbcTemplate.queryForObject("SELECT NOW()", String.class);
    }
}
