package edu.programacion.central.service;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
import edu.programacion.central.dto.Ropa;
import edu.programacion.central.integration.api.ROPAAPI;

@Service
public class ROPAService {
    private ROPAAPI ropaAPI;

    public ROPAService(ROPAAPI ropaAPI){
        this.ropaAPI = ropaAPI;
    }

    public List<Ropa> getValidRopas(){
        List<Ropa> ropasValid = ropaAPI.getRopas().stream().collect(Collectors.toList());
        return ropasValid;
    }

}
