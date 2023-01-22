package ru.pesnin.system.accounting.integration.dto.journal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.services.entity.journal.CrossDevicesEntity;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrossDevicesDto {
    @JsonProperty("Id_crossdevices")
    private Integer idCrossDevices;
    @JsonProperty("id_devices_first")
    private Integer idDevicesFirst;
    @JsonProperty("host_name_start")
    private String hostNameStart;
    @JsonProperty("inventar_number")
    private String inventarNumber;
    @JsonProperty("user_otv_dev")
    private String userOtvDev;
    @JsonProperty("id_devices_end")
    private Integer idDevicesEnd;
    @JsonProperty("host_name_end")
    private String hostNameEnd;
    @JsonProperty("id_user_otv")
    private Integer idUserOtv;
    @JsonProperty("user_otv")
    private String userOtv;
    @JsonProperty("id_user_old")
    private Integer idUserOld;
    @JsonProperty("user_old")
    private String userOld;
    @JsonProperty("id_network_journal")
    private Integer idNetworkJournal;
    @JsonProperty("ip_address_network")
    private String ipAddressNetwork;

    private String description;
    @JsonProperty("date_reg")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private String dateReg;
    @JsonProperty("date_old")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private String dateOld;
    @JsonProperty("id_vlan")
    private Integer idVlan;
    @JsonProperty("name_vlan")
    private String nameVlan;
    @JsonProperty("id_crosses")
    private Integer idCrosses;
    @JsonProperty("info_crosses")
    private String infoCrosses;
    @JsonProperty("id_status")
    private Integer idStatus;
    @JsonProperty("name_status")
    private String nameStatus;

    public CrossDevicesDto(CrossDevicesEntity obj) {
        this.idCrossDevices = obj.getIdCrossDevices();
        this.idDevicesFirst = obj.getIdDevicesFirst().getIdDevices();
        this.hostNameStart = obj.getIdDevicesFirst().getHostname();
        this.idDevicesEnd = obj.getIdDevicesEnd().getIdDevices();
        this.hostNameEnd = obj.getIdDevicesEnd().getHostname();
        this.inventarNumber = obj.getIdDevicesEnd().getInventarNumber();
        this.userOtvDev = obj.getIdDevicesEnd().getUserOtv().getFioUser();
        this.idUserOtv = obj.getIdUserOtv().getUserId();
        this.userOtv = obj.getIdUserOtv().getFioUser();
        this.idUserOld = obj.getIdUserOld().getUserId();
        this.userOld = obj.getIdUserOld().getFioUser();
        this.idNetworkJournal = obj.getIdNetworkJournal().getIdNetworkJournal();
        this.ipAddressNetwork = obj.getIdNetworkJournal().getIpAddress();
        try {
            this.description = obj.getDescription();
        }
        catch (Exception e){
            this.description = "";
        }
        this.dateReg = obj.getDateReg().toString();
        try {
            this.dateOld = obj.getDateOld().toString();
        }catch (Exception e){
            this.dateOld = "";
        }
        this.idVlan = obj.getIdVlan().getIdVlan();
        this.nameVlan = "["+obj.getIdVlan().getVlanNumber()+"] "+obj.getIdVlan().getVlanName();
        this.idCrosses = obj.getIdCrosses().getIdCrossesFirst();
        this.infoCrosses = obj.getIdCrosses().getInfoCrosses();
        this.idStatus = obj.getIsStatus().getIdStatus();
        this.nameStatus = obj.getIsStatus().getNameStatus();
    }

    @Override
    public String toString() {
        return "CrossDevicesDto{" +
                "idCrossDevices=" + idCrossDevices +
                ", idDevicesFirst=" + idDevicesFirst +
                ", hostNameStart='" + hostNameStart + '\'' +
                ", inventarNumber='" + inventarNumber + '\'' +
                ", userOtvDev='" + userOtvDev + '\'' +
                ", idDevicesEnd=" + idDevicesEnd +
                ", hostNameEnd='" + hostNameEnd + '\'' +
                ", idUserOtv=" + idUserOtv +
                ", userOtv='" + userOtv + '\'' +
                ", idUserOld=" + idUserOld +
                ", userOld='" + userOld + '\'' +
                ", idNetworkJournal=" + idNetworkJournal +
                ", ipAddressNetwork='" + ipAddressNetwork + '\'' +
                ", description='" + description + '\'' +
                ", dateReg='" + dateReg + '\'' +
                ", dateOld='" + dateOld + '\'' +
                ", idVlan=" + idVlan +
                ", nameVlan='" + nameVlan + '\'' +
                ", idCrosses=" + idCrosses +
                ", infoCrosses='" + infoCrosses + '\'' +
                ", idStatus=" + idStatus +
                ", nameStatus='" + nameStatus + '\'' +
                '}';
    }
}
