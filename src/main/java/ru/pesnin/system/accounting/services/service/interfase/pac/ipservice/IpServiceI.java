package ru.pesnin.system.accounting.services.service.interfase.pac.ipservice;

import java.util.List;

public interface IpServiceI {
    String netAddress (String addr);
    List<String> getAllIpAddress(String addressStart, String addressEnd);
}
