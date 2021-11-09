package uk.gov.metoffice.testbase;



import io.restassured.RestAssured;
import org.junit.BeforeClass;
import uk.gov.metoffice.utils.PropertyReader;

public class TestBase {

    //Get baseurl using propertyFile
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init(){
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");

    }

}
