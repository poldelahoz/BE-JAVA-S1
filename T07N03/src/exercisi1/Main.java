package exercisi1;

import java.lang.reflect.Field;

public class Main {

	public static void main(String[] args) {
		try {
			scanAnnotation();
			Alumne alumne = new Alumne("Harry", "Potter", 1, Alumne.Casa.Gryffindor);
			ObjectToJsonConverter otjc = new ObjectToJsonConverter();
			otjc.convertToJson(alumne);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void scanAnnotation() {
		try {
			Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("exercisi1.Alumne");
			JsonSerializable classAnnotation = clazz.getAnnotation(JsonSerializable.class);
			if (classAnnotation != null)
			{
				System.out.println("La classe alumne té l'anotació personalitzada JsonSerializable amb valor savePath = " + classAnnotation.savePath());
			}else {
				System.out.println("La classe alumne NO té l'anotació personalitzada JsonSerializable.");
			}
			System.out.println();
			System.out.println("Atributs de la classe Alumne amb anotació personalitzada JsonElement: ");
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
			    if (field.isAnnotationPresent(JsonElement.class)) {
			    	JsonElement fieldAnnotation = field.getAnnotation(JsonElement.class);
			        System.out.println("Atribut: " + field.getName());
			        System.out.println("Paràmetre nom de l'anotació JsonElement:" + fieldAnnotation.name());
			    }
			}
			System.out.println();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
