package ru.pesnin.system.accounting.services.entity.network;

import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(schema = "network", name = "Crosses")
@NoArgsConstructor
public class CrossesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_crosses")
    private Integer idCrosses;

    @Column(name = "id_crosses_first")
    private  Integer idCrossesFirst;
    @Column(name = "id_crosses_end")
    private Integer idCrossesEnd;
    @Column(name = "shkaf")
    private Integer shkaf;
    @Column(name = "slot")
    private Integer slot;
    @Column(name = "port")
    private Integer port;


    public String getInfoCrosses(){
        return "Порт: "+this.port+" Слот: "+this.slot+" Шкаф:"+this.shkaf;
    }

    @Override
    public String toString() {
        return "CrossesEntity{" +
                "idCrosses=" + idCrosses +
                ", idCrossesFirst=" + idCrossesFirst +
                ", idCrossesEnd=" + idCrossesEnd +
                ", shkaf=" + shkaf +
                ", slot=" + slot +
                ", port=" + port +
                '}';
    }
}
