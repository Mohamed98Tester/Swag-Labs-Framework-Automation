package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataUtility {

    //TODO : Reading data from Properties File

    public static String getValue (String fileName , String key ) throws IOException {

        String Test_Data_Path = "src/test/resources/TestData/";

        Properties properties = new Properties();
        properties .load(new FileInputStream(Test_Data_Path + fileName+".properties"));
        return properties.getProperty(key);
    }




}
