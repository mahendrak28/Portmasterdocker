package com.portmaster.controller;

import com.portmaster.entity.PortEffAttribute;
import com.portmaster.entity.PortStaticAttribute;
import com.portmaster.exception.ResourceNotFoundException;
import com.portmaster.repository.PortEffRepository;
import com.portmaster.repository.PortfolioRepository;
import com.portmaster.service.PortfolioEffService;
import com.portmaster.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api/auth")
public class PortfController {

    @Autowired
    PortfolioService portfolioService;

    @Autowired
    PortfolioEffService portfolioEffService;

    @Autowired
    private PortfolioRepository repo;

    @Autowired
    private PortEffRepository effrepo;

//To get all portfolios from portfolio static table
     @RequestMapping("/api/auth/getPortfolio")
     @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
       public List<PortStaticAttribute> getPortfolio() {
        return portfolioService.getPortfolio();
    }

    //To get  portfolio based on Id from portfolio static table
    @RequestMapping("/api/auth/getPortfolio/{Id}")

    public PortStaticAttribute getPortfolioById(@PathVariable int Id) {
        return portfolioService.getPortfolioById(Id);
    }

    //To get  portfolio based on port Id and status from portfolio static table
    @RequestMapping("/api/auth/getPortfolio/{portid}/{portstatus}")

    public List<PortStaticAttribute> getPortfolioByPortIdAndPortStatus(@PathVariable String portid, @PathVariable int portstatus) {
        return portfolioService.getPortfolioByPortIdAndPortStatus(portid, portstatus);
    }

    // To create a new portfolio in portfolio static table
  /*  @RequestMapping(value ="/getPortfolio", method = RequestMethod.POST)
    public void createPortfolio(@RequestBody PortStaticWrapper wrapper) {
         portfolioService.createPortfolio(wrapper);

    }*/

    @RequestMapping(value ="/api/auth/getPortfolio", method = RequestMethod.POST)
   // @PostMapping(value ="/api/auth/getPortfolio", method = RequestMethod.POST)
    public void createPortfolio(@RequestBody byte[] portStaticAttribute) throws IOException {
        byte[] mapData = portStaticAttribute;
        PortStaticAttribute[] portstaticarray =null;

        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        portstaticarray = objectMapper.readValue(mapData,PortStaticAttribute[].class);
        List<PortStaticAttribute> portStaticList = Arrays.asList(portstaticarray);
        for (PortStaticAttribute port :  portStaticList){
            portfolioService.createPortfolio(port);
        }
    }


/*
    @RequestMapping(value="/getPortfolio", method=RequestMethod.POST)
    @JsonFormat(shape =JsonFormat.Shape.ARRAY )
    @ResponseBody
    public List<String> createPortfolio(@RequestBody PortStaticWrapper wrapper) {
        System.out.println("Enter");
        List<String> response = new ArrayList<>();
        for (PortStaticAttribute portStaticAttribute: wrapper.getPortStaticAttributes()){
            System.out.println(portStaticAttribute);
            portfolioService.createPortfolio(portStaticAttribute);
            response.add("Saved portfoio: " + portStaticAttribute.toString());
        }
        return response;
    }
*/
    //To update portfolio in portfolio static table
    @RequestMapping(value ="/api/auth/getPortfolio/", method = RequestMethod.PUT)
   // @PostMapping(value ="/getPortfolio/", method = RequestMethod.PUT)
    public void updatePortfolio(@RequestBody PortStaticAttribute portStaticAttribute) {
        portfolioService.updatePortfolio(portStaticAttribute);
     }

    //To delete portfolio in portfolio static table
    @RequestMapping(value ="/api/auth/getPortfolio/{Id}", method = RequestMethod.DELETE)
    public void deletePortfolioById(@PathVariable int  Id) {
        portfolioService.deletePortfolioById(Id);
    }


    //to get data from portfolio details table, need to fix it
    @RequestMapping(value = "/api/auth/getPortfolio/{portid}/PortEffAttribute" , method = RequestMethod.POST)
    public PortEffAttribute CreatePortfolioById(@RequestBody PortEffAttribute portEffAttribute,@PathVariable int portid) {

        return repo.findById(portid).map(portStaticAttribute -> {
            portEffAttribute.setPortStaticAttribute(portStaticAttribute);
            return effrepo.save(portEffAttribute);
        }).orElseThrow(() -> new ResourceNotFoundException("portid " + portid + " not found"));
    }

}
