package com.codesmiths.mongoDB;

import com.codesmiths.priority.Priority;
import com.codesmiths.structures.Email;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MongoDBConnector {
    // Returns list of emails from MongoDB
    public static List<Email> getHackathonData() {
        // Temporary data pulled from a capture of the endpoint
        ArrayList<Email> emails = new ArrayList<Email>();

        String csvFile = "result.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] email = line.split(cvsSplitBy);
                Email e = new Email(email[5], email[1], email[0], email[2], email[4], new Date(), Priority.LOW);

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

    public static boolean authenticateUser(String username, String password) {
        // Hash and salt password
        // Connect the MongoDB and authenticate user
        System.out.println("Username:" + username + "\nPassword: " + password);
        return true;
    }
}