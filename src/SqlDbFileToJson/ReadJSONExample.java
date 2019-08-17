package SqlDbFileToJson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.pojo.CspdclOutput;
 
public class ReadJSONExample
{
    @SuppressWarnings("unchecked")
    public  JSONArray FileToJsonArray(String path)
    {
    	 JSONArray employeeList =null;
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader(new File(path)))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
             employeeList = (JSONArray) obj;
            System.out.println(employeeList);
            
            ObjectMapper mapper = new ObjectMapper();
            List<CspdclOutput> cspdclOutputList = mapper.readValue(employeeList.toJSONString(), new TypeReference<List<CspdclOutput>>(){});
            System.out.println("list size= "+cspdclOutputList.size());
             
            //Iterate over employee array
//            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return employeeList;
    }
 
    private static void parseEmployeeObject(JSONObject employee)
    {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");
         
        //Get employee first name
        String firstName = (String) employeeObject.get("firstName");   
        System.out.println(firstName);
         
        //Get employee last name
        String lastName = (String) employeeObject.get("lastName"); 
        System.out.println(lastName);
         
        //Get employee website name
        String website = (String) employeeObject.get("website");   
        System.out.println(website);
    }
}