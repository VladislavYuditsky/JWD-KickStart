package com.yuditsky.jwd.kickstart.dao;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class OvalDAORunner extends BlockJUnit4ClassRunner {
    private OvalDAORunListener runListener;

    public OvalDAORunner(Class<OvalDAORunListener> clazz) throws InitializationError {
        super(clazz);
        runListener = new OvalDAORunListener();
    }

    public void run(RunNotifier notifier) {
        notifier.addListener(runListener);
        super.run(notifier);
    }
}
