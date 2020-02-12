package com.portmaster.service;

import com.portmaster.entity.PortStaticAttribute;
import com.portmaster.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository repo;

    public List<PortStaticAttribute> getPortfolio() {
        return (List<PortStaticAttribute>) repo.findAll();
    }

    public PortStaticAttribute getPortfolioById(int Id) {
        return repo.findById(Id).get();
    }

  /*  public List<PortStaticAttribute> getPortfolioByPortId(String portId) {
        return repo.findByPortId(portId);
    }
*/
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
    }
}
