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
@Table(name = "opinion_revisions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OpinionRevision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String opinion_id;
    private String edited_by;
    private String content;
    private String created_at;
}