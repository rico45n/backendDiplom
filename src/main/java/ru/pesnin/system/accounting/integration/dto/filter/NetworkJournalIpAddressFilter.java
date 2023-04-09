package ru.pesnin.system.accounting.integration.dto.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NetworkJournalIpAddressFilter {

    private Integer id;
    private String ipAddress;

    public void setNetworkJournalIpAddressFilter(Integer id, String ipAddress) {
        this.id = id;
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "NetworkJournalIpAddressFilter{" +
                "id=" + id +
                ", ip_address='" + ipAddress + '\'' +
                '}';
    }
}
