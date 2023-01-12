package ru.pesnin.system.accounting.services.entity.network;

import lombok.Data;
import jakarta.persistence.*;
import ru.pesnin.system.accounting.integration.dto.network.NetworkDTO;
import ru.pesnin.system.accounting.services.entity.RefStatusDomain;
import ru.pesnin.system.accounting.services.entity.user.UsersDomain;

import java.util.Date;

@Entity
@Data
@Table(schema = "network", name = "Network")
public class NetworkDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_network;

    @ManyToOne
    @JoinColumn(name = "id_pool_address")
    private Pool_address_Domain id_pool_address;

    @ManyToOne
    @JoinColumn(name = "id_user_reg",referencedColumnName = "user_id")
    private UsersDomain id_user_reg;

    @ManyToOne
    @JoinColumn(name = "id_user_old",referencedColumnName = "user_id")
    private UsersDomain id_user_old;

    @ManyToOne
    @JoinColumn(name = "id_vlan")
    private VlanDomain id_vlan;

    @ManyToOne
    @JoinColumn(name = "id_DHCP_pool", referencedColumnName = "id_DHCP_pool")
    private Dhcp_poolDomain id_DHCP_pool;

    @Column(name = "ip_address_network")
    private String ip_address_network;

    @Column(name = "network_mask")
    private String networkMask;

    private String defaultGeteway;

    private Date date_reg;

    private Date date_old;

    @ManyToOne
    @JoinColumn(name = "is_status",referencedColumnName ="id_status" )
    private RefStatusDomain is_status;

    public NetworkDomain() {
    }

    public void setNewNetworkDomain(NetworkDTO networkDTO, Pool_address_Domain pool_address_domain, UsersDomain user_reg, UsersDomain user_old,
                                    VlanDomain vlanDomain, Dhcp_poolDomain dhcp_poolDomain, RefStatusDomain refStatusDomain){
        this.id_pool_address = pool_address_domain;
        this.id_user_reg = user_reg;
        this.id_user_old = user_old;
        this.id_vlan = vlanDomain;
        this.id_DHCP_pool = dhcp_poolDomain;
        try {
            String[] net = networkDTO.getIp_address_network().split("/");
            this.ip_address_network = net[0];
            this.networkMask = net[1];
        }catch (Exception e){
            this.ip_address_network = networkDTO.getIp_address_network();
            this.networkMask = networkDTO.getNetworkMask();
        }
        this.defaultGeteway = networkDTO.getDefaultGeteway();
        this.date_reg = new Date();
        this.date_old = null;
        this.is_status = refStatusDomain;
    }


    public Integer getId_network() {
        return id_network;
    }

    public void setId_network(Integer id_network) {
        this.id_network = id_network;
    }

    public Pool_address_Domain getId_pool_address() {
        return id_pool_address;
    }

    public void setId_pool_address(Pool_address_Domain id_pool_address) {
        this.id_pool_address = id_pool_address;
    }

    public UsersDomain getId_user_reg() {
        return id_user_reg;
    }

    public void setId_user_reg(UsersDomain id_user_reg) {
        this.id_user_reg = id_user_reg;
    }

    public UsersDomain getId_user_old() {
        return id_user_old;
    }

    public void setId_user_old(UsersDomain id_user_old) {
        this.id_user_old = id_user_old;
    }

    public VlanDomain getId_vlan() {
        return id_vlan;
    }

    public void setId_vlan(VlanDomain id_vlan) {
        this.id_vlan = id_vlan;
    }

    public Dhcp_poolDomain getId_DHCP_pool() {
        return id_DHCP_pool;
    }

    public void setId_DHCP_pool(Dhcp_poolDomain id_DHCP_pool) {
        this.id_DHCP_pool = id_DHCP_pool;
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

    public RefStatusDomain getIs_status() {
        return is_status;
    }

    public void setIs_status(RefStatusDomain is_status) {
        this.is_status = is_status;
    }

    public String getPoolIpAddress (){
        try {
            return this.id_pool_address.getIp_addres_start() + "-" + this.id_pool_address.getIp_addres_end();
        }
        catch (Exception e){
            return " ";
        }
    }

    public String getDHCPPoolIpAddress (){
        try {
            return this.id_DHCP_pool.getAddress_start()+"-" + this.id_DHCP_pool.getAddress_end();
        }
        catch (Exception e){
            return " ";
        }
    }

    public String getVlan (){
        try {
            return "["+this.id_vlan.getVlan_number() +"] " + this.id_vlan.getVlan_name();
        }
        catch (Exception e){
            return " ";
        }
    }

    public String getNetworkInfo(){
        return this.ip_address_network+"/"+this.networkMask;
    }


}
