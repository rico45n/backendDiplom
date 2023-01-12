package ru.pesnin.system.accounting.services.entity.devices;

import jakarta.persistence.*;
import lombok.Data;
import ru.pesnin.system.accounting.services.entity.RefStatusDomain;
import ru.pesnin.system.accounting.services.entity.room.RoomDomain;
import ru.pesnin.system.accounting.services.entity.user.UsersDomain;

@Entity
@Data
@Table(schema = "network", name = "Devices")
public class DevicesDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_devices;

    @ManyToOne
    @JoinColumn(name = "id_type_devices", referencedColumnName = "id_type_dev")
    private TypeDeviceDomain id_type_devices;

    @ManyToOne
    @JoinColumn(name = "user_otv", referencedColumnName = "user_id")
    private UsersDomain user_otv;


    @Column(unique = true)
    private String hostname;

    @Column(unique = true)
    private String mac_address;

    @Column(unique = true)
    private String inventar_number;

    @ManyToOne
    @JoinColumn(name = "id_room", referencedColumnName = "id_room")
    private RoomDomain id_room;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_props_port",referencedColumnName ="id_props_port" )
    private PropsPortDomain id_props_port;

    @ManyToOne
    @JoinColumn(name = "is_status",referencedColumnName ="id_status" )
    private RefStatusDomain is_status;

    public DevicesDomain() {
    }

    public DevicesDomain(TypeDeviceDomain id_type_devices,
                         UsersDomain user_otv, String hostname, String mac_address, String inventar_number,
                         RoomDomain id_room, PropsPortDomain id_props_port, RefStatusDomain is_status) {
        this.id_type_devices = id_type_devices;
        this.user_otv = user_otv;
        this.hostname = hostname;
        this.mac_address = mac_address;
        this.inventar_number = inventar_number;
        this.id_room = id_room;
        this.id_props_port = id_props_port;
        this.is_status = is_status;
    }

    public Integer getId_devices() {
        return id_devices;
    }

    public void setId_devices(Integer id_devices) {
        this.id_devices = id_devices;
    }

    public TypeDeviceDomain getId_type_devices() {
        return id_type_devices;
    }

    public void setId_type_devices(TypeDeviceDomain id_type_devices) {
        this.id_type_devices = id_type_devices;
    }

    public UsersDomain getUser_otv() {
        return user_otv;
    }

    public void setUser_otv(UsersDomain user_otv) {
        this.user_otv = user_otv;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getMac_address() {
        return mac_address;
    }

    public void setMac_address(String mac_address) {
        this.mac_address = mac_address;
    }

    public String getInventar_number() {
        return inventar_number;
    }

    public void setInventar_number(String inventar_number) {
        this.inventar_number = inventar_number;
    }

    public RoomDomain getId_room() {
        return id_room;
    }

    public void setId_room(RoomDomain id_room) {
        this.id_room = id_room;
    }

    public PropsPortDomain getId_props_port() {
        return id_props_port;
    }

    public void setId_props_port(PropsPortDomain id_props_port) {
        this.id_props_port = id_props_port;
    }

    public RefStatusDomain getIs_status() {
        return is_status;
    }

    public void setIs_status(RefStatusDomain is_status) {
        this.is_status = is_status;
    }
}

