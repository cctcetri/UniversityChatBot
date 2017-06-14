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
        
 
 
        /*        수정해야 할 부분 ↓        */
 
        // say hello 버튼이 입력된 상황 설정
        
        JSONObject js = new JSONObject();
        
        js.put("content", "하하");
        
        input = js;
 
        /*        수정해야 할 부분 ↑        */
 
        
 
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
 


