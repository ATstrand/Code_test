package com.Strandberg.intervju;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class IntervjuApplication {
	private static String filepath = "prospects.txt";
	public static void start() throws Exception{
		List<String[]> lraw = FileRead.getList(filepath);
		ArrayList<Customer> customerList = FileRead.getArraylist(lraw);
		for (Customer c : customerList){
			System.out.println(c.getTextoutput());
		}

	}
	public static void main(String[] args) throws Exception {
		SpringApplication.run(IntervjuApplication.class, args);
		start();
	}


}

