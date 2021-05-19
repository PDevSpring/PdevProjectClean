package com.dari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.model.FileDB;

@Repository
public interface FileDBRepository extends CrudRepository<FileDB, Long>{

}
