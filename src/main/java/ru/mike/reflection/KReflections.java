package ru.mike.reflection;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class KReflections {

    public static <T> T newInstance(Class<?> clazz, Class<?>...parameterTypes) throws RuntimeException {
        try {
           return (T) clazz.getDeclaredConstructor().newInstance(parameterTypes);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fieldSet(Field field, Object obj, Object value) {
        try {
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            String message = String.format("Error when setting field:%s with value:%s on object:%s",
                    field.getType().getName(), value.getClass(), obj.getClass());

            throw new RuntimeException(message, e);
        }
    }
}
