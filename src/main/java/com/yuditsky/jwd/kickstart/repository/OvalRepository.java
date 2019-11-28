package com.yuditsky.jwd.kickstart.repository;

import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.repository.specification.Specification;

import java.util.List;

public interface OvalRepository {
    void add(Oval oval);

    void remove(Oval oval);

    List<Oval> readAll();

    List<Oval> query(Specification specification);
}
