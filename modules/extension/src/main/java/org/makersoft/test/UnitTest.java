/*
 * @(#)UnitTest.java 2013-1-22 下午1:56:53
 *
 * Copyright (c) 2011-2013 Makersoft.org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 */
package org.makersoft.test;

import org.junit.Assert;

/**
 * 单元测试基类.
 */
public class UnitTest extends Assert{

	/**
	 * Pause the current thread
	 */
	public void pause(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}
}
