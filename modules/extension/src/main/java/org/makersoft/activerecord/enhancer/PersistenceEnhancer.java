/*
 * @(#)PersistenceEnhancer.java 2012-9-24 下午1:27:41
 *
 * Copyright (c) 2011-2012 Makersoft.org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 */
package org.makersoft.activerecord.enhancer;

import java.io.InputStream;

import javassist.CtClass;
import javassist.CtMethod;

/**
 * Class description goes here.
 * 
 * @version 2012-9-24 下午1:27:41
 * @author Feng Kuok
 */
public class PersistenceEnhancer extends Enhancer{

	@Override
	public void enhanceThisClass(InputStream inputStream) throws Exception {
		CtClass ctClass = super.makeClass(inputStream);
		
		
        if (!ctClass.subtypeOf(classPool.get("org.makersoft.roo.model.ActiveRecord"))) {
            return;
        }
        
        String entityName = ctClass.getName();
        
        // Enhance only JPA entities
        if (!hasAnnotation(ctClass, "javax.persistence.Entity")) {
            return;
        }

        // count
        CtMethod count = CtMethod.make("public static long count() { return getMyBatisContext().count(" + entityName + ".class); }", ctClass);
//        CtMethod count = CtMethod.make("public static long count() { return org.makersoft.roo.model.ActiveRecord.getMyBatisContext().count(" + entityName + ".class); }", ctClass);
        ctClass.addMethod(count);

//        // findAll
//        CtMethod findAll = CtMethod.make("public static java.util.List findAll() { return  getJPAConfig("+entityName+".class).jpql.findAll(\"" + entityName + "\"); }", ctClass);
//        ctClass.addMethod(findAll);
//
//        // findById
//        CtMethod findById = CtMethod.make("public static play.db.jpa.JPABase findById(Object id) { return  getJPAConfig("+entityName+".class).jpql.findById(\"" + entityName + "\", id); }", ctClass);
//        ctClass.addMethod(findById);
//
//        // find
//        CtMethod find = CtMethod.make("public static play.db.jpa.GenericModel.JPAQuery find(String query, Object[] params) { return  getJPAConfig("+entityName+".class).jpql.find(\"" + entityName + "\", query, params); }", ctClass);
//        ctClass.addMethod(find);
//
//        // find
//        CtMethod find2 = CtMethod.make("public static play.db.jpa.GenericModel.JPAQuery find() { return  getJPAConfig("+entityName+".class).jpql.find(\"" + entityName + "\"); }", ctClass);
//        ctClass.addMethod(find2);
//
//        // all
//        CtMethod all = CtMethod.make("public static play.db.jpa.GenericModel.JPAQuery all() { return  getJPAConfig("+entityName+".class).jpql.all(\"" + entityName + "\"); }", ctClass);
//        ctClass.addMethod(all);
//
//        // delete
//        CtMethod delete = CtMethod.make("public static int delete(String query, Object[] params) { return  getJPAConfig("+entityName+".class).jpql.delete(\"" + entityName + "\", query, params); }", ctClass);
//        ctClass.addMethod(delete);
//
//        // deleteAll
//        CtMethod deleteAll = CtMethod.make("public static int deleteAll() { return  getJPAConfig("+entityName+".class).jpql.deleteAll(\"" + entityName + "\"); }", ctClass);
//        ctClass.addMethod(deleteAll);
//
//        // findOneBy
//        CtMethod findOneBy = CtMethod.make("public static play.db.jpa.JPABase findOneBy(String query, Object[] params) { return  getJPAConfig("+entityName+".class).jpql.findOneBy(\"" + entityName + "\", query, params); }", ctClass);
//        ctClass.addMethod(findOneBy);
//
//        // create
//        CtMethod create = CtMethod.make("public static play.db.jpa.JPABase create(String name, play.mvc.Scope.Params params) { return  getJPAConfig("+entityName+".class).jpql.create(\"" + entityName + "\", name, params); }", ctClass);
//        ctClass.addMethod(create);

        // Done.
//        applicationClass.enhancedByteCode = ctClass.toBytecode();
        ctClass.defrost();
        
        this.getClass().getClassLoader().loadClass(ctClass.toClass().getName());
	}

}
