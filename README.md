# British Spoken Time (Strategy Pattern) - Java 21

A Java 21 project converting `HH:mm` time strings into British spoken form using the **Strategy pattern**.

## Highlights
- Java 21 toolchain
- Gradle build
- Checkstyle integration
- JaCoCo test coverage with HTML report
- GitHub Actions CI (runs JUnit, JaCoCo, Checkstyle)

## Design
- `TimeSpeaker` (Strategy interface)
- `BritishTimeSpeaker` (British rules implementation)
- `SpeakerContext` (context that holds a strategy)
- `BritishTimeConverter` (facade that parses input and delegates)

## How to build & run
Requirements: JDK 21
Build & run tests:
```
./gradlew test
```
Run the app:
```
./gradlew run
```
Generate JaCoCo report:
```
./gradlew jacocoTestReport
# open build/reports/jacoco/html/index.html
```

## Notes
- Package root: `com.andela.smartbear.britishtime`
- The project uses documented and consistent spoken-time rules (past/to/quarter/half/noon/midnight).
