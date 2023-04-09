package ru.pesnin.system.accounting.integration.dto.crosses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrossesDto {
    private int idCrosses;
    private int idCrossesFirst;
    private int idCrossesEnd;
    private int shkaf;
    private int slot;
    private int port;
    private int infoCrosses;

    @Override
    public String toString() {
        return "CrossesDto{" +
                "idCrosses=" + idCrosses +
                ", idCrossesFirst=" + idCrossesFirst +
                ", idCrossesEnd=" + idCrossesEnd +
                ", shkaf=" + shkaf +
                ", slot=" + slot +
                ", port=" + port +
                ", infoCrosses=" + infoCrosses +
                '}';
    }
}
