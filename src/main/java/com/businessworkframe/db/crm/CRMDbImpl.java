package com.businessworkframe.db.crm;

import com.businessworkframe.config.ObjectMapperConfig;
import com.businessworkframe.db.crm.CRMDb;

public class CRMDbImpl implements CRMDb {
    private final String URL = "https://projektskizze-a175.restdb.io/rest/crm-1";
    private final String XAPIKEY= "eaabcde666d8b00aa3ebf7e2c58aa29cfb44d" ;

    ObjectMapperConfig objectMapperConfig = new ObjectMapperConfig();
    public CRMDbImpl() {
        objectMapperConfig.configObjectMapper();
    }

    /*@Override
    public List<Crm> getAllCRMData() throws UnirestException {
       HttpResponse<JsonNode> jsonResponse = null;
        List<Crm> crmList = new ArrayList<>();
        try {
            crmList = Unirest.get(URL)
                    .header("x-apikey", XAPIKEY)
                    .header("cache-control", "no-cache")
                    .asObject(new GenericType<List<Crm>>(){}).getBody();
        }catch (UnirestException e){
            e.printStackTrace();
        }
        JSONObject jsonObject = jsonResponse.getBody().getObject();
        String name = (String) jsonObject.get("name");

        return crmList;
        //JsonFactory factory = new JsonFactory();
        //JsonParser parser = factory.createParser(response);
    }*/

}
