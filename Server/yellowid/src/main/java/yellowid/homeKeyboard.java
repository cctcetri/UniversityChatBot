package yellowid;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.json.*;


import java.io.*;
import java.net.*;

import org.json.simple.*;
import org.json.simple.parser.*;
public class homeKeyboard implements RequestHandler<JSONObject, JSONObject> {

	String a;
	int state=0;
    public JSONObject handleRequest(JSONObject input, Context context) {
        //JSON ��ü ����
        JSONObject js = new JSONObject();
        JSONArray jsArr = new JSONArray();
        
        JSONObject js2 = new JSONObject();
        JSONArray jsArr2 = new JSONArray();
        
   
        //��ư�� �� �ؽ�Ʈ �־��ֱ�
      //  jsArr.add("say hello");
      //  jsArr.add("say bye");
        jsArr.add("�ȳ� �Ѽ���!!");
       
     
        
        
        js.put("type", "buttons");
        js.put("buttons", jsArr);
        
     
    
        //home keyboard �������ֱ�
      //  js.put("type", "buttons");

     
       
        //�ϼ��� JSON ��������
        return js;
    }
  
	 public void EchoClient(){
		  try{
		   Socket s = new Socket("localhost",3000);
		   
		   OutputStream os = s.getOutputStream();
		   InputStream is = s.getInputStream();
		   BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
		   BufferedReader br = new BufferedReader(new InputStreamReader(is));
		   
		   bw.write(" => Ŭ���̾�Ʈ �Դϴ�. \n");
		   bw.flush();
		   
		   
		   String message = br.readLine();
		   System.out.println("[���� �޼���] " + message);
		   if(message.equals("������ ����"));
		   {
			   state=1;
			   message="��ȭ����";
		   }
		  }catch(UnknownHostException e){
		   System.out.println("[���] ������ ã�� �� �����ϴ�.");
		  }catch(IOException e){
		   System.out.println("[���] ������ �ʴ� PORT ��ȣ �Դϴ�.");
		  }
		 }
		 
		 public static void main(String[] args){
		  new homeKeyboard();
		 }


	}

