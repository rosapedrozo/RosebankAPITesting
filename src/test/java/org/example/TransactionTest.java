package org.example;

import Utilities.ClientsPOJO;
import Utilities.GetDataPOJO;
import Utilities.Utilities;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class TransactionTest {

        String URL = "https://6087624ca3b9c200173b7f0f.mockapi.io/api/v7/bankrose";

    /** Validate that the Endpoint does not contain any data, it contains any data remove that.*/

        @Test
        public void verifyEndPointIsEmpty(){
            String response;
            response = given().contentType("application/json").when().get(URL).toString();
            if(response!="[ ]"){
                given().contentType("application/json").when().delete(URL);
            }
        }

    /** Create random data and validate duplication avoiding.*/
       @Test
        public void postRequest(){
            ///Given
            Response response;
           List<ClientsPOJO> clients = GetDataPOJO.getRandomClients(20);

           if (!Utilities.isEmailrepeated(clients)){
               response= given().contentType("application/json").body(clients).post(URL);
               assertEquals(201,response.getStatusCode());

           }else {
               System.out.println("Email is repeated, the process can not be completed");

           }

        }

    /** Validate that same email data can not be posted.*/
        @Test
        public void getRequest(){
            String EMAIL = "Pojopurina@yahoo.com";

            Map<String,String> client=new HashMap<String,String>();
            client.put("Name","Carlos");
            client.put("LastName","Perez");
            client.put("AccountNumber","1005487798");
            client.put("Ammount","2148");
            client.put("TransactionType","Carlos");
            client.put("Email",EMAIL);
            client.put("Active","true");
            client.put("Country","Peru");
            client.put("Telephone","3127894123");
            /// given
            Response response;

            /// when
                response = given().get(URL);
                response.then().assertThat().statusCode(200);

           List<String> emails = response.jsonPath().getList("Email");
           boolean emailExist = false;
           for(String e:emails){
               if(e.equals(EMAIL)) emailExist = true;

               System.out.println(e);
           }
            if(emailExist){
                System.out.println("Email already exist");

            }else {
                assertEquals(201,given().contentType("application/json").body(client).post(URL).getStatusCode());

            }


        }

    /** Verify that a record can be updated through a put request.*/
    @Test
    public void putRequest() {
        String putURL = "https://6087624ca3b9c200173b7f0f.mockapi.io/api/v7/bankrose/7";

        Map<String, String> client = new HashMap<String, String>();
        client.put("AccountNumber", "1021871309");
        /// given
        Response response;

        /// when
        response = given().contentType("application/json").body(client).put(putURL);
        response.then().assertThat().statusCode(200);
        assertEquals("1021871309",response.jsonPath().getString("AccountNumber"));
    }
    }
