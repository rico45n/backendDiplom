package ru.pesnin.system.accounting.services.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(schema = "network", name = "ref_status")
public class RefStatusDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_status;


    private String name_status;

    public RefStatusDomain() {
    }

    public Integer getId_status() {
        return id_status;
    }

    public void setId_status(Integer id_status) {
        this.id_status = id_status;
    }

    public String getName_status() {
        return name_status;
    }

    public void setName_status(String name_status) {
        this.name_status = name_status;
    }
}
