import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
import java.lang.*;
def Message processData(Message message)
{
    map = message.getProperties();
    def ZF1    = map.get("F1");
    def ZF2    = map.get("F2");
    def ZF3    = map.get("F3");
    String ZConcat = ZF1.concat(ZF2).concat(ZF3);
    message.setProperty("ConcatenatedResult",ZConcat);
    return message;
}