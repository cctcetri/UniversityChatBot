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
        //JSON 객체 생성
        JSONObject js = new JSONObject();
        JSONArray jsArr = new JSONArray();
        
        JSONObject js2 = new JSONObject();
        JSONArray jsArr2 = new JSONArray();
        
   
        //버튼에 들어갈 텍스트 넣어주기
      //  jsArr.add("say hello");
      //  jsArr.add("say bye");
        jsArr.add("안녕 한성봇!!");
       
     
        
        
        js.put("type", "buttons");
        js.put("buttons", jsArr);
        
     
    
        //home keyboard 설정해주기
      //  js.put("type", "buttons");

     
       
        //완성된 JSON 내보내기
        return js;
    }
  
	 public void EchoClient(){
		  try{
		   Socket s = new Socket("localhost",3000);
		   
		   OutputStream os = s.getOutputStream();
		   InputStream is = s.getInputStream();
		   BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
		   BufferedReader br = new BufferedReader(new InputStreamReader(is));
		   
		   bw.write(" => 클라이언트 입니다. \n");
		   bw.flush();
		   
		   
		   String message = br.readLine();
		   System.out.println("[서버 메세지] " + message);
		   if(message.equals("교수님 정보"));
		   {
			   state=1;
			   message="대화시작";
		   }
		  }catch(UnknownHostException e){
		   System.out.println("[경고] 서버를 찾을 수 없습니다.");
		  }catch(IOException e){
		   System.out.println("[경고] 사용되지 않는 PORT 번호 입니다.");
		  }
		 }
		 
		 public static void main(String[] args){
		  new homeKeyboard();
		 }


	}

