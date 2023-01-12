package ru.pesnin.system.accounting.services.entity.journal;
import jakarta.persistence.*;
import lombok.Data;
import ru.pesnin.system.accounting.integration.dto.journal.NetworkJournalDTO;
import ru.pesnin.system.accounting.services.entity.RefStatusDomain;
import ru.pesnin.system.accounting.services.entity.devices.DevicesDomain;
import ru.pesnin.system.accounting.services.entity.network.NetworkDomain;
import ru.pesnin.system.accounting.services.entity.user.UsersDomain;

import java.util.Date;

@Entity
@Data
@Table(schema = "network", name = "NetworkJournal")
public class NetworkJournalDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_network_journal;


    @ManyToOne(optional=false)
    @JoinColumn(name = "id_network")
    private NetworkDomain id_network;


    private String DNS_zone;

    private Date date_reg;

    private Date date_old;

    private String ip_address;


    @ManyToOne
    @JoinColumn(name = "id_user_reg",referencedColumnName = "user_id")
    private UsersDomain id_user_reg;

    @ManyToOne
    @JoinColumn(name = "id_user_old",referencedColumnName = "user_id")
    private UsersDomain id_user_old;


    @ManyToOne
    @JoinColumn(name = "id_devices", referencedColumnName = "id_devices")
    private DevicesDomain id_devices;


    @ManyToOne
    @JoinColumn(name = "is_status",referencedColumnName ="id_status" )
    private RefStatusDomain is_status;


    public NetworkJournalDomain() {
    }

    public void setNetworkJournalDomain(NetworkDomain networkDomain, NetworkJournalDTO dto, UsersDomain user_reg, UsersDomain user_old, DevicesDomain device, RefStatusDomain status){
        this.id_network = networkDomain;
        this.DNS_zone = dto.getDNS_zone();
        this.date_reg = new Date();
        this.date_old = null;
        this.ip_address = dto.getIp_address();
        this.id_user_reg = user_reg;
        this.id_user_old = user_old;
        this.id_devices = device;
        this.is_status = status;
    }

    public Integer getId_network_journal() {
        return id_network_journal;
    }

    public void setId_network_journal(Integer id_network_journal) {
        this.id_network_journal = id_network_journal;
    }

    public NetworkDomain getId_network() {
        return id_network;
    }

    public void setId_network(NetworkDomain id_network) {
        this.id_network = id_network;
    }

    public String getDNS_zone() {
        return DNS_zone;
    }

    public void setDNS_zone(String DNS_zone) {
        this.DNS_zone = DNS_zone;
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

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
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

    public DevicesDomain getId_devices() {
        return id_devices;
    }

    public void setId_devices(DevicesDomain id_devices) {
        this.id_devices = id_devices;
    }

    public RefStatusDomain getIs_status() {
        return is_status;
    }

    public void setIs_status(RefStatusDomain is_status) {
        this.is_status = is_status;
    }
}

