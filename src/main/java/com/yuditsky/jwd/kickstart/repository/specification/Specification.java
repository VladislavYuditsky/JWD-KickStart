package com.yuditsky.jwd.kickstart.repository.specification;

import com.yuditsky.jwd.kickstart.bean.Oval;

public interface Specification {
    boolean specify(Oval oval);
}
