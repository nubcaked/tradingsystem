package com.liangwei.tradingsystem.service;

import com.liangwei.tradingsystem.entity.Security;
import com.liangwei.tradingsystem.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    @Autowired
    SecurityRepository securityRepository;

    public void populateSampleData() {
        Security s1 = new Security("GOOG", "stock");
        securityRepository.save(s1);

        Security s2 = new Security("MCO", "stock");
        securityRepository.save(s2);

        Security s3 = new Security("MSFT", "stock");
        securityRepository.save(s3);
    }

}
