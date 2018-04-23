#!/usr/bin/env groovy

// https://www.logicmonitor.com/support/terminology-syntax/scripting-support/access-a-website-from-groovy/

import com.santaba.agent.groovyapi.http.*;

class Basicauth {
	static void main(String[] args) {
		Basicauth test = new Basicauth();
		//test.httpPost();
		//test.basicAuth();
	}

	int httpPost() {
		// instantiate an http client object for the target system
		def ip="mydevice.com"
		def httpClient = HTTP.open(ip, 443);

		// use an authentication API call to initiate a session
		// specify the url to which we want to post
		def url = "https://"+ip+"/api/v310/session/login";
		def payload = '{"username":"myusername","typeId":"com.tintri.api.rest.vcommon.dto.rbac.RestApiCredentials","password":"mypassword"}';

		// do the post
		def postResponse = httpClient.post(url, payload,["Content-Type":"application/json"]);
		// does the response indicate a successful authentication?
		if ( !(httpClient.getStatusCode() =~ /200/) ) 
		{
			// no -- report an error, and return a non-zero exit code
			println "authentication failure";
			return(1);
		}
		// we are now authenticated. Subsequent GETs with the httpClient will pass in the session cookie 
		url="https://"+ip+"/api/info";
		def getResponse=httpClient.get(url);
		// print some data
		println httpClient.getResponseBody();
	}

	int basicAuth() {
		// instantiate an http client object for the target system
		def httpClient = HTTP.open("www.mysite.com",80);
		// set basic authentication credentials
		httpClient.setAuthentication("myusername","kkk");

		def url = "https://www.mysite.com/httpgallery/authentication/authenticatedimage/figure1.gif";
		
		def getResponse=httpClient.get(url);
		
		def headers=httpClient.getHeaders();
		
		println headers;
		def times=httpClient.getTimeStatistics();
		println "Connect Time "+times[0];
		println "Read Time "+times[1];
		
		httpClient.close();
		return 0;
	}
}
