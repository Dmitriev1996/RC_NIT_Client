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

import logic.entity.Teacher;

public class TeacherDAO {
	private HttpClient client=null;
	private HttpGet request=null;
	private HttpPost postreq=null;
	private HttpPut putreq=null;
	private HttpDelete delreq=null;
	private String URL="http://localhost:8080/WebJsp/webresources/Teacher/";
	private HttpResponse response=null;
	private BufferedReader rd=null;
	private GsonBuilder builder=null;
	private Gson gson;
	private StringEntity entity=null;
	private HttpParams params=null;
	
	public ArrayList<Teacher> getTeacherList() throws ClientProtocolException, IOException{
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
		Type type=new TypeToken<ArrayList<Teacher>>() {}.getType();
	    ArrayList<Teacher> teacherlist=gson.fromJson(json, type);
	    return teacherlist;
		
	}

}
