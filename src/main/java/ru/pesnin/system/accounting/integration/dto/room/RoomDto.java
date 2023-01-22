package ru.pesnin.system.accounting.integration.dto.room;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.services.entity.room.RoomEntity;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {

    private Integer idRoom;

    private String nameRoom;

    private Integer idUserOtv;

    private String userOtv;

    private String typeRoom;

    private Integer idNodes;

    private String nameNodes;
    public RoomDto(RoomEntity obj) {
        this.idRoom = obj.getIdRoom();
        this.nameRoom = obj.getNameRoom();
        this.idUserOtv = obj.getUserOtv().getUserId();
        this.userOtv = obj.getUserOtv().getFioUser();
        this.typeRoom = obj.getTypeRoom();
        this.idNodes = obj.getIdNodes().getIdNodes();
        this.nameNodes = obj.getIdNodes().getNameNodes();
    }

    @Override
    public String toString() {
        return "RoomDto{" +
                "idRoom=" + idRoom +
                ", nameRoom='" + nameRoom + '\'' +
                ", idUserOtv=" + idUserOtv +
                ", userOtv='" + userOtv + '\'' +
                ", typeRoom='" + typeRoom + '\'' +
                ", idNodes=" + idNodes +
                ", nameNodes='" + nameNodes + '\'' +
                '}';
    }
}
