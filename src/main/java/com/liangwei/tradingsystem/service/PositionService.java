package com.liangwei.tradingsystem.service;

import com.google.common.collect.ImmutableList;
import com.google.common.io.CharSource;
import com.google.common.io.Resources;
import com.liangwei.tradingsystem.entity.Position;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;

@Service
public class PositionService {

    public String getPositions(String filePath) throws IOException {
        CharSource charSource = Resources.asCharSource(Resources.getResource(filePath), Charset.forName("UTF-8"));
        String positions = charSource.read();
        return positions;

//        ImmutableList<String> stringImmutableList = charSource.readLines();
//        stringImmutableList.forEach(line -> {
//            System.out.println(line);
//        });
//
//        return new Position();
    }

}
