package ru.pesnin.system.accounting.services.entity.devices;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(schema = "network", name = "type_device")
public class TypeDeviceDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_type_dev;


    private String name_type_dev;


    public TypeDeviceDomain(){}

    public Integer getId_type_dev() {
        return id_type_dev;
    }

    public void setId_type_dev(Integer id_type_dev) {
        this.id_type_dev = id_type_dev;
    }

    public String getName_type_dev() {
        return name_type_dev;
    }

    public void setName_type_dev(String name_type_dev) {
        this.name_type_dev = name_type_dev;
    }
}

