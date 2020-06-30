package com.sanjeev.springrestsample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@RestController
public class TraderController {

    private final  TraderRepository traderRepository;

    @Autowired
    public TraderController(TraderRepository traderRepository) {
        this.traderRepository = traderRepository;
    }

    @GetMapping(path = "/traders", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Trader> getTraders() {
        Stream.of("Sanjeev", "Chiru", "Naisha")
                .map(name -> new Trader(UUID.randomUUID().toString(), name))
                .forEach(traderRepository::save);
       return  traderRepository.findAll();
    }
}
