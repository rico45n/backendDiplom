package ru.pesnin.system.accounting.integration.dto;

public class MapperStringToEntity {

    private Integer idObject;
    private String bodyObject;

    public MapperStringToEntity(Integer idObject, String bodyObject) {
        this.idObject = idObject;
        this.bodyObject = bodyObject;
    }

    public MapperStringToEntity() {
    }

    public Integer getIdObject() {
        return idObject;
    }

    public void setIdObject(Integer idObject) {
        this.idObject = idObject;
    }

    public String getBodyObject() {
        return bodyObject;
    }

    public void setBodyObject(String bodyObject) {
        this.bodyObject = bodyObject;
    }
}
