package ru.pesnin.system.accounting.integration.dto.devices;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class InfoCrossDeviceEndDTO implements Serializable {

    @Id
    private Integer id;

    private Integer id_devices;

    private String hostname;

    private String inventar_number;

    private String mac_address;

    private Integer user_id;

    private String fiouser;

    private Integer id_network_journal;

    private String ip_address;

    private Integer id_vlan;

    private String vlan_name;

    public InfoCrossDeviceEndDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_devices() {
        return id_devices;
    }

    public void setId_devices(Integer id_devices) {
        this.id_devices = id_devices;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getInventar_number() {
        return inventar_number;
    }

    public void setInventar_number(String inventar_number) {
        this.inventar_number = inventar_number;
    }

    public String getMac_address() {
        return mac_address;
    }

    public void setMac_address(String mac_address) {
        this.mac_address = mac_address;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getFiouser() {
        return fiouser;
    }

    public void setFiouser(String fiouser) {
        this.fiouser = fiouser;
    }

    public Integer getId_network_journal() {
        return id_network_journal;
    }

    public void setId_network_journal(Integer id_network_journal) {
        this.id_network_journal = id_network_journal;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public Integer getId_vlan() {
        return id_vlan;
    }

    public void setId_vlan(Integer id_vlan) {
        this.id_vlan = id_vlan;
    }

    public String getVlan_name() {
        return vlan_name;
    }

    public void setVlan_name(String vlan_name) {
        this.vlan_name = vlan_name;
    }

    @Override
    public String toString() {
        return "InfoCrossDeviceEndDTO{" +
                "id=" + id +
                ", id_devices=" + id_devices +
                ", hostname='" + hostname + '\'' +
                ", inventar_number='" + inventar_number + '\'' +
                ", mac_address='" + mac_address + '\'' +
                ", user_id=" + user_id +
                ", fiouser='" + fiouser + '\'' +
                ", id_network_journal=" + id_network_journal +
                ", ip_address='" + ip_address + '\'' +
                ", id_vlan=" + id_vlan +
                ", vlan_name='" + vlan_name + '\'' +
                '}';
    }
}
