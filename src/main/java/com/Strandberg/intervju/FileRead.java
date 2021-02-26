package com.Strandberg.intervju;

import com.mongodb.client.MongoClient;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileRead {
    public static List<String[]> getList(String filename){
        List<String[]> r= null;
        try (CSVReader reader = new CSVReader(new FileReader(filename))) {
             r = reader.readAll();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }
        return r;
    }
    public static ArrayList<Customer> getArraylist (List<String[]> oldlist){
        ArrayList<Customer> r = new ArrayList<Customer>();
        //skipped first line
        for (int i=1;i< oldlist.size();i++){

          if (oldlist.get(i).length==4){
              r.add(new Customer(oldlist.get(i)[0],Double.valueOf(oldlist.get(i)[1]),Double.valueOf(oldlist.get(i)[2]),Integer.parseInt(oldlist.get(i)[3])));
          }
        }
        return r;
    }
}
