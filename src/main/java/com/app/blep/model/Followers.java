package com.app.blep.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
public class Followers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int followers_id;
    private int following_id;
    private Timestamp created_at;
}
