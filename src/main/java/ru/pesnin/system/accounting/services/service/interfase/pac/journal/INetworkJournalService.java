package ru.pesnin.system.accounting.services.service.interfase.pac.journal;



import ru.pesnin.system.accounting.integration.dto.filter.NetworkJournalIpAddressFilter;
import ru.pesnin.system.accounting.integration.dto.journal.NetworkJournalDto;

import java.util.List;

public interface  INetworkJournalService {
    List<NetworkJournalDto> findAll();
    NetworkJournalDto read(NetworkJournalDto obj);
    List<NetworkJournalDto> delete(Integer idNetwork_journal, NetworkJournalDto newObj);
    List<NetworkJournalDto> update(Integer idNetwork_journal, NetworkJournalDto newObj);
    List<NetworkJournalDto> create(NetworkJournalDto obj);
    List<NetworkJournalIpAddressFilter> findByIpAddress(Integer idNetwork);

}
