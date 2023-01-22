package ru.pesnin.system.accounting.integration.dto.network;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.services.entity.network.NodesEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NodesDto {

    private Integer idNodes;

    private String userOtv;

    private Integer idUserOtv;

    private String nameNodes;


    public NodesDto(NodesEntity nodes) {
        this.idNodes = nodes.getIdNodes();
        this.userOtv = nodes.getUserOtv().getFioUser();
        this.nameNodes = nodes.getNameNodes();
        this.idUserOtv = nodes.getUserOtv().getUserId();
    }

    @Override
    public String toString() {
        return "NodesDto{" +
                "idNodes=" + idNodes +
                ", userOtv='" + userOtv + '\'' +
                ", idUserOtv=" + idUserOtv +
                ", nameNodes='" + nameNodes + '\'' +
                '}';
    }
}
