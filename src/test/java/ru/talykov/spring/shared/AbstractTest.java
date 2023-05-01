package ru.talykov.spring.shared;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.talykov.spring.configurations.MockConfiguration;
import ru.talykov.spring.configurations.TestServiceConfiguration;
import ru.talykov.spring.testservice.api.verifiers.TestServiceConfigurationVerifier;
import ru.talykov.spring.testservice.api.verifiers.TestServiceVerifier;
import ru.talykov.spring.testservice.api.rest.TestServiceApiClient;
import ru.talykov.spring.testservice.managers.TestServiceManager;

@SpringBootTest
@ExtendWith(SpringExtension.class)
abstract public class AbstractTest {

    /* Configurations */
    @Autowired
    protected MockConfiguration mockConfiguration;

    @Autowired
    protected TestServiceConfiguration testServiceConfiguration;

    /* Mountebank mock */
    // TODO: Создать клиента mountebank

    /* Data providers */
    @Autowired
    protected TestServiceManager testServiceManager;

    /* Clients */
    @Autowired
    protected TestServiceApiClient testServiceApiClient;

    /* Verifiers */
    @Autowired
    protected TestServiceVerifier testServiceVerifier;

    @Autowired
    protected TestServiceConfigurationVerifier testServiceConfigurationVerifier;
}
