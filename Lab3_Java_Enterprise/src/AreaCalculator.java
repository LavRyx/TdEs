public class AreaCalculator {
    public static void calculateArea(Object object) {
        Class<?> clazz = object.getClass();

        // Проверяем, помечен ли объект аннотацией @haveArea
        if (clazz.isAnnotationPresent(haveArea.class)) {
            haveArea haveAreaAnnotation = clazz.getAnnotation(haveArea.class);
            String name = haveAreaAnnotation.name();

            // Ищем метод, помеченный аннотацией @returnArea
            for (java.lang.reflect.Method method : clazz.getMethods()) {
                if (method.isAnnotationPresent(returnArea.class)) {
                    try {
                        // Вызываем метод для вычисления площади
                        double area = (double) method.invoke(object);
                        System.out.println("Площадь " + name + ": " + area);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("Объект не помечен аннотацией @haveArea");
        }
    }
}