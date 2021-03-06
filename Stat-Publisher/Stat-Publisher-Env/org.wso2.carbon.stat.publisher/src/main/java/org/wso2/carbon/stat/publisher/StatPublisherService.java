package org.wso2.carbon.stat.publisher;

import org.wso2.carbon.context.CarbonContext;
import org.wso2.carbon.stat.publisher.internal.DTO.StatConfigurationDTO;
import org.wso2.carbon.stat.publisher.internal.util.URLOperations;
import org.wso2.carbon.stat.publisher.internal.data.StatConfiguration;

public class StatPublisherService {


    private StatConfigurationDTO StatConfigurationDTOObject;


    public StatConfiguration getStatConfiguration() {
        int tenantID = CarbonContext.getThreadLocalCarbonContext().getTenantId();
        //int tenantID=-1223;
        StatConfigurationDTOObject = new StatConfigurationDTO();
        return StatConfigurationDTOObject.ReadRegistry(tenantID);
    }


    //Credential details set method
    public boolean setStatConfiguration(StatConfiguration StatConfigurationData) {
        StatConfigurationDTOObject = new StatConfigurationDTO();
        StatConfigurationDTOObject.WriteRegistry(StatConfigurationData);


        return true;
    }

    //util validation method
    public boolean URLValidator(String URLS) {

        URLOperations URLValidatorObject = new URLOperations();
        return URLValidatorObject.URLValidator(URLS);


    }
}
