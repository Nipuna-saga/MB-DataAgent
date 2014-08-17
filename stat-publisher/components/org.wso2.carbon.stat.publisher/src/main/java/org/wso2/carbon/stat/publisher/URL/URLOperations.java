package org.wso2.carbon.stat.publisher.URL;

import java.net.Socket;

/**
 * Created by nipuna on 8/15/14.
 */
public class URLOperations {



    public boolean URLValidator(String URLS) {

        boolean response = true;

        String[] URLArray = URLS.split(";");
        for (int count = 0; count < URLArray.length; count++) {

            try {

                String[] URLParts = URLArray[count].split(":");
                String IPAddress = URLParts[0];
                int portNumber = Integer.parseInt(URLParts[1]);


                Socket serverSocket = new Socket(IPAddress, portNumber);
            } catch (Exception e) {
                response = false;
            }


        }


        return response;


    }

}
