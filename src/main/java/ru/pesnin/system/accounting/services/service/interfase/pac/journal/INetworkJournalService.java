package ru.pesnin.system.accounting.services.service.interfase.pac.journal;



import ru.pesnin.system.accounting.integration.dto.filter.NetworkJournalIpAddressFilter;
import ru.pesnin.system.accounting.integration.dto.journal.NetworkJournalDTO;

import java.util.List;

public interface  INetworkJournalService {
    List<NetworkJournalDTO> findAll();
    NetworkJournalDTO read(NetworkJournalDTO obj);
    List<NetworkJournalDTO> delete(Integer id_network_journal, NetworkJournalDTO new_obj);
    List<NetworkJournalDTO> update(Integer id_network_journal, NetworkJournalDTO new_obj);
    List<NetworkJournalDTO> create(NetworkJournalDTO obj);
    List<NetworkJournalIpAddressFilter> findByIpAddress(Integer id_network);

}
