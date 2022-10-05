import com.sap.gateway.ip.core.customdev.util.Message
import java.util.Map
import java.util.Iterator
import javax.activation.DataHandler


//Unzipping input ZIP file from SOAP request to have multiple files at target size
def Message processData(Message message) {

   Map<String, DataHandler> attachments = message.getAttachments()
   if (attachments.isEmpty()) {
       message.setBody("No attachment Found")
     return message;
   } else {
      Iterator<DataHandler> it = attachments.values().iterator()
      DataHandler attachment = it.next()
      message.setBody(attachment.getContent())
   }
   return message
}