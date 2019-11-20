package com.yuditsky.jwd.kickstart.observer.impl;

import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.observer.Observed;
import com.yuditsky.jwd.kickstart.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ObservedOval implements Observed {
    private Oval oval;
    private List<Observer> observers = new ArrayList<>();

    public void setOval(Oval oval) {
        this.oval = oval;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.handleEvent(oval);
        }
    }
}
