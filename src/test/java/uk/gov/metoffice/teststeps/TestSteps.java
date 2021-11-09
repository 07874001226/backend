package uk.gov.metoffice.teststeps;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.gov.metoffice.stepinfo.MetSteps;
import uk.gov.metoffice.testbase.TestBase;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SerenityRunner.class)
public class TestSteps extends TestBase {

    static ValidatableResponse response;

    @Steps
    MetSteps metSteps;


    @Title("This will get three hourly Data")
    @Test
    public void threeHourlyData() {
        metSteps.getAllThreeHourlyDataInformation().log().all().statusCode(200);
    }
    @Title("This will Daily Data Data")
    @Test
    public void dailyData() {

        metSteps.getDailyDataInformation().log().all().statusCode(200);
    }

    @Title("This will get the Location ID for ‘Croydon")
    @Test
    public void locationIdCroydon() {

        response = metSteps.getAllThreeHourlyDataInformation();
        List<HashMap<String, String>> croydonMapList= response.extract().path("Locations.Location.findAll{it.name=='Croydon'}");
        System.out.println(croydonMapList);
        HashMap<String, String> croydonMap = croydonMapList.get(0);
        String id = croydonMap.get("id");
        System.out.println(id);

    }
    @Title("This will get the Location ID")
    @Test
    public void locationId() {

        response = metSteps.getAllThreeHourlyDataInformation();
        List<HashMap<String, String>> croydonMapList= response.extract().path("Locations.Location.findAll{it.id=='324152'}");
        System.out.println(croydonMapList);
        HashMap<String, String> croydonMap = croydonMapList.get(0);
        String id = croydonMap.get("id");
        System.out.println(id);

    }
   // x.SiteRep.DV.Location.Period[0].Rep[0].S

    @Title("This will get the WindSpeed")
    @Test
    public void windSpeed() {

        response = metSteps.getDailyDataInformation();
//        List<HashMap<String, String>> croydonMapList= response.extract().path("SiteRep.Wx.Param[10].findAll{it.id=='324152'}");
//        System.out.println(croydonMapList);
//        HashMap<String, String> croydonMap = croydonMapList.get(0);
//        String id = croydonMap.get("id");
//        System.out.println(id);
       // response.body("SiteRep.Wx.Param[10]", hasKey("$"))
       List<Integer> id = response.extract().path("data.findAll{it.id== 'SiteRep.Wx.Param[10]'}");
      // List<Integer> id = response.extract().path("data.findAll{it.name== 'S'}.id");

       // List<Integer> id = response.extract().path("data.findAll{it.id== 'SiteRep.Wx'}.Param[10].name");
        System.out.println("The search query is:" + id);

        //  .body("data.name",hasItem("S"))
               //  .body("data.name",hasItem("Wind Speed"));
//            response.body("limit", equalTo(10))
//                    .body("data.name", hasItem("Duracell - AA Batteries (8-Pack)"))
//                    .body("data.findAll{it.name=='McVities Biscuits18836'}", hasItems(hasEntry("manufacturer", "Duracell")));
      //  List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name== 'SiteRep.Wx.Param[10].name");
      //  System.out.println("The search query is:" + values);
        //System.out.println("------------------StartingTest---------------------------");
        //System.out.println("The values for item name Straight Talk SAMSUNG Galaxy A20, 32GB Black - Prepaid Smartphone are: " +values);
       // System.out.println("------------------End of Test---------------------------");
    }


    }