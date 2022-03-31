package com.company;

import com.company.SomeSmallTest;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;

import java.io.IOException;

public class Runner {
  public static void main(String[] args) throws IOException {


    /*    TestExecutor executor = new TestExecutor(
            Model1Test.class

    );
        Result result = executor.execute(true);
    System.out.println("Done: [" + result.getResults().toString(2) + "]");*/

    /*TestExecutor executor2 = new TestExecutor(
            Model2Test.class

    );

    Result result2 = executor2.execute(true);
    System.out.println("Done: [" + result2.getResults().toString(2) + "]");*/
    TestExecutor executor3 = new TestExecutor(
            Model3Test.class

    );
    Result result3 = executor3.execute(true);
    System.out.println("Done: [" + result3.getResults().toString(2) + "]");
  }
}
