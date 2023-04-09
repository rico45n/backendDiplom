package ru.pesnin.system.accounting.services.entity.network;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.integration.dto.network.PoolAddressDto;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;

import java.util.Date;

@Entity
@Data
@Table(schema = "network", name = "Pool_address")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PoolAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pool_address")
    private Integer idPoolAddress;

    @Column(name = "name_pool")
    private String namePool;

    @Column(name = "ip_addres_start")
    private String ipAddresStart;

    @Column(name = "ip_addres_end")
    private String ipAddresEnd;

    @ManyToOne
    @JoinColumn(name = "id_user_old",referencedColumnName = "user_id")
    private UsersEntity idUserOld;

    @ManyToOne
    @JoinColumn(name = "id_user_reg",referencedColumnName = "user_id")
    private UsersEntity idUserReg;


    public void setNewPool(PoolAddressDto dto, UsersEntity userReg, UsersEntity userOld){
        this.namePool = dto.getNamePool();
        this.ipAddresStart = dto.getIpAddresStart();
        this.ipAddresEnd = dto.getIpAddresEnd();
        this.idUserReg = userReg;
        this.idUserOld = userOld;
    }

    public String getFIOReg(){
        return this.idUserReg.getFirstName() +" "
                +this.idUserReg.getLastName()+" "
                +this.idUserReg.getMiddleName();
    }
    public String getFIOOld(){
            try {
                return this.idUserOld.getFirstName() + " "
                        + this.idUserOld.getLastName() + " "
                        + this.idUserOld.getMiddleName();
            }
        catch (Exception e){
            return " ";
        }
    }

    @Override
    public String toString() {
        return "PoolAddressEntity{" +
                "idPoolAddress=" + idPoolAddress +
                ", namePool='" + namePool + '\'' +
                ", ipAddresStart='" + ipAddresStart + '\'' +
                ", ipAddresEnd='" + ipAddresEnd + '\'' +
                ", idUserOld=" + idUserOld +
                ", idUserReg=" + idUserReg +
                ", isStatus=" +
                '}';
    }
}
