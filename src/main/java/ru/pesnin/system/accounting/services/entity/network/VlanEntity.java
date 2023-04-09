package ru.pesnin.system.accounting.services.entity.network;

import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(schema = "network", name = "Vlan")
@NoArgsConstructor
public class VlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vlan")
    private Integer idVlan;
    @Column(name = "vlan_name")
    private String vlanName;
    @Column(name = "vlan_number")
    private String vlanNumber;




    public void setVlan(VlanEntity obj){
        this.vlanName = obj.getVlanName();
        this.vlanNumber = obj.getVlanNumber();
    }

    @Override
    public String toString() {
        return "VlanEntity{" +
                "idVlan=" + idVlan +
                ", vlanName='" + vlanName + '\'' +
                ", vlanNumber='" + vlanNumber + '\'' +
                ", isStatus=" +
                '}';
    }
}
