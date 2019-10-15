import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class StringfyTest {
            
    public static void main(String[] args){
        
        String name = "Leonardo";
        Boolean engineer = true;
        Integer age = 25;
        
        String json = "{\"name\": \""+name+"\", \"java\":"+engineer+", \"sum\":"+age+"}";
        
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        String s = jsonObject.get("name").getAsString();
        Boolean b = jsonObject.get("java").getAsBoolean();
        Integer i = jsonObject.get("sum").getAsInt();
        
        System.out.println(s);
        System.out.println(b);
        System.out.println(i);
              
    }
    
}
