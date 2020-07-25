package com.sdqube.service;

import com.sdqube.service.logger.SDQubeLogger;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/26/20 2:52 AM
 */
public class Injector {
    private static final SDQubeLogger logger = SDQubeLogger.getLogger(Injector.class);

    private Injector() {
        //Empty on purpose
    }

    public static <T> T instance(String className) {
        try {
            return (T) Class.forName(className).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            logger.error("Exception on instance creation : " + className, e);
        }
        return null;
    }

    public static <T> T instance(String className, Class[] clazz, Object[] args) {
        try {
            return (T) Class.forName(className).getConstructor(clazz).newInstance(args);
        } catch (InstantiationException
                | IllegalAccessException
                | NoSuchMethodException
                | InvocationTargetException
                | ClassNotFoundException e) {
            logger.error("Exception on instance creation : " + className, e);
        }
        return null;
    }
}