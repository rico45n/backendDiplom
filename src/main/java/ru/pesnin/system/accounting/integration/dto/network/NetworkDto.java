package ru.pesnin.system.accounting.integration.dto.network;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.services.entity.network.NetworkEntity;


import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NetworkDto {

    private Integer idNetwork;

    private String poolAddress;

    private Integer idPoolAddress;

    private String userReg;

    private Integer idUserReg;

    private String userOld;

    private Integer idUserOld;

    private String vlan;

    private Integer idVlan;

    private String dhcpPool;

    private Integer idDhcpPool;

    private String ipAddressNetwork;

    private String networkMask;

    public String ipAndMask;

    public NetworkDto(NetworkEntity net) {
        this.idNetwork = net.getIdNetwork();
        this.poolAddress = net.getIdPoolAddress().getNamePool();
        this.idPoolAddress = net.getIdPoolAddress().getIdPoolAddress();
        this.userReg = net.getIdUserReg().getFioUser();
        this.userOld = net.getIdUserOld().getFioUser();
        this.idUserOld = net.getIdUserOld().getUserId();
        this.idUserReg = net.getIdUserReg().getUserId();
        this.vlan = net.getVlan();
        this.idVlan = net.getIdVlan().getIdVlan();
        this.dhcpPool = net.getDHCPPoolIpAddress();
        this.idDhcpPool = net.getIdDhcpPool().getIdDhcpPool();
        this.ipAddressNetwork = net.getIpAddressNetwork();
        this.networkMask = net.getNetworkMask();
    }

    @Override
    public String toString() {
        return "NetworkDto{" +
                "idNetwork=" + idNetwork +
                ", poolAddress='" + poolAddress + '\'' +
                ", idPoolAddress=" + idPoolAddress +
                ", userReg='" + userReg + '\'' +
                ", idUserReg=" + idUserReg +
                ", userOld='" + userOld + '\'' +
                ", idUserOld=" + idUserOld +
                ", vlan='" + vlan + '\'' +
                ", idVlan=" + idVlan +
                ", dhcpPool='" + dhcpPool + '\'' +
                ", idDhcpPool=" + idDhcpPool +
                ", ipAddressNetwork='" + ipAddressNetwork + '\'' +
                ", networkMask='" + networkMask;
    }
}

