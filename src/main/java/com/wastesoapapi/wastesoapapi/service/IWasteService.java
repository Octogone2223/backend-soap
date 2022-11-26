package com.wastesoapapi.wastesoapapi.service;

import java.util.List;
import com.wastesoapapi.wastesoapapi.entity.Waste;

public interface IWasteService {
    List<Waste> getAllWastes();
    Waste getWasteById(String wasteId);
    boolean addWaste(Waste waste);
    void updateWaste(Waste waste);
    void deleteWaste(Waste waste);
}
