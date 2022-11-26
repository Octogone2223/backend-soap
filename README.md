# Octogone SOAP API - backend

## BDD
Utilisation d’une base de données Mongo Atlas —> cloud

## Dépendances

- Java
- Spring Boot
- Spring Data MongoDB
- JAXB
- WSDL

## Model

- Waste

  *_wasteid : id technique en base de données de l'élément*

  *label : libellé du déchet alimentaire.*

  *issuingCompany : compagnie émettrice du déchet alimentaire.*

  *quantity : quantité en kg de déchet alimentaire.*

  *expirationDate : date limite de consommation du produit.*

  *isCollected : le déchet alimentaire est-il récupérable --> limiter le gaspillage alimentaire.*

## Endpoints

- Lien WSDL:  http://localhost:8080/soapws/wastes.wsdl

- Add waste:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:was="http://www.wastesoapapi.com/waste-ws">
    <soapenv:Header/>
    <soapenv:Body>
        <was:addWasteRequest>
            <was:label>Pommes</was:label>
            <was:issuingCompany>Carrefour</was:issuingCompany>
            <was:quantity>11</was:quantity>
            <was:expirationDate>2022/10/10</was:expirationDate>
            <was:isCollected>true</was:isCollected>
        </was:addWasteRequest>
    </soapenv:Body>
</soapenv:Envelope> 
```

- Get all wastes:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:was="http://www.wastesoapapi.com/waste-ws">
    <soapenv:Header/>
    <soapenv:Body>
        <was:getAllWastesRequest/>
    </soapenv:Body>
</soapenv:Envelope>
```

- Get waste by id:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:was="http://www.wastesoapapi.com/waste-ws">
    <soapenv:Header/>
    <soapenv:Body>
        <was:getWasteByIdRequest>
            <was:wasteId>?</was:wasteId>
        </was:getWasteByIdRequest>
    </soapenv:Body>
</soapenv:Envelope>
```

- Update waste:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:was="http://www.wastesoapapi.com/waste-ws">
    <soapenv:Header/>
    <soapenv:Body>
        <was:updateWasteRequest>
            <was:wasteInfo>
                <was:wasteId>?</was:wasteId>
                <was:label>?</was:label>
                <was:issuingCompany>?</was:issuingCompany>
                <was:quantity>?</was:quantity>
                <was:expirationDate>?</was:expirationDate>
                <was:isCollected>?</was:isCollected>
            </was:wasteInfo>
        </was:updateWasteRequest>
    </soapenv:Body>
</soapenv:Envelope>
```
- Delete waste:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:was="http://www.wastesoapapi.com/waste-ws">
    <soapenv:Header/>
    <soapenv:Body>
        <was:deleteWasteRequest>
            <was:wasteId>?</was:wasteId>
        </was:deleteWasteRequest>
    </soapenv:Body>
</soapenv:Envelope>
```

