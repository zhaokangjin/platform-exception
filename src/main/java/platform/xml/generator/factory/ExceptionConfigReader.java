package platform.xml.generator.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import platform.xml.generator.exception.ExceptionEntry;

@SuppressWarnings("unchecked")
public class ExceptionConfigReader {
	public static List<ExceptionEntry> exceptionList(String i18n) {
		List<ExceptionEntry> customExceptionList = new ArrayList<ExceptionEntry>();
		return readExceptionConfigXML(customExceptionList, i18n);
	}

	private static List<ExceptionEntry> readExceptionConfigXML(List<ExceptionEntry> customExceptionList, String i18n) {
		SAXReader reader = new SAXReader();
		InputStream xmlInput = ExceptionConfigReader.class.getClassLoader().getResourceAsStream("customExceptionConfig.xml");
		try {
			Document document = reader.read(xmlInput);
			Element root = document.getRootElement();
			List<Element> exceptionElements = root.elements();
			ExceptionEntry exceptionEntry = null;
			for (Element exceptionElement : exceptionElements) {
				exceptionEntry = new ExceptionEntry();
				exceptionEntry.setCode(exceptionElement.attributeValue("code"));
				List<Element> messageElements = exceptionElement.elements();
				for (Element messageElement : messageElements) {
					if (messageElement.attribute("i18n").getValue().equals(i18n)) {
						exceptionEntry.setMessage(messageElement.getText().trim());
					}
				}
				customExceptionList.add(exceptionEntry);
			}
			return customExceptionList;
		} catch (DocumentException e) {
			throw new NullPointerException();
		} finally {
			try {
				xmlInput.close();
			} catch (IOException e) {

			}

		}
	}
}
