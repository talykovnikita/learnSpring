package ru.talykov.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.talykov.spring.postgres.repository.UsersRepository;
import ru.talykov.spring.testservice.api.rest.clients.TestServiceApiClient;
import ru.talykov.spring.testservice.api.verifiers.TestServiceConfigurationVerifier;
import ru.talykov.spring.testservice.api.verifiers.TestServiceVerifier;
import ru.talykov.spring.testservice.managers.TestServiceManager;

@SpringBootTest
public abstract class AbstractTest {

  /* Configurations */
  @Autowired protected MockConfiguration mockConfiguration;

  @Autowired protected TestServiceConfiguration testServiceConfiguration;

  /* Mountebank mock */
  // TODO: Create client mountebank

  /* Database */
  @Autowired protected UsersRepository usersRepository;

  /* Expected test data providers */
  @Autowired protected TestServiceManager testServiceManager;

  /* Clients */
  @Autowired protected TestServiceApiClient testServiceApiClient;

  /* Verifiers */
  @Autowired protected TestServiceVerifier testServiceVerifier;

  @Autowired protected TestServiceConfigurationVerifier testServiceConfigurationVerifier;
}
