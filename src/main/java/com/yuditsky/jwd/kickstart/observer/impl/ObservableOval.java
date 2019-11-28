package com.yuditsky.jwd.kickstart.observer.impl;

import com.yuditsky.jwd.kickstart.bean.Dot;
import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.bean.impl.OvalImpl;
import com.yuditsky.jwd.kickstart.observer.Observable;
import com.yuditsky.jwd.kickstart.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ObservableOval implements Observable<Oval>, Oval {
    private Oval oval;
    private List<Observer> observers = new ArrayList<>();

    public ObservableOval() {
        oval = new OvalImpl();
    }

    public ObservableOval(Oval oval) {
        this.oval = oval;
    }

    public Oval getOval() {
        return oval;
    }

    public void setOval(Oval oval) {
        this.oval = oval;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
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
        for (Observer observer : observers) {
            observer.handleEvent(oval);
        }
    }

    @Override
    public Dot getDot1() {
        return oval.getDot1();
    }

    @Override
    public void setDot1(Dot dot1) {
        oval.setDot1(dot1);
        notifyObservers();
    }

    @Override
    public Dot getDot2() {
        return oval.getDot2();
    }

    @Override
    public void setDot2(Dot dot2) {
        oval.setDot2(dot2);
        notifyObservers();
    }
}
