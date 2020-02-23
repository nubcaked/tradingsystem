package com.liangwei.tradingsystem.command;

import com.liangwei.tradingsystem.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.IOException;

@ShellComponent
public class PositionCommand {

    @Autowired
    PositionService positionService;

    @ShellMethod("Displays a list of positions by extracting from a csv file")
    public String getPositions() throws IOException {
        return positionService.getPositions("positions.csv").toString();
    }
}
