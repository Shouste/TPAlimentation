# TPAlimentation
TP Alimentation 
- <strong>Batch de chargement de la base de données</strong></br>
  Reste à faire : contrôle des enregistrements, pour exclure ceux non conformes (code groupe absent par ex, non numérique...)
- <strong>API de consultation d'un aliment par nom ou par id </strong></br>

exemple logback.xml :
<configuration debug="true">
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <property name="LOG_DIR" value="C:\\Users\\Sandrine\\projects" />
    <appender name="FILE" class="ch.qos.logback.core.FileAppender">
        <file>C:\\Users\\Sandrine\\projects\tests.log</file>
        <append>true</append>
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{35} - %msg%n</pattern>
        </encoder>
    </appender>

    <root level="info">
        <appender-ref ref="FILE" />
    </root>
</configuration>




