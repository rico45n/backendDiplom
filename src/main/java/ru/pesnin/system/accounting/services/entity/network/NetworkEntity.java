package ru.pesnin.system.accounting.services.entity.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.integration.dto.network.NetworkDto;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;

import java.util.Date;

@Entity
@Data
@Table(schema = "network", name = "Network")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class NetworkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_network")
    private Integer idNetwork;

    @ManyToOne
    @JoinColumn(name = "id_pool_address")
    private PoolAddressEntity idPoolAddress;

    @ManyToOne
    @JoinColumn(name = "id_user_reg",referencedColumnName = "user_id")
    private UsersEntity idUserReg;

    @ManyToOne
    @JoinColumn(name = "id_user_old",referencedColumnName = "user_id")
    private UsersEntity idUserOld;

    @ManyToOne
    @JoinColumn(name = "id_vlan")
    private VlanEntity idVlan;

    @ManyToOne
    @JoinColumn(name = "id_dhcp_pool", referencedColumnName = "id_dhcp_pool")
    private DhcpPoolEntity idDhcpPool;

    @Column(name = "ip_address_network")
    private String ipAddressNetwork;

    @Column(name = "network_mask")
    private String networkMask;





    public void setNewNetworkEntity(NetworkDto networkDto, PoolAddressEntity poolAddressEntity, UsersEntity userReg, UsersEntity userOld,
                                    VlanEntity vlanEntity, DhcpPoolEntity dhcpPoolEntity){
        this.idPoolAddress = poolAddressEntity;
        this.idUserReg = userReg;
        this.idUserOld = userOld;
        this.idVlan = vlanEntity;
        this.idDhcpPool = dhcpPoolEntity;
        try {
            String[] net = networkDto.getIpAddressNetwork().split("/");
            this.ipAddressNetwork = net[0];
            this.networkMask = net[1];
        }catch (Exception e){
            this.ipAddressNetwork = networkDto.getIpAddressNetwork();
            this.networkMask = networkDto.getNetworkMask();
        }

    }


    public String getPoolIpAddress (){
        try {
            return this.idPoolAddress.getIpAddresStart() + "-" + this.idPoolAddress.getIpAddresEnd();
        }
        catch (Exception e){
            return " ";
        }
    }

    public String getDHCPPoolIpAddress (){
        try {
            return this.idDhcpPool.getAddressStart()+"-" + this.idDhcpPool.getAddressEnd();
        }
        catch (Exception e){
            return " ";
        }
    }

    public String getVlan (){
        try {
            return "["+this.idVlan.getVlanNumber() +"] " + this.idVlan.getVlanName();
        }
        catch (Exception e){
            return " ";
        }
    }

    public String getNetworkInfo(){
        return this.ipAddressNetwork+"/"+this.networkMask;
    }


}
