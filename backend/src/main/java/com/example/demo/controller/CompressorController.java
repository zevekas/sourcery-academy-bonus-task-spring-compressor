package com.example.demo.controller;

import com.example.demo.service.CompressorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class CompressorController {

    @Autowired
    private CompressorService compressorService;

    @GetMapping("/compress/{compress}")
    public ResponseEntity<String> compress(@PathVariable String toCompress) {
        return new ResponseEntity<String>(compressorService.compressString(toCompress), HttpStatus.OK);
    }

    @GetMapping("/compress/{decompress}")
    public ResponseEntity<String> decompress(@PathVariable String toCompress) {
        return new ResponseEntity<String>(compressorService.decompressString(toCompress), HttpStatus.OK);
    }

}
