package ru.pesnin.system.accounting.integration.dto.journal;




import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.services.entity.journal.NetworkJournalEntity;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetworkJournalDto {
    @JsonProperty("id_network_journal")
    private Integer idNetworkJournal;
    @JsonProperty("id_network")
    private Integer idNetwork;

    private String network;
    @JsonProperty("DNS_zone")
    private String dnsZone;
    @JsonProperty("date_reg")
    private Date dateReg;
    @JsonProperty("date_old")
    private Date dateOld;
    @JsonProperty("ip_address")
    private String ipAddress;
    @JsonProperty("id_user_reg")
    private Integer idUserReg;
    @JsonProperty("user_reg")
    private String userReg;
    @JsonProperty("id_user_old")
    private Integer idUserOld;
    @JsonProperty("user_old")
    private String userOld;
    @JsonProperty("id_devices")
    private Integer idDevices;
    @JsonProperty("hostname")
    private String hostName;
    @JsonProperty("id_status")
    private Integer idStatus;
    @JsonProperty("name_status")
    private String nameStatus;


    public NetworkJournalDto(NetworkJournalEntity obj) {
        this.idNetworkJournal = obj.getIdNetworkJournal();
        this.idNetwork = obj.getIdNetwork().getIdNetwork();
        this.network = obj.getIdNetwork().getNetworkInfo();
        this.dnsZone = obj.getDnsZone();
        this.dateReg = obj.getDateReg();
        this.dateOld = obj.getDateOld();
        this.ipAddress = obj.getIpAddress();
        this.idUserReg = obj.getIdUserReg().getUserId();
        this.userReg = obj.getIdUserReg().getFioUser();
        this.idUserOld = obj.getIdUserOld().getUserId();
        this.userOld = obj.getIdUserOld().getFioUser();
        this.idDevices = obj.getIdDevices().getIdDevices();
        this.hostName = obj.getIdDevices().getHostname();
        this.idStatus = obj.getIsStatus().getIdStatus();
        this.nameStatus = obj.getIsStatus().getNameStatus();
    }

    @Override
    public String toString() {
        return "NetworkJournalDto{" +
                "idNetworkJournal=" + idNetworkJournal +
                ", idNetwork=" + idNetwork +
                ", network='" + network + '\'' +
                ", dnsZone='" + dnsZone + '\'' +
                ", dateReg=" + dateReg +
                ", dateOld=" + dateOld +
                ", ipAddress='" + ipAddress + '\'' +
                ", idUserReg=" + idUserReg +
                ", userReg='" + userReg + '\'' +
                ", idUserOld=" + idUserOld +
                ", userOld='" + userOld + '\'' +
                ", idDevices=" + idDevices +
                ", hostName='" + hostName + '\'' +
                ", idStatus=" + idStatus +
                ", nameStatus='" + nameStatus + '\'' +
                '}';
    }
}
