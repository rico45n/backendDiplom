package ru.pesnin.system.accounting.integration.dto.devices;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.services.entity.devices.DevicesEntity;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DevicesDto {

    private Integer idDevices;

    private Integer idTypeDevices;

    private String typeDevice;

    private Integer idUserOtv;

    private String userOtv;

    private String hostName;

    private String macAddress;

    private String inventarNumber;

    private Integer idRoom;

    private String  room;

    private Integer idPropsPort;

    private Integer countOptPort;

    private Integer countEthernetPort;

    private Integer idStatus;

    private String nameStatus;
    public DevicesDto(DevicesEntity dev) {
        this.idDevices = dev.getIdDevices();
        this.idTypeDevices = dev.getIdTypeDevices().getIdTypeDev();
        this.typeDevice = dev.getIdTypeDevices().getNameTypeDev();
        this.idUserOtv = dev.getUserOtv().getUserId();
        this.userOtv = dev.getUserOtv().getFioUser();
        this.hostName = dev.getHostname();
        this.idRoom = dev.getIdRoom().getIdRoom();
        this.room = dev.getIdRoom().getNameRoom();
        this.idPropsPort = dev.getIdPropsPort().getIdPropsPort();
        this.countOptPort = dev.getIdPropsPort().getOVPort();
        this.countEthernetPort = dev.getIdPropsPort().getEthernetPort();
        this.macAddress = dev.getMacAddress();
        this.inventarNumber = dev.getInventarNumber();
    }

    @Override
    public String toString() {
        return "DevicesDto{" +
                "idDevices=" + idDevices +
                ", idTypeDevices=" + idTypeDevices +
                ", typeDevice='" + typeDevice + '\'' +
                ", idUserOtv=" + idUserOtv +
                ", userOtv='" + userOtv + '\'' +
                ", hostName='" + hostName + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", inventarNumber='" + inventarNumber + '\'' +
                ", idRoom=" + idRoom +
                ", room='" + room + '\'' +
                ", idPropsPort=" + idPropsPort +
                ", countOptPort=" + countOptPort +
                ", countEthernetPort=" + countEthernetPort +
                ", idStatus=" + idStatus +
                ", nameStatus='" + nameStatus + '\'' +
                '}';
    }
}

