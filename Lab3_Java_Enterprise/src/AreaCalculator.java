import java.lang.reflect.Method;

public class AreaCalculator {
    public static void calculateArea(Object object) {

        Class<?> test = object.getClass();

        if (test.isAnnotationPresent(haveArea.class)) {
            for (Method method : test.getMethods()) {
                if (method.isAnnotationPresent(returnArea.class)) {
                    try {
                        double area = (double) method.invoke(object);
                        System.out.println("Площадь: " + area);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("Объект не помечен аннотацией");
        }
    }
}