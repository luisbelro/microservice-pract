package com.asteci.customer.products.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.asteci.customer.products.dto.ProductDTO;
import com.asteci.customer.products.repository.ProductsRepository;

import lombok.extern.slf4j.Slf4j;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
public class JsonResourceUtils {

    public JsonResourceUtils() {
    }


    public static JSONObject getJsonObjFromConfiguration(){
        String FILENAME = "products.json";
        return getJsonObjFromResource(FILENAME);
    }

    public static JSONObject getJsonObjFromResource(String filename){
        JSONObject json = null;

        if (!filename.contains(".json")){
            filename += ".json";
        }

        try{
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
            if (inputStream != null){
                StringBuilder sb = new StringBuilder();
                InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader bfReader = new BufferedReader(reader);
                String content = null;
                while((content = bfReader.readLine()) != null){
                    sb.append(content);
                }
                bfReader.close();
                json = JSON.parseObject(sb.toString());
            }else{
                log.info("[{}] file not exist",filename);
            }

        }catch (Exception e){
            log.error("read file to string error",e);
        }

        return json;
    }

    public static List<ProductDTO> parseJsonArray(JSONObject json,String arg){
        JSONArray jsonArray = (JSONArray)json.get(arg);
        List<ProductDTO> listP  = (List<ProductDTO>)JSONArray.parseArray(jsonArray.toString(),ProductDTO.class);
      return listP;
    }

    
    public void putProducts() {
    	JSONObject json =  getJsonObjFromConfiguration();
        List<ProductDTO> listP = parseJsonArray(json,"listProducts");

        ProductsRepository.productDTOs = listP;
        
        
    }
   
}

