package com.zizitop.course.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PackageScanner {

    public static List<Class<?>> scanPackage(String packageName) {
        String packagePath = packageName.replace('.', '/');
        List<Class<?>> classes = new ArrayList<>();

        // Get the class loader for the current thread
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = PackageScanner.class.getClassLoader();
        }

        try {
            // Get the resource URL for the package path
            File packageDirectory = new File(classLoader.getResource(packagePath).getFile());

            // List all files and directories in the package directory
            File[] files = packageDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".class")) {
                        // Remove the ".class" extension and convert the file path to a fully qualified class name
                        String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                        Class<?> clazz = Class.forName(className);
                        classes.add(clazz);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return classes;
    }
}
