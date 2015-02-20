package com.free.testspring;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONWriter;
import org.codehaus.jettison.mapped.SimpleConverter;
import org.junit.Test;

import com.free.testspring.domain.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

public class JsonTest {
	@Test
	public void testJsonConvert() {
		User use = new User();
		Map<String, Object> value = new HashMap<String,Object>();
		value.put("user", use);
		value.put("isUser", true);
		XStream stream = new XStream(new JsonHierarchicalStreamDriver(){
			@Override
			public HierarchicalStreamWriter createWriter(Writer out) {
				// TODO Auto-generated method stub
				return new JsonWriter(out, JsonWriter.STRICT_MODE);
			}
		});
//		stream.setMode(JsonWriter.DROP_ROOT_MODE);
		stream.alias("use", JSONObject.class);

        System.out.println(stream.toXML(value));	
        
        JSONObject jsonObj = new JSONObject(value);
        System.out.println(jsonObj.toString());
        
        
	    SimpleConverter converter = new SimpleConverter();
	    converter.convertToJSONPrimitive("");
	}
}
