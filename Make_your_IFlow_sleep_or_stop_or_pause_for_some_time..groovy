import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
def Message processData(Message message)
{
       def body = message.getBody();
       sleep(40000);
       message.setBody(body);
       return message;
}