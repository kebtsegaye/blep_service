package com.app.blep.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //@Column(name = "username")
    private String username;
    private String email;
    // plain password right now
    private String passwordHash;
    private Timestamp created_at;
}
