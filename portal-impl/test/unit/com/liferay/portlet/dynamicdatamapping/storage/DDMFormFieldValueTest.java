/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.dynamicdatamapping.storage;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.dynamicdatamapping.BaseDDMTestCase;
import com.liferay.portlet.dynamicdatamapping.model.UnlocalizedValue;

import org.junit.Test;

import org.testng.Assert;

/**
 * @author Marcellus Tavares
 */
public class DDMFormFieldValueTest extends BaseDDMTestCase {

	@Test
	public void testEqualsWithDifferentInstanceId() {
		DDMFormFieldValue ddmFormFieldValue1 = createDDMFormFieldValue(
			StringUtil.randomString(), "Test", new UnlocalizedValue("Value"));

		DDMFormFieldValue ddmFormFieldValue2 =  createDDMFormFieldValue(
			StringUtil.randomString(), "Test", new UnlocalizedValue("Value"));

		Assert.assertFalse(ddmFormFieldValue1.equals(ddmFormFieldValue2));
	}

	@Test
	public void testEqualsWithDifferentName() {
		DDMFormFieldValue ddmFormFieldValue1 = createDDMFormFieldValue(
			"xhsy", StringUtil.randomString(), new UnlocalizedValue("Value"));

		DDMFormFieldValue ddmFormFieldValue2 = createDDMFormFieldValue(
			"xhsy", StringUtil.randomString(), new UnlocalizedValue("Value"));

		Assert.assertFalse(ddmFormFieldValue1.equals(ddmFormFieldValue2));
	}

	@Test
	public void testEqualsWithDifferentNestedDDMFormFieldValues() {
		DDMFormFieldValue ddmFormFieldValue1 = createDDMFormFieldValue(
			"xhsy", "Test", new UnlocalizedValue("Value"));

		ddmFormFieldValue1.addNestedDDMFormFieldValue(
			createDDMFormFieldValue(
				"jamy", "Nested", new UnlocalizedValue("Nested Value")));

		DDMFormFieldValue ddmFormFieldValue2 = createDDMFormFieldValue(
			"xhsy", "Test", new UnlocalizedValue("Value"));

		ddmFormFieldValue2.addNestedDDMFormFieldValue(
			createDDMFormFieldValue(
				"jamy", "Nested",
				new UnlocalizedValue("Different Nested Value")));

		Assert.assertFalse(ddmFormFieldValue1.equals(ddmFormFieldValue2));
	}

	@Test
	public void testEqualsWithDifferentValue() {
		DDMFormFieldValue ddmFormFieldValue1 = createDDMFormFieldValue(
			"xhsy", "Test", new UnlocalizedValue("Value"));

		DDMFormFieldValue ddmFormFieldValue2 = createDDMFormFieldValue(
			"xhsy", "Test", new UnlocalizedValue("Different Value"));

		Assert.assertFalse(ddmFormFieldValue1.equals(ddmFormFieldValue2));
	}

	@Test
	public void testEqualsWithSameAttributes() {
		DDMFormFieldValue ddmFormFieldValue1 = createDDMFormFieldValue(
			"xhsy", "Test", new UnlocalizedValue("Value"));

		ddmFormFieldValue1.addNestedDDMFormFieldValue(
			createDDMFormFieldValue(
				"jamy", "Nested", new UnlocalizedValue("Nested Value")));

		DDMFormFieldValue ddmFormFieldValue2 = createDDMFormFieldValue(
			"xhsy", "Test", new UnlocalizedValue("Value"));

		ddmFormFieldValue2.addNestedDDMFormFieldValue(
			createDDMFormFieldValue(
				"jamy", "Nested", new UnlocalizedValue("Nested Value")));

		Assert.assertTrue(ddmFormFieldValue1.equals(ddmFormFieldValue2));
	}

}