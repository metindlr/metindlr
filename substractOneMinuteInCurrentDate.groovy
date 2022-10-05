import com.sap.gateway.ip.core.customdev.util.Message;
import groovy.time.TimeCategory
import java.util.TimeZone;

import java.util.HashMap;

//şişecam cpı Rusya için yapıldı.
//scripten önce contend modifier konuldu ve headerda "previousDay cosntant ${date:now:yyyy-MM-dd'T'HH:mm:ss.SSS'Z'}" diye belirtildi.curent date de "currentDate expression ${date:now:yyyy-MM-dd'T'HH:mm:ss.SSS'Z'}" diye belirtildi
def Message processData(Message message) {
    //Body 
     //  def body = message.getBody();
       //message.setBody(body + "Body is modified");
       //Headers
       def TodaysDate = new java.util.Date()
        TodaysDate= TodaysDate.format("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
      // def previous = TodaysDate.previous()
       def previous = "";
   
   
       use(TimeCategory) {
       previous = new Date()-1.minutes
  
       }
 
       previous=previous.format("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
       def map = message.getHeaders();
       def value = map.get("previousDay");
       message.setHeader("previousDay", value + "modified");
       message.setHeader("previousDay", previous);
       return message;
}