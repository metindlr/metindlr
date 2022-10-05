import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
import groovy.xml.XmlUtil;
import groovy.util.*;

def Message processData(Message message) {
    def body = message.getBody(java.lang.String);
    def root = new XmlParser().parseText(body)
    root.data.row.each { row ->
        row.appendNode("Field5", "newfield")
    }
    message.setBody(XmlUtil.serialize(root));
    return message;
}
