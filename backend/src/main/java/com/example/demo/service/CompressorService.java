package com.example.demo.service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompressorService {

    public String compressString(String stringToCompress) {
        int length = stringToCompress.length();

        // If string is empty, then returns empty
        if (length == 0) return "";


        String compressedString = "";

        int amount = 1;

        // Loop through every character
        for (int i = 0; i < length - 1; i++) {

            // Get the current and next charters
            char current = stringToCompress.charAt(i);
            char next = stringToCompress.charAt(i + 1);

            // Check if still on the same letter
            // If next letter is different, add the current letter and the amount
            if (current != next) {
                compressedString += current;
                compressedString += Character.forDigit(amount, 10);

                // If it's the last character, and it's alone add it
                // (Needed for string who ends a single character. For example: aaab)
                if (i == length - 2) {
                    compressedString += next;
                    compressedString += '1';
                }

                amount = 1;

                // If it's the last character add it
            } else if (i == length - 2) {
                compressedString += current;
                compressedString += Character.forDigit(++amount, 10);
                // If it is not the last character and the next  one is the same as the previous
                // increase amount
            } else {
                amount++;
            }
        }

        return compressedString;
    }

    public String decompressString(String stringToDecompress) {
        int length = stringToDecompress.length();

        String decompressed = "";

        if (length == 0) return "";

        // Get the first two characters
        char letter = stringToDecompress.charAt(0);
        String number = String.valueOf(stringToDecompress.charAt(1));

        // If the length is 2 decompress here
        if (length == 2) {
            for (int i = 0; i < Integer.parseInt(number); i++) decompressed += letter;
            return decompressed;
        }

        // If the string is longer than two characters, loop through it
        for (int i = 1; i < length - 1; i++) {
            char next = stringToDecompress.charAt(i + 1);

            // If the next char is a letter, or it's the last char, decompress the last recorded letter and number
            if (next >= 97 || i == length - 2) {

                // If it's the last char, add it to the number string now
                // because the last if statement line won't be reached
                if (i == length - 2) number += next;

                int amount = Integer.parseInt(number);

                // Add repeated letters to the string
                for (int j = 0; j < amount; j++) {
                    decompressed += letter;
                }

                // Reset variables and continue
                letter = next;
                number = "";
                continue;
            }

            // If the next char is not a letter but instead a multiple digit number
            // add it to the number string
            number += next;
        }

        return decompressed;
    }
}
