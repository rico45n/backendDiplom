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
    @JsonProperty("id_config")
    private Integer idConfig;
    @JsonProperty("id_device")
    private Integer idDevice;
    @JsonProperty("host_name")
    private String hostName;
    @JsonProperty("config_first")
    private String configFirst;
    @JsonProperty("config_last")
    private String configLast;

    private String deference;
    @JsonProperty("id_user_reg")
    private Integer idUserReg;
    @JsonProperty("user_reg")
    private String userReg;
    @JsonProperty("id_user_old")
    private Integer idUserOld;
    @JsonProperty("user_old")
    private String userOld;
    @JsonProperty("date_reg")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private String dateReg;
    @JsonProperty("date_old")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private String dateOld;
    @JsonProperty("id_status")
    private Integer idStatus;
    @JsonProperty("name_status")
    private String nameStatus;

    public ConfigurationDto(ConfigurationEntity obj) {
            this.idConfig = obj.getIdConfig();
            this.idDevice = obj.getIdDevice().getIdDevices();
            this.hostName = obj.getIdDevice().getHostname();
            this.configFirst = obj.getConfigFirst();
            this.idUserReg = obj.getIdUserReg().getUserId();
            this.userReg = obj.getIdUserReg().getFioUser();
            this.idUserOld = obj.getIdUserOld().getUserId();
            this.userOld = obj.getIdUserOld().getFioUser();
            this.dateReg = obj.getDateReg().toString();
            this.idStatus = obj.getIsStatus().getIdStatus();
            this.nameStatus = obj.getIsStatus().getNameStatus();

            try {
                this.dateOld = obj.getDateOld().toString();
            }
            catch (Exception e){
                this.dateOld = "";
            }
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
                ", userOld='" + userOld + '\'' +
                ", dateReg='" + dateReg + '\'' +
                ", dateOld='" + dateOld + '\'' +
                ", idStatus=" + idStatus +
                ", nameStatus='" + nameStatus + '\'' +
                '}';
    }
}
