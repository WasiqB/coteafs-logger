# coteafs-logger

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)][home]
[![CircleCI](https://circleci.com/gh/WasiqB/coteafs-logger.svg?style=svg)][circleci]
[![Test Coverage](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alogger&metric=coverage)][coverage]
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alogger&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.github.wasiqb.coteafs%3Alogger)
[![Maintainability](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alogger&metric=sqale_rating)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Alogger&metric=Maintainability)
[![Reliability](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alogger&metric=reliability_rating)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Alogger&metric=Reliability)
[![Security](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alogger&metric=security_rating)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Alogger&metric=Security)
[![Vulnurability](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alogger&metric=vulnerabilities)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Alogger&metric=new_vulnerabilities)
[![Duplicate Code](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Alogger&metric=duplicated_lines_density)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Alogger&metric=Duplications)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.wasiqb.coteafs/logger.svg)][maven]
[![Github Releases](https://img.shields.io/github/downloads/WasiqB/coteafs-logger/total.svg)](https://github.com/WasiqB/coteafs-logger/releases)


## :boom: What's this all about?

coteafs-logger is a wrapper library on top of **log4j2**. This library was created to simplify the logging as there is no need to add two dependency of log4j2. Also the logger config is simplified by introducing Yaml style of configs.

## :golf: What this library offers?

By default if you don't provide the logger config, it will output the logs on the console. But if the logger file is provided, it will have precedence over default behavior.

## :soccer: Logger config file

The config file should be placed in `src/main/resources.` 
Following is the sample logger config which will create 3 different log files, as follows:

1. log-error.log -- It will contain error and fatal logs only.
2. log-main.log  -- It will contain info as well as error and fatal logs.
3. log-all.log   -- It will contain all the logs, i.e. Info, error, warn, debug, trace and fatal.

The above generated files will be archived on the following basis:

- On Every Automation Run
- When log file size exceeds 5 mb.
- Every next day.

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

## :pushpin: Usage?

You can use the following dependency into your `pom.xml` to use this library.

```xml
<dependency>
  <groupId>com.github.wasiqb.coteafs</groupId>
  <artifactId>logger</artifactId>
  <version>1.8.0</version>
</dependency>
```

## :question: Need Assistance?
* Directly chat with me on my [site][] and I'll revert to you as soon as possible.
* Discuss your queries by writing to me @ wasbhamla2005@gmail.com
* If you find any issue which is bottleneck for you, [search the issue tracker][] to see if it is already raised.
* If not raised, then you can create a [new issue][] with required details as mentioned in the issue template.

## :star: What you do if you like the project?
* Spread the word with your network.
* **Star** the project to make the project popular.
* Stay updated with the project progress by **Watching** it.
* Contribute to fix open issues, documentations or add new features. To know more, see our [contributing][] page.
* I would be delighted if you can **Sponsor** this project and provide your support to open source development by clicking on the **Sponsor button** on the top of this repository.

## :heavy_check_mark: Contributors

<div>
  <ul>
    <li>
      <a href="https://github.com/WasiqB">
        <img alt="Wasiq Bhamla: Framework developer and maintainer." src="https://github.com/WasiqB.png" width=100 height=100 />
      </a>
    </li>
    <li>
      <a href="https://github.com/mfaisalkhatri">
        <img alt="Mohammad Faisal Khatri: Framework Tester." src="https://github.com/mfaisalkhatri.png" width=100 height=100 />
      </a>
    </li>
  </ul>
</div>

## :ticket: Versioning ideology

<p align="left">
  <a href="http://semver.org/">
    <img src="assets/semver.png" width=300 />
  </a>
</p>

## :copyright:Wasiq Bhamla

<p align="left">
  <a href="http://www.apache.org/licenses/LICENSE-2.0">
    <img src="http://www.apache.org/img/asf_logo.png" width=300 />
  </a>
</p>

[site]: https://wasiqb.github.io
[search the issue tracker]: https://github.com/WasiqB/coteafs-logger/issues?q=something
[new issue]: https://github.com/WasiqB/coteafs-logger/issues/new
[contributing]: .github/CONTRIBUTING.md
[home]: https://github.com/wasiqb/coteafs-logger
[circleci]: https://circleci.com/gh/WasiqB/coteafs-logger
[coverage]: https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Alogger&metric=Coverage
[maven]: https://maven-badges.herokuapp.com/maven-central/com.github.wasiqb.coteafs/logger
