package com.aiways.androidut.junit.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(CategoryMarker.SlowTests.class)
@Suite.SuiteClasses({TestA.class, TestB.class})
public class SlowTestSuite {
}
