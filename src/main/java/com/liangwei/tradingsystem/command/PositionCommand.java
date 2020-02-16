package com.liangwei.tradingsystem.command;

import com.liangwei.tradingsystem.entity.Security;
import com.liangwei.tradingsystem.repository.SecurityRepository;
import com.liangwei.tradingsystem.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Optional;

@ShellComponent
public class PositionCommand {

    @Autowired
    PositionService positionService;

    @Autowired
    SecurityRepository securityRepository;

    @ShellMethod("Displays greeting message to the user whose name is supplied")
    public String getPositions() throws Exception {
        String positions = positionService.getPositions("positions.csv");
        return positions;
    }

    @ShellMethod("Just to test db")
    public String testDb() throws Exception {
        Security security = new Security("GOOG", "Stock");
        securityRepository.save(security);
        Optional<Security> result = securityRepository.findById(2L);
        return result.get().getTicker();
    }
}
