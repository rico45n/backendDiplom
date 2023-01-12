package ru.pesnin.system.accounting.integration.dto.journal;




import ru.pesnin.system.accounting.services.entity.journal.NetworkJournalDomain;

import java.util.Date;


public class NetworkJournalDTO {

    private Integer id_network_journal;

    private Integer id_network;
    private String network;

    private String DNS_zone;

    private Date date_reg;

    private Date date_old;

    private String ip_address;

    private Integer id_user_reg;
    private String user_reg;

    private Integer id_user_old;
    private String user_old;

    private Integer id_devices;
    private String hostname;

    private Integer id_status;
    private String name_status;

    public NetworkJournalDTO() {
    }

    public NetworkJournalDTO(NetworkJournalDomain obj) {
        this.id_network_journal = obj.getId_network_journal();
        this.id_network = obj.getId_network().getId_network();
        this.network = obj.getId_network().getNetworkInfo();
        this.DNS_zone = obj.getDNS_zone();
        this.date_reg = obj.getDate_reg();
        this.date_old = obj.getDate_old();
        this.ip_address = obj.getIp_address();
        this.id_user_reg = obj.getId_user_reg().getUser_id();
        this.user_reg = obj.getId_user_reg().getFioUser();
        this.id_user_old = obj.getId_user_old().getUser_id();
        this.user_old = obj.getId_user_old().getFioUser();
        this.id_devices = obj.getId_devices().getId_devices();
        this.hostname = obj.getId_devices().getHostname();
        this.id_status = obj.getIs_status().getId_status();
        this.name_status = obj.getIs_status().getName_status();
    }

    public Integer getId_network_journal() {
        return id_network_journal;
    }

    public void setId_network_journal(Integer id_network_journal) {
        this.id_network_journal = id_network_journal;
    }

    public Integer getId_network() {
        return id_network;
    }

    public void setId_network(Integer id_network) {
        this.id_network = id_network;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
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

    public Integer getId_user_reg() {
        return id_user_reg;
    }

    public void setId_user_reg(Integer id_user_reg) {
        this.id_user_reg = id_user_reg;
    }

    public String getUser_reg() {
        return user_reg;
    }

    public void setUser_reg(String user_reg) {
        this.user_reg = user_reg;
    }

    public Integer getId_user_old() {
        return id_user_old;
    }

    public void setId_user_old(Integer id_user_old) {
        this.id_user_old = id_user_old;
    }

    public String getUser_old() {
        return user_old;
    }

    public void setUser_old(String user_old) {
        this.user_old = user_old;
    }

    public Integer getId_devices() {
        return id_devices;
    }

    public void setId_devices(Integer id_devices) {
        this.id_devices = id_devices;
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

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @Override
    public String toString() {
        return "NetworkJournalDTO{" +
                "id_network_journal=" + id_network_journal +
                ", id_network=" + id_network +
                ", network='" + network + '\'' +
                ", DNS_zone='" + DNS_zone + '\'' +
                ", date_reg=" + date_reg +
                ", date_old=" + date_old +
                ", ip_address='" + ip_address + '\'' +
                ", id_user_reg=" + id_user_reg +
                ", user_reg='" + user_reg + '\'' +
                ", id_user_old=" + id_user_old +
                ", user_old='" + user_old + '\'' +
                ", id_devices=" + id_devices +
                ", hostname='" + hostname + '\'' +
                ", id_status=" + id_status +
                ", name_status='" + name_status + '\'' +
                '}';
    }
}
