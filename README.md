# karate-test-framework

This framework runs api and performance tests on be spring based api located at 'https://github.com/lubchynsky/spring-be-api'

This app should be up and running before tests execution

## Used frameworks and libraries
- karate
- gatling for performance tests with scala
- logback

## gatling performance test execution

mvn clean test-compile gatling:test