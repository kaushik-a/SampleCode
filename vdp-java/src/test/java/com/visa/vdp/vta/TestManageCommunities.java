package com.visa.vdp.vta;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import com.visa.vdp.utils.AbstractVisaAPIClient;
import com.visa.vdp.utils.MethodTypes;
import com.visa.vdp.utils.Property;
import com.visa.vdp.utils.VisaProperties;

public class TestManageCommunities {

	 AbstractVisaAPIClient abstractVisaAPIClient;
	 
	 @Test(groups = "vta")
     public void setUp() {
    	 this.abstractVisaAPIClient = new AbstractVisaAPIClient();
	 }
	
     @Test(groups = "vta")
     public void testGetCommunities() throws Exception {
         String baseUri = "vta/";
         String resourcePath = "v3/communities";
         
         Map<String,String> headers = new HashMap<String,String>();
         headers.put("ServiceId", VisaProperties.getProperty(Property.VTA_SERVICE_ID));
         CloseableHttpResponse response = this.abstractVisaAPIClient.doMutualAuthRequest(baseUri + resourcePath, "Get Communities Test", "", MethodTypes.GET, headers);
         Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
         response.close();
     }
}