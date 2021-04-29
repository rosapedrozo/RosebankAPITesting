package Utilities;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class GetDataPOJO {

    /***
     * Method for getting fake random data from the clients POJO
     *
     * @param quantity
     * @return clients
     */

    public static List<ClientsPOJO> getRandomClients(int quantity){
        List<ClientsPOJO> clients = new ArrayList<ClientsPOJO>();
        for (int i = 0; i < quantity; i++) {
            ClientsPOJO client = new ClientsPOJO();
            Faker faker = new Faker();

            client.setName(faker.name().firstName());
            client.setLastname(faker.name().lastName());
            client.setAccountNumber(faker.finance().creditCard());
            client.setAmount(faker.number().digits(5));
            client.setTransactionType("Invoce");
            client.setEmail(faker.internet().emailAddress());
            client.setActive(true);
            client.setCountry(faker.address().country());
            client.setTelephone("+57"+faker.number().digits(10));

            clients.add(client);

        }


        return clients;


    }
}
