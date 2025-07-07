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
@Table(name = "terms_acceptance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermAcceptance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String user_id;
    private String accepted_at;
    private String terms_version;
}