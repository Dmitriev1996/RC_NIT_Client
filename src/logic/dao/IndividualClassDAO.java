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

import logic.entity.IndividualClass;

public class IndividualClassDAO {
	private HttpClient client=null;
	private HttpGet request=null;
	private HttpPost postreq=null;
	private HttpPut putreq=null;
	private HttpDelete delreq=null;
	private String URL="http://localhost:8080/WebJsp/webresources/IndividualClass/";
	private HttpResponse response=null;
	private BufferedReader rd=null;
	private GsonBuilder builder=null;
	private Gson gson;
	private StringEntity entity=null;
	private HttpParams params=null;
	
	public ArrayList<IndividualClass> getClassList() throws ClientProtocolException, IOException{
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
		Type type=new TypeToken<ArrayList<IndividualClass>>() {}.getType();
		ArrayList<IndividualClass> classlist=gson.fromJson(json, type);
		return classlist;
	}
	
	public IndividualClass getClassById(int id) throws ClientProtocolException, IOException {
		   String json="";
		   String str="";
		   builder=new GsonBuilder();
		   gson=builder.setPrettyPrinting().create();
		   json=gson.toJson(id);
		   postreq=new HttpPost(URL+"GetById");
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
	       return gson.fromJson(obj, IndividualClass.class);
	}
	
	public ArrayList<IndividualClass> getClassListAtParams(String params) throws ClientProtocolException, IOException{
		String json="";
		String str="";
		builder=new GsonBuilder();
		gson=builder.setPrettyPrinting().create();
		json=gson.toJson(params);
		postreq=new HttpPost(URL+"ListAtParams");
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
	    Type type=new TypeToken<ArrayList<IndividualClass>>() {}.getType();
	    ArrayList<IndividualClass> list=gson.fromJson(obj, type);
	    return list;
	}
	
	public String insertClass(IndividualClass classes) throws ClientProtocolException, IOException {
		   String json="";
		   String str="";
		   builder=new GsonBuilder();
		   gson=builder.setPrettyPrinting().create();
		   json=gson.toJson(classes);
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
	
	public String updateClass(IndividualClass classes) throws ClientProtocolException, IOException {
		String json="";
		String str="";
		builder=new GsonBuilder();
		gson=builder.setPrettyPrinting().create();
		json=gson.toJson(classes);
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

}
