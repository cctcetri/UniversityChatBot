package yellowid;

import java.io.IOException;
 
import org.junit.BeforeClass;
import org.junit.Test;
 
import com.amazonaws.services.lambda.runtime.Context;
 
import org.json.*;
import org.json.simple.*;
import org.json.simple.parser.*;
 
/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class messageTest {
 
    private static JSONObject input;
 
    @BeforeClass
    public static void createInput() throws IOException {
        // TODO: set up your sample input object here.
        
 
 
        /*        �����ؾ� �� �κ� ��        */
 
        // say hello ��ư�� �Էµ� ��Ȳ ����
        
        JSONObject js = new JSONObject();
        
        js.put("content", "����");
        
        input = js;
 
        /*        �����ؾ� �� �κ� ��        */
 
        
 
    }
 
    private Context createContext() {
        TestContext ctx = new TestContext();
 
        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");
 
        return ctx;
    }
 
    @Test
    public void testmessage() {
        message handler = new message();
        Context ctx = createContext();
 
        JSONObject output = handler.handleRequest(input, ctx);
 
        // TODO: validate output here if needed.
        if (output != null) {
            System.out.println(output.toString());
        }
    }
}
 


