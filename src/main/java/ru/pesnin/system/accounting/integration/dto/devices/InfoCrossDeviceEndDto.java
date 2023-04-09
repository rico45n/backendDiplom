package ru.pesnin.system.accounting.integration.dto.devices;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfoCrossDeviceEndDto implements Serializable {

    @Id
    private Integer id;

    private Integer idDevices;

    private String hostName;

    private String inventarNumber;

    private String macAddress;

    private Integer userId;

    private String fioUser;

    private Integer idNetworkJournal;

    private String ipAddress;

    private Integer idVlan;

    private String vlanName;


}
