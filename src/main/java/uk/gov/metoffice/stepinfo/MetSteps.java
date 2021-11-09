package uk.gov.metoffice.stepinfo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import uk.gov.metoffice.constant.EndPoint;

import java.util.HashMap;

public class MetSteps {
//    @Step("Get the all data ")
//    public ValidatableResponse getAllData() {
//        return SerenityRest.rest()
//                .given().log().all()
//                .accept("application/json")
//                .header("Content-Type", "application/json")
//                .when()
//                .get(EndPoint.Get_All_data)
//                .then();
//    }

    @Step("Getting all three hourly data information")
    public ValidatableResponse getAllThreeHourlyDataInformation() {
        return SerenityRest.rest()
                .given().accept("application/json")
                .when()
                .get(EndPoint.Get_All_three_hourly_forecast_data)
                .then();
    }

    @Step("Getting all daily data information")
    public ValidatableResponse getDailyDataInformation() {
        return SerenityRest.rest()
                .given().accept("application/json")
                .when()
                .get(EndPoint.Get_All_daily_forecast_data)
                .then();
    }





}
