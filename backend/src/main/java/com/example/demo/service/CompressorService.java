package com.example.demo.service;

import com.example.demo.model.Compressor;
import com.example.demo.repo.CompressorMyBatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompressorService {

    @Autowired
    CompressorMyBatisRepository repo;

    public List<Compressor> getAllCompressed() {
        return repo.findAll();
    }

    public int addCompress(Compressor compressor) {
        String compressed = compressString(compressor.getDecompressed());
        compressor.setCompressed(compressed);
        return repo.insert(compressor);
    }

    private String compressString(String stringToCompress) {
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

    public Compressor getCompressorById(int id) {
        return repo.findById(id);
    }

    public int deleteById(int id) {
        return repo.deleteById(id);
    }
}
