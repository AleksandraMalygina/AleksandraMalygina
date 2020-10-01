package hwjdi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hwjdi.beans.MetalColorEntity;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class DataProviders {
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

    @DataProvider(name = "expectedDataProvider")
    public Object[][] expectedDataProvider() {
        getDataFromJson();
        Object[][] expData = new Object[data.size()][];
        int i = 0;
        for (Map.Entry<String, MetalColorEntity> entry : data.entrySet()) {
            expData[i] = new Object[]{entry.getValue(), entry.getValue().getAsList()};
            i++;
        }
        return expData;
    }
}
