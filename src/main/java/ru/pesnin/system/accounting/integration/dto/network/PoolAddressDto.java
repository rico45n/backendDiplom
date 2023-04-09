package ru.pesnin.system.accounting.integration.dto.network;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.services.entity.network.PoolAddressEntity;


import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PoolAddressDto {
    private Integer idPoolAddress;

    private String namePool;

    private String ipAddresStart;

    private String ipAddresEnd;

    private String userOld;

    private Integer idUserOld;

    private String userReg;

    private Integer idUserReg;


    public PoolAddressDto(PoolAddressEntity pool) {
        this.idPoolAddress = pool.getIdPoolAddress();
        this.namePool = pool.getNamePool();
        this.ipAddresStart = pool.getIpAddresStart();
        this.ipAddresEnd = pool.getIpAddresEnd();
        this.userOld = pool.getIdUserOld().getFioUser();
        this.userReg = pool.getIdUserReg().getFioUser();
        this.idUserOld = pool.getIdUserOld().getUserId();
        this.idUserReg = pool.getIdUserReg().getUserId();
    }

    @Override
    public String toString() {
        return "PoolAddressDto{" +
                "idPoolAddress=" + idPoolAddress +
                ", namePool='" + namePool + '\'' +
                ", ipAddresStart='" + ipAddresStart + '\'' +
                ", ipAddresEnd='" + ipAddresEnd + '\'' +
                ", userOld='" + userOld + '\'' +
                ", idUserOld=" + idUserOld +
                ", userReg='" + userReg + '\'' +
                ", idUserReg=" + idUserReg +
                '}';
    }
}

