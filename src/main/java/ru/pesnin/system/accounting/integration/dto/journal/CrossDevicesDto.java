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

    private Integer idCrossDevices;

    private Integer idDevicesFirst;

    private String hostNameStart;

    private String inventarNumber;

    private String userOtvDev;

    private Integer idDevicesEnd;

    private String hostNameEnd;

    private Integer idUserOtv;

    private String userOtv;

    private Integer idUserOld;

    private String userOld;

    private Integer idNetworkJournal;

    private String ipAddressNetwork;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private String dateReg;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private String dateOld;

    private Integer idVlan;

    private String nameVlan;

    private Integer idCrosses;

    private String infoCrosses;

    private Integer idStatus;

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

        try {

        }catch (Exception e){
            this.dateOld = "";
        }
        this.idVlan = obj.getIdVlan().getIdVlan();
        this.nameVlan = "["+obj.getIdVlan().getVlanNumber()+"] "+obj.getIdVlan().getVlanName();
        this.idCrosses = obj.getIdCrosses().getIdCrossesFirst();
        this.infoCrosses = obj.getIdCrosses().getInfoCrosses();
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
