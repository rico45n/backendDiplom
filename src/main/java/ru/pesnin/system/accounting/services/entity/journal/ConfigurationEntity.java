package ru.pesnin.system.accounting.services.entity.journal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.services.entity.devices.DevicesEntity;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;

@Entity
@Data
@Table(schema = "network", name = "Configuration")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ConfigurationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_config")
    private Integer idConfig;

    @OneToOne
    @JoinColumn(name = "id_device")
    private DevicesEntity idDevice;
    @Column(name = "config_first")
    private String configFirst;
    @Column(name = "config_last")
    private String configLast;
    @Column(name = "deference")
    private String deference;

    @ManyToOne
    @JoinColumn(name = "id_user_reg",referencedColumnName = "user_id")
    private UsersEntity idUserReg;

    @ManyToOne
    @JoinColumn(name = "id_user_old",referencedColumnName = "user_id")
    private UsersEntity idUserOld;

    public void setConfiguration(DevicesEntity device, String configFirst, String configLast, String deference,
                                 UsersEntity userReg, UsersEntity userOld) {
        this.idDevice = device;
        this.configFirst = configFirst;
        this.configLast = configLast;
        this.deference = deference;
        this.idUserReg = userReg;
        this.idUserOld = userOld;
    }


    @Override
    public String toString() {
        return "ConfigurationEntity{" +
                "idConfig=" + idConfig +
                ", idDevice=" + idDevice +
                ", configFirst='" + configFirst + '\'' +
                ", configLast='" + configLast + '\'' +
                ", deference='" + deference + '\'' +
                ", idUserReg=" + idUserReg +
                ", idUserOld=" + idUserOld +
                ", isStatus=" +
                '}';
    }
}
