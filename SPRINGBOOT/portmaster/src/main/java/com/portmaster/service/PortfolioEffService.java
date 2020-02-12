package com.portmaster.service;

import com.portmaster.entity.PortEffAttribute;
import com.portmaster.entity.PortStaticAttribute;
import com.portmaster.repository.PortEffRepository;
import com.portmaster.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PortfolioEffService {

    @Autowired
    private PortEffRepository repo;


    public List<PortEffAttribute> getPortfolio() {
        return (List<PortEffAttribute>) repo.findAll();
    }

    public void createEffPortfolio(@RequestBody PortEffAttribute portEffAttribute) {
        repo.save(portEffAttribute);
    }

   // public List<PortEffAttribute> getPortfolioByPortId(String portid) {

     //   return repo.findByPortId(portid);
    //}

  /*  public PortStaticAttribute getPortfolioById(int Id) {
        return repo.findById(Id).get();
    }



    public List<PortStaticAttribute> getPortfolioByPortIdAndPortStatus(String portid, int portstatus) {
        return repo.findByPortIdAndPortStatus(portid, portstatus);
    }

    public void createPortfolio(PortStaticAttribute portStaticAttribute) {
        repo.save(portStaticAttribute);
    }
    public void updatePortfolio(PortStaticAttribute portStaticAttribute) {
        repo.save(portStaticAttribute);
    }

    public void deletePortfolioById(int Id) {
         repo.deleteById(Id);
    }*/
}
