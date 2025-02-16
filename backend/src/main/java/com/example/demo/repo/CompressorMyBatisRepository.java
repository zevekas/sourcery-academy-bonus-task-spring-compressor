package com.example.demo.repo;

import com.example.demo.model.Compressor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompressorMyBatisRepository {
    @Select("SELECT * FROM compressor")
    public List<Compressor> findAll();

    @Select("SELECT * FROM compressor WHERE id = #{id}")
    public Compressor findById(long id);

    @Delete("DELETE FROM compressor WHERE id = #{id}")
    public int deleteById(long id);

    @Insert("INSERT INTO compressor(decompressed, compressed) " +
            "VALUES (#{decompressed}, #{compressed})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insert(Compressor compressor);
}
