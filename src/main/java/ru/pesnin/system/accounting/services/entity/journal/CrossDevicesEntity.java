package ru.pesnin.system.accounting.services.entity.journal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.services.entity.devices.DevicesEntity;
import ru.pesnin.system.accounting.services.entity.network.CrossesEntity;
import ru.pesnin.system.accounting.services.entity.network.VlanEntity;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;

import java.util.Date;

@Entity
@Data
@Table(schema = "network", name = "CrossDevices")
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    @ManyToOne
    @JoinColumn(name = "id_vlan", referencedColumnName = "id_vlan")
    private VlanEntity idVlan;

    @ManyToOne
    @JoinColumn(name = "id_crosses", referencedColumnName = "id_crosses")
    private CrossesEntity idCrosses;




    public CrossDevicesEntity(DevicesEntity idDevicesFirst,
                              DevicesEntity idDevicesEnd, UsersEntity idUserOtv,
                              UsersEntity idUserOld, NetworkJournalEntity idNetworkJournal,
                              String description, VlanEntity idVlan,
                              CrossesEntity idCrosses) {

        this.idDevicesFirst = idDevicesFirst;
        this.idDevicesEnd = idDevicesEnd;
        this.idUserOtv = idUserOtv;
        this.idUserOld = idUserOld;
        this.idNetworkJournal = idNetworkJournal;
        this.description = description;
        this.idVlan = idVlan;
        this.idCrosses = idCrosses;

    }

    public void setCrossDevicesEntity(DevicesEntity idDevicesFirst, DevicesEntity idDevicesEnd, UsersEntity idUserOtv,
                                      UsersEntity idUserOld, NetworkJournalEntity idNetworkJournal, String description,
                                     VlanEntity idVlan, CrossesEntity idCrosses){
        this.idDevicesFirst = idDevicesFirst;
        this.idDevicesEnd = idDevicesEnd;
        this.idUserOtv = idUserOtv;
        this.idUserOld = idUserOld;
        this.idNetworkJournal = idNetworkJournal;
        this.description = description;
        this.idVlan = idVlan;
        this.idCrosses = idCrosses;
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
                ", idVlan=" + idVlan +
                ", idCrosses=" + idCrosses +
                ", isStatus=" +
                '}';
    }
}

