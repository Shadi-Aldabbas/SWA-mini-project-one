package com.miniOne.MiniOne.repository;

import com.miniOne.MiniOne.entity.Batch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepo extends CrudRepository<Batch,Integer> {
}
