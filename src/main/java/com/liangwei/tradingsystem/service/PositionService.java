package com.liangwei.tradingsystem.service;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.io.CharSource;
import com.google.common.io.Resources;
import com.liangwei.tradingsystem.dto.Position;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PositionService {

    public List<Position> getPositions(String filePath) throws IOException {
        List<Position> result = new ArrayList<>();
        CharSource charSource = Resources.asCharSource(Resources.getResource(filePath), Charset.forName("UTF-8"));
        ImmutableList<String> stringImmutableList = charSource.readLines();
        stringImmutableList.forEach(s -> {
            List<String> stringList = Splitter.on(",").splitToList(s);
            Position position = new Position(stringList.get(0), stringList.get(1), Integer.parseInt(stringList.get(2)));
            result.add(position);
        });
        return result;
    }
}
