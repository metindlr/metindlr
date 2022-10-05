import com.sap.gateway.ip.core.customdev.util.Message;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.ByteArrayInputStream
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;



// xls excel versiyonlar Base64 de dönüştürülerek post edilip xml haline dönüştürülür.
def Message processData(Message message) {
    
    Map<String, String> headerToFieldMap = new HashMap<String, String>() {
		{
			put("Interval_Begin_Interval", "Interval_Begin_Interval");
			put("Inteval_End_Interval", "Inteval_End_Interval");
			put("Message_Count_For_Aggregation_Entity", "Message_Count_For_Aggregation_Entity");
			put("Inteval_End_Interval", "Inteval_End_Interval");
			put("Sender_Component", "Sender_Component");
			put("Receiver_Component", "Receiver_Component");
			put("Interface", "Interface");
			put("Interface_NameSpace", "Interface_NameSpace");
			
			put("Avg_Message_Size", "Avg_Message_Size");
			put("Max_Message_Size", "Max_Message_Size");
			put("Total_Message_Size", "Total_Message_Size");
			put("Avg_Processing_Time", "Avg_Processing_Time");
			put("Total_Processing_Time", "Total_Processing_Time");
		
			
			
			
			
			
			
			
			
		//	put("Order Detail", "OrderDetail");

		}
	};

	Map<Integer, String> indexToFieldMap = new HashMap<Integer, String>();

	String NSURL = "https://nttdata.com";
	
	
    //Body 
       def body = message.getBody(String.class);
       
        byte[] data = java.util.Base64.getDecoder().decode(body)
        
     
       Document doc = newDocument();
		
		Element rootEl = doc.createElementNS(NSURL,
				"ns1:MT_GunlukAktarimler");
		doc.appendChild(rootEl);

		Workbook workbook = new HSSFWorkbook( new ByteArrayInputStream(data));

		String sheetName = "Entegrasyon";

		// workbook.getSheetAt(1);
		Sheet sheet = workbook.getSheet(sheetName);

		for (Row row : sheet) {

			// System.out.println(row.getRowNum());
			// if(row.getRowNum()==0) {
			// continue;
			// }

			// ADD A NEW ROW
			Element itemEl = doc.createElementNS("", "row");

			for (Cell cell : row) {
				String cellValue = null;
				switch (cell.getCellTypeEnum()) {
				case CellType.STRING:
					// System.out.println(cell.getStringCellValue());
					cellValue = cell.getStringCellValue();
					break;
				case CellType.NUMERIC:
					// System.out.println(cell.getNumericCellValue());
					cellValue = String.valueOf(cell.getNumericCellValue());
					break;
				// case BOOLEAN: ... break;
				// case FORMULA: ... break;
				default:
					System.out.println("CELL TYPE NOT USED!");
				}

				if (cellValue != null) {
					// use the first row for header -> fieldname mapping
					if (row.getRowNum() == 0) {
						indexToFieldMap.put(cell.getColumnIndex(),
								headerToFieldMap.get(cellValue));
						continue;
					}
					// add item if it is not header.
					rootEl.appendChild(itemEl);
					// System.out.println(cellValue);
					Element fieldEl = doc.createElementNS("", indexToFieldMap.get(cell.getColumnIndex()));
					itemEl.appendChild(fieldEl);
					fieldEl.setTextContent(cellValue);
				}
			}
		}

        message.setBody(doc)

       return message;
}

	public static Document newDocument() throws ParserConfigurationException {
		DocumentBuilderFactory factory;
		DocumentBuilder builder;
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
			return builder.newDocument();

		} finally {
			builder = null;
			factory = null;
		}
	}