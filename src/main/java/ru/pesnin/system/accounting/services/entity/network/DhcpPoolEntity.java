package ru.pesnin.system.accounting.services.entity.network;

import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(schema = "network", name = "DHCP_pool")
@NoArgsConstructor
public class DhcpPoolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dhcp_pool")
    private Integer idDhcpPool;

    @Column(name = "address_start")
    private String addressStart;

    @Column(name = "address_end")
    private String addressEnd;




    public String getPoolIP(){
        return this.addressStart+"-"+this.addressEnd ;
    }

    @Override
    public String toString() {
        return "DhcpPoolEntity{" +
                "idDhcpPool=" + idDhcpPool +
                ", addressStart='" + addressStart + '\'' +
                ", addressEnd='" + addressEnd + '\'' +
                ", isStatus=" +
                '}';
    }
}
