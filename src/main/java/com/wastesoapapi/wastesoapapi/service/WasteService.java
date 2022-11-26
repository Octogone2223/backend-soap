package com.wastesoapapi.wastesoapapi.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wastesoapapi.wastesoapapi.entity.Waste;
import com.wastesoapapi.wastesoapapi.repository.WasteRepository;

@Service
public class WasteService implements IWasteService {
    @Autowired
    private WasteRepository wasteRepository;

    @Override
    public Waste getWasteById(String wasteId) {
        Waste obj = wasteRepository.findWasteByWasteId(wasteId);
        return obj;
    }
    @Override
    public List<Waste> getAllWastes(){
        List<Waste> list = new ArrayList<>();
        wasteRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
    @Override
    public synchronized boolean addWaste(Waste waste){
        waste = wasteRepository.save(waste);
        return true;
    }
    @Override
    public void updateWaste(Waste waste) {
        wasteRepository.save(waste);
    }
    @Override
    public void deleteWaste(Waste waste) {
        wasteRepository.delete(waste);
    }
}
