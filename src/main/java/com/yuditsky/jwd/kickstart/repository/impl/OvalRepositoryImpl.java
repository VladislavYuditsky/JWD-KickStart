package com.yuditsky.jwd.kickstart.repository.impl;

import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.repository.OvalRepository;
import com.yuditsky.jwd.kickstart.repository.specification.Specification;

import java.util.ArrayList;
import java.util.List;

public class OvalRepositoryImpl implements OvalRepository {
    private List<Oval> ovals = new ArrayList<>();

    @Override
    public void add(Oval oval) {
        ovals.add(oval);
    }

    @Override
    public void remove(Oval oval) {
        ovals.remove(oval);
    }

    @Override
    public List<Oval> readAll() {
        return ovals;
    }

    @Override
    public List<Oval> query(Specification specification) {
        List<Oval> specificOvals = new ArrayList<>();
        for (Oval oval : ovals) {
            if (specification.specify(oval)) {
                specificOvals.add(oval);
            }
        }
        return specificOvals;
    }
}
