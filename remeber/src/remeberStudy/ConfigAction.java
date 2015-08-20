package remeberStudy;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class ConfigAction {
	public static HashMap<String, String> loadConfig(String s) throws Exception {
		HashMap<String, String> h=new HashMap<String, String>();
		try {
			SAXReader sr=new SAXReader();
			Document doc=sr.read(new File(s));
			List<Element> list=doc.getRootElement().elements();
			for (Element e : list) {
				String key = e.getName();
				String value = e.getTextTrim();
				h.put(key, value);
			}
			return h;
		} catch (Exception e) {
			throw e;
		}
	}
}
