package ru.pesnin.system.accounting.integration.dto.journal;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import ru.pesnin.system.accounting.services.entity.journal.CrossDevicesDomain;


@Data
public class CrossDevicesDTO {

    private Integer Id_crossdevices;

    private Integer id_devices_first;
    private String host_name_start;
    private String inventar_number;
    private String user_otv_dev;

    private Integer id_devices_end;
    private String host_name_end;

    private Integer id_user_otv;
    private String user_otv;

    private Integer id_user_old;
    private String user_old;

    private Integer id_network_journal;
    private String ip_address_network;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private String date_reg;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private String date_old;

    private Integer id_vlan;
    private String name_vlan;

    private Integer id_crosses;
    private String info_crosses;

    private Integer id_status;
    private String name_status;

    public CrossDevicesDTO() {
    }

    public CrossDevicesDTO(CrossDevicesDomain obj) {
        Id_crossdevices = obj.getId_crossdevices();
        this.id_devices_first = obj.getId_devices_first().getId_devices();
        this.host_name_start = obj.getId_devices_first().getHostname();
        this.id_devices_end = obj.getId_devices_end().getId_devices();
        this.host_name_end = obj.getId_devices_end().getHostname();
        this.inventar_number = obj.getId_devices_end().getInventar_number();
        this.user_otv_dev = obj.getId_devices_end().getUser_otv().getFioUser();
        this.id_user_otv = obj.getId_user_otv().getUser_id();
        this.user_otv = obj.getId_user_otv().getFioUser();
        this.id_user_old = obj.getId_user_old().getUser_id();
        this.user_old = obj.getId_user_old().getFioUser();
        this.id_network_journal = obj.getId_network_journal().getId_network_journal();
        this.ip_address_network = obj.getId_network_journal().getIp_address();
        try {
            this.description = obj.getDescription();
        }
        catch (Exception e){
            this.description = "";
        }
        this.date_reg = obj.getDate_reg().toString();
        try {
            this.date_old = obj.getDate_old().toString();
        }catch (Exception e){
            this.date_old = "";
        }
        this.id_vlan = obj.getId_vlan().getId_vlan();
        this.name_vlan = "["+obj.getId_vlan().getVlan_number()+"] "+obj.getId_vlan().getVlan_name();
        this.id_crosses = obj.getId_crosses().getId_crosses_first();
        this.info_crosses = obj.getId_crosses().getInfoCrosses();
        this.id_status = obj.getIs_status().getId_status();
        this.name_status = obj.getIs_status().getName_status();
    }

    public Integer getId_crossdevices() {
        return Id_crossdevices;
    }

    public void setId_crossdevices(Integer id_crossdevices) {
        Id_crossdevices = id_crossdevices;
    }

    public Integer getId_devices_first() {
        return id_devices_first;
    }

    public void setId_devices_first(Integer id_devices_first) {
        this.id_devices_first = id_devices_first;
    }

    public String getHost_name_start() {
        return host_name_start;
    }

    public void setHost_name_start(String host_name_start) {
        this.host_name_start = host_name_start;
    }

    public Integer getId_devices_end() {
        return id_devices_end;
    }

    public void setId_devices_end(Integer id_devices_end) {
        this.id_devices_end = id_devices_end;
    }

    public String getHost_name_end() {
        return host_name_end;
    }

    public void setHost_name_end(String host_name_end) {
        this.host_name_end = host_name_end;
    }

    public Integer getId_user_otv() {
        return id_user_otv;
    }

    public void setId_user_otv(Integer id_user_otv) {
        this.id_user_otv = id_user_otv;
    }

    public String getUser_otv() {
        return user_otv;
    }

    public void setUser_otv(String user_otv) {
        this.user_otv = user_otv;
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

    public Integer getId_network_journal() {
        return id_network_journal;
    }

    public void setId_network_journal(Integer id_network_journal) {
        this.id_network_journal = id_network_journal;
    }

    public String getIp_address_network() {
        return ip_address_network;
    }

    public void setIp_address_network(String ip_address_network) {
        this.ip_address_network = ip_address_network;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_reg() {
        return date_reg;
    }

    public void setDate_reg(String date_reg) {
        this.date_reg = date_reg;
    }

    public String getDate_old() {
        return date_old;
    }

    public void setDate_old(String date_old) {
        this.date_old = date_old;
    }

    public Integer getId_vlan() {
        return id_vlan;
    }

    public void setId_vlan(Integer id_vlan) {
        this.id_vlan = id_vlan;
    }

    public String getName_vlan() {

        return name_vlan;
    }

    public void setName_vlan(String name_vlan) {
        this.name_vlan = name_vlan;
    }

    public Integer getId_crosses() {
        return id_crosses;
    }

    public void setId_crosses(Integer id_crosses) {
        this.id_crosses = id_crosses;
    }

    public String getInfo_crosses() {
        return info_crosses;
    }

    public void setInfo_crosses(String info_crosses) {
        this.info_crosses = info_crosses;
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

    public String getInventar_number() {
        return inventar_number;
    }

    public void setInventar_number(String inventar_number) {
        this.inventar_number = inventar_number;
    }

    public String getUser_otv_dev() {
        return user_otv_dev;
    }

    public void setUser_otv_dev(String user_otv_dev) {
        this.user_otv_dev = user_otv_dev;
    }

    @Override
    public String toString() {
        return "CrossDevicesDTO{" +
                "Id_crossdevices=" + Id_crossdevices +
                ", id_devices_first=" + id_devices_first +
                ", host_name_start='" + host_name_start + '\'' +
                ", inventar_number='" + inventar_number + '\'' +
                ", user_otv_dev='" + user_otv_dev + '\'' +
                ", id_devices_end=" + id_devices_end +
                ", host_name_end='" + host_name_end + '\'' +
                ", id_user_otv=" + id_user_otv +
                ", user_otv='" + user_otv + '\'' +
                ", id_user_old=" + id_user_old +
                ", user_old='" + user_old + '\'' +
                ", id_network_journal=" + id_network_journal +
                ", ip_address_network='" + ip_address_network + '\'' +
                ", description='" + description + '\'' +
                ", date_reg='" + date_reg + '\'' +
                ", date_old='" + date_old + '\'' +
                ", id_vlan=" + id_vlan +
                ", name_vlan='" + name_vlan + '\'' +
                ", id_crosses=" + id_crosses +
                ", info_crosses='" + info_crosses + '\'' +
                ", id_status=" + id_status +
                ", name_status='" + name_status + '\'' +
                '}';
    }
}
