package ru.pesnin.system.accounting.services.entity.network;

import lombok.Data;
import jakarta.persistence.*;
import ru.pesnin.system.accounting.services.entity.RefStatusDomain;


@Entity
@Data
@Table(schema = "network", name = "DHCP_pool")
public class Dhcp_poolDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_DHCP_pool;


    private String address_start;

    @Column(name = "address_end")

    private String address_end;

    @ManyToOne
    @JoinColumn(name = "is_status",referencedColumnName ="id_status" )
    private RefStatusDomain is_status;

    public Dhcp_poolDomain(){}

    public Integer getId_DHCP_pool() {
        return id_DHCP_pool;
    }

    public void setId_DHCP_pool(Integer id_DHCP_pool) {
        this.id_DHCP_pool = id_DHCP_pool;
    }

    public String getAddress_start() {
        return address_start;
    }

    public void setAddress_start(String address_start) {
        this.address_start = address_start;
    }

    public String getAddress_end() {
        return address_end;
    }

    public void setAddress_end(String address_end) {
        this.address_end = address_end;
    }

    public RefStatusDomain getIs_status() {
        return is_status;
    }

    public void setIs_status(RefStatusDomain is_status) {
        this.is_status = is_status;
    }

    public String getPoolIP(){
        return this.address_start+"-"+this.address_end ;
    }
}
