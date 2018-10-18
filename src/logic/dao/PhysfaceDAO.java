package logic.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import logic.entity.Physface;

public class PhysfaceDAO {
	private HttpClient client=null;
	private HttpGet request=null;
	private HttpPost postreq=null;
	private HttpPut putreq=null;
	private HttpDelete delreq=null;
	private String URL="http://localhost:8080/WebJsp/webresources/Physface/";
	private HttpResponse response=null;
	private BufferedReader rd=null;
	private GsonBuilder builder=null;
	private Gson gson;
	private StringEntity entity=null;
	private HttpParams params=null;
	
	public ArrayList<Physface> getPhysfaceList() throws ClientProtocolException, IOException{
		String json="";
		String str="";
		client=new DefaultHttpClient();
		request=new HttpGet(URL+"List");
		response=client.execute(request);
		rd=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		while((str=rd.readLine())!=null) {
			json+=str;
		}
		builder=new GsonBuilder();
		gson=builder.create();
		Type type=new TypeToken<ArrayList<Physface>>() {}.getType();
		ArrayList<Physface> physfacelist=gson.fromJson(json, type);
		return physfacelist;
	}
	
	public String insertPhysface(Physface physface) throws ClientProtocolException, IOException {
		String json="";
		   String str="";
		   builder=new GsonBuilder();
		   gson=builder.setPrettyPrinting().create();
		   json=gson.toJson(physface);
		   postreq=new HttpPost(URL+"Insert");
		   entity=new StringEntity(json, "UTF-8");
	       entity.setContentType("application/json");
	       entity.setContentEncoding("UTF-8");
	       postreq.setEntity(entity);
	       client=new DefaultHttpClient();
	       response=client.execute(postreq);
	       rd=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	       String obj="";
	       while((str=rd.readLine())!=null) {
	    	   obj+=str;
	       }
	       return gson.fromJson(obj, String.class);
	}
	
	public String updatePhysface(Physface physface) throws ClientProtocolException, IOException {
		String json="";
		   String str="";
		   builder=new GsonBuilder();
		   gson=builder.setPrettyPrinting().create();
		   json=gson.toJson(physface);
		   putreq=new HttpPut(URL+"Update");
		   entity=new StringEntity(json, "UTF-8");
	       entity.setContentType("application/json");
	       entity.setContentEncoding("UTF-8");
	       putreq.setEntity(entity);
	       client=new DefaultHttpClient();
	       response=client.execute(putreq);
	       rd=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	       String obj="";
	       while((str=rd.readLine())!=null) {
	    	   obj+=str;
	       }
	       return gson.fromJson(obj, String.class);
	}
	
	public String updatePhysfaceList(ArrayList<Physface> physfacelist) throws ClientProtocolException, IOException {
		String json="";
		   String str="";
		   builder=new GsonBuilder();
		   gson=builder.setPrettyPrinting().create();
		   json=gson.toJson(physfacelist);
		   putreq=new HttpPut(URL+"UpdateList");
		   entity=new StringEntity(json, "UTF-8");
	       entity.setContentType("application/json");
	       entity.setContentEncoding("UTF-8");
	       putreq.setEntity(entity);
	       client=new DefaultHttpClient();
	       response=client.execute(putreq);
	       rd=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	       String obj="";
	       while((str=rd.readLine())!=null) {
	    	   obj+=str;
	       }
	       return gson.fromJson(obj, String.class);
	}
	
	public String deletePhysface(Physface physface) throws ClientProtocolException, IOException {
		   String json="";
		   String str="";
		   builder=new GsonBuilder();
		   gson=builder.setPrettyPrinting().create();
		   json=gson.toJson(physface);
		   postreq=new HttpPost(URL+"Delete");
		   entity=new StringEntity(json, "UTF-8");
	       entity.setContentType("application/json");
	       entity.setContentEncoding("UTF-8");
	       postreq.setEntity(entity);
	       client=new DefaultHttpClient();
	       response=client.execute(postreq);
	       rd=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	       String obj="";
	       while((str=rd.readLine())!=null) {
	    	   obj+=str;
	       }
	       return gson.fromJson(obj, String.class);
	}
	
	public String deletePhysfaceList(ArrayList<Physface> physfacelist) throws ClientProtocolException, IOException {
		   String json="";
		   String str="";
		   builder=new GsonBuilder();
		   gson=builder.setPrettyPrinting().create();
		   json=gson.toJson(physfacelist);
		   postreq=new HttpPost(URL+"DeleteList");
		   entity=new StringEntity(json, "UTF-8");
	       entity.setContentType("application/json");
	       entity.setContentEncoding("UTF-8");
	       postreq.setEntity(entity);
	       client=new DefaultHttpClient();
	       response=client.execute(postreq);
	       rd=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	       String obj="";
	       while((str=rd.readLine())!=null) {
	    	   obj+=str;
	       }
	       return gson.fromJson(obj, String.class);
	}

}
