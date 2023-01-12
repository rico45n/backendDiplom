package ru.pesnin.system.accounting.integration.dto.filter;

public class NetworkJournalDeviceFilter {
    private Integer id_devices;
    private String hostname;

    public NetworkJournalDeviceFilter(Integer id_devices, String hostname) {
        this.id_devices = id_devices;
        this.hostname = hostname;
    }

    public NetworkJournalDeviceFilter() {
    }

    public Integer getId_devices() {
        return id_devices;
    }

    public void setId_devices(Integer id_devices) {
        this.id_devices = id_devices;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @Override
    public String toString() {
        return "networkJournalDeviceFilter{" +
                "id_devices=" + id_devices +
                ", hostname='" + hostname + '\'' +
                '}';
    }
}
