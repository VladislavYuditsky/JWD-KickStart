package com.yuditsky.jwd.first_task.service;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class OvalServiceRunner extends BlockJUnit4ClassRunner {
    private OvalServiceRunListener runListener;

    public OvalServiceRunner(Class<OvalServiceRunListener> clazz) throws InitializationError {
        super(clazz);
        runListener = new OvalServiceRunListener();
    }

    public void run(RunNotifier notifier) {
        notifier.addListener(runListener);
        super.run(notifier);
    }
}
