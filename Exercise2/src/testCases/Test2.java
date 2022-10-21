package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class Test2 {

	@Test
	public void testCase2() {
		Response response = get("http://dummy.restapiexample.com/api/v1/employees");
		int status = response.getStatusCode();
		String body = response.getBody().asString();
		System.out.println("Response body:"+body);
		System.out.println("Status:"+status);
		Assert.assertEquals(status, 200);
	}
	
	@Test
	public void verifyEmployee() {
		given()
			.get("http://dummy.restapiexample.com/api/v1/employees")
		.then()
			.statusCode(200)
			.body("data.id[0]",equalTo(1)); //In this line I can verify the records of the data
	}
	
	@Test
	public void verifyEmployeeSalary() {
		given()
		.get("http://dummy.restapiexample.com/api/v1/employees")
	.then()
		.statusCode(200)
		.body("data.employee_salary[23]",equalTo(85600)); //In this line I can verify the records of the data
	}
}
