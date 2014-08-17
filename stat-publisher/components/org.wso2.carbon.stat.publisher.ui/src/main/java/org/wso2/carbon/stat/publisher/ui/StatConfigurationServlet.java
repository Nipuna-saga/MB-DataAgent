package org.wso2.carbon.stat.publisher.ui;

import org.wso2.carbon.stat.publisher.data.xsd.StatConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nipuna on 8/15/14.
 */
public class StatConfigurationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        boolean enable = false;
        String button_action = "";

        String username = "";
        String password = "";
        String URLAddress = "";

        boolean message_stat = false;
        boolean system_stat = false;
        boolean MB_stat = false;

        button_action = req.getParameter("saveButton");

        StatConfiguration statConfigurationSetObject=new StatConfiguration();
        if (button_action.equals("Save")) {

            enable = Boolean.getBoolean(req.getParameter("enable_check").toString());

            username = req.getParameter("username");
            password = req.getParameter("password");
            URLAddress = req.getParameter("url_address");

            message_stat = Boolean.parseBoolean(req.getParameter("message_stat_check"));
            system_stat = Boolean.parseBoolean(req.getParameter("system_stat_check"));
            MB_stat = Boolean.parseBoolean(req.getParameter("MB_stat_check"));

            statConfigurationSetObject.setEnableStatPublisher(enable);
            statConfigurationSetObject.setUsername(username.toString());
            statConfigurationSetObject.setPassword(password.toString());
            statConfigurationSetObject.setURL(URLAddress.toString());
            statConfigurationSetObject.setMessage_statEnable(message_stat);
            statConfigurationSetObject.setSystem_statEnable(system_stat);
            statConfigurationSetObject.setMB_statEnable(MB_stat);



        }



        StatPublisherClient client;
        String validateResponse;

        try {

            try {
                client = StatPublisherClient.getStatPublisherClient();

                validateResponse = client.setStatConfiguration(statConfigurationSetObject);

                if (button_action.equals("Reset")) {

                    validateResponse = "Successfully reset";

                }

                req.setAttribute("servlet_resp", validateResponse);
                req.getRequestDispatcher("/carbon/stat-publisher/index.jsp").forward(req, resp);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {


        }
    }


}
