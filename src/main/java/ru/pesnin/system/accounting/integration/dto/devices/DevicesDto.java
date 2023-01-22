package ru.pesnin.system.accounting.integration.dto.devices;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.pesnin.system.accounting.services.entity.devices.DevicesEntity;


@Data
public class DevicesDto {
    @JsonProperty("id_devices")
    private Integer idDevices;
    @JsonProperty("id_type_devices")
    private Integer idTypeDevices;
    @JsonProperty("type_device")
    private String typeDevice;
    @JsonProperty("id_user_otv")
    private Integer idUserOtv;
    @JsonProperty("user_otv")
    private String userOtv;
    @JsonProperty("hostname")
    private String hostName;
    @JsonProperty("mac_address")
    private String macAddress;
    @JsonProperty("inventar_number")
    private String inventarNumber;
    @JsonProperty("id_room")
    private Integer idRoom;

    private String  room;
    @JsonProperty("id_props_port")
    private Integer idPropsPort;
    @JsonProperty("count_opt_port")
    private Integer countOptPort;
    @JsonProperty("count_ethernet_port")
    private Integer countEthernetPort;
    @JsonProperty("id_status")
    private Integer idStatus;
    @JsonProperty("name_status")
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
        this.idStatus = dev.getIsStatus().getIdStatus();
        this.nameStatus = dev.getIsStatus().getNameStatus();
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

