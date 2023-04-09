package ru.pesnin.system.accounting.integration.dto.journal;




import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.services.entity.journal.NetworkJournalEntity;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NetworkJournalDto {

    private Integer idNetworkJournal;

    private Integer idNetwork;

    private String network;

    private String dnsZone;

    private String ipAddress;

    private Integer idUserReg;

    private String userReg;

    private Integer idUserOld;

    private String userOld;

    private Integer idDevices;

    private String hostName;


    public NetworkJournalDto(NetworkJournalEntity obj) {
        this.idNetworkJournal = obj.getIdNetworkJournal();
        this.idNetwork = obj.getIdNetwork().getIdNetwork();
        this.network = obj.getIdNetwork().getNetworkInfo();
        this.dnsZone = obj.getDnsZone();
        this.ipAddress = obj.getIpAddress();
        this.idUserReg = obj.getIdUserReg().getUserId();
        this.userReg = obj.getIdUserReg().getFioUser();
        this.idUserOld = obj.getIdUserOld().getUserId();
        this.userOld = obj.getIdUserOld().getFioUser();
        this.idDevices = obj.getIdDevices().getIdDevices();
        this.hostName = obj.getIdDevices().getHostname();
    }

    @Override
    public String toString() {
        return "NetworkJournalDto{" +
                "idNetworkJournal=" + idNetworkJournal +
                ", idNetwork=" + idNetwork +
                ", network='" + network + '\'' +
                ", dnsZone='" + dnsZone + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", idUserReg=" + idUserReg +
                ", userReg='" + userReg + '\'' +
                ", idUserOld=" + idUserOld +
                ", userOld='" + userOld + '\'' +
                ", idDevices=" + idDevices +
                ", hostName='" + hostName + '\'' +
                '}';
    }
}
