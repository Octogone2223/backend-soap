package com.wastesoapapi.wastesoapapi.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("waste")
public class Waste {

    @Id
    private String wasteId;

    private String label;
    private String issuingCompany;
    private String quantity;
    private String expirationDate;
    private String isCollected;

    public Waste() {
    }

    public Waste(String label, String issuingCompany, String quantity, String expirationDate, String isCollected) {
        this.label = label;
        this.issuingCompany = issuingCompany;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.isCollected = isCollected;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIssuingCompany() {
        return issuingCompany;
    }

    public void setIssuingCompany(String issuingCompany) {
        this.issuingCompany = issuingCompany;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getIsCollected() {
        return isCollected;
    }

    public void setIsCollected(String isCollected) {
        this.isCollected = isCollected;
    }

    @Override
    public String toString() {
        return "Waste{" +
                "wasteId='" + wasteId + '\'' +
                ", label='" + label + '\'' +
                ", issuingCompany='" + issuingCompany + '\'' +
                ", quantity='" + quantity + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", isCollected='" + isCollected + '\'' +
                '}';
    }
}
