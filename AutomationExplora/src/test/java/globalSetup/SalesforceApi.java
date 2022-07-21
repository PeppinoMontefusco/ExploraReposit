package globalSetup;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class SalesforceApi {

	public static String getSessionId() throws UnirestException {
		HttpResponse<String> response = Unirest.post("https://nextgenlux--preprod.my.salesforce.com/services/Soap/u/53.0")
				  .header("Content-Type", "text/xml")
				  .header("SOAPAction", "login")
				  .header("charset", "UTF-8")
				  .header("Accept", "text/xml")
				  .header("Cookie", "BrowserId=IoRIjwadEe2Vr_t6Vz_BoQ; CookieConsentPolicy=0:1; LSKey-c$CookieConsentPolicy=0:1")
				  .body("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<env:Envelope xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n    xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\">\n  <env:Body>\n    <n1:login xmlns:n1=\"urn:partner.soap.sforce.com\">\n      <n1:username><![CDATA[testing.api@explorajourneys.com.preprod]]></n1:username>\n      <n1:password><![CDATA[Nicolino2017!!!cX3rF0Cd5ACcaRDhVgIpLTrs]]></n1:password>\n    </n1:login>\n  </env:Body>\n</env:Envelope>")
				  .asString();
				String a =response.getBody();
				JSONObject soapDatainJsonObject = XML.toJSONObject(a);
			
				String result = soapDatainJsonObject.getJSONObject("soapenv:Envelope").getJSONObject("soapenv:Body").getJSONObject("loginResponse").getJSONObject("result").get("sessionId").toString();
				return result;

		
	}
	
	public static String getLeadId(String Id) throws UnirestException {
		HttpResponse<JsonNode> response = Unirest.get("https://nextgenlux--preprod.my.salesforce.com/services/data/v53.0/query/?q=SELECT%20FIELDS(All)%20FROM%20Lead%20Where%20Email='provaleadconv@yopmail.com'%20LIMIT%201")
				  .header("Content-Type", "application/json")
				  .header("Authorization", "Bearer " +Id)
				  .header("Cookie", "BrowserId=IoRIjwadEe2Vr_t6Vz_BoQ; CookieConsentPolicy=0:1; LSKey-c$CookieConsentPolicy=0:1")
				  .asJson();

		  var array=response.getBody().getObject();
	      JSONArray result = array.getJSONArray("records");
	      JSONObject object=(JSONObject) result.get(0);
	      String id=object.get("Id").toString();
	      return id;
	}
	
}
