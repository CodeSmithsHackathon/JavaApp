package com.codesmiths.priority;

import com.codesmiths.Email;

public class PriorityEngine {
    // Calculates the score of the email and sets the priority of the email
    public static void calculatePriority(Email e) {
        e.setPriority(Priority.LOW);
    }
}
