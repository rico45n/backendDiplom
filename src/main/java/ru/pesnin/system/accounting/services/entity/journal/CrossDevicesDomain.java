package ru.pesnin.system.accounting.services.entity.journal;
import jakarta.persistence.*;
import lombok.Data;
import ru.pesnin.system.accounting.services.entity.RefStatusDomain;
import ru.pesnin.system.accounting.services.entity.devices.DevicesDomain;
import ru.pesnin.system.accounting.services.entity.network.CrossesDomain;
import ru.pesnin.system.accounting.services.entity.network.VlanDomain;
import ru.pesnin.system.accounting.services.entity.user.UsersDomain;

import java.util.Date;

@Entity
@Data
@Table(schema = "network", name = "CrossDevices")
public class CrossDevicesDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_crossdevices;

    @ManyToOne
    @JoinColumn(name = "id_devices_first", referencedColumnName = "id_devices")
    private DevicesDomain id_devices_first;

    @ManyToOne
    @JoinColumn(name = "id_devices_end", referencedColumnName = "id_devices")
    private DevicesDomain id_devices_end;

    @ManyToOne
    @JoinColumn(name = "id_user_otv",referencedColumnName = "user_id")
    private UsersDomain id_user_otv;

    @ManyToOne
    @JoinColumn(name = "id_user_old",referencedColumnName = "user_id")
    private UsersDomain id_user_old;

    @OneToOne
    @JoinColumn(name = "id_network_journal", referencedColumnName = "id_network_journal")
    private NetworkJournalDomain id_network_journal;

    private String description;

    private Date date_reg;

    private Date date_old;

    @ManyToOne
    @JoinColumn(name = "id_vlan", referencedColumnName = "id_vlan")
    private VlanDomain id_vlan;

    @ManyToOne
    @JoinColumn(name = "id_crosses", referencedColumnName = "id_crosses")
    private CrossesDomain id_crosses;

    @ManyToOne
    @JoinColumn(name = "is_status",referencedColumnName ="id_status" )
    private RefStatusDomain is_status;

    public CrossDevicesDomain() {
    }

    public CrossDevicesDomain(DevicesDomain id_devices_first, DevicesDomain id_devices_end, UsersDomain id_user_otv,
                              UsersDomain id_user_old, NetworkJournalDomain id_network_journal, String description,
                              Date date_reg, Date date_old, VlanDomain id_vlan, CrossesDomain id_crosses, RefStatusDomain is_status){
        this.id_devices_first = id_devices_first;
        this.id_devices_end = id_devices_end;
        this.id_user_otv = id_user_otv;
        this.id_user_old = id_user_old;
        this.id_network_journal = id_network_journal;
        this.description = description;
        this.date_reg = date_reg;
        this.date_old = date_old;
        this.id_vlan = id_vlan;
        this.id_crosses = id_crosses;
        this.is_status = is_status;
    }

    public void setCrossDevicesDomain(DevicesDomain id_devices_first, DevicesDomain id_devices_end, UsersDomain id_user_otv,
                                      UsersDomain id_user_old, NetworkJournalDomain id_network_journal, String description,
                                      Date date_reg, Date date_old, VlanDomain id_vlan, CrossesDomain id_crosses, RefStatusDomain is_status){
        this.id_devices_first = id_devices_first;
        this.id_devices_end = id_devices_end;
        this.id_user_otv = id_user_otv;
        this.id_user_old = id_user_old;
        this.id_network_journal = id_network_journal;
        this.description = description;
        this.date_reg = date_reg;
        this.date_old = date_old;
        this.id_vlan = id_vlan;
        this.id_crosses = id_crosses;
        this.is_status = is_status;
    }

    public Integer getId_crossdevices() {
        return Id_crossdevices;
    }

    public void setId_crossdevices(Integer id_crossdevices) {
        Id_crossdevices = id_crossdevices;
    }

    public DevicesDomain getId_devices_first() {
        return id_devices_first;
    }

    public void setId_devices_first(DevicesDomain id_devices_first) {
        this.id_devices_first = id_devices_first;
    }

    public DevicesDomain getId_devices_end() {
        return id_devices_end;
    }

    public void setId_devices_end(DevicesDomain id_devices_end) {
        this.id_devices_end = id_devices_end;
    }

    public UsersDomain getId_user_otv() {
        return id_user_otv;
    }

    public void setId_user_otv(UsersDomain id_user_otv) {
        this.id_user_otv = id_user_otv;
    }

    public UsersDomain getId_user_old() {
        return id_user_old;
    }

    public void setId_user_old(UsersDomain id_user_old) {
        this.id_user_old = id_user_old;
    }

    public NetworkJournalDomain getId_network_journal() {
        return id_network_journal;
    }

    public void setId_network_journal(NetworkJournalDomain id_network_journal) {
        this.id_network_journal = id_network_journal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public VlanDomain getId_vlan() {
        return id_vlan;
    }

    public void setId_vlan(VlanDomain id_vlan) {
        this.id_vlan = id_vlan;
    }

    public CrossesDomain getId_crosses() {
        return id_crosses;
    }

    public void setId_crosses(CrossesDomain id_crosses) {
        this.id_crosses = id_crosses;
    }

    public RefStatusDomain getIs_status() {
        return is_status;
    }

    public void setIs_status(RefStatusDomain is_status) {
        this.is_status = is_status;
    }

    @Override
    public String toString() {
        return "CrossDevicesDomain{" +
                "Id_crossdevices=" + Id_crossdevices +
                ", id_devices_first=" + id_devices_first +
                ", id_devices_end=" + id_devices_end +
                ", id_user_otv=" + id_user_otv +
                ", id_user_old=" + id_user_old +
                ", id_network_journal=" + id_network_journal +
                ", description='" + description + '\'' +
                ", date_reg=" + date_reg +
                ", date_old=" + date_old +
                ", id_vlan=" + id_vlan +
                ", id_crosses=" + id_crosses +
                ", is_status=" + is_status +
                '}';
    }
}

