package com.app.blep.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@Data
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int comment_id;
    @NotNull
    private int post_id;
    @NotNull
    private int user_id;
    @NotNull
    private String content;
    private Timestamp created_at;

}
