package com.codesmiths.mongoDB;

import com.codesmiths.Email;
import com.codesmiths.priority.PriorityEngine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MongoDBConnector {
    // Returns list of emails from MongoDB
    public static ArrayList<Email> getHackathonData() {
        // Temporary data pulled from a capture of the endpoint
        ArrayList<Email> emails = new ArrayList<Email>();

        String csvFile = "result.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] email = line.split(cvsSplitBy);
                Email e = new Email(email[5], email[1], email[0], email[2], email[4], new Date());

                PriorityEngine.calculatePriority(e);
                emails.add(e);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return emails;
    }

    // Tells MongoDB to update the data from the endpoint
    public static void updateHackathonData() {

    }
}