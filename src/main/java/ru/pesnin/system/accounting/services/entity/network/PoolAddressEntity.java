package ru.pesnin.system.accounting.services.entity.network;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.integration.dto.network.PoolAddressDto;
import ru.pesnin.system.accounting.services.entity.RefStatusEntity;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;

import java.util.Date;

@Entity
@Data
@Table(schema = "network", name = "Pool_address")
@NoArgsConstructor
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

    @Column(name = "date_reg")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date dateReg;

    @Column(name = "date_old")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date dateOld;

    @ManyToOne
    @JoinColumn(name = "id_user_old",referencedColumnName = "user_id")
    private UsersEntity idUserOld;

    @ManyToOne
    @JoinColumn(name = "id_user_reg",referencedColumnName = "user_id")
    private UsersEntity idUserReg;

    @ManyToOne
    @JoinColumn(name = "is_status",referencedColumnName ="id_status" )
    private RefStatusEntity isStatus;

    public void setNewPool(PoolAddressDto dto, UsersEntity userReg, UsersEntity userOld, RefStatusEntity refStatusEntity, Date dateReg, Date dateOld ){
        this.namePool = dto.getNamePool();
        this.ipAddresStart = dto.getIpAddresStart();
        this.ipAddresEnd = dto.getIpAddresEnd();
        this.idUserReg = userReg;
        this.dateReg = dateReg;
        this.idUserOld = userOld;
        this.dateOld = dateOld;
        this.isStatus = refStatusEntity;
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
                ", dateReg=" + dateReg +
                ", dateOld=" + dateOld +
                ", idUserOld=" + idUserOld +
                ", idUserReg=" + idUserReg +
                ", isStatus=" + isStatus +
                '}';
    }
}
