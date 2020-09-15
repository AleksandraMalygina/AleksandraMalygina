package hwjdi;

import hwjdi.beans.MetalColorEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataProviders {
    public static final String login = "Roman";
    public static final String password = "Jdi1234";
    public static final String userName = "ROMAN IOVLEV";


    private Map<String, MetalColorEntity> data = new HashMap<>();

    private Map<String, MetalColorEntity> getDataFromJson() {

        InputStream jsonStream = null;
        try {
            jsonStream =
            new FileInputStream("src/main/resources/jsons/JDI_ex8_metalsColorsDataSet.json");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Type dataSet = new TypeToken<HashMap<String, MetalColorEntity>>(){}.getType();

         try {
             data =
                     new Gson().fromJson(IOUtils.toString(jsonStream, "UTF-8"), dataSet);

         } catch (IOException ex) {
             ex.printStackTrace();
         }

        return data;
    }

    public Map<String, MetalColorEntity> getData() {
        getDataFromJson();
        return data;
    }
    
    public List<String> getExpectedDataAsText(MetalColorEntity entry) {
        List<String> dataList = new ArrayList<>();

        dataList.add("Summary: " + entry.getSummary()
                                            .stream()
                                            .mapToInt(Integer::intValue)
                                            .sum());
        dataList.add("Elements: " + entry.getElements()
                                            .stream()
                                            .collect(Collectors.joining(", ")));
        dataList.add("Color: " + entry.getColor());
        dataList.add("Metal: " + entry.getMetals());
        dataList.add("Vegetables: " + entry.getVegetables()
                                            .stream()
                                            .collect(Collectors.joining(", ")));
        return dataList;
    }

}
