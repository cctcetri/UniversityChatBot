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
		// �Էµ� �޽������� content�� �̾Ƴ���
		//run("C:\\Users\\12�迵��\\Desktop\\test.csv", "euc-kr");
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
					new InputStreamReader(new URL("http://52.78.94.234//kakao.php?test="+answer).openStream())); //������ ��ȭ��ȣ
			
			BufferedReader br2 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//kakao2.php?test="+answer).openStream())); // �ü� ��ȭ��ȣ
			BufferedReader br3 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//bab.php?test="+answer).openStream())); // ���� �߽�
			BufferedReader br4 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//bab2.php?test="+answer).openStream())); // ���� ����
			BufferedReader br5 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//bab3.php?test="+answer).openStream())); // ������ �߽�
			BufferedReader br6 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//bab4.php?test="+answer).openStream())); // ������ ����
			BufferedReader br7 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//kakao2.php?test="+answer).openStream())); // ������ e����
			BufferedReader br8 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//date.php?test="+answer).openStream())); // ������ e����
		

			b5= br5.readLine();
			b6= br6.readLine();
			b2= br2.readLine();
			b = br.readLine();
			b3 = br3.readLine();
			b4 = br4.readLine();
			b7 = br7.readLine();
			b8 = br8.readLine();
			System.out.println("��"); // print the string b

		} catch (IOException e) {
			System.out.println("error");
		}
		
		/*

		if (answer.equals("������ ����")) { // ���ο� ��ư �ҷ����� �Լ�
			button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
			//System.out.println(name2[2]);
			jsArr.add("����");
			jsArr.add("����");
			jsArr.add("�ι���");
			jsArr.add("��ȸ���д�");
			
		//	System.out.println(name.get(2));
			jsAns.put("text", "���� ������ �̸��� �˰� �����ø� \n" + "'xxx ������'���� �Է��Ͽ� �ֽø� ���մϴ�");
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
	
			System.out.println("yoyo");

		}
		/
		if (answer.equals("����")) { // ���ο� ��ư �ҷ����� �Լ�
			jsArr.add("��ǻ�Ͱ��к�");
			jsArr.add("�����������а�");
			jsArr.add("IT����ý��۰��а�");
			jsArr.add("����濵���а�");
			jsArr.add("���ý��۰��а�");

			jsAns.put("text", "�ȳ� �����!!");
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
		}
		if (answer.equals("��ǻ�Ͱ��к�")) { // ���ο� ��ư �ҷ����� �Լ�
			int a = 0;
			
			jsArr.add("�а��繫��");
			jsArr.add("�����߱�����");
			jsArr.add("�����������");
			jsArr.add("�ǿ��̱�����");
			jsArr.add("�賲��������");
			jsArr.add("�輺��������");
			jsArr.add("�迵��������");
			jsArr.add("����ȯ������");
			jsArr.add("������������");
			jsArr.add("�̼��ⱳ����");
			jsArr.add("���繮������");
			jsArr.add("������������");
			jsArr.add("���翵������");
			jsArr.add("���λ󱳼���");
			jsArr.add("����ȫ������");
			jsArr.add("���ؿ�������");
			jsArr.add("Ȳ���±�����");
			jsArr.add("Ȳȣ��������");
	
			jsAns.put("text", "������ �̸��� �Է��� �ּ���");
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
		
			button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
		}
		

	
		
		

		if (answer.equals("�����������а�")) { // ���ο� ��ư �ҷ����� �Լ�
			int a = 0;

			jsArr.add("�а��繫��");
			jsArr.add("������ ������");
			jsArr.add("������ ������");
			jsArr.add("������ ������");
			jsArr.add("������ ������");
			jsArr.add("�迵�� ������");
			jsArr.add("����ȯ ������");
			jsArr.add("������ ������");
			jsArr.add("�̼��� ������");
			jsArr.add("���繮 ������");
			jsArr.add("������ ������");
			jsArr.add("���翵 ������");
			jsArr.add("���λ� ������");
			jsArr.add("����ȯ ������");
			jsArr.add("����ȫ ������");
			jsArr.add("�ֺ��� ������");
			jsArr.add("���ؿ� ������");
			jsArr.add("Ȳ���� ������");
			jsArr.add("Ȳȣ�� ������");

			jsAns.put("text", "������ �̸��� �Է��� �ּ���");
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
	
			System.out.println("yoyo");
			button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
		}
		if (answer.equals("�ι���")) { // �ι��� ��ư
			jsArr.add("�ѱ���к�");
			jsArr.add("����к�");
			jsArr.add("���繮ȭ�к�");
			jsArr.add("���Ĺ�ȭ�к�");

			jsAns.put("text", "�ȳ�~~@@");
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
	
			System.out.println("yoyo");
			button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
		}

		if (answer.equals("��ȸ���д�")) { // ��ȸ���д� ��ư
			jsArr.add("�濵�к�");
			jsArr.add("�����а�");
			jsArr.add("�����а�");
			jsArr.add("�����а�");
			jsArr.add("�ε����а�");
			jsArr.add("�ε��� �����濵�а�");
			jsArr.add("���������а�");

			jsAns.put("text", "�ȳ�~~@@");
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);

			System.out.println("yoyo");
			button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
		}

		if (answer.equals("����")) { // ����
			jsArr.add("�����а�");
			jsArr.add("ȸȭ��");
			jsArr.add("�ð����� ����������");
			jsArr.add("�ִϸ��̼� ��ǰ����������");
			jsArr.add("���׸������������");
			jsArr.add("�мǵ���������");
			jsArr.add("�Ƿ��мǻ������");
			jsArr.add("�м��к�");
			jsArr.add("��Ƽ�������а�");

			jsAns.put("text", "�ȳ�~~@@");
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
		
			System.out.println("yoyo");
			button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
		}
*/
		
	
		if (answer.equals("�ȳ� �Ѽ���!!")){
			
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			jsAns.put("text", "�ȳ��ϼ��� �Ѽ����Դϴ�\n"
					+ "��ư�� �Է��ϸ� ��ư ��尡 �����մϴ�");
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			ts=1;
			button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
		}
	
	
		button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
		if (answer.equals("��ư")) { // ����
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			jsAns.put("text", "���Ͻô� ��ư�� �Է� �Ͽ� �ּ���");
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			ts=1;
			button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
		}
		
		///////////////////////////////////////////////���� �˻� ��ư
		if (answer.equals("�����˻�")) { // ����
			jsArr.add("����������");
			jsArr.add("�н�");
			jsArr.add("�ڷΰ���");
			jsArr.add("�л�����");
			
			

			jsAns.put("text", "�ֽ� ������Ʈ ���� �ȳ�!!");
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			state="1";
			ts=1;
			button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
		}
		if (answer.equals("�л�����")) { // ����
			jsArr.add("3��");
			jsArr.add("4��");
			jsArr.add("�ڷΰ���");
			jsArr.add("5��");
			jsArr.add("6��");
			jsArr.add("7��");
			jsArr.add("8��");
			
			jsAns.put("text", "�ñ��Ͻ� x�� �л� ������ �����Ͽ� �ּ���");
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			state="2";
			ts=1;
			button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
		}
		
		
	
	
		
		if (answer.equals("�н�")) { // ����
			jsArr.add("����");
			jsArr.add("������");
			jsArr.add("�ڷΰ���");

			jsAns.put("text", "���� ������ �ַ� �Ծ��");
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			state="2";
			ts=1;
			button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
		}
		
	
	
		if (answer.equals("����")) { // ����
			jsArr.add("��");
			jsArr.add("ȭ");
			jsArr.add("�ڷΰ���");
			jsArr.add("��");
			jsArr.add("��");
			jsArr.add("��");
			
			jsAns.put("text", "������ �����Ͽ� �ּ���");
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			state="3";
			bab=1;
			button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
			ts=1;
		}
		
		if (answer.equals("������")) {
			jsArr.add("��");
			jsArr.add("ȭ");
			jsArr.add("�ڷΰ���");
			jsArr.add("��");
			jsArr.add("��");
			jsArr.add("��");
			
			jsAns.put("text", "������ �����Ͽ� �ּ���");
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			state="3";
			bab=2;
			ts=1;
			button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
		}

		
	
		
		
		///////////////////////////////////////////////////////////// ���� ���� ��ư
		if (answer.equals("���˲���")) { // ����
			
			jsArr.add("������õ");
			jsArr.add("�ü��ȳ�");
			jsArr.add("�ڷΰ���");
			jsArr.add("�б�Ȩ������");
			
			state="1";
			jsAns.put("text","���� ������ ���ƿ�!!" );
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			ts=1;
			button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
			
		}
		
if (answer.equals("�б�Ȩ������")) { // ����
			
			jsArr.add("�Ѽ����б�");
			jsArr.add("���������ý���");
			jsArr.add("�ڷΰ���");
			jsArr.add("�����Ǹ޾Ƹ�");
			jsArr.add("�а�Ȩ������");
			jsArr.add("��������");
			
			jsAns.put("text","��� Ȩ������ �����������?" );
			state="4";
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			ts=1;
			button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
			
		}

if (answer.equals("�а�Ȩ������")) { // ���ο� ��ư �ҷ����� �Լ�
	button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
	//System.out.println(name2[2]);
	jsArr.add("����");
	jsArr.add("����");
	jsArr.add("�ڷΰ���");
	jsArr.add("�ι���");
	jsArr.add("��ȸ���д�");
	state="5";
	
//	System.out.println(name.get(2));
	jsAns.put("text", "��� �кθ� ���Ͻó���");
	jsMes.put("message", jsAns);

	jsAns2.put("type", "buttons");
	jsAns2.put("buttons", jsArr);
	jsMes.put("keyboard", jsAns2);

	ts=1;
}

if (answer.equals("����")) { // ���ο� ��ư �ҷ����� �Լ�
	jsArr.add("��ǻ�Ͱ��к�");
	jsArr.add("�����������а�");
	jsArr.add("�ڷΰ���");
	jsArr.add("IT����ý��۰��а�");
	jsArr.add("����濵���а�");
	jsArr.add("���ý��۰��а�");
	state="6";
	jsAns.put("text", "�ȳ� �����!!");
	jsMes.put("message", jsAns);

	jsAns2.put("type", "buttons");
	jsAns2.put("buttons", jsArr);
	jsMes.put("keyboard", jsAns2);
	ts=1;
	button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
}
if (answer.equals("�ι���")) { // �ι��� ��ư
	jsArr.add("�ѱ���к�");
	jsArr.add("����к�");
	jsArr.add("�ڷΰ���");
	jsArr.add("���繮ȭ�к�");
	jsArr.add("���Ĺ�ȭ�к�");
	state="6";
	jsAns.put("text", "�ȳ�~~@@");
	jsMes.put("message", jsAns);

	jsAns2.put("type", "buttons");
	jsAns2.put("buttons", jsArr);
	jsMes.put("keyboard", jsAns2);
	ts=1;
	System.out.println("yoyo");
	button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
}

if (answer.equals("��ȸ���д�")) { // ��ȸ���д� ��ư
	jsArr.add("�濵�к�");
	jsArr.add("�����а�");
	jsArr.add("�ڷΰ���");
	jsArr.add("�����а�");
	jsArr.add("�����а�");
	jsArr.add("�ε����а�");
	jsArr.add("�ε��� �����濵�а�");
	jsArr.add("���������а�");
	state="6";
	jsAns.put("text", "�ȳ�~~@@");
	jsMes.put("message", jsAns);

	jsAns2.put("type", "buttons");
	jsAns2.put("buttons", jsArr);
	jsMes.put("keyboard", jsAns2);
	ts=1;
	System.out.println("yoyo");
	button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
}

if (answer.equals("����")) { // ����
	jsArr.add("�����а�");
	jsArr.add("ȸȭ��");
	jsArr.add("�ڷΰ���");
	jsArr.add("�ð����� ����������");
	jsArr.add("�ִϸ��̼� ��ǰ����������");
	jsArr.add("���׸������������");
	jsArr.add("�мǵ���������");
	jsArr.add("�Ƿ��мǻ������");
	jsArr.add("�м��к�");
	jsArr.add("��Ƽ�������а�");
	state="6";
	jsAns.put("text", "�ȳ�~~@@");
	jsMes.put("message", jsAns);

	jsAns2.put("type", "buttons");
	jsAns2.put("buttons", jsArr);
	jsMes.put("keyboard", jsAns2);
	ts=1;
	System.out.println("yoyo");
	button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
}

	if (answer.equals("������õ")) { // ����
			
			jsArr.add("�ѽ�-�н�");
			jsArr.add("�Ͻ�-�߽�");
			jsArr.add("�ڷΰ���");
			jsArr.add("����-ġŲ");
			jsArr.add("���");
			jsArr.add("�ƹ��ų�");
			
			
			jsAns.put("text","���� ���� �Ѽ�in��� Į�����\n"
					+ "���۽��� �ַ� ����" );
			state="4";
			jsAns.put("text","���Ͻô� ��ư�� �����ּ���" );
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			ts=1;
			button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
			
		}
	

		///////////////////////////////////////////////////////////////�ڷΰ���
		if (answer.equals("�ڷΰ���")&&state=="1") { // ����
			
			
			
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			jsAns.put("text", "��ư�̶�� �Է½ø� ��ư�� �۵��մϴ�");
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			ts=1;
			button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
			}
		
		
		if (answer.equals("�ڷΰ���")&&state=="2") { // ����
			
			
			
			jsArr.add("������");
			jsArr.add("�л�����");
			jsArr.add("�ڷΰ���");
			jsArr.add("�н�");
			
			jsAns.put("text", "�ֽ� ������Ʈ ���� �ȳ�!!");
		
			state="1";
			jsMes.put("message", jsAns);
			ts=1;
			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
		
		}

	if (answer.equals("�ڷΰ���")&&state=="3") { // ����
		
		
		
		jsArr.add("����");
		jsArr.add("������");
		jsArr.add("�ڷΰ���");
		state="2";
		jsAns.put("text","���� �ַ� ������ ����" );
	
		
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);

		ts=1;
		button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
	
	}
	
	if (answer.equals("�ڷΰ���")&&state=="4") { // ����
		
		
		
		jsArr.add("������õ");
		jsArr.add("�ü��ȳ�");
		jsArr.add("�ڷΰ���");
		jsArr.add("�б�Ȩ������");
		state="1";
		jsAns.put("text","���� ������ ���ƿ�!!" );
		
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		ts=1;
		button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
	
	}
	if (answer.equals("�ڷΰ���")&&state=="5") { // ����
		
		
		
		jsArr.add("�Ѽ����б�");
		jsArr.add("���������ý���");
		jsArr.add("�ڷΰ���");
		jsArr.add("�����Ǹ޾Ƹ�");
		jsArr.add("�а�Ȩ������");
		jsArr.add("��������");
		
		jsAns.put("text","��� Ȩ������ �����������?" );
		state="4";

		
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		ts=1;
		button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
	
	}
	if (answer.equals("�ڷΰ���")&&state=="6") { // ����
		
		
		
		button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
		//System.out.println(name2[2]);
		jsArr.add("����");
		jsArr.add("����");
		jsArr.add("�ڷΰ���");
		jsArr.add("�ι���");
		jsArr.add("��ȸ���д�");
		state="5";
		
//		System.out.println(name.get(2));
		jsAns.put("text", "��� �кθ� ���Ͻó���");
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		ts=1;
		button=1; // ��ư�� ���������� ȣ���ϱ� ���� ���� �Լ�
	
	}
	//////////////////////////////////////////////////////////////////////////����
		
	if(answer.equals("�ѽ�-�н�")){
		Random random = new Random();
		int r=random.nextInt(12);
		
		if(r==0){
			
			jsAns.put("text", "http://blog.naver.com/tjrsuqhqk/220972066473 \n\n"
					+ "���۽�\n"
					+ "��ȭ��ȣ:02-762-4437 \n"
					+ "��ް��ɿ���: X");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
		}
		if(r==1){
			jsAns.put("text", "https://store.naver.com/restaurants/detail?id=752168392 \n\n"
					+ "������\n"
					+ "��ȭ��ȣ:02-765-7179\n"
					+ "��ް��ɿ���:X");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
		}
		if(r==2){
			jsAns.put("text", "https://store.naver.com/restaurants/detail?id=752168392 \n\n"
					+ "����\n"
					+ "��ȭ��ȣ:02-765-7179\n"
					+ "��ް��ɿ���: O");
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		ts=1;
		button=1;
		}
		if(r==3){
			jsAns.put("text", "http://blog.naver.com/cuti1902/220197519436 \n\n"
					+ "ū��\n"
					+ "��ȭ��ȣ: X\n"
					+ "��ް��ɿ���:X");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
		}
		if(r==4){	
		jsAns.put("text", "http://blog.naver.com/gyo1118?Redirect=Log&logNo=220873393635 \n\n"
				+ "����Ϲ��� \n"
				+ "��ȭ��ȣ:02-744-8014\n"
				+ "��ް��ɿ���:X");
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
		ts=1;
		}
		if(r==5){	
			jsAns.put("text", "http://blog.naver.com/jiwoo090605/221001018877 \n\n"
					+ "ġ���&����ִ� �ø�\n"
					+ "��ȭ��ȣ:02-766-0228"
					+ "��ް��ɿ���:O");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==6){	
			jsAns.put("text", "http://blog.naver.com/llillo2/220861599680 \n\n"
					+ "�����������\n"
					+ "��ȭ��ȣ:02-741-2595\n"
					+ "���O");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==7){	
			jsAns.put("text", "http://blog.naver.com/hongik9016/220985825512 \n\n"
					+ "�ѾƸ� \n"
					+ "��ȭ��ȣ:02-762-2277\n"
					+ "��ް��ɿ���:X");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==8){	
			jsAns.put("text", 
					 "���кн� \n"
					+ "��ȭ��ȣ:X\n"
					+ "��ް��ɿ���:X");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==9){	
			jsAns.put("text", "https://store.naver.com/restaurants/detail?id=36727762 \n\n"
					+ "������ \n"
					+ "��ȭ��ȣ:02-741-3824\n"
					+ "��ް��ɿ���:X");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==10){	
			jsAns.put("text", "http://blog.naver.com/warmspeech3/220491406658 \n\n"
					+ "�ٸ���Ȱ ������ġ \n"
					+ "��ȭ��ȣ:02-3672-0915\n"
					+ "��ް��ɿ���:X");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==11){	
			jsAns.put("text", 
					 "�Ѽ��ζ���� \n"
					+ "��ȭ��ȣ:x\n"
					+ "��ް��ɿ���:x");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==12){	
			jsAns.put("text", "http://blog.naver.com/suntr0208/220936763287 \n\n"
					+ "�������� \n"
					+ "��ȭ��ȣ:02-591-9940\n"
					+ "��ް��ɿ���:X");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		button=0;
	}
		
		
	if(answer.equals("�Ͻ�-�߽�")){
		Random random = new Random();
		int r=random.nextInt(20);
		
		if(r==0){	
			jsAns.put("text", "http://blog.naver.com/yongyewest/220840656780 \n\n"
					+ "�紩�� \n"
					+ "��ȭ��ȣ:02-900-2452\n"
					+ "��ް��ɿ���:X");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==1){	
			jsAns.put("text", "http://blog.naver.com/llillo2/220861599680 \n\n"
					+ "�ϸ��� \n"
					+ "��ȭ��ȣ:02-741-2595\n"
					+ "��ް��ɿ���:O");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==2){	
			jsAns.put("text", "http://blog.naver.com/ppoby1004/220553102709 \n\n"
					+ "�¸��� \n"
					+ "��ȭ��ȣ:02-765-1004\n"
					+ "��ް��ɿ���:O");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==3){	
			jsAns.put("text", "http://blog.naver.com/daumcood/220865809396 \n\n"
					+ "��Ÿ�� \n"
					+ "��ȭ��ȣ:02-743-7707\n"
					+ "��ް��ɿ���:X");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		button=0;
	}
	if(answer.equals("����-ġŲ")){
		Random random = new Random();
		int r=random.nextInt(2);
		
		if(r==0){	
			jsAns.put("text", "https://mamis.modoo.at/ \n\n"
					+ "���̽� \n"
					+ "��ȭ��ȣ:02-3675-4929"
					+ "��ް��ɿ���:O");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==1){	
			jsAns.put("text", "https://store.naver.com/restaurants/detail?id=35003497 \n\n"
					+ "����Bell \n"
					+ "��ȭ��ȣ:02-749-3369\n"
					+ "��ް��ɿ���:O");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==2){	
			jsAns.put("text", "http://blog.naver.com/chavely85/220645684762 \n\n"
					+ "���ġŲ \n"
					+ "��ȭ��ȣ:02-764-5874\n"
					+ "��ް��ɿ���:X");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
	
		button=0;
	}
	if(answer.equals("���")){
		Random random = new Random();
		int r=random.nextInt(2);
		
		if(r==0){
			jsAns.put("text", "https://store.naver.com/restaurants/detail?id=752168392 \n\n"
					+ "����\n"
					+ "��ȭ��ȣ:02-765-7179\n"
					+ "��ް��ɿ���: O");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
		}
		if(r==1){	
			jsAns.put("text", "http://blog.naver.com/jiwoo090605/221001018877 \n\n"
					+ "ġ���&����ִ� �ø�\n"
					+ "��ȭ��ȣ:02-766-0228"
					+ "��ް��ɿ���:O");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==2){	
			jsAns.put("text", "https://mamis.modoo.at/ \n\n"
					+ "���̽� \n"
					+ "��ȭ��ȣ:02-3675-4929"
					+ "��ް��ɿ���:O");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==3){	
			jsAns.put("text", "http://blog.naver.com/llillo2/220861599680 \n\n"
					+ "�ϸ��� \n"
					+ "��ȭ��ȣ:02-741-2595\n"
					+ "��ް��ɿ���:O");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==4){	
			jsAns.put("text", "http://blog.naver.com/ppoby1004/220553102709 \n\n"
					+ "�¸��� \n"
					+ "��ȭ��ȣ:02-765-1004\n"
					+ "��ް��ɿ���:O");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
		if(r==5){	
			jsAns.put("text", "https://store.naver.com/restaurants/detail?id=35003497 \n\n"
					+ "����Bell \n"
					+ "��ȭ��ȣ:02-749-3369\n"
					+ "��ް��ɿ���:O");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
	
	
	}
	
	if(answer.equals("�ƹ��ų�")){
			Random random = new Random();
			int r=random.nextInt(20);
			
			if(r==0){
				jsAns.put("text", "http://blog.naver.com/tjrsuqhqk/220972066473 \n\n"
						+ "���۽�\n"
						+ "��ȭ��ȣ:02-762-4437 \n"
						+ "��ް��ɿ���: X");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
			}
			if(r==1){
				jsAns.put("text", "https://store.naver.com/restaurants/detail?id=752168392 \n\n"
						+ "������\n"
						+ "��ȭ��ȣ:02-765-7179\n"
						+ "��ް��ɿ���:X");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
			}
			if(r==2){
				jsAns.put("text", "https://store.naver.com/restaurants/detail?id=752168392 \n\n"
						+ "����\n"
						+ "��ȭ��ȣ:02-765-7179\n"
						+ "��ް��ɿ���: O");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
			}
			if(r==3){
				jsAns.put("text", "http://blog.naver.com/cuti1902/220197519436 \n\n"
						+ "ū��\n"
						+ "��ȭ��ȣ: X\n"
						+ "��ް��ɿ���:X");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
			}
			if(r==4){	
			jsAns.put("text", "http://blog.naver.com/gyo1118?Redirect=Log&logNo=220873393635 \n\n"
					+ "����Ϲ��� \n"
					+ "��ȭ��ȣ:02-744-8014\n"
					+ "��ް��ɿ���:X");
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");


			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
			ts=1;
			}
			if(r==5){	
				jsAns.put("text", "http://blog.naver.com/jiwoo090605/221001018877 \n\n"
						+ "ġ���&����ִ� �ø�\n"
						+ "��ȭ��ȣ:02-766-0228"
						+ "��ް��ɿ���:O");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==6){	
				jsAns.put("text", "https://mamis.modoo.at/ \n\n"
						+ "���̽� \n"
						+ "��ȭ��ȣ:02-3675-4929"
						+ "��ް��ɿ���:O");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==7){	
				jsAns.put("text", "http://blog.naver.com/yongyewest/220840656780 \n\n"
						+ "�紩�� \n"
						+ "��ȭ��ȣ:02-900-2452\n"
						+ "��ް��ɿ���:X");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==8){	
				jsAns.put("text", "http://blog.naver.com/llillo2/220861599680 \n\n"
						+ "�ϸ��� \n"
						+ "��ȭ��ȣ:02-741-2595\n"
						+ "��ް��ɿ���:O");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==9){	
				jsAns.put("text", "https://store.naver.com/restaurants/detail?id=32430405 \n\n"
						+ "�����������\n"
						+ "��ȭ��ȣ:02-741-6535\n"
						+ "���X");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==10){	
				jsAns.put("text", "http://blog.naver.com/hongik9016/220985825512 \n\n"
						+ "�ѾƸ� \n"
						+ "��ȭ��ȣ:02-762-2277\n"
						+ "��ް��ɿ���:X");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==11){	
				jsAns.put("text", 
						 "���кн� \n"
						+ "��ȭ��ȣ:X\n"
						+ "��ް��ɿ���:X");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==12){	
				jsAns.put("text", "https://store.naver.com/restaurants/detail?id=36727762 \n\n"
						+ "������ \n"
						+ "��ȭ��ȣ:02-741-3824\n"
						+ "��ް��ɿ���:X");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==13){	
				jsAns.put("text", "http://blog.naver.com/warmspeech3/220491406658 \n\n"
						+ "�ٸ���Ȱ ������ġ \n"
						+ "��ȭ��ȣ:02-3672-0915\n"
						+ "��ް��ɿ���:X");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==14){	
				jsAns.put("text", "http://blog.naver.com/chavely85/220645684762 \n\n"
						+ "���ġŲ \n"
						+ "��ȭ��ȣ:02-764-5874\n"
						+ "��ް��ɿ���:X");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==15){	
				jsAns.put("text", "http://blog.naver.com/ppoby1004/220553102709 \n\n"
						+ "�¸��� \n"
						+ "��ȭ��ȣ:02-765-1004\n"
						+ "��ް��ɿ���:O");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==16){	
				jsAns.put("text", 
						 "�Ѽ��ζ���� \n"
						+ "��ȭ��ȣ:x\n"
						+ "��ް��ɿ���:x");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==17){	
				jsAns.put("text", "http://blog.naver.com/daumcood/220865809396 \n\n"
						+ "��Ÿ�� \n"
						+ "��ȭ��ȣ:02-743-7707\n"
						+ "��ް��ɿ���:X");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==18){	
				jsAns.put("text", "https://store.naver.com/restaurants/detail?id=20874411 \n\n"
						+ "�츮���н� \n"
						+ "��ȭ��ȣ:02-764-1388\n"
						+ "��ް��ɿ���:X");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==19){	
				jsAns.put("text", "http://blog.naver.com/suntr0208/220936763287 \n\n"
						+ "�������� \n"
						+ "��ȭ��ȣ:02-591-9940\n"
						+ "��ް��ɿ���:X");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
			if(r==20){	
				jsAns.put("text", "https://store.naver.com/restaurants/detail?id=35003497 \n\n"
						+ "����Bell \n"
						+ "��ȭ��ȣ:02-749-3369\n"
						+ "��ް��ɿ���:O");
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");


				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
				ts=1;
				}
		
			
		 // �޼����� ���������� ȣ���ϱ� ���� ���� �Լ�
			
		
			
		}
	
	////////////////////////////////////////////////////////////////////////������
	if (answer.equals("����������")) {
		jsAns.put("text", "�˰� ���� �������� �Է� �Ͽ� �ּ���\n\n"
				+ "ex)xxx������");	jsArr.add("��ȭ����");
				ts=1;
				button=0;	}
	
	if (answer.equals("�Ѽ����б�")) {
		jsAns.put("text", "http://www.hansung.ac.kr/web/www/home");
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	}
	if (answer.equals("��������")) {
		jsAns.put("text", "http://www.hansung.ac.kr/web/www/cmty_01_01");
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	}
	if (answer.equals("�����Ǹ޾Ƹ�")) {
		jsAns.put("text", "http://www.hansung.ac.kr/web/www/cmty_03_01");
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	}
	if (answer.equals("���������ý���")) {
		jsAns.put("text", "http://info.hansung.ac.kr/");
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	}
	
	if (answer.equals("��ǻ�Ͱ��к�")) {
		jsAns.put("text", "http://cse.hansung.ac.kr/");
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	}
	if (answer.equals("�����������а�")) {
		jsAns.put("text", "http://www.hansung.ac.kr/~dice");
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	}
	if (answer.equals("IT����ý��۰��а�")) {
		jsAns.put("text", "http://www.hansung.ac.kr/~ait");
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;

	}
	if (answer.equals("����濵���а�")) {
		jsAns.put("text", "http://www.hansung.ac.kr/web/ie");
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	}
	if (answer.equals("���ý��۰��а�")) {
		jsAns.put("text", "www.hansung.ac.kr/~me");
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	}
	
	
		

		
		//////////////////////////////////////////////////////////////
	
	if(answer.equals("�̻����")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n���� 908ȣ");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("�񼭽�")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("���п�������")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n����1002ȣ");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("����������")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("�м��ڷ���")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("�л�������")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("�м�������")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n�̷���2��");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("��������������")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("�м�������")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n�̷��� 1��~5��");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("��ȹ������")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("����ȭ��")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n�̷���2��");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("�򰡰�����")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("���ȫ����")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n���̰�603ȣ");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("��������������")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n���̰�302ȣ");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("�����ξ�Ʈ���������")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n�м۰�");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("���񱺱����Ʒ�")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n���̰� 313ȣ");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("���к�����")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n������ 1��");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("����������")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n���̰�610ȣ");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("��°���������")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("�л���㼾��")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n�̷��� ���� 1��");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("�ѹ��λ���")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("�缺������")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n�̷��� B1��");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("�繫ȸ����")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n���̰� 305ȣ");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("�ǰ�������")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n���� 102ȣ");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("��ü��")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n�߹� ��");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("���б�ȹ��")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type", "buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("IPP�����")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n���� 402ȣ");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type","buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
	if(answer.equals("���а�����")){
		jsAns.put("text", "(��ȭ��ȣ)\n"+b2+"\n(��ġ)\n���̰� 304ȣ");	
		jsArr.add("��ȭ����");
		jsArr.add("�����˻�");
		jsArr.add("���˲���");


		ts=1;
		jsMes.put("message", jsAns);

		jsAns2.put("type","buttons");
		jsAns2.put("buttons", jsArr);
		jsMes.put("keyboard", jsAns2);
		button=1;
	
		
	}
		
		/////////////////////////////////////////////////////////////
		
		if(answer.equals("��")) {
			if(bab==1){
			String s2=b3.replaceAll("@@", "\n");
			String s3=b4.replaceAll("@@", "\n");
			s2=s2.replaceAll("@", "");
		    s3=s3.replaceAll("@", "");
		    jsAns.put("text", "<�߽�>\n "+s2+"\n\n<����>\n "+s3);			
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

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
			    jsAns.put("text", "<�߽�>\n "+s2+"\n\n<����>\n "+s3);			
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");

				ts=1;
				
				jsMes.put("message", jsAns);

				jsAns2.put("type", "buttons");
				jsAns2.put("buttons", jsArr);
				jsMes.put("keyboard", jsAns2);
				button=1;
			}
		}
		if(answer.equals("ȭ")) {
			if(bab==1){
				String s2=b3.replaceAll("@@", "\n");
				String s3=b4.replaceAll("@@", "\n");
				s2=s2.replaceAll("@", "");
			    s3=s3.replaceAll("@", "");
			    jsAns.put("text", "<�߽�>\n "+s2+"\n\n<����>\n "+s3);			
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");

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
				    jsAns.put("text", "<�߽�>\n "+s2+"\n\n<����>\n "+s3);			
					jsArr.add("��ȭ����");
					jsArr.add("�����˻�");
					jsArr.add("���˲���");

					ts=1;
					
					jsMes.put("message", jsAns);

					jsAns2.put("type", "buttons");
					jsAns2.put("buttons", jsArr);
					jsMes.put("keyboard", jsAns2);
					button=1;
				}
		}
		if(answer.equals("��")) {
			if(bab==1){
				String s2=b3.replaceAll("@@", "\n");
				String s3=b4.replaceAll("@@", "\n");
				s2=s2.replaceAll("@", "");
			    s3=s3.replaceAll("@", "");
			    jsAns.put("text", "<�߽�>\n "+s2+"\n\n<����>\n "+s3);			
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");

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
				    jsAns.put("text", "<�߽�>\n "+s2+"\n\n<����>\n "+s3);			
					jsArr.add("��ȭ����");
					jsArr.add("�����˻�");
					jsArr.add("���˲���");

					ts=1;
					
					jsMes.put("message", jsAns);

					jsAns2.put("type", "buttons");
					jsAns2.put("buttons", jsArr);
					jsMes.put("keyboard", jsAns2);
					button=1;
				}
		}
		if(answer.equals("��")) {
			if(bab==1){
				String s2=b3.replaceAll("@@", "\n");
				String s3=b4.replaceAll("@@", "\n");
				s2=s2.replaceAll("@", "");
			    s3=s3.replaceAll("@", "");
			    jsAns.put("text", "<�߽�>\n "+s2+"\n\n<����>\n "+s3);			
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");

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
				    jsAns.put("text", "<�߽�>\n "+s2+"\n\n<����>\n "+s3);			
					jsArr.add("��ȭ����");
					jsArr.add("�����˻�");
					jsArr.add("���˲���");

					ts=1;
					
					jsMes.put("message", jsAns);

					jsAns2.put("type", "buttons");
					jsAns2.put("buttons", jsArr);
					jsMes.put("keyboard", jsAns2);
					button=1;
				}
		}
		if(answer.equals("��")) {
			if(bab==1){
				String s2=b3.replaceAll("@@", "\n");
				String s3=b4.replaceAll("@@", "\n");
				s2=s2.replaceAll("@", "");
			    s3=s3.replaceAll("@", "");
			    jsAns.put("text", "<�߽�>\n "+s2+"\n\n<����>\n "+s3);			
				jsArr.add("��ȭ����");
				jsArr.add("�����˻�");
				jsArr.add("���˲���");

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
				    jsAns.put("text", "<�߽�>\n "+s2+"\n\n<����>\n "+s3);			
					jsArr.add("��ȭ����");
					jsArr.add("�����˻�");
					jsArr.add("���˲���");

					ts=1;
					
					jsMes.put("message", jsAns);

					jsAns2.put("type", "buttons");
					jsAns2.put("buttons", jsArr);
					jsMes.put("keyboard", jsAns2);
					button=1;
				}
		}
		///////////////////////////////////////////////////////////////�л�����
		if (answer.equals("3��")) {
			String s2=b8.replaceAll("@@", "\n");
			String s3=s2.replaceAll("@", "\n");
			jsAns.put("text", s3);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("4��")) {
			String s2=b8.replaceAll("@@", "\n");
			String s3=s2.replaceAll("@", "\n");
			jsAns.put("text", s3);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("5��")) {
			String s2=b8.replaceAll("@@", "\n");
			String s3=s2.replaceAll("@", "\n");
			jsAns.put("text", s3);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("6��")) {
			String s2=b8.replaceAll("@@", "\n");
			String s3=s2.replaceAll("@", "\n");
			jsAns.put("text", s3);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("7��")) {
			String s2=b8.replaceAll("@@", "\n");
			String s3=s2.replaceAll("@", "\n");
			jsAns.put("text", s3);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("8��")) {
			String s2=b8.replaceAll("@@", "\n");
			String s3=s2.replaceAll("@", "\n");
			jsAns.put("text", s3);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		
		
		/////////////////////////////////////////////////////////////// ������ �亯

		
		if(answer.equals("�����߱�����")||answer.equals("�����߱�����e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);		jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("�����������")||answer.equals("�����������e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("�ǿ��̱�����")||answer.equals("�ǿ��̱�����e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("�賲��������")||answer.equals("�賲��������e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("�輺��������")||answer.equals("�輺��������e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("�迵��������")||answer.equals("�迵��������e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("����ȯ������")||answer.equals("����ȯ������e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;

		}
		if (answer.equals("������������")||answer.equals("������������e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;

		}
		if (answer.equals("�̼��ⱳ����")||answer.equals("�̼��ⱳ����e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		if (answer.equals("���繮������")||answer.equals("���繮������e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
	
		if (answer.equals("������������")||answer.equals("������������e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		
		if (answer.equals("���翵������")||answer.equals("���翵������e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			
			jsAns.put("text",s1);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		
		if (answer.equals("���λ󱳼���")||answer.equals("���λ󱳼���e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			ts=1;
			jsAns.put("text",s1);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		
		if (answer.equals("����ȫ������")||answer.equals("����ȫ������e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			ts=1;
			jsAns.put("text",s1);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
		
		if (answer.equals("���ؿ�������")||answer.equals("���ؿ�������e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			ts=1;
			jsAns.put("text",s1);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
	
		if (answer.equals("Ȳ���±�����")||answer.equals("Ȳ���±�����e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			ts=1;
			jsAns.put("text",s1);
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
	
		if (answer.equals("Ȳȣ��������")||answer.equals("Ȳȣ��������e")) {
			String s2=b.replaceAll("AT", "@");
			String s1=s2.replaceAll("@@", "\n");
			ts=1;
			jsAns.put("text",s1);
			
			jsArr.add("��ȭ����");
			jsArr.add("�����˻�");
			jsArr.add("���˲���");

			ts=1;
			
			jsMes.put("message", jsAns);

			jsAns2.put("type", "buttons");
			jsAns2.put("buttons", jsArr);
			jsMes.put("keyboard", jsAns2);
			button=1;
		}
////////////////////////////////////////////////////////////////////////////`
		

		// say hello�� �Էµ��� ��


		if (answer.equals("��ȭ����")) {
			jsAns.put("text", "�ȳ�~~");
			button=0; // �޼����� ���������� ȣ���ϱ� ���� ���� �Լ�
			ts=1;
		}
	
			
		if (answer.equals("�ü��ȳ�")) {
			jsAns.put("text", "(�ü� �̸��� ��Ȯ�� �Է��Ͽ� �ּ���)\n"
					+ "�̻����  "
					+ "���а����� \n"
					+ "���п�������  "
					+ "����������\n"
					+ "�м�������  "
					+ "��������������\n"
					+ "�м�������  "
					+ "��ȹ������\n"
					+ "����ȭ��  "
					+ "�򰡰�����\n"
					+ "���ȫ����  "
					+ "��������������\n"
					+ "�����ξ�Ʈ���������  "
					+ "���񱺱����Ʒ�\n"
					+ "���к�����  "
					+ "����������\n"
					+ "��°���������  "
					+ "�л���㼾��\n"
					+ "�ѹ��λ���  "
					+ "�缺������\n"
					+ "�繫ȸ����  "
					+ "�ǰ�������\n"
					+ "��ü��  "
					+ "���б�ȹ��\n"
					+ "IPP�����");
			ts=1;
			button=0; // �޼����� ���������� ȣ���ϱ� ���� ���� �Լ�
		}
	
		if (answer.equals("�ڱ�Ұ�")) {
			jsAns.put("text", "�ȳ� ~~�� �Ѽ����̾� �������� �����ϸ� �ȵ�");
			button=0; // �޼����� ���������� ȣ���ϱ� ���� ���� �Լ�
		}else if(ts==0){
			try{
			String count="1";
			String s5=answer.replaceAll(" ", "@");
			BufferedReader br12 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//kakaosend.php?send="+s5).openStream())); //������ ��ȭ��ȣ
	
			BufferedReader br13 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//kakaomsg.php?state="+'1').openStream())); //������ ��ȭ��ȣ
		
			BufferedReader br10 = new BufferedReader(
					new InputStreamReader(new URL("http://52.78.94.234//state2.php?state="+'5').openStream())); //������ ��ȭ��ȣ
	
	
			}catch(IOException e){}
		
			// String erg = "2";
			
			

		//	b11= br13.readLine();
			try {
				Thread.sleep(1000);
				BufferedReader br11 = new BufferedReader(
						new InputStreamReader(new URL("http://52.78.94.234//kakaopy2.php?msg="+"1").openStream())); //������ ��ȭ��ȣ
				b11= br11.readLine();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			System.out.println("ts����");
			jsAns.put("text", b11);
			button=0; // �޼����� ���������� ȣ���ϱ� ���� ���� �Լ�
		}

		



		/*
		 * js.put("type", "buttons"); js.put("buttons", "�ȳ�");
		 */
		// say bye�� �Էµ��� ��

		// ������ JSON�� jsMes�� if���� ���� ��Ȳ�� ���� �亯�� �־��ݴϴ�

		if(button==0){
			jsMes.put("message", jsAns);  //��ư�� �ƴ϶� message�϶���  if�� �ȿ� �����Ѵ�
			System.out.println("����");
		}

		return jsMes;

	}

	private Object Stirng(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
