spring.application.name=3-chat-history-jdbc
# PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=root
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
#spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

#Spring AI to create the chat memory table.
spring.ai.chat.memory.repository.jdbc.initialize-schema=always

spring.ai.openai.api-key={your key}