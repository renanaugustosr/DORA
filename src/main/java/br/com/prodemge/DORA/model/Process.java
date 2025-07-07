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
@Table(name = "processes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String number;
    private String type_id;
    private String status_id;
    private String created_by;
    private String created_at;
    private String updated_at;
}