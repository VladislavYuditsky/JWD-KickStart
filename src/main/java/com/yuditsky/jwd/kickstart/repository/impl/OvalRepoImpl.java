package com.yuditsky.jwd.kickstart.repository.impl;

import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.repository.OvalRepo;

import java.util.ArrayList;
import java.util.List;

public class OvalRepoImpl implements OvalRepo {
   List<Oval> ovals = new ArrayList<>();

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
}
