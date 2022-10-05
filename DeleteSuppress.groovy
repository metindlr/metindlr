import com.sap.it.api.mapping.*;

/*Add MappingContext parameter to read or set headers and properties
def String customFunc1(String P1,String P2,MappingContext context) {
         String value1 = context.getHeader(P1);
         String value2 = context.getProperty(P2);
         return value1+value2;
}

Add Output parameter to assign the output value.
def void custFunc2(String[] is,String[] ps, Output output, MappingContext context) {
        String value1 = context.getHeader(is[0]);
        String value2 = context.getProperty(ps[0]);
        output.addValue(value1);
        output.addValue(value2);
}*/

def void deleteSuppress(String[] contextValues, Output output, MappingContext context) {
			if (contextValues != null && contextValues.length > 0) {
			for (int i = 0; i < contextValues.length; i++) {
				if (contextValues[i] != null
						&& !Output.SUPPRESS
								.equalsIgnoreCase(contextValues[i])) {
					output.addValue(contextValues[i]);
				}
			}
		}
}