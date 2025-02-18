package com.example.demo.service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompressorService {

    public String compressString(String stringToCompress) {
        int length = stringToCompress.length();

        if (length == 0) return "";

        List<Character> compressedString = new ArrayList<>();

        int amount = 1;

        for (int i = 0; i < length - 1; i++) {

            char current = stringToCompress.charAt(i);
            char next = stringToCompress.charAt(i + 1);

            if (current != next) {
                compressedString.add(current);
                compressedString.add(Character.forDigit(amount, 10));

                if (i == length - 2) {
                    compressedString.add(next);
                    compressedString.add('1');
                }

                amount = 1;
            } else if (i == length - 2) {
                compressedString.add(current);
                compressedString.add(Character.forDigit(++amount, 10));
            } else {
                amount++;
            }
        }

        return compressedString.stream()
                .map(String::valueOf)
                .reduce("", String::concat);
    }

    public String decompressString(String stringToDecompress) {
        int length = stringToDecompress.length();

        String decompressed = "";

        char letter = stringToDecompress.charAt(0);
        String number = String.valueOf(stringToDecompress.charAt(1));

        for (int i = 1; i < length - 1; i++) {
            char next = stringToDecompress.charAt(i + 1);


            if (next >= 97 || i == length - 2) {

                if (i == length - 2) number += next;

                int amount = Integer.parseInt(number);

                for (int j = 0; j < amount; j++) {
                    decompressed += letter;
                }

                letter = next;
                number = "";
                continue;
            }

            number += next;
        }

        return decompressed;
    }
}
