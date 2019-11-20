package com.yuditsky.jwd.kickstart.repository;

import com.yuditsky.jwd.kickstart.bean.Oval;

import java.util.List;

public interface OvalRepo {
    void add(Oval oval);

    void remove(Oval oval);

    List<Oval> readAll();
}
