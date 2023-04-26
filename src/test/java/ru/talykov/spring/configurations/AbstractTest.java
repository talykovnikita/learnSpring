package ru.talykov.spring.configurations;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.talykov.spring.testservice.api.rest.TestServiceClient;
import ru.talykov.spring.testservice.managers.TestServiceManager;

@SpringBootTest
@ExtendWith(SpringExtension.class)
abstract public class AbstractTest {

    @Autowired
    protected MockConfiguration mockConfiguration;

    @Autowired
    protected TestServiceConfiguration testServiceConfiguration;

    @Autowired
    protected TestServiceManager testServiceManager;

    @Autowired
    protected TestServiceClient testServiceClient;
}
