package ru.pesnin.system.accounting.services.entity.network;

import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.services.entity.RefStatusEntity;

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

    @ManyToOne
    @JoinColumn(name = "is_status",referencedColumnName ="id_status" )
    private RefStatusEntity isStatus;



    public void setVlan(VlanEntity obj, RefStatusEntity statusEntity){
        this.vlanName = obj.getVlanName();
        this.vlanNumber = obj.getVlanNumber();
        this.isStatus = statusEntity;
    }

    @Override
    public String toString() {
        return "VlanEntity{" +
                "idVlan=" + idVlan +
                ", vlanName='" + vlanName + '\'' +
                ", vlanNumber='" + vlanNumber + '\'' +
                ", isStatus=" + isStatus +
                '}';
    }
}
