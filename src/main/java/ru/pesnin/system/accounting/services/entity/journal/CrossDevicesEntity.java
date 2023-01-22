package ru.pesnin.system.accounting.services.entity.journal;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.services.entity.RefStatusEntity;
import ru.pesnin.system.accounting.services.entity.devices.DevicesEntity;
import ru.pesnin.system.accounting.services.entity.network.CrossesEntity;
import ru.pesnin.system.accounting.services.entity.network.VlanEntity;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;

import java.util.Date;

@Entity
@Data
@Table(schema = "network", name = "CrossDevices")
@NoArgsConstructor
public class CrossDevicesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_crossdevices")
    private Integer IdCrossDevices;

    @ManyToOne
    @JoinColumn(name = "id_devices_first", referencedColumnName = "id_devices")
    private DevicesEntity idDevicesFirst;

    @ManyToOne
    @JoinColumn(name = "id_devices_end", referencedColumnName = "id_devices")
    private DevicesEntity idDevicesEnd;

    @ManyToOne
    @JoinColumn(name = "id_user_otv",referencedColumnName = "user_id")
    private UsersEntity idUserOtv;

    @ManyToOne
    @JoinColumn(name = "id_user_old",referencedColumnName = "user_id")
    private UsersEntity idUserOld;

    @OneToOne
    @JoinColumn(name = "id_network_journal", referencedColumnName = "id_network_journal")
    private NetworkJournalEntity idNetworkJournal;
    @Column(name = "description")
    private String description;
    @Column(name = "date_reg")
    private Date dateReg;
    @Column(name = "date_old")
    private Date dateOld;

    @ManyToOne
    @JoinColumn(name = "id_vlan", referencedColumnName = "id_vlan")
    private VlanEntity idVlan;

    @ManyToOne
    @JoinColumn(name = "id_crosses", referencedColumnName = "id_crosses")
    private CrossesEntity idCrosses;

    @ManyToOne
    @JoinColumn(name = "is_status",referencedColumnName ="id_status" )
    private RefStatusEntity isStatus;


    public CrossDevicesEntity(DevicesEntity idDevicesFirst,
                              DevicesEntity idDevicesEnd, UsersEntity idUserOtv,
                              UsersEntity idUserOld, NetworkJournalEntity idNetworkJournal,
                              String description, Date dateReg, Date dateOld, VlanEntity idVlan,
                              CrossesEntity idCrosses, RefStatusEntity isStatus) {

        this.idDevicesFirst = idDevicesFirst;
        this.idDevicesEnd = idDevicesEnd;
        this.idUserOtv = idUserOtv;
        this.idUserOld = idUserOld;
        this.idNetworkJournal = idNetworkJournal;
        this.description = description;
        this.dateReg = dateReg;
        this.dateOld = dateOld;
        this.idVlan = idVlan;
        this.idCrosses = idCrosses;
        this.isStatus = isStatus;
    }

    public void setCrossDevicesEntity(DevicesEntity idDevicesFirst, DevicesEntity idDevicesEnd, UsersEntity idUserOtv,
                                      UsersEntity idUserOld, NetworkJournalEntity idNetworkJournal, String description,
                                      Date dateReg, Date dateOld, VlanEntity idVlan, CrossesEntity idCrosses, RefStatusEntity isStatus){
        this.idDevicesFirst = idDevicesFirst;
        this.idDevicesEnd = idDevicesEnd;
        this.idUserOtv = idUserOtv;
        this.idUserOld = idUserOld;
        this.idNetworkJournal = idNetworkJournal;
        this.description = description;
        this.dateReg = dateReg;
        this.dateOld = dateOld;
        this.idVlan = idVlan;
        this.idCrosses = idCrosses;
        this.isStatus = isStatus;
    }

    @Override
    public String toString() {
        return "CrossDevicesEntity{" +
                "IdCrossDevices=" + IdCrossDevices +
                ", idDevicesFirst=" + idDevicesFirst +
                ", idDevicesEnd=" + idDevicesEnd +
                ", idUserOtv=" + idUserOtv +
                ", idUserOld=" + idUserOld +
                ", idNetworkJournal=" + idNetworkJournal +
                ", description='" + description + '\'' +
                ", dateReg=" + dateReg +
                ", dateOld=" + dateOld +
                ", idVlan=" + idVlan +
                ", idCrosses=" + idCrosses +
                ", isStatus=" + isStatus +
                '}';
    }
}

