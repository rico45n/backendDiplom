package ru.pesnin.system.accounting.integration.dto.journal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.services.entity.journal.ConfigurationEntity;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigurationDto {

    private Integer idConfig;

    private Integer idDevice;

    private String hostName;

    private String configFirst;

    private String configLast;

    private String deference;

    private Integer idUserReg;

    private String userReg;

    private Integer idUserOld;

    private String userOld;

    public ConfigurationDto(ConfigurationEntity obj) {
            this.idConfig = obj.getIdConfig();
            this.idDevice = obj.getIdDevice().getIdDevices();
            this.hostName = obj.getIdDevice().getHostname();
            this.configFirst = obj.getConfigFirst();
            this.idUserReg = obj.getIdUserReg().getUserId();
            this.userReg = obj.getIdUserReg().getFioUser();
            this.idUserOld = obj.getIdUserOld().getUserId();
            this.userOld = obj.getIdUserOld().getFioUser();


            try {
                this.deference = obj.getDeference();
            }
            catch (Exception e){
                this.deference = "";
            }
            try {
                this.configLast = obj.getConfigLast();
            }
            catch (Exception e){
                this.configLast = "";
            }
    }

    @Override
    public String toString() {
        return "ConfigurationDto{" +
                "idConfig=" + idConfig +
                ", idDevice=" + idDevice +
                ", hostName='" + hostName + '\'' +
                ", configFirst='" + configFirst + '\'' +
                ", configLast='" + configLast + '\'' +
                ", deference='" + deference + '\'' +
                ", idUserReg=" + idUserReg +
                ", userReg='" + userReg + '\'' +
                ", idUserOld=" + idUserOld +
                ", userOld='" + userOld + '\'';
    }
}
