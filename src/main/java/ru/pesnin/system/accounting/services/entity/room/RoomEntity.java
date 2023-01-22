package ru.pesnin.system.accounting.services.entity.room;

import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.services.entity.network.NodesEntity;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;

@Entity
@Data
@Table(schema = "network", name = "Room")
@NoArgsConstructor
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_room")
    private Integer idRoom;

    @Column(name = "name_room")
    private String nameRoom;

    @ManyToOne
    @JoinColumn(name = "usert_otv",referencedColumnName = "user_id")
    private UsersEntity userOtv;

    @Column(name = "type_room")
    private String typeRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nodes", referencedColumnName = "id_nodes")
    private NodesEntity idNodes;


    public RoomEntity(String nameRoom, UsersEntity userOtv, String typeRoom, NodesEntity idNodes) {
        this.nameRoom = nameRoom;
        this.userOtv = userOtv;
        this.typeRoom = typeRoom;
        this.idNodes = idNodes;
    }

    @Override
    public String toString() {
        return "RoomEntity{" +
                "idRoom=" + idRoom +
                ", nameRoom='" + nameRoom + '\'' +
                ", userOtv=" + userOtv +
                ", typeRoom='" + typeRoom + '\'' +
                ", idNodes=" + idNodes +
                '}';
    }
}
