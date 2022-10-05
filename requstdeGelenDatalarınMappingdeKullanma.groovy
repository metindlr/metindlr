import com.sap.it.api.mapping.*;

def String SOAP1(String arg1, MappingContext context) {
         String SOAP1 = context.getProperty('SOAP1');
         return SOAP1;
}
def String SOAP2(String arg1, MappingContext context) {
         String SOAP2 = context.getProperty('SOAP2');
         return SOAP2;
}