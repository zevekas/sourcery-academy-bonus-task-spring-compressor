package com.example.demo.model;

public class Compressor {
    private long id;
    private String decompressed;
    private String compressed;

    public Compressor() {

    }

    public Compressor(String decompressed) {
        this.decompressed = decompressed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDecompressed() {
        return decompressed;
    }

    public void setDecompressed(String decompressed) {
        this.decompressed = decompressed;
    }

    public String getCompressed() {
        return compressed;
    }

    public void setCompressed(String compressed) {
        this.compressed = compressed;
    }
}
