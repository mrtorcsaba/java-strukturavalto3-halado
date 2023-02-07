package org.training360.week01.day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public interface BeforeAlgorithms {



    @BeforeEach
    default void init(TestInfo info){
        System.out.println(info.toString());
    }
}
