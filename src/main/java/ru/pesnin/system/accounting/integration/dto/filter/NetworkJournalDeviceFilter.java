package ru.pesnin.system.accounting.integration.dto.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NetworkJournalDeviceFilter {

    private Integer idDevices;

    private String hostName;

    @Override
    public String toString() {
        return "NetworkJournalDeviceFilter{" +
                "idDevices=" + idDevices +
                ", hostName='" + hostName + '\'' +
                '}';
    }
}
