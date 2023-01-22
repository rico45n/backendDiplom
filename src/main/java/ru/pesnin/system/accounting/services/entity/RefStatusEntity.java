package ru.pesnin.system.accounting.services.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(schema = "network", name = "ref_status")
@NoArgsConstructor
public class RefStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private Integer idStatus;

    @Column(name ="name_status")
    private String nameStatus;


    @Override
    public String toString() {
        return "RefStatusEntity{" +
                "id_status=" + idStatus +
                ", nameStatus='" + nameStatus + '\'' +
                '}';
    }
}
