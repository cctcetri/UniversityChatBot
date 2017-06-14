package yellowid;

import com.amazonaws.services.lambda.runtime.Context;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.json.*;

import org.json.simple.*;
import org.json.simple.parser.*;
import java.util.Random;
public class message implements RequestHandler<JSONObject, JSONObject> {
	
	
	static String state="0";
    static ArrayList name= new ArrayList();
	static String name2[] = null;
	static int count;
	static int bab=0;
	static int bab1=0;
	boolean play=true;
	
   /* private static void run(String path, String encoding) {

        //BufferedReader br1 = null;
        //String line;
        //String cvsSplitBy = ",";
    
        
       try {
        	 count=0;
            br1 = new BufferedReader(new InputStreamReader(new FileInputStream(path), encoding));
            while (true) {
            	line = br1.readLine();
            	if(line==null)
            		break;
            	
            	name.add(line.split(cvsSplitBy)[0]); 
            //	name2[i]=(String) name.get(i);
           // 	System.out.println(name.get(i));
            	count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br1 != null) {
                try {
                    br1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }  */

	public JSONObject handleRequest(JSONObject input, Context context) {
		// 입력된 메시지에서 content만 뽑아내기
		//run("C:\\Users\\12김영대\\Desktop\\test.csv", "euc-kr");
		int button=0;

		String answer = input.get("content").toString();
		String b = null;
		String b2 = null;
		String b3 = null;
		String b4 = null;
		String b5 = null;
		String b6 = null;
		String b7 = null;
		String b8 = null;
		String b10 = null;
		String b11=null;
		int ts=0;
		JSONObject js = new JSONObject();
		JSONArray jsArr = new JSONArray();
		
	
		JSONObject jsMes = new JSONObject();
		JSONObject jsAns = new JSONObject();
		JSONObject jsAns1 = new JSONObject();
		JSONObject jsAns2 = new JSONObject();
	 
	
		
		try {
			

			BufferedReader br = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//kakao.php?test="+answer).openStream())); //교수님 전화번호
			
			BufferedReader br2 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//kakao2.php?test="+answer).openStream())); // 시설 전화번호
			BufferedReader br3 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//bab.php?test="+answer).openStream())); // 옛향 중식
			BufferedReader br4 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//bab2.php?test="+answer).openStream())); // 옛향 석식
			BufferedReader br5 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//bab3.php?test="+answer).openStream())); // 교직원 중식
			BufferedReader br6 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//bab4.php?test="+answer).openStream())); // 교직원 석식
			BufferedReader br7 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//kakao2.php?test="+answer).openStream())); // 교수님 e메일
			BufferedReader br8 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//date.php?test="+answer).openStream())); // 교수님 e메일
		

			b5= br5.readLine();
			b6= br6.readLine();
			b2= br2.readLine();
			b = br.readLine();
			b3 = br3.readLine();
			b4 = br4.readLine();
			b7 = br7.readLine();
			b8 = br8.readLine();
			System.out.println("ㅠ"); // print the string b

		} catch (IOException e) {
			System.out.println("error");
		}
		
		/*

		if (answer.equals("교수님 정보")) { // 새로운 버튼 불러오는 함수
			button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
			//System.out.println(name2[2]);
			jsArr.add("공대");
			jsArr.add("예대");
			jsArr.add("인문대");
			jsArr.add("사회과학대");
			
		//	System.out.println(name.get(2));
			jsAns.put("text", "만약 교수님 이름을 알고 있으시면 \n" + "'xxx 교수님'으로 입력하여 주시면 편리합니다");
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
	
			System.out.println("yoyo");

		}
		/
		if (answer.equals("공대")) { // 새로운 버튼 불러오는 함수
			jsArr.add("컴퓨터공학부");
			jsArr.add("전자정보공학과");
			jsArr.add("IT응용시스템공학과");
			jsArr.add("산업경영공학과");
			jsArr.add("기계시스템공학과");

			jsAns.put("text", "안녕 공대생!!");
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
		}
		if (answer.equals("컴퓨터공학부")) { // 새로운 버튼 불러오는 함수
			int a = 0;
			
			jsArr.add("학과사무실");
			jsArr.add("강희중교수님");
			jsArr.add("계희원교수님");
			jsArr.add("권영미교수님");
			jsArr.add("김남윤교수님");
			jsArr.add("김성동교수님");
			jsArr.add("김영웅교수님");
			jsArr.add("김진환교수님");
			jsArr.add("염종석교수님");
			jsArr.add("이석기교수님");
			jsArr.add("이재문교수님");
			jsArr.add("이항찬교수님");
			jsArr.add("장재영교수님");
			jsArr.add("정인상교수님");
			jsArr.add("조세홍교수님");
			jsArr.add("허준영교수님");
			jsArr.add("황기태교수님");
			jsArr.add("황호영교수님");
	
			jsAns.put("text", "교수님 이름을 입력해 주세요");
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
		
			button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
		}
		

	
		
		

		if (answer.equals("전자정보공학과")) { // 새로운 버튼 불러오는 함수
			int a = 0;

			jsArr.add("학과사무실");
			jsArr.add("정영모 교수님");
			jsArr.add("조혜경 교수님");
			jsArr.add("정성훈 교수님");
			jsArr.add("오종택 교수님");
			jsArr.add("김영웅 교수님");
			jsArr.add("김진환 교수님");
			jsArr.add("엄종석 교수님");
			jsArr.add("이석기 교수님");
			jsArr.add("이재문 교수님");
			jsArr.add("이항찬 교수님");
			jsArr.add("장재영 교수님");
			jsArr.add("정인상 교수님");
			jsArr.add("정인환 교수님");
			jsArr.add("조세홍 교수님");
			jsArr.add("최병수 교수님");
			jsArr.add("허준영 교수님");
			jsArr.add("황기태 교수님");
			jsArr.add("황호영 교수님");

			jsAns.put("text", "교수님 이름을 입력해 주세요");
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
	
			System.out.println("yoyo");
			button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
		}
		if (answer.equals("인문대")) { // 인문대 버튼
			jsArr.add("한국어문학부");
			jsArr.add("영어문학부");
			jsArr.add("역사문화학부");
			jsArr.add("지식문화학부");

			jsAns.put("text", "안녕~~@@");
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
	
			System.out.println("yoyo");
			button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
		}

		if (answer.equals("사회과학대")) { // 사회과학대 버튼
			jsArr.add("경영학부");
			jsArr.add("행정학과");
			jsArr.add("경제학과");
			jsArr.add("무역학과");
			jsArr.add("부동산학과");
			jsArr.add("부동산 세무경영학과");
			jsArr.add("공공인재학과");

			jsAns.put("text", "안녕~~@@");
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);

			System.out.println("yoyo");
			button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
		}

		if (answer.equals("예대")) { // 예대
			jsArr.add("무용학과");
			jsArr.add("회화과");
			jsArr.add("시각영상 디자인전공");
			jsArr.add("애니메이션 제품디자인전공");
			jsArr.add("인테리어디자인전공");
			jsArr.add("패션디자인전공");
			jsArr.add("의류패션산업전공");
			jsArr.add("패션학부");
			jsArr.add("뷰티디자인학과");

			jsAns.put("text", "안녕~~@@");
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
		
			System.out.println("yoyo");
			button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
		}
*/
		
	
		if (answer.equals("안녕 한성봇!!")){
			
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			jsAns.put("text", "안녕하세요 한성봇입니다\n"
					+ "버튼을 입력하면 버튼 모드가 동작합니다");
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			ts=1;
			button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
		}
	
	
		button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
		if (answer.equals("버튼")) { // 예대
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			jsAns.put("text", "원하시는 버튼을 입력 하여 주세요");
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			ts=1;
			button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
		}
		
		///////////////////////////////////////////////정보 검색 버튼
		if (answer.equals("정보검색")) { // 예대
			jsArr.add("교수님정보");
			jsArr.add("학식");
			jsArr.add("뒤로가기");
			jsArr.add("학사정보");
			
			

			jsAns.put("text", "최신 업데이트 정보 안내!!");
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			state="1";
			ts=1;
			button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
		}
		if (answer.equals("학사정보")) { // 예대
			jsArr.add("3월");
			jsArr.add("4월");
			jsArr.add("뒤로가기");
			jsArr.add("5월");
			jsArr.add("6월");
			jsArr.add("7월");
			jsArr.add("8월");
			
			jsAns.put("text", "궁굼하신 x월 학사 정보를 선택하여 주세요");
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			state="2";
			ts=1;
			button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
		}
		
		
	
	
		
		if (answer.equals("학식")) { // 예대
			jsArr.add("옛향");
			jsArr.add("교직원");
			jsArr.add("뒤로가기");

			jsAns.put("text", "저는 옛향을 주로 먹어요");
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			state="2";
			ts=1;
			button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
		}
		
	
	
		if (answer.equals("옛향")) { // 예대
			jsArr.add("월");
			jsArr.add("화");
			jsArr.add("뒤로가기");
			jsArr.add("수");
			jsArr.add("목");
			jsArr.add("금");
			
			jsAns.put("text", "요일을 선택하여 주세여");
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			state="3";
			bab=1;
			button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
			ts=1;
		}
		
		if (answer.equals("교직원")) {
			jsArr.add("월");
			jsArr.add("화");
			jsArr.add("뒤로가기");
			jsArr.add("수");
			jsArr.add("목");
			jsArr.add("금");
			
			jsAns.put("text", "요일을 선택하여 주세여");
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			state="3";
			bab=2;
			ts=1;
			button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
		}

		
	
		
		
		///////////////////////////////////////////////////////////// 깨알 꿀팁 버튼
		if (answer.equals("깨알꿀팁")) { // 예대
			
			jsArr.add("맛집추천");
			jsArr.add("시설안내");
			jsArr.add("뒤로가기");
			jsArr.add("학교홈페이지");
			
			state="1";
			jsAns.put("text","좋은 정보들 많아요!!" );
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			ts=1;
			button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
			
		}
		
if (answer.equals("학교홈페이지")) { // 예대
			
			jsArr.add("한성대학교");
			jsArr.add("종합정보시스템");
			jsArr.add("뒤로가기");
			jsArr.add("낙산의메아리");
			jsArr.add("학과홈페이지");
			jsArr.add("공지사항");
			
			jsAns.put("text","어느 홈페이지 보고싶으세요?" );
			state="4";
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			ts=1;
			button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
			
		}

if (answer.equals("학과홈페이지")) { // 새로운 버튼 불러오는 함수
	button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
	//System.out.println(name2[2]);
	jsArr.add("공대");
	jsArr.add("예대");
	jsArr.add("뒤로가기");
	jsArr.add("인문대");
	jsArr.add("사회과학대");
	state="5";
	
//	System.out.println(name.get(2));
	jsAns.put("text", "어느 학부를 원하시나요");
	jsMes.put("message", jsAns);

	jsAns2.put("type", "buttons");
	jsAns2.put("buttons", jsArr);
	jsMes.put("keyboard", jsAns2);

	ts=1;
}

if (answer.equals("공대")) { // 새로운 버튼 불러오는 함수
	jsArr.add("컴퓨터공학부");
	jsArr.add("전자정보공학과");
	jsArr.add("뒤로가기");
	jsArr.add("IT응용시스템공학과");
	jsArr.add("산업경영공학과");
	jsArr.add("기계시스템공학과");
	state="6";
	jsAns.put("text", "안녕 공대생!!");
	jsMes.put("message", jsAns);

	jsAns2.put("type", "buttons");
	jsAns2.put("buttons", jsArr);
	jsMes.put("keyboard", jsAns2);
	ts=1;
	button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
}
if (answer.equals("인문대")) { // 인문대 버튼
	jsArr.add("한국어문학부");
	jsArr.add("영어문학부");
	jsArr.add("뒤로가기");
	jsArr.add("역사문화학부");
	jsArr.add("지식문화학부");
	state="6";
	jsAns.put("text", "안녕~~@@");
	jsMes.put("message", jsAns);

	jsAns2.put("type", "buttons");
	jsAns2.put("buttons", jsArr);
	jsMes.put("keyboard", jsAns2);
	ts=1;
	System.out.println("yoyo");
	button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
}

if (answer.equals("사회과학대")) { // 사회과학대 버튼
	jsArr.add("경영학부");
	jsArr.add("행정학과");
	jsArr.add("뒤로가기");
	jsArr.add("경제학과");
	jsArr.add("무역학과");
	jsArr.add("부동산학과");
	jsArr.add("부동산 세무경영학과");
	jsArr.add("공공인재학과");
	state="6";
	jsAns.put("text", "안녕~~@@");
	jsMes.put("message", jsAns);

	jsAns2.put("type", "buttons");
	jsAns2.put("buttons", jsArr);
	jsMes.put("keyboard", jsAns2);
	ts=1;
	System.out.println("yoyo");
	button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
}

if (answer.equals("예대")) { // 예대
	jsArr.add("무용학과");
	jsArr.add("회화과");
	jsArr.add("뒤로가기");
	jsArr.add("시각영상 디자인전공");
	jsArr.add("애니메이션 제품디자인전공");
	jsArr.add("인테리어디자인전공");
	jsArr.add("패션디자인전공");
	jsArr.add("의류패션산업전공");
	jsArr.add("패션학부");
	jsArr.add("뷰티디자인학과");
	state="6";
	jsAns.put("text", "안녕~~@@");
	jsMes.put("message", jsAns);

	jsAns2.put("type", "buttons");
	jsAns2.put("buttons", jsArr);
	jsMes.put("keyboard", jsAns2);
	ts=1;
	System.out.println("yoyo");
	button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
}

	if (answer.equals("맛집추천")) { // 예대
			
			jsArr.add("한식-분식");
			jsArr.add("일식-중식");
			jsArr.add("뒤로가기");
			jsArr.add("피자-치킨");
			jsArr.add("배달");
			jsArr.add("아무거나");
			
			
			jsAns.put("text","저는 요즘 한성in라면 칼제비랑\n"
					+ "밥퍼스를 주로 가요" );
			state="4";
			jsAns.put("text","원하시는 버튼을 눌러주세요" );
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			ts=1;
			button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
			
		}
	

		///////////////////////////////////////////////////////////////뒤로가기
		if (answer.equals("뒤로가기")&&state=="1") { // 예대
			
			
			
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			jsAns.put("text", "버튼이라고 입력시면 버튼이 작동합니다");
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			ts=1;
			button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
			}
		
		
		if (answer.equals("뒤로가기")&&state=="2") { // 예대
			
			
			
			jsArr.add("교수님");
			jsArr.add("학사정보");
			jsArr.add("뒤로가기");
			jsArr.add("학식");
			
			jsAns.put("text", "최신 업데이트 정보 안내!!");
		
			state="1";
			jsMes.put("message", jsAns);
			ts=1;
			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
		
		}

	if (answer.equals("뒤로가기")&&state=="3") { // 예대
		
		
		
		jsArr.add("옛향");
		jsArr.add("교직원");
		jsArr.add("뒤로가기");
		state="2";
		jsAns.put("text","저는 주로 옛향을 먹죠" );
	
		
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);

		ts=1;
		button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
	
	}
	
	if (answer.equals("뒤로가기")&&state=="4") { // 예대
		
		
		
		jsArr.add("맛집추천");
		jsArr.add("시설안내");
		jsArr.add("뒤로가기");
		jsArr.add("학교홈페이지");
		state="1";
		jsAns.put("text","좋은 정보들 많아요!!" );
		
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		ts=1;
		button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
	
	}
	if (answer.equals("뒤로가기")&&state=="5") { // 예대
		
		
		
		jsArr.add("한성대학교");
		jsArr.add("종합정보시스템");
		jsArr.add("뒤로가기");
		jsArr.add("낙산의메아리");
		jsArr.add("학과홈페이지");
		jsArr.add("공지사항");
		
		jsAns.put("text","어느 홈페이지 보고싶으세요?" );
		state="4";

		
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		ts=1;
		button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
	
	}
	if (answer.equals("뒤로가기")&&state=="6") { // 예대
		
		
		
		button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
		//System.out.println(name2[2]);
		jsArr.add("공대");
		jsArr.add("예대");
		jsArr.add("뒤로가기");
		jsArr.add("인문대");
		jsArr.add("사회과학대");
		state="5";
		
//		System.out.println(name.get(2));
		jsAns.put("text", "어느 학부를 원하시나요");
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		ts=1;
		button=1; // 버튼을 정상적으로 호출하기 위한 상태 함수
	
	}
	//////////////////////////////////////////////////////////////////////////맛집
		
	if(answer.equals("한식-분식")){
		Random random = new Random();
		int r=random.nextInt(12);
		
		if(r==0){
			
			jsAns.put("text", "http://blog.naver.com/tjrsuqhqk/220972066473 \n\n"
					+ "밥퍼스\n"
					+ "전화번호:02-762-4437 \n"
					+ "배달가능여부: X");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
		}
		if(r==1){
			jsAns.put("text", "https://store.naver.com/restaurants/detail?id=752168392 \n\n"
					+ "윤가네\n"
					+ "전화번호:02-765-7179\n"
					+ "배달가능여부:X");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
		}
		if(r==2){
			jsAns.put("text", "https://store.naver.com/restaurants/detail?id=752168392 \n\n"
					+ "영웅\n"
					+ "전화번호:02-765-7179\n"
					+ "배달가능여부: O");
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		ts=1;
		button=1;
		}
		if(r==3){
			jsAns.put("text", "http://blog.naver.com/cuti1902/220197519436 \n\n"
					+ "큰뫼\n"
					+ "전화번호: X\n"
					+ "배달가능여부:X");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
		}
		if(r==4){	
		jsAns.put("text", "http://blog.naver.com/gyo1118?Redirect=Log&logNo=220873393635 \n\n"
				+ "라면일번지 \n"
				+ "전화번호:02-744-8014\n"
				+ "배달가능여부:X");
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
		ts=1;
		}
		if(r==5){	
			jsAns.put("text", "http://blog.naver.com/jiwoo090605/221001018877 \n\n"
					+ "치즈밥&고기주는 냉면\n"
					+ "전화번호:02-766-0228"
					+ "배달가능여부:O");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==6){	
			jsAns.put("text", "http://blog.naver.com/llillo2/220861599680 \n\n"
					+ "봉구스밥버거\n"
					+ "전화번호:02-741-2595\n"
					+ "배달O");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==7){	
			jsAns.put("text", "http://blog.naver.com/hongik9016/220985825512 \n\n"
					+ "한아름 \n"
					+ "전화번호:02-762-2277\n"
					+ "배달가능여부:X");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==8){	
			jsAns.put("text", 
					 "대학분식 \n"
					+ "전화번호:X\n"
					+ "배달가능여부:X");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==9){	
			jsAns.put("text", "https://store.naver.com/restaurants/detail?id=36727762 \n\n"
					+ "지지고 \n"
					+ "전화번호:02-741-3824\n"
					+ "배달가능여부:X");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==10){	
			jsAns.put("text", "http://blog.naver.com/warmspeech3/220491406658 \n\n"
					+ "바른생활 샌드위치 \n"
					+ "전화번호:02-3672-0915\n"
					+ "배달가능여부:X");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==11){	
			jsAns.put("text", 
					 "한성인라면집 \n"
					+ "전화번호:x\n"
					+ "배달가능여부:x");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==12){	
			jsAns.put("text", "http://blog.naver.com/suntr0208/220936763287 \n\n"
					+ "퐁닭퐁닭 \n"
					+ "전화번호:02-591-9940\n"
					+ "배달가능여부:X");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		button=0;
	}
		
		
	if(answer.equals("일식-중식")){
		Random random = new Random();
		int r=random.nextInt(20);
		
		if(r==0){	
			jsAns.put("text", "http://blog.naver.com/yongyewest/220840656780 \n\n"
					+ "사누끼 \n"
					+ "전화번호:02-900-2452\n"
					+ "배달가능여부:X");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==1){	
			jsAns.put("text", "http://blog.naver.com/llillo2/220861599680 \n\n"
					+ "하리원 \n"
					+ "전화번호:02-741-2595\n"
					+ "배달가능여부:O");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==2){	
			jsAns.put("text", "http://blog.naver.com/ppoby1004/220553102709 \n\n"
					+ "승리장 \n"
					+ "전화번호:02-765-1004\n"
					+ "배달가능여부:O");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==3){	
			jsAns.put("text", "http://blog.naver.com/daumcood/220865809396 \n\n"
					+ "스타동 \n"
					+ "전화번호:02-743-7707\n"
					+ "배달가능여부:X");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		button=0;
	}
	if(answer.equals("피자-치킨")){
		Random random = new Random();
		int r=random.nextInt(2);
		
		if(r==0){	
			jsAns.put("text", "https://mamis.modoo.at/ \n\n"
					+ "마미스 \n"
					+ "전화번호:02-3675-4929"
					+ "배달가능여부:O");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==1){	
			jsAns.put("text", "https://store.naver.com/restaurants/detail?id=35003497 \n\n"
					+ "피자Bell \n"
					+ "전화번호:02-749-3369\n"
					+ "배달가능여부:O");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==2){	
			jsAns.put("text", "http://blog.naver.com/chavely85/220645684762 \n\n"
					+ "대박치킨 \n"
					+ "전화번호:02-764-5874\n"
					+ "배달가능여부:X");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
	
		button=0;
	}
	if(answer.equals("배달")){
		Random random = new Random();
		int r=random.nextInt(2);
		
		if(r==0){
			jsAns.put("text", "https://store.naver.com/restaurants/detail?id=752168392 \n\n"
					+ "영웅\n"
					+ "전화번호:02-765-7179\n"
					+ "배달가능여부: O");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
		}
		if(r==1){	
			jsAns.put("text", "http://blog.naver.com/jiwoo090605/221001018877 \n\n"
					+ "치즈밥&고기주는 냉면\n"
					+ "전화번호:02-766-0228"
					+ "배달가능여부:O");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==2){	
			jsAns.put("text", "https://mamis.modoo.at/ \n\n"
					+ "마미스 \n"
					+ "전화번호:02-3675-4929"
					+ "배달가능여부:O");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==3){	
			jsAns.put("text", "http://blog.naver.com/llillo2/220861599680 \n\n"
					+ "하리원 \n"
					+ "전화번호:02-741-2595\n"
					+ "배달가능여부:O");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==4){	
			jsAns.put("text", "http://blog.naver.com/ppoby1004/220553102709 \n\n"
					+ "승리장 \n"
					+ "전화번호:02-765-1004\n"
					+ "배달가능여부:O");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==5){	
			jsAns.put("text", "https://store.naver.com/restaurants/detail?id=35003497 \n\n"
					+ "피자Bell \n"
					+ "전화번호:02-749-3369\n"
					+ "배달가능여부:O");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
	
	
	}
	
	if(answer.equals("아무거나")){
			Random random = new Random();
			int r=random.nextInt(20);
			
			if(r==0){
				jsAns.put("text", "http://blog.naver.com/tjrsuqhqk/220972066473 \n\n"
						+ "밥퍼스\n"
						+ "전화번호:02-762-4437 \n"
						+ "배달가능여부: X");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
			}
			if(r==1){
				jsAns.put("text", "https://store.naver.com/restaurants/detail?id=752168392 \n\n"
						+ "윤가네\n"
						+ "전화번호:02-765-7179\n"
						+ "배달가능여부:X");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
			}
			if(r==2){
				jsAns.put("text", "https://store.naver.com/restaurants/detail?id=752168392 \n\n"
						+ "영웅\n"
						+ "전화번호:02-765-7179\n"
						+ "배달가능여부: O");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
			}
			if(r==3){
				jsAns.put("text", "http://blog.naver.com/cuti1902/220197519436 \n\n"
						+ "큰뫼\n"
						+ "전화번호: X\n"
						+ "배달가능여부:X");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
			}
			if(r==4){	
			jsAns.put("text", "http://blog.naver.com/gyo1118?Redirect=Log&logNo=220873393635 \n\n"
					+ "라면일번지 \n"
					+ "전화번호:02-744-8014\n"
					+ "배달가능여부:X");
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
			if(r==5){	
				jsAns.put("text", "http://blog.naver.com/jiwoo090605/221001018877 \n\n"
						+ "치즈밥&고기주는 냉면\n"
						+ "전화번호:02-766-0228"
						+ "배달가능여부:O");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==6){	
				jsAns.put("text", "https://mamis.modoo.at/ \n\n"
						+ "마미스 \n"
						+ "전화번호:02-3675-4929"
						+ "배달가능여부:O");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==7){	
				jsAns.put("text", "http://blog.naver.com/yongyewest/220840656780 \n\n"
						+ "사누끼 \n"
						+ "전화번호:02-900-2452\n"
						+ "배달가능여부:X");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==8){	
				jsAns.put("text", "http://blog.naver.com/llillo2/220861599680 \n\n"
						+ "하리원 \n"
						+ "전화번호:02-741-2595\n"
						+ "배달가능여부:O");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==9){	
				jsAns.put("text", "https://store.naver.com/restaurants/detail?id=32430405 \n\n"
						+ "봉구스밥버거\n"
						+ "전화번호:02-741-6535\n"
						+ "배달X");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==10){	
				jsAns.put("text", "http://blog.naver.com/hongik9016/220985825512 \n\n"
						+ "한아름 \n"
						+ "전화번호:02-762-2277\n"
						+ "배달가능여부:X");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==11){	
				jsAns.put("text", 
						 "대학분식 \n"
						+ "전화번호:X\n"
						+ "배달가능여부:X");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==12){	
				jsAns.put("text", "https://store.naver.com/restaurants/detail?id=36727762 \n\n"
						+ "지지고 \n"
						+ "전화번호:02-741-3824\n"
						+ "배달가능여부:X");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==13){	
				jsAns.put("text", "http://blog.naver.com/warmspeech3/220491406658 \n\n"
						+ "바른생활 샌드위치 \n"
						+ "전화번호:02-3672-0915\n"
						+ "배달가능여부:X");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==14){	
				jsAns.put("text", "http://blog.naver.com/chavely85/220645684762 \n\n"
						+ "대박치킨 \n"
						+ "전화번호:02-764-5874\n"
						+ "배달가능여부:X");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==15){	
				jsAns.put("text", "http://blog.naver.com/ppoby1004/220553102709 \n\n"
						+ "승리장 \n"
						+ "전화번호:02-765-1004\n"
						+ "배달가능여부:O");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==16){	
				jsAns.put("text", 
						 "한성인라면집 \n"
						+ "전화번호:x\n"
						+ "배달가능여부:x");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==17){	
				jsAns.put("text", "http://blog.naver.com/daumcood/220865809396 \n\n"
						+ "스타동 \n"
						+ "전화번호:02-743-7707\n"
						+ "배달가능여부:X");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==18){	
				jsAns.put("text", "https://store.naver.com/restaurants/detail?id=20874411 \n\n"
						+ "우리집분식 \n"
						+ "전화번호:02-764-1388\n"
						+ "배달가능여부:X");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==19){	
				jsAns.put("text", "http://blog.naver.com/suntr0208/220936763287 \n\n"
						+ "퐁닭퐁닭 \n"
						+ "전화번호:02-591-9940\n"
						+ "배달가능여부:X");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==20){	
				jsAns.put("text", "https://store.naver.com/restaurants/detail?id=35003497 \n\n"
						+ "피자Bell \n"
						+ "전화번호:02-749-3369\n"
						+ "배달가능여부:O");
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
		
			
		 // 메세지를 정상적으로 호출하기 위한 상태 함수
			
		
			
		}
	
	////////////////////////////////////////////////////////////////////////교수님
	if (answer.equals("교수님정보")) {
		jsAns.put("text", "알고 싶은 교수님을 입력 하여 주세요\n\n"
				+ "ex)xxx교수님");	jsArr.add("대화시작");
				ts=1;
				button=0;	}
	
	if (answer.equals("한성대학교")) {
		jsAns.put("text", "http://www.hansung.ac.kr/web/www/home");
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	}
	if (answer.equals("공지사항")) {
		jsAns.put("text", "http://www.hansung.ac.kr/web/www/cmty_01_01");
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	}
	if (answer.equals("낙산의메아리")) {
		jsAns.put("text", "http://www.hansung.ac.kr/web/www/cmty_03_01");
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	}
	if (answer.equals("종합정보시스템")) {
		jsAns.put("text", "http://info.hansung.ac.kr/");
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	}
	
	if (answer.equals("컴퓨터공학부")) {
		jsAns.put("text", "http://cse.hansung.ac.kr/");
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	}
	if (answer.equals("전자정보공학과")) {
		jsAns.put("text", "http://www.hansung.ac.kr/~dice");
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	}
	if (answer.equals("IT응용시스템공학과")) {
		jsAns.put("text", "http://www.hansung.ac.kr/~ait");
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;

	}
	if (answer.equals("산업경영공학과")) {
		jsAns.put("text", "http://www.hansung.ac.kr/web/ie");
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	}
	if (answer.equals("기계시스템공학과")) {
		jsAns.put("text", "www.hansung.ac.kr/~me");
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	}
	
	
		

		
		//////////////////////////////////////////////////////////////
	
	if(answer.equals("이사장실")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n상상관 908호");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("비서실")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("대학원교학팀")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n상상관1002호");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("교수지원팀")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("학술자료팀")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("학사지원팀")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("학술정보팀")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n미래관2층");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("교육행정지원팀")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("학술정보관")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n미래관 1층~5층");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("기획전략팀")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("정보화팀")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n미래관2층");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("평가감사팀")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("대외홍보팀")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n우촌관603호");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("국제교류협력팀")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n우촌관302호");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("디자인아트평생교육원")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n학송관");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("예비군교육훈련")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n우촌관 313호");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("장학복지팀")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n진리관 1층");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("신학협력팀")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n우촌관610호");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("경력개발지원팀")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("학생상담센터")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n미래관 지하 1층");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("총무인사팀")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("양성평등상담소")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n미래관 B1층");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("재무회계팀")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n우촌관 305호");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("건강관리실")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n상상관 102호");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("우체국")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n중문 앞");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("입학기획팀")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("IPP사업단")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n상상관 402호");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type","buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("입학관리팀")){
		jsAns.put("text", "(전화번호)\n"+b2+"\n(위치)\n우촌관 304호");	
		jsArr.add("대화시작");
		jsArr.add("정보검색");
		jsArr.add("깨알꿀팁");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type","buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
		
		/////////////////////////////////////////////////////////////
		
		if(answer.equals("월")) {
			if(bab==1){
			String s2=b3.replaceAll("@@", "\n");
			String s3=b4.replaceAll("@@", "\n");
			s2=s2.replaceAll("@", "");
		    s3=s3.replaceAll("@", "");
		    jsAns.put("text", "<중식>\n "+s2+"\n\n<석식>\n "+s3);			
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			}
			if(bab==2){
				String s2=b5.replaceAll("@@", "\n");
				String s3=b6.replaceAll("@@", "\n");
				s2=s2.replaceAll("@", "");
			    s3=s3.replaceAll("@", "");
			    jsAns.put("text", "<중식>\n "+s2+"\n\n<석식>\n "+s3);			
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");

				ts=1;
				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
			}
		}
		if(answer.equals("화")) {
			if(bab==1){
				String s2=b3.replaceAll("@@", "\n");
				String s3=b4.replaceAll("@@", "\n");
				s2=s2.replaceAll("@", "");
			    s3=s3.replaceAll("@", "");
			    jsAns.put("text", "<중식>\n "+s2+"\n\n<석식>\n "+s3);			
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");

				ts=1;
				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				}
				if(bab==2){
					String s2=b5.replaceAll("@@", "\n");
					String s3=b6.replaceAll("@@", "\n");
					s2=s2.replaceAll("@", "");
				    s3=s3.replaceAll("@", "");
				    jsAns.put("text", "<중식>\n "+s2+"\n\n<석식>\n "+s3);			
					jsArr.add("대화시작");
					jsArr.add("정보검색");
					jsArr.add("깨알꿀팁");

					ts=1;
					
					jsMes.put("message", jsAns);

					jsAns2.put("type", "buttons");
					jsAns2.put("buttons", jsArr);
					jsMes.put("keyboard", jsAns2);
					button=1;
				}
		}
		if(answer.equals("수")) {
			if(bab==1){
				String s2=b3.replaceAll("@@", "\n");
				String s3=b4.replaceAll("@@", "\n");
				s2=s2.replaceAll("@", "");
			    s3=s3.replaceAll("@", "");
			    jsAns.put("text", "<중식>\n "+s2+"\n\n<석식>\n "+s3);			
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");

				ts=1;
				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				}
				if(bab==2){
					String s2=b5.replaceAll("@@", "\n");
					String s3=b6.replaceAll("@@", "\n");
					s2=s2.replaceAll("@", "");
				    s3=s3.replaceAll("@", "");
				    jsAns.put("text", "<중식>\n "+s2+"\n\n<석식>\n "+s3);			
					jsArr.add("대화시작");
					jsArr.add("정보검색");
					jsArr.add("깨알꿀팁");

					ts=1;
					
					jsMes.put("message", jsAns);

					jsAns2.put("type", "buttons");
					jsAns2.put("buttons", jsArr);
					jsMes.put("keyboard", jsAns2);
					button=1;
				}
		}
		if(answer.equals("목")) {
			if(bab==1){
				String s2=b3.replaceAll("@@", "\n");
				String s3=b4.replaceAll("@@", "\n");
				s2=s2.replaceAll("@", "");
			    s3=s3.replaceAll("@", "");
			    jsAns.put("text", "<중식>\n "+s2+"\n\n<석식>\n "+s3);			
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");

				ts=1;
				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				}
				if(bab==2){
					String s2=b5.replaceAll("@@", "\n");
					String s3=b6.replaceAll("@@", "\n");
					s2=s2.replaceAll("@", "");
				    s3=s3.replaceAll("@", "");
				    jsAns.put("text", "<중식>\n "+s2+"\n\n<석식>\n "+s3);			
					jsArr.add("대화시작");
					jsArr.add("정보검색");
					jsArr.add("깨알꿀팁");

					ts=1;
					
					jsMes.put("message", jsAns);

					jsAns2.put("type", "buttons");
					jsAns2.put("buttons", jsArr);
					jsMes.put("keyboard", jsAns2);
					button=1;
				}
		}
		if(answer.equals("금")) {
			if(bab==1){
				String s2=b3.replaceAll("@@", "\n");
				String s3=b4.replaceAll("@@", "\n");
				s2=s2.replaceAll("@", "");
			    s3=s3.replaceAll("@", "");
			    jsAns.put("text", "<중식>\n "+s2+"\n\n<석식>\n "+s3);			
				jsArr.add("대화시작");
				jsArr.add("정보검색");
				jsArr.add("깨알꿀팁");

				ts=1;
				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				}
				if(bab==2){
					String s2=b5.replaceAll("@@", "\n");
					String s3=b6.replaceAll("@@", "\n");
					s2=s2.replaceAll("@", "");
				    s3=s3.replaceAll("@", "");
				    jsAns.put("text", "<중식>\n "+s2+"\n\n<석식>\n "+s3);			
					jsArr.add("대화시작");
					jsArr.add("정보검색");
					jsArr.add("깨알꿀팁");

					ts=1;
					
					jsMes.put("message", jsAns);

					jsAns2.put("type", "buttons");
					jsAns2.put("buttons", jsArr);
					jsMes.put("keyboard", jsAns2);
					button=1;
				}
		}
		///////////////////////////////////////////////////////////////학사일정
		if (answer.equals("3월")) {
			String s2=b8.replaceAll("@@", "\n");
			String s3=s2.replaceAll("@", "\n");
			jsAns.put("text", s3);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("4월")) {
			String s2=b8.replaceAll("@@", "\n");
			String s3=s2.replaceAll("@", "\n");
			jsAns.put("text", s3);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("5월")) {
			String s2=b8.replaceAll("@@", "\n");
			String s3=s2.replaceAll("@", "\n");
			jsAns.put("text", s3);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("6월")) {
			String s2=b8.replaceAll("@@", "\n");
			String s3=s2.replaceAll("@", "\n");
			jsAns.put("text", s3);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("7월")) {
			String s2=b8.replaceAll("@@", "\n");
			String s3=s2.replaceAll("@", "\n");
			jsAns.put("text", s3);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("8월")) {
			String s2=b8.replaceAll("@@", "\n");
			String s3=s2.replaceAll("@", "\n");
			jsAns.put("text", s3);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		
		
		/////////////////////////////////////////////////////////////// 교수님 답변

		
		if(answer.equals("강희중교수님")||answer.equals("강희중교수님e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);		jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("계희원교수님")||answer.equals("계희원교수님e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("권영미교수님")||answer.equals("권영미교수님e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("김남윤교수님")||answer.equals("김남윤교수님e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("김성동교수님")||answer.equals("김성동교수님e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("김영웅교수님")||answer.equals("김영웅교수님e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("김진환교수님")||answer.equals("김진환교수님e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;

		}
		if (answer.equals("염종석교수님")||answer.equals("염종석교수님e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;

		}
		if (answer.equals("이석기교수님")||answer.equals("이석기교수님e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("이재문교수님")||answer.equals("이재문교수님e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
	
		if (answer.equals("이항찬교수님")||answer.equals("이항찬교수님e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		
		if (answer.equals("장재영교수님")||answer.equals("장재영교수님e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		
		if (answer.equals("정인상교수님")||answer.equals("정인상교수님e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			ts=1;
			jsAns.put("text",s1);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		
		if (answer.equals("조세홍교수님")||answer.equals("조세홍교수님e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			ts=1;
			jsAns.put("text",s1);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		
		if (answer.equals("허준영교수님")||answer.equals("허준영교수님e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			ts=1;
			jsAns.put("text",s1);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
	
		if (answer.equals("황기태교수님")||answer.equals("황기태교수님e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			ts=1;
			jsAns.put("text",s1);
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
	
		if (answer.equals("황호영교수님")||answer.equals("황호영교수님e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			ts=1;
			jsAns.put("text",s1);
			
			jsArr.add("대화시작");
			jsArr.add("정보검색");
			jsArr.add("깨알꿀팁");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
////////////////////////////////////////////////////////////////////////////`
		

		// say hello가 입력됐을 때


		if (answer.equals("대화시작")) {
			jsAns.put("text", "안녕~~");
			button=0; // 메세지를 정상적으로 호출하기 위한 상태 함수
			ts=1;
		}
	
			
		if (answer.equals("시설안내")) {
			jsAns.put("text", "(시설 이름을 정확히 입력하여 주세요)\n"
					+ "이사장실  "
					+ "입학관리팀 \n"
					+ "대학원교학팀  "
					+ "교수지원팀\n"
					+ "학술정보팀  "
					+ "교육행정지원팀\n"
					+ "학술정보관  "
					+ "기획전략팀\n"
					+ "정보화팀  "
					+ "평가감사팀\n"
					+ "대외홍보팀  "
					+ "국제교류협력팀\n"
					+ "디자인아트평생교육원  "
					+ "예비군교육훈련\n"
					+ "장학복지팀  "
					+ "신학협력팀\n"
					+ "경력개발지원팀  "
					+ "학생상담센터\n"
					+ "총무인사팀  "
					+ "양성평등상담소\n"
					+ "재무회계팀  "
					+ "건강관리실\n"
					+ "우체국  "
					+ "입학기획팀\n"
					+ "IPP사업단");
			ts=1;
			button=0; // 메세지를 정상적으로 호출하기 위한 상태 함수
		}
	
		if (answer.equals("자기소개")) {
			jsAns.put("text", "안녕 ~~나 한성봇이야 새벽에는 문자하면 안돼");
			button=0; // 메세지를 정상적으로 호출하기 위한 상태 함수
		}else if(ts==0){
			try{
			String count="1";
			String s5=answer.replaceAll(" ", "@");
			BufferedReader br12 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//kakaosend.php?send="+s5).openStream())); //교수님 전화번호
	
			BufferedReader br13 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//kakaomsg.php?state="+'1').openStream())); //교수님 전화번호
		
			BufferedReader br10 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//state2.php?state="+'5').openStream())); //교수님 전화번호
	
	
			}catch(IOException e){}
		
			// String erg = "2";
			
			

		//	b11= br13.readLine();
			try {
				Thread.sleep(1000);
				BufferedReader br11 = new BufferedReader(
						new InputStreamReader(new URL("http://52.78.94.234//kakaopy2.php?msg="+"1").openStream())); //교수님 전화번호
				b11= br11.readLine();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			System.out.println("ts들어옴");
			jsAns.put("text", b11);
			button=0; // 메세지를 정상적으로 호출하기 위한 상태 함수
		}

		



		/*
		 * js.put("type", "buttons"); js.put("buttons", "안녕");
		 */
		// say bye가 입력됐을 때

		// 내보낼 JSON인 jsMes에 if절로 만든 상황에 따른 답변을 넣어줍니다

		if(button==0){
			jsMes.put("message", jsAns);  //버튼이 아니라 message일때만  if문 안에 들어가야한다
			System.out.println("들어옴");
		}

		return jsMes;

	}

	private Object Stirng(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
