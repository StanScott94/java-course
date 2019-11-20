package com.stantonscott.javabasics.cashregister;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import static com.stantonscott.javabasics.cashregister.Main.*;

public class ReadFromFile implements Callable<List<String>> {

    private File file;

    public ReadFromFile(File file) {
        this.file = file;
    }


    @Override
    public List<String> call() throws Exception {
        String row = null;

        List<String> data = new ArrayList<>();
        try (BufferedReader csvReader = new BufferedReader(new FileReader(file))) {
            while ((row = csvReader.readLine()) != null) {
                data = Arrays.asList(row.split(";"));
            }
        } catch (IOException i) {
            System.out.println("Break");
        }

        return data;
    }
}