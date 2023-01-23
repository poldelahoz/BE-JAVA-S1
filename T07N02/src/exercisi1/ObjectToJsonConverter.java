package exercisi1;

import java.lang.reflect.Field;
import java.util.Objects;

public class ObjectToJsonConverter {
	
	public void convertToJson(Object object) throws Exception {
        try {
            checkIfSerializable(object);
            String data = getJsonString(object);
            String savePath = getSavePath(object);
            FileUtils.saveToFile(data, savePath, "json");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
	
	private void checkIfSerializable(Object object) throws Exception{
	    if (Objects.isNull(object)) {
	        throw new Exception("L'objecte a deserialitzar és null.");
	    }
	        
	    Class<?> clazz = object.getClass();
	    if (!clazz.isAnnotationPresent(JsonSerializable.class)) {
	        throw new Exception("La classe " + clazz.getSimpleName() + " no està anotada amb JsonSerializable.");
	    }
	}
	
	private String getJsonString(Object object) throws Exception {	
	    Class<?> clazz = object.getClass();
	    String jsonString = "{\n";
	    for(int i = 0; i < clazz.getDeclaredFields().length; i++)
	    {
	    	Field field = clazz.getDeclaredFields()[i];
	    	JsonElement jsonElement = field.getAnnotation(JsonElement.class);
	        field.setAccessible(true);
	        if (field.isAnnotationPresent(JsonElement.class)) {
	        	String key = jsonElement.name();
	        	Object value = field.get(object);
	            jsonString += "	\"" + key + "\":\"" + value + "\"";
	        }
	        if(i+1 == clazz.getDeclaredFields().length)
	        	jsonString += "\n";
	        else
	        	jsonString += ",\n";
	    }
	    jsonString += "}";
	    return jsonString;
	}
	
	private String getSavePath(Object object) {
		Class<?> clazz = object.getClass();
	    JsonSerializable jsonSerializable = clazz.getAnnotation(JsonSerializable.class);
	    return jsonSerializable.savePath();
	}
}

