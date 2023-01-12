package ru.pesnin.system.accounting.services.entity.network;

import lombok.Data;
import jakarta.persistence.*;



@Entity
@Data
@Table(schema = "network", name = "Crosses")
public class CrossesDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_crosses;


    private  Integer id_crosses_first;

    private Integer id_crosses_end;

    private Integer shkaf;

    private Integer slot;

    private Integer port;

    public CrossesDomain() {
    }

    public Integer getId_crosses_first() {
        return id_crosses_first;
    }

    public void setId_crosses_first(Integer id_crosses_first) {
        this.id_crosses_first = id_crosses_first;
    }

    public Integer getId_crosses_end() {
        return id_crosses_end;
    }

    public void setId_crosses_end(Integer id_crosses_end) {
        this.id_crosses_end = id_crosses_end;
    }

    public Integer getShkaf() {
        return shkaf;
    }

    public void setShkaf(Integer shkaf) {
        this.shkaf = shkaf;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getId_crosses() {
        return id_crosses;
    }

    public void setId_crosses(Integer id_crosses) {
        this.id_crosses = id_crosses;
    }

    public String getInfoCrosses(){
        return "Порт: "+this.port+" Слот: "+this.slot+" Шкаф:"+this.shkaf;
    }
}
