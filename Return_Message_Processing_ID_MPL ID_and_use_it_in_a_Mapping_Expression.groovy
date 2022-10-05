import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
import com.sap.it.api.mapping.*;

def String getMessageProcessingLogID(String header,MappingContext context)
{
        String mplId = context.getHeader("SAP_MessageProcessingLogID").toString();
        return mplId;
}