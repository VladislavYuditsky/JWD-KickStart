package com.yuditsky.jwd.first_task.service;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class OvalServiceRunListener extends RunListener {
    @Override
    public void testStarted(Description description) throws Exception {
        System.out.println("Test started: " + description.getMethodName());
    }

    @Override
    public void testFinished(Description description) throws Exception {
        System.out.println("Test finished: " + description.getMethodName());
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        System.out.println("Test failure with exception: "
                + failure.getException());
    }

    @Override
    public void testIgnored(Description description) throws Exception {
        System.out.println("Test ignored: " + description.getMethodName());
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println("Test results:");
        System.out.println("Run time: (" + result.getRunTime()
                + ") millis");
        System.out.println("Number of tests executed: " + result.getRunCount());
        System.out.println("Number of tests failed: " + result.getFailureCount());
        System.out.println("Number of tests ignored: " + result.getIgnoreCount());
        System.out.println("All tests executed successfully: "
                + result.wasSuccessful());
    }
}
