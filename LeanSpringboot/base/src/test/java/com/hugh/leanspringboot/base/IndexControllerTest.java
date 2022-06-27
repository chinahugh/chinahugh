package com.hugh.leanspringboot.base;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.IntStream;

class IndexControllerTest {

    @Test
    void index() {
        ArrayList<Object> objects = new ArrayList<>();
        IntStream.range(1, 10).forEach(objects::add);
        Iterator<Object> iterator = objects.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
            break;
        }
        System.out.println(objects);
    }
}
