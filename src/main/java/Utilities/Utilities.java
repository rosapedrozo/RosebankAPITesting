package Utilities;

import java.util.List;

public class Utilities {

    /***
     * Method to avoid email duplication
     *
     * @param clients
     * @return response
     */
    public static boolean isEmailrepeated(List<ClientsPOJO>clients){
        boolean response = false;
          for (ClientsPOJO c: clients ){
              int count = 0;
            for (ClientsPOJO currentc: clients){

                if (c.getEmail().equals(currentc.getEmail())){
                    count++;
                    if(count>=2){
                        System.out.println(c.getEmail() + currentc.getEmail());
                        response=true;
                    }

                }
            }

        }
        return response;

    }
}
