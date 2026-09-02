# spring-beans

Maven project with Java 21 and `spring-core` dependency.

Prerequisites:

- Java 21 JDK installed
- Maven installed

Build:

```bash
mvn -f "spring-beans/pom.xml" clean package
```

Run (via Maven exec):

```bash
mvn -f "spring-beans" exec:java -Dexec.mainClass=com.example.springbeans.Application
```

Or run the compiled classes/jar as appropriate.
