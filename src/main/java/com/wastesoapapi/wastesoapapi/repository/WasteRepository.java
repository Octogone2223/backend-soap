package com.wastesoapapi.wastesoapapi.repository;

import com.wastesoapapi.wastesoapapi.entity.Waste;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface WasteRepository extends MongoRepository<Waste, String> {
    @Query("{name:'?0'}")
    Waste findWasteByWasteId(String wasteId);

}
