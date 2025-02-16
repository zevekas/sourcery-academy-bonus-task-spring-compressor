package com.example.demo.controller;


import com.example.demo.model.Compressor;
import com.example.demo.service.CompressorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CompressorController {

    @Autowired
    private CompressorService compressorService;

    @GetMapping("/compress")
    public ResponseEntity<List<Compressor>> getAllCompressed() {
        return new ResponseEntity<>(compressorService.getAllCompressed(), HttpStatus.OK);
    }

    @PostMapping("/compress")
    public ResponseEntity<?> addCompress(@RequestBody Compressor compressor) {
        return new ResponseEntity<>(compressorService.addCompress(compressor), HttpStatus.CREATED);
    }

    @DeleteMapping("/compress/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Compressor compressor = compressorService.getCompressorById(id);
        if (compressor != null) {
            compressorService.deleteById(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Compressor not found", HttpStatus.NOT_FOUND);
    }
}
