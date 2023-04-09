package ru.pesnin.system.accounting.services.entity.journal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.integration.dto.journal.NetworkJournalDto;
import ru.pesnin.system.accounting.services.entity.devices.DevicesEntity;
import ru.pesnin.system.accounting.services.entity.network.NetworkEntity;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;

import java.util.Date;

@Entity
@Data
@Table(schema = "network", name = "NetworkJournal")
@NoArgsConstructor
@Builder
@AllArgsConstructor
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


    public void setNetworkJournalEntity(NetworkEntity networkDomain, NetworkJournalDto dto, UsersEntity userReg, UsersEntity userOld, DevicesEntity device){
        this.idNetwork = networkDomain;
        this.DnsZone = dto.getDnsZone();
        this.ipAddress = dto.getIpAddress();
        this.idUserReg = userReg;
        this.idUserOld = userOld;
        this.idDevices = device;

    }

    @Override
    public String toString() {
        return "NetworkJournalEntity{" +
                "idNetworkJournal=" + idNetworkJournal +
                ", idNetwork=" + idNetwork +
                ", DnsZone='" + DnsZone + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", idUserReg=" + idUserReg +
                ", idUserOld=" + idUserOld +
                ", idDevices=" + idDevices +
                ", isStatus=" +
                '}';
    }
}

