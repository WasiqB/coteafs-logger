# coteafs-logger

## What's this is all about?

coteafs-logger is a wrapper library on top of **log4j2**. This library was created to simplify the logging as there is no need to add two dependency of log4j2. Also the logger config is simplified by introducing Yaml style of configs.

## What this library offers?

By default if you don't provide the logger config, it will output the logs on the console. But if the logger file is provided, it will have precedence over default behavior.

## Logger config file

The config file should be placed in `src/main/resources`. Following is the sample logger config which will add 3 log files and will archive the logs on,

- Every run
- Log file size exceeds 5 MB
- Every next day

**`coteafs-logger.yml`**

```yaml
status: WARN
monitor_interval: 30

properties:
  - name: log-path
    value: logs   # Log folder name.
  - name: error-log
    value: my-log-error   # All Errors will be logged in this log file.
  - name: all-log
    value: my-log-all   # All types of logs will be logged in this log file.
  - name: test-log
    value: my-log-main    # All info logs will be logged in this log file.
  - name: log-pattern
    value: "[%d{HH:mm:ss.SSS}] [%-5level] - %msg (%logger{1}:%L) %throwable{short.message}%n"

appenders:
  - name: console-log
    plugin: Console
    layout:
      plugin: PatternLayout
      attributes:
        pattern: ${log-pattern}
    attributes:
      target: SYSTEM_OUT
  - name: all-log-appender
    plugin: RollingFile
    attributes:
      fileName: ${log-path}/${all-log}.log
      filePattern: ${log-path}/${all-log}-%d{yyyy-MM-dd}-%i.log
      immediateFlush: true
    layout:
      plugin: PatternLayout
      attributes:
        pattern: ${log-pattern}
    component:
      plugin: Policies
      components:
        - plugin: TimeBasedTriggeringPolicy
          attributes:
            interval: 1
            modulate: true
        - plugin: SizeBasedTriggeringPolicy
          attributes:
            size: 5 MB
        - plugin: OnStartupTriggeringPolicy
  - name: test-log-appender
    plugin: RollingFile
    attributes:
      fileName: ${log-path}/${test-log}.log
      filePattern: ${log-path}/${test-log}-%d{yyyy-MM-dd}-%i.log
      immediateFlush: true
    layout:
      plugin: PatternLayout
      attributes:
        pattern: ${log-pattern}
    component:
      plugin: Policies
      components:
        - plugin: TimeBasedTriggeringPolicy
          attributes:
            interval: 1
            modulate: true
        - plugin: SizeBasedTriggeringPolicy
          attributes:
            size: 5 MB
        - plugin: OnStartupTriggeringPolicy
  - name: error-log-appender
    plugin: RollingFile
    attributes:
      fileName: ${log-path}/${error-log}.log
      filePattern: ${log-path}/${error-log}-%d{yyyy-MM-dd}-%i.log
      immediateFlush: true
    layout:
      plugin: PatternLayout
      attributes:
        pattern: ${log-pattern}
    component:
      plugin: Policies
      components:
        - plugin: TimeBasedTriggeringPolicy
          attributes:
            interval: 1
            modulate: true
        - plugin: SizeBasedTriggeringPolicy
          attributes:
            size: 5 MB
        - plugin: OnStartupTriggeringPolicy
  - name: async
    plugin: Async
    appender_ref:
      - ref: "test-log-appender"

loggers:
  level: ALL  
  appender_ref:
  - ref: "console-log"
    attributes:
      level: DEBUG
  - ref: "async"
    attributes:
      level: INFO
  - ref: "all-log-appender"
    attributes:
      level: TRACE
  - ref: "error-log-appender"
    attributes:
      level: ERROR
```

## Usage?

You can drop the dependency into your `pom.xml` to use this library.

```xml
<dependency>
  <groupId>com.github.wasiqb.coteafs</groupId>
  <artifactId>logger</artifactId>
  <version>1.8.0</version>
</dependency>
```
