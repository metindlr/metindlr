import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
def Message processData(Message message) {
    //Body 
       def body = message.getBody();
       sleep(120000);
       message.setBody(body);
       return message;

}