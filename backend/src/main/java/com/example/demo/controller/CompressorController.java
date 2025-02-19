package com.example.demo.controller;

import com.example.demo.service.CompressorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class CompressorController {

    @Autowired
    private CompressorService compressorService;

    @GetMapping("/compress/{input}")
    public ResponseEntity<String> compress(@PathVariable String input) {
        return new ResponseEntity<String>(compressorService.compressString(input), HttpStatus.OK);
    }

    @GetMapping("/decompress/{input}")
    public ResponseEntity<String> decompress(@PathVariable String input) {
        return new ResponseEntity<String>(compressorService.decompressString(input), HttpStatus.OK);
    }

}
