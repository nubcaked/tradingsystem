package com.liangwei.tradingsystem.service;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.io.CharSource;
import com.google.common.io.Resources;
import com.liangwei.tradingsystem.entity.Position;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

@Service
public class PositionService {

    public ImmutableList<String> getPositions(String filePath) throws IOException {
        CharSource charSource = Resources.asCharSource(Resources.getResource(filePath), Charset.forName("UTF-8"));
        ImmutableList<String> stringImmutableList = charSource.readLines();
        return stringImmutableList;
    }
}
