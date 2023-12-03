package com.solvd.reflection;

import java.lang.reflect.*;

public class ReflectionHandler {

    /**
     * Inspects the fields, constructors, and methods of a given class.
     *
     * @param clazz The Class object to be inspected.
     */
    public static void inspectClass(Class<?> clazz) {
        inspectFields(clazz);
        inspectConstructors(clazz);
        inspectMethods(clazz);
    }

    /**
     * Inspects the fields of a class.
     *
     * @param clazz The Class object whose fields are to be inspected.
     */
    public static void inspectFields(Class<?> clazz) {
        System.out.println("Fields:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Name: " + field.getName());
            System.out.println("Type: " + field.getType().getSimpleName());
            System.out.println("Modifiers: " + Modifier.toString(field.getModifiers()));
            System.out.println("-----");
        }
        System.out.println();
    }

    /**
     * Inspects the constructors of a class.
     *
     * @param clazz The Class object whose constructors are to be inspected.
     */
    public static void inspectConstructors(Class<?> clazz) {
        System.out.println("Constructors:");
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("Name: " + constructor.getName());
            System.out.println("Parameters: ");
            Class<?>[] paramTypes = constructor.getParameterTypes();
            for (Class<?> paramType : paramTypes) {
                System.out.println("- " + paramType.getSimpleName());
            }
            System.out.println("Modifiers: " + Modifier.toString(constructor.getModifiers()));
            System.out.println("-----");
        }
        System.out.println();
    }

    /**
     * Inspects the methods of a class.
     *
     * @param clazz The Class object whose methods are to be inspected.
     */
    public static void inspectMethods(Class<?> clazz) {
        System.out.println("Methods:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            // Exclude synthetic and lambda methods
            if (!method.isSynthetic() && !method.getName().contains("lambda$")) {
                System.out.println("Name: " + method.getName());
                System.out.println("Return Type: " + method.getReturnType().getSimpleName());
                System.out.println("Parameters: ");
                Class<?>[] paramTypes = method.getParameterTypes();
                for (Class<?> paramType : paramTypes) {
                    System.out.println("- " + paramType.getSimpleName());
                }
                System.out.println("Modifiers: " + Modifier.toString(method.getModifiers()));
                System.out.println("-----");
            }
        }
        System.out.println();
    }
}