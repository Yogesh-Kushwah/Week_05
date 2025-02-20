package com.practiceproblems.problem4;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.*;

public class MergeJsonObject {
    public JSONObject mergeObject(){
        JSONObject jsonObject1=new JSONObject();
        jsonObject1.put("name","Gagan");
        jsonObject1.put("age",21);
        jsonObject1.put("marks",450);
        JSONObject jsonObject2=new JSONObject();
        jsonObject2.put("city","bhopal");
        jsonObject2.put("id","id512");

        JSONObject mergedObject=new JSONObject();

        try{
            mergedObject=new JSONObject(jsonObject1,JSONObject.getNames(jsonObject1));
            for(String name:JSONObject.getNames(jsonObject2)){
                mergedObject.put(name, jsonObject2.get(name));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return mergedObject;
    }
    public static void main(String args[]){
        MergeJsonObject merge=new MergeJsonObject();
        JSONObject merged=merge.mergeObject();
        System.out.println(merged.toString());
    }
}
