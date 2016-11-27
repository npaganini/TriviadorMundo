package view;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import controller.TestJunitController;
import model.TestJunitModel;

/**
 * Sets a JUnit Suite class to run all test classes together.
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
   TestJunitModel.class,
   TestJunitController.class,
   TestJunitView.class
})

public class JunitTestSuite {
}
