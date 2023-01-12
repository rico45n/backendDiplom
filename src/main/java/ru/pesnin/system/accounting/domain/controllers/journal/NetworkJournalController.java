package ru.pesnin.system.accounting.domain.controllers.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pesnin.system.accounting.integration.dto.filter.NetworkJournalIpAddressFilter;
import ru.pesnin.system.accounting.integration.dto.journal.NetworkJournalDTO;
import ru.pesnin.system.accounting.services.service.interfase.pac.journal.INetworkJournalService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/NetworkJournal/")
public class NetworkJournalController  {
    @Autowired
    private INetworkJournalService networkJournalService;

    @RequestMapping(value = "/NetworkJournalAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NetworkJournalDTO> findAll() {
        return networkJournalService.findAll();
    }

    @RequestMapping(value = "/SearchNetworkJournal/{id_network_journal}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public NetworkJournalDTO read(@PathVariable("id_network_journal") NetworkJournalDTO obj) {
        return networkJournalService.read(obj);
    }

    @RequestMapping(value = "/DeleteNetworkJournal/{id_network_journal}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NetworkJournalDTO> delete(@PathVariable("id_network_journal") Integer id_network_journal,  @RequestBody NetworkJournalDTO new_obj) {
        return networkJournalService.delete(id_network_journal, new_obj);
    }

    @RequestMapping(value = "/UpdateNetworkJournal/{id_network_journal}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NetworkJournalDTO> update(@PathVariable("id_network_journal") Integer id_network_journal, @RequestBody NetworkJournalDTO new_obj) {
        return networkJournalService.update(id_network_journal, new_obj);
    }

    @RequestMapping(value = "/CreateNetworkJournal", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NetworkJournalDTO> create(@RequestBody NetworkJournalDTO obj){
        return networkJournalService.create(obj);
    }

    @RequestMapping(value = "/NetworkJournalIpFilter/{id_network}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NetworkJournalIpAddressFilter> findByIpAddress(@PathVariable("id_network") Integer id_network) {
        return networkJournalService.findByIpAddress(id_network);
    }

}