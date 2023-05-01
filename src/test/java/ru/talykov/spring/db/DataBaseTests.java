package ru.talykov.spring.db;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.talykov.spring.shared.AbstractTest;

class DataBaseTests extends AbstractTest {
    @Test
    void firstTest(){
        int a = 1;
        int b = Integer.parseInt("2") - 1;
        Assertions.assertThat(a)
                .isEqualTo(b);
    }
}
