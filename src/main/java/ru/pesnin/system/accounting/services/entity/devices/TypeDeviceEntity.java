package ru.pesnin.system.accounting.services.entity.devices;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(schema = "network", name = "type_device")
@NoArgsConstructor
public class TypeDeviceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_dev")
    private Integer idTypeDev;
    @Column(name = "name_type_dev")
    private String nameTypeDev;

    @Override
    public String toString() {
        return "TypeDeviceEntity{" +
                "idTypeDev=" + idTypeDev +
                ", nameTypeDev='" + nameTypeDev + '\'' +
                '}';
    }
}

