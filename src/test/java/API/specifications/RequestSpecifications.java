package API.specifications;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public final class RequestSpecifications {

    public static RequestSpecification specWithoutAuth(RequestSpecification specification) {
        return RestAssured
                .given()
                .spec(specification);
    }
}
