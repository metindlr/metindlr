import com.sap.gateway.ip.core.customdev.util.Message;

import java.util.HashMap;

def Message processData(Message message)

{

def removal=message.getBody(java.lang.String) as String;

removal=removal.replace(/<?xml version="1.0" encoding="UTF-8"?>/,"");

message.setBody(removal);

return message;

}