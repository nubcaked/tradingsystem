package com.liangwei.tradingsystem.command;

import com.google.common.base.Joiner;
import com.liangwei.tradingsystem.entity.Security;
import com.liangwei.tradingsystem.repository.SecurityRepository;
import com.liangwei.tradingsystem.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;
import java.util.Optional;

@ShellComponent
public class SecurityCommand {

    @Autowired
    SecurityRepository securityRepository;

    @Autowired
    SecurityService securityService;

    @ShellMethod("Load H2 database with data")
    public String loadDb() throws Exception {

        securityService.populateSampleData();

        List<Security> securityList = securityRepository.findAll();
        String result = Joiner.on("\n").join(securityList);

        return result;
    }
}
