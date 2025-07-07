package br.com.prodemge.DORA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "opinions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String process_id;
    private String author_id;
    private String content;
    private String created_at;
    private String status;
}