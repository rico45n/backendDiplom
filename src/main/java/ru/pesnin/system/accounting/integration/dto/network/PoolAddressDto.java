package ru.pesnin.system.accounting.integration.dto.network;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.services.entity.network.PoolAddressEntity;


import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoolAddressDto {
    @JsonProperty("id_pool_address")
    private Integer idPoolAddress;
    @JsonProperty("name_pool")
    private String namePool;
    @JsonProperty("ip_addres_start")
    private String ipAddresStart;
    @JsonProperty("ip_addres_end")
    private String ipAddresEnd;
    @JsonProperty("date_reg")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date dateReg;
    @JsonProperty("date_old")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date dateOld;
    @JsonProperty("user_old")
    private String userOld;
    @JsonProperty("id_user_old")
    private Integer idUserOld;
    @JsonProperty("user_reg")
    private String userReg;
    @JsonProperty("id_user_reg")
    private Integer idUserReg;
    @JsonProperty("id_status")
    private Integer idStatus;
    @JsonProperty("name_status")
    private String nameStatus;



    public PoolAddressDto(PoolAddressEntity pool) {
        this.idPoolAddress = pool.getIdPoolAddress();
        this.namePool = pool.getNamePool();
        this.ipAddresStart = pool.getIpAddresStart();
        this.ipAddresEnd = pool.getIpAddresEnd();
        this.dateReg = pool.getDateReg();
        this.dateOld = pool.getDateOld();
        this.userOld = pool.getIdUserOld().getFioUser();
        this.userReg = pool.getIdUserReg().getFioUser();
        this.idStatus = pool.getIsStatus().getIdStatus();
        this.nameStatus = pool.getIsStatus().getNameStatus();
        this.idUserOld = pool.getIdUserOld().getUserId();
    }

    @Override
    public String toString() {
        return "PoolAddressDto{" +
                "idPoolAddress=" + idPoolAddress +
                ", namePool='" + namePool + '\'' +
                ", ipAddresStart='" + ipAddresStart + '\'' +
                ", ipAddresEnd='" + ipAddresEnd + '\'' +
                ", dateReg=" + dateReg +
                ", dateOld=" + dateOld +
                ", userOld='" + userOld + '\'' +
                ", idUserOld=" + idUserOld +
                ", userReg='" + userReg + '\'' +
                ", idUserReg=" + idUserReg +
                ", idStatus=" + idStatus +
                ", nameStatus='" + nameStatus + '\'' +
                '}';
    }
}

