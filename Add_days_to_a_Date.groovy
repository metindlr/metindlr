import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
import java.lang.*;
import com.sap.it.api.mapping.*;
def Message processData(Message message)
{
    Date zcurDate = new Date();
    Date zNewDate = zcurDate + 30;
    message.setProperty("Current_Date",zcurDate);
    message.setProperty("New_Date",zNewDate);
    return message;
}