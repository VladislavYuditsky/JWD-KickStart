package com.yuditsky.jwd.kickstart.observer;

public interface Observer<T> {
    void handleEvent(T t);
}
