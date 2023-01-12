package ru.pesnin.system.accounting.services.entity.devices;

import lombok.Data;
import jakarta.persistence.*;
@Entity
@Data
@Table(schema = "network", name = "PropsPort")
public class PropsPortDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_props_port;

    private Integer EthernetPort;

    private Integer OVPort;



    public PropsPortDomain( Integer EthernetPort, Integer OVPort) {
        this.EthernetPort = EthernetPort;
        this.OVPort = OVPort;
    }

    public PropsPortDomain() {
    }

    public Integer getId_props_port() {
        return id_props_port;
    }

    public void setId_props_port(Integer id_props_port) {
        this.id_props_port = id_props_port;
    }

    public Integer getEthernetPort() {
        return EthernetPort;
    }

    public void setEthernetPort(Integer ethernetPort) {
        EthernetPort = ethernetPort;
    }

    public Integer getOVPort() {
        return OVPort;
    }

    public void setOVPort(Integer OVPort) {
        this.OVPort = OVPort;
    }

}

