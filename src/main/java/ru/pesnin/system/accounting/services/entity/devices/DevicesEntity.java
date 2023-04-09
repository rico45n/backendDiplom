package ru.pesnin.system.accounting.services.entity.devices;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.services.entity.room.RoomEntity;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;

@Entity
@Data
@Table(schema = "network", name = "Devices")
@NoArgsConstructor
public class DevicesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_devices")
    private Integer idDevices;

    @ManyToOne
    @JoinColumn(name = "id_type_devices", referencedColumnName = "id_type_dev")
    private TypeDeviceEntity idTypeDevices;

    @ManyToOne
    @JoinColumn(name = "user_otv", referencedColumnName = "user_id")
    private UsersEntity userOtv;


    @Column(unique = true , name = "hostname")
    private String hostname;

    @Column(unique = true , name = "mac_address")
    private String macAddress;

    @Column(unique = true , name = "inventar_number")
    private String inventarNumber;

    @ManyToOne
    @JoinColumn(name = "id_room", referencedColumnName = "id_room")
    private RoomEntity idRoom;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_props_port",referencedColumnName ="id_props_port" )
    private PropsPortEntity idPropsPort;



    public DevicesEntity(TypeDeviceEntity idTypeDevices,
                         UsersEntity userOtv, String hostname,
                         String macAddress, String inventarNumber,
                         RoomEntity idRoom, PropsPortEntity idPropsPort) {

        this.idTypeDevices = idTypeDevices;
        this.userOtv = userOtv;
        this.hostname = hostname;
        this.macAddress = macAddress;
        this.inventarNumber = inventarNumber;
        this.idRoom = idRoom;
        this.idPropsPort = idPropsPort;
    }

    @Override
    public String toString() {
        return "DevicesEntity{" +
                "idTypeDevices=" + idTypeDevices +
                ", userOtv=" + userOtv +
                ", hostname='" + hostname + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", inventarNumber='" + inventarNumber + '\'' +
                ", idRoom=" + idRoom +
                ", idPropsPort=" + idPropsPort +
                ", isStatus=" +
                '}';
    }
}

