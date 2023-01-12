package ru.pesnin.system.accounting.services.entity.network;

import lombok.Data;
import jakarta.persistence.*;
import ru.pesnin.system.accounting.services.entity.RefStatusDomain;

@Entity
@Data
@Table(schema = "network", name = "Vlan")
public class VlanDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_vlan;

    private String vlan_name;

    private String vlan_number;

    @ManyToOne
    @JoinColumn(name = "is_status",referencedColumnName ="id_status" )
    private RefStatusDomain is_status;


    public VlanDomain(){}

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

    public String getVlan_number() {
        return vlan_number;
    }

    public void setVlan_number(String vlan_number) {
        this.vlan_number = vlan_number;
    }

    public RefStatusDomain getIs_status() {
        return is_status;
    }

    public void setIs_status(RefStatusDomain is_status) {
        this.is_status = is_status;
    }

    public void setVlan(VlanDomain obj, RefStatusDomain statusDomain){
        this.vlan_name = obj.getVlan_name();
        this.vlan_number = obj.getVlan_number();
        this.is_status = statusDomain;
    }
}
