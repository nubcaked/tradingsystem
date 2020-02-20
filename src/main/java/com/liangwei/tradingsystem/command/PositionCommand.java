package com.liangwei.tradingsystem.command;

import com.google.common.collect.ImmutableList;
import com.liangwei.tradingsystem.repository.SecurityRepository;
import com.liangwei.tradingsystem.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class PositionCommand {

    @Autowired
    PositionService positionService;

    @Autowired
    SecurityRepository securityRepository;

    @ShellMethod("Displays greeting message to the user whose name is supplied")
    public void getPositions() throws Exception {
        ImmutableList<String> positions = positionService.getPositions("positions.csv");
        positions.forEach(line -> {
            System.out.println(line);
        });
        return;
    }
}
