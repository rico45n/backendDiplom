package ru.pesnin.system.accounting.integration.dto.network;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.pesnin.system.accounting.services.entity.network.NetworkDomain;


import java.util.Date;

public class NetworkDTO {

    private Integer id_network;

    private String pool_address;
    private Integer id_pool_address;

    private String user_reg;
    private Integer id_user_reg;

    private String user_old;
    private Integer id_user_old;

    private String vlan;
    private Integer id_vlan;

    private String dhcp_pool;
    private Integer id_dhcp_pool;

    private String ip_address_network;

    private String networkMask;


    private String defaultGeteway;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date date_reg;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date date_old;

    private Integer id_status;
    private String name_status;

    private Float status_network;
    private String name_stat_network;

    public NetworkDTO() {
    }

    public NetworkDTO(NetworkDomain net, Float status_network, String name_stat_network) {
        this.id_network = net.getId_network();
        this.pool_address = net.getId_pool_address().getName_pool();
        this.id_pool_address = net.getId_pool_address().getId_pool_address();
        this.user_reg = net.getId_user_reg().getFioUser();
        this.user_old = net.getId_user_old().getFioUser();
        this.id_user_old = net.getId_user_old().getUser_id();
        this.id_user_reg = net.getId_user_reg().getUser_id();
        this.vlan = net.getVlan();
        this.id_vlan = net.getId_vlan().getId_vlan();
        this.dhcp_pool = net.getDHCPPoolIpAddress();
        this.id_dhcp_pool = net.getId_DHCP_pool().getId_DHCP_pool();
        this.ip_address_network = net.getIp_address_network();
        this.networkMask = net.getNetworkMask();
        this.defaultGeteway = net.getDefaultGeteway();
        this.date_reg = net.getDate_reg();
        this.date_old = net.getDate_old();
        this.id_status = net.getIs_status().getId_status();
        this.name_status = net.getIs_status().getName_status();
        this.status_network = status_network;
        this.name_stat_network = name_stat_network;
    }

    public Integer getId_network() {
        return id_network;
    }

    public void setId_network(Integer id_network) {
        this.id_network = id_network;
    }

    public String getPool_address() {
        return pool_address;
    }

    public void setPool_address(String pool_address) {
        this.pool_address = pool_address;
    }

    public Integer getId_pool_address() {
        return id_pool_address;
    }

    public void setId_pool_address(Integer id_pool_address) {
        this.id_pool_address = id_pool_address;
    }

    public String getUser_reg() {
        return user_reg;
    }

    public void setUser_reg(String user_reg) {
        this.user_reg = user_reg;
    }

    public Integer getId_user_reg() {
        return id_user_reg;
    }

    public void setId_user_reg(Integer id_user_reg) {
        this.id_user_reg = id_user_reg;
    }

    public String getUser_old() {
        return user_old;
    }

    public void setUser_old(String user_old) {
        this.user_old = user_old;
    }

    public Integer getId_user_old() {
        return id_user_old;
    }

    public void setId_user_old(Integer id_user_old) {
        this.id_user_old = id_user_old;
    }

    public String getVlan() {
        return vlan;
    }

    public void setVlan(String vlan) {
        this.vlan = vlan;
    }

    public Integer getId_vlan() {
        return id_vlan;
    }

    public void setId_vlan(Integer id_vlan) {
        this.id_vlan = id_vlan;
    }

    public String getDhcp_pool() {
        return dhcp_pool;
    }

    public void setDhcp_pool(String dhcp_pool) {
        this.dhcp_pool = dhcp_pool;
    }

    public Integer getId_dhcp_pool() {
        return id_dhcp_pool;
    }

    public void setId_dhcp_pool(Integer id_dhcp_pool) {
        this.id_dhcp_pool = id_dhcp_pool;
    }

    public String getIp_address_network() {
        return ip_address_network;
    }

    public void setIp_address_network(String ip_address_network) {
        this.ip_address_network = ip_address_network;
    }

    public String getNetworkMask() {
        return networkMask;
    }

    public void setNetworkMask(String networkMask) {
        this.networkMask = networkMask;
    }

    public String getDefaultGeteway() {
        return defaultGeteway;
    }

    public void setDefaultGeteway(String defaultGeteway) {
        this.defaultGeteway = defaultGeteway;
    }

    public Date getDate_reg() {
        return date_reg;
    }

    public void setDate_reg(Date date_reg) {
        this.date_reg = date_reg;
    }

    public Date getDate_old() {
        return date_old;
    }

    public void setDate_old(Date date_old) {
        this.date_old = date_old;
    }

    public Integer getId_status() {
        return id_status;
    }

    public void setId_status(Integer id_status) {
        this.id_status = id_status;
    }

    public String getName_status() {
        return name_status;
    }

    public void setName_status(String name_status) {
        this.name_status = name_status;
    }

    public Float getStatus_network() {
        return status_network;
    }

    public void setStatus_network(Float status_network) {
        this.status_network = status_network;
    }

    public String getName_stat_network() {
        return name_stat_network;
    }

    public void setName_stat_network(String name_stat_network) {
        this.name_stat_network = name_stat_network;
    }

    @Override
    public String toString() {
        return "NetworkDTO{" +
                "id_network=" + id_network +
                ", pool_address='" + pool_address + '\'' +
                ", id_pool_address=" + id_pool_address +
                ", user_reg='" + user_reg + '\'' +
                ", id_user_reg=" + id_user_reg +
                ", user_old='" + user_old + '\'' +
                ", id_user_old=" + id_user_old +
                ", vlan='" + vlan + '\'' +
                ", id_vlan=" + id_vlan +
                ", dhcp_pool='" + dhcp_pool + '\'' +
                ", id_dhcp_pool=" + id_dhcp_pool +
                ", ip_address_network='" + ip_address_network + '\'' +
                ", networkMask='" + networkMask + '\'' +
                ", defaultGeteway='" + defaultGeteway + '\'' +
                ", date_reg=" + date_reg +
                ", date_old=" + date_old +
                ", id_status=" + id_status +
                ", name_status='" + name_status + '\'' +
                ", status_network=" + status_network +
                ", name_stat_network='" + name_stat_network + '\'' +
                '}';
    }
}

