package ru.pesnin.system.accounting.services.entity.journal;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.integration.dto.journal.NetworkJournalDto;
import ru.pesnin.system.accounting.services.entity.RefStatusEntity;
import ru.pesnin.system.accounting.services.entity.devices.DevicesEntity;
import ru.pesnin.system.accounting.services.entity.network.NetworkEntity;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;

import java.util.Date;

@Entity
@Data
@Table(schema = "network", name = "NetworkJournal")
@NoArgsConstructor
public class NetworkJournalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_network_journal")
    private Integer idNetworkJournal;


    @ManyToOne(optional=false)
    @JoinColumn(name = "id_network")
    private NetworkEntity idNetwork;

    @Column(name = "dns_zone")
    private String DnsZone;
    @Column(name = "date_reg")
    private Date dateReg;
    @Column(name = "date_old")
    private Date dateOld;
    @Column(name = "ip_address")
    private String ipAddress;


    @ManyToOne
    @JoinColumn(name = "id_user_reg",referencedColumnName = "user_id")
    private UsersEntity idUserReg;

    @ManyToOne
    @JoinColumn(name = "id_user_old",referencedColumnName = "user_id")
    private UsersEntity idUserOld;


    @ManyToOne
    @JoinColumn(name = "id_devices", referencedColumnName = "id_devices")
    private DevicesEntity idDevices;


    @ManyToOne
    @JoinColumn(name = "is_status",referencedColumnName ="id_status" )
    private RefStatusEntity isStatus;
    public void setNetworkJournalEntity(NetworkEntity networkDomain, NetworkJournalDto dto, UsersEntity userReg, UsersEntity userOld, DevicesEntity device, RefStatusEntity status){
        this.idNetwork = networkDomain;
        this.DnsZone = dto.getDnsZone();
        this.dateReg = new Date();
        this.dateOld = null;
        this.ipAddress = dto.getIpAddress();
        this.idUserReg = userReg;
        this.idUserOld = userOld;
        this.idDevices = device;
        this.isStatus = status;
    }

    @Override
    public String toString() {
        return "NetworkJournalEntity{" +
                "idNetworkJournal=" + idNetworkJournal +
                ", idNetwork=" + idNetwork +
                ", DnsZone='" + DnsZone + '\'' +
                ", dateReg=" + dateReg +
                ", dateOld=" + dateOld +
                ", ipAddress='" + ipAddress + '\'' +
                ", idUserReg=" + idUserReg +
                ", idUserOld=" + idUserOld +
                ", idDevices=" + idDevices +
                ", isStatus=" + isStatus +
                '}';
    }
}

