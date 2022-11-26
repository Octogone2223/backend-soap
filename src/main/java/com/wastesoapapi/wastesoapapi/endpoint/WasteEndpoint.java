package com.wastesoapapi.wastesoapapi.endpoint;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.wastesoapapi.wastesoapapi.entity.Waste;
import com.wastesoapapi.wastesoapapi.gs_ws.AddWasteRequest;
import com.wastesoapapi.wastesoapapi.gs_ws.AddWasteResponse;
import com.wastesoapapi.wastesoapapi.gs_ws.WasteInfo;
import com.wastesoapapi.wastesoapapi.gs_ws.DeleteWasteRequest;
import com.wastesoapapi.wastesoapapi.gs_ws.DeleteWasteResponse;
import com.wastesoapapi.wastesoapapi.gs_ws.GetAllWastesResponse;
import com.wastesoapapi.wastesoapapi.gs_ws.GetWasteByIdRequest;
import com.wastesoapapi.wastesoapapi.gs_ws.GetWasteByIdResponse;
import com.wastesoapapi.wastesoapapi.gs_ws.ServiceStatus;
import com.wastesoapapi.wastesoapapi.gs_ws.UpdateWasteRequest;
import com.wastesoapapi.wastesoapapi.gs_ws.UpdateWasteResponse;
import com.wastesoapapi.wastesoapapi.service.IWasteService;

@Endpoint
public class WasteEndpoint {
    private static final String NAMESPACE_URI = "http://www.wastesoapapi.com/waste-ws";
    @Autowired
    private IWasteService wasteService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getWasteByIdRequest")
    @ResponsePayload
    public GetWasteByIdResponse getWaste(@RequestPayload GetWasteByIdRequest request) {
        GetWasteByIdResponse response = new GetWasteByIdResponse();
        WasteInfo wasteInfo = new WasteInfo();
        BeanUtils.copyProperties(wasteService.getWasteById(request.getWasteId()), wasteInfo);
        response.setWasteInfo(wasteInfo);
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllWasteRequest")
    @ResponsePayload
    public GetAllWastesResponse getAllWastes() {
        GetAllWastesResponse response = new GetAllWastesResponse();
        List<WasteInfo> wasteInfoList = new ArrayList<>();
        List<Waste> wasteList = wasteService.getAllWastes();
        for (int i = 0; i < wasteList.size(); i++) {
            WasteInfo ob = new WasteInfo();
            BeanUtils.copyProperties(wasteList.get(i), ob);
            wasteInfoList.add(ob);
        }
        response.getWasteInfo().addAll(wasteInfoList);
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addWasteRequest")
    @ResponsePayload
    public AddWasteResponse addWaste(@RequestPayload AddWasteRequest request) {
        AddWasteResponse response = new AddWasteResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        Waste waste = new Waste();
        waste.setLabel(request.getLabel());
        waste.setIssuingCompany(request.getIssuingCompany());
        waste.setQuantity(request.getQuantity());
        waste.setExpirationDate(request.getExpirationDate());
        waste.setIsCollected(request.getIsCollected());
        boolean flag = wasteService.addWaste(waste);
        if (!flag) {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Content Already Available");
            response.setServiceStatus(serviceStatus);
        } else {
            WasteInfo wasteInfo = new WasteInfo();
            BeanUtils.copyProperties(waste, wasteInfo);
            response.setWasteInfo(wasteInfo);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Added Successfully");
            response.setServiceStatus(serviceStatus);
        }
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateWasteRequest")
    @ResponsePayload
    public UpdateWasteResponse updateWaste(@RequestPayload UpdateWasteRequest request) {
        Waste waste = new Waste();
        BeanUtils.copyProperties(request.getWasteInfo(), waste);
        wasteService.updateWaste(waste);
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatusCode("SUCCESS");
        serviceStatus.setMessage("Content Updated Successfully");
        UpdateWasteResponse response = new UpdateWasteResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteWasteRequest")
    @ResponsePayload
    public DeleteWasteResponse deleteWaste(@RequestPayload DeleteWasteRequest request) {
        Waste waste = wasteService.getWasteById(request.getWasteId());
        ServiceStatus serviceStatus = new ServiceStatus();
        if (waste == null ) {
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Content Not Available");
        } else {
            wasteService.deleteWaste(waste);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Deleted Successfully");
        }
        DeleteWasteResponse response = new DeleteWasteResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }
}
