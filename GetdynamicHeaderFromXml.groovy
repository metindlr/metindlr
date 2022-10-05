import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
import groovy.util.XmlSlurper;
def Message processData(Message message) {
   def body = message.getBody(String.class);
   def completeXml = new XmlSlurper().parseText(body);
   def GLN = completeXml.'**'.find{ node-> node.name() == 'Sender'}.text();
   message.setProperty("GLN",GLN);
 return message;
}