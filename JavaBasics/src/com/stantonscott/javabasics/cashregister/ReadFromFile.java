package com.stantonscott.javabasics.cashregister;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Callable;

import static com.stantonscott.javabasics.cashregister.Main.*;

public class ReadFromFile implements Callable<Object> {

    private File file;
    private Object object;

    public ReadFromFile(File file, Object object) {
        this.file = file;
        this.object = object;
    }


    @Override
    public Object call() throws Exception {
        String row = null;

        List<String> data = new ArrayList<>();
        Map items = new HashMap();

        if (object instanceof List) {

            try (BufferedReader csvReader = new BufferedReader(new FileReader(file))) {
                while ((row = csvReader.readLine()) != null) {
                    data.addAll(Arrays.asList(row.split(";")));
                }
            } catch (IOException i) {
                System.out.println("Break");
            }
            return data;
        } else if (object instanceof Map) {

            BufferedReader csvReader = new BufferedReader(new FileReader(file));
            while ((row = csvReader.readLine()) != null) {
                data.addAll(Arrays.asList(row.split(";")));
            }
            for (String string : data) {
                String[] dataForMap = string.split(",");
                if (dataForMap[1].contains(".")) {
                    items.put(dataForMap[0], Float.parseFloat(dataForMap[1]));
                } else
                    items.put(dataForMap[0], Integer.parseInt(dataForMap[1]));
            }

            return items;
        } else
            return null;
    }
}