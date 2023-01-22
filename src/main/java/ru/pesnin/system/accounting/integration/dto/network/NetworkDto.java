package ru.pesnin.system.accounting.integration.dto.network;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.services.entity.network.NetworkEntity;


import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
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


    private String defaultGeteway;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date dateReg;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date dateOld;

    private Integer idStatus;

    private String nameStatus;

    private Float statusNetwork;

    private String nameStatNetwork;


    public NetworkDto(NetworkEntity net, Float statusNetwork, String nameStatNetwork) {
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
        this.defaultGeteway = net.getDefaultGetAway();
        this.dateReg = net.getDateReg();
        this.dateOld = net.getDateOld();
        this.idStatus = net.getIsStatus().getIdStatus();
        this.nameStatus = net.getIsStatus().getNameStatus();
        this.statusNetwork = statusNetwork;
        this.nameStatNetwork = nameStatNetwork;
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
                ", networkMask='" + networkMask + '\'' +
                ", defaultGeteway='" + defaultGeteway + '\'' +
                ", dateReg=" + dateReg +
                ", dateOld=" + dateOld +
                ", idStatus=" + idStatus +
                ", nameStatus='" + nameStatus + '\'' +
                ", statusNetwork=" + statusNetwork +
                ", nameStatNetwork='" + nameStatNetwork + '\'' +
                '}';
    }
}

