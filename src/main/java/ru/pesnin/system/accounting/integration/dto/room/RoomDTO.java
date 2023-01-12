package ru.pesnin.system.accounting.integration.dto.room;


import ru.pesnin.system.accounting.services.entity.room.RoomDomain;

public class RoomDTO {

    private Integer id_room;

    private String name_room;

    private Integer id_user_otv;
    private String user_otv;

    private String type_room;

    private Integer id_nodes;
    private String name_nodes;


    RoomDTO(){}
    public RoomDTO(RoomDomain obj) {
        this.id_room = obj.getId_room();
        this.name_room = obj.getName_room();
        this.id_user_otv = obj.getUser_otv().getUser_id();
        this.user_otv = obj.getUser_otv().getFioUser();
        this.type_room = obj.getType_room();
        this.id_nodes = obj.getId_nodes().getId_nodes();
        this.name_nodes = obj.getId_nodes().getName_nodes();
    }

    public Integer getId_room() {
        return id_room;
    }

    public void setId_room(Integer id_room) {
        this.id_room = id_room;
    }

    public String getName_room() {
        return name_room;
    }

    public void setName_room(String name_room) {
        this.name_room = name_room;
    }

    public Integer getId_user_otv() {
        return id_user_otv;
    }

    public void setId_user_otv(Integer id_user_otv) {
        this.id_user_otv = id_user_otv;
    }

    public String getUser_otv() {
        return user_otv;
    }

    public void setUser_otv(String user_otv) {
        this.user_otv = user_otv;
    }

    public String getType_room() {
        return type_room;
    }

    public void setType_room(String type_room) {
        this.type_room = type_room;
    }

    public Integer getId_nodes() {
        return id_nodes;
    }

    public void setId_nodes(Integer id_nodes) {
        this.id_nodes = id_nodes;
    }

    public String getName_nodes() {
        return name_nodes;
    }

    public void setName_nodes(String name_nodes) {
        this.name_nodes = name_nodes;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "id_room=" + id_room +
                ", name_room='" + name_room + '\'' +
                ", id_user_otv=" + id_user_otv +
                ", user_otv='" + user_otv + '\'' +
                ", type_room='" + type_room + '\'' +
                ", id_nodes=" + id_nodes +
                ", name_nodes='" + name_nodes + '\'' +
                '}';
    }
}
