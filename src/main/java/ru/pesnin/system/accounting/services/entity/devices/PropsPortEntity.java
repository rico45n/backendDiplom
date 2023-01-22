package ru.pesnin.system.accounting.services.entity.devices;

import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(schema = "network", name = "PropsPort")
@NoArgsConstructor
public class PropsPortEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_props_port")
    private Integer idPropsPort;
    @Column(name = "ethernet_port")
    private Integer EthernetPort;
    @Column(name = "ovport")
    private Integer OVPort;



    public PropsPortEntity(Integer EthernetPort, Integer OVPort) {
        this.EthernetPort = EthernetPort;
        this.OVPort = OVPort;
    }

    @Override
    public String toString() {
        return "PropsPortEntity{" +
                "idPropsPort=" + idPropsPort +
                ", EthernetPort=" + EthernetPort +
                ", OVPort=" + OVPort +
                '}';
    }
}

