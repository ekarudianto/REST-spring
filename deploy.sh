echo 'Build packages';

gradle build

echo 'Deploy app';

java -jar build/libs/spring-rest-service-0.1.0.jar