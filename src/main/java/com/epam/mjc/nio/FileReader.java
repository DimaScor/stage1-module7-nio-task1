package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new java.io.FileReader(file))){
            while(reader.ready()){
                sb.append(reader.readLine()).append(" ");
            }
        }catch(IOException ignored){
            /*NOPE*/
        }

        ArrayList<String> list = new ArrayList<>(Arrays.asList(sb.toString().split(" ")));

        int indexName = list.indexOf("Name:");
        int indexAge = list.indexOf("Age:");
        int indexEmail = list.indexOf("Email:");
        int indexPhone = list.indexOf("Phone:");

        String name = list.get(indexName + 1);
        String email = list.get(indexEmail + 1);
        int age = 0;
        long phone = 0;

        try{
            age = Integer.parseInt(list.get(indexAge + 1));
            phone = Long.parseLong(list.get(indexPhone + 1));
        }catch (NumberFormatException ignored){
            /*NOPE*/
        }

        return new Profile(name, age, email, phone);
    }
}
