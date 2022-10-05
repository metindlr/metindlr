	import com.sap.it.api.mapping.*;

	import com.sap.it.api.mapping.*;
	
	import com.sap.it.api.mapping.MappingContext;
	
	def String getProperty(String property_name, MappingContext context) {
	
	    def propertyvalue= context.getProperty(property_name);
	
	    return propertyvalue;
	 
	}
