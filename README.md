# 🕒 British Spoken Time— Java 21

A **Java 21** application that converts 24-hour `HH:mm` time strings into **British spoken form** (e.g. `06:25 → "twenty five past six"`).  
Implements the **Strategy Design Pattern** for clean, extensible architecture.

---

## 🚀 Highlights

- ✅ **Java 21 toolchain**
- 🧱 **Gradle** build system
- 🧹 **Checkstyle** code-style validation
- 📊 **JaCoCo** test coverage with HTML report
- ⚙️ **GitHub Actions CI** (runs JUnit tests, Checkstyle, and JaCoCo)
- 🧠 **Strategy Pattern** for interchangeable time-speaking logic

---

## 🧩 Design Overview

| Component | Type | Responsibility |
|------------|-------|----------------|
| `TimeSpeaker` | Strategy Interface | Defines a contract for converting numeric time to spoken form |
| `BritishTimeSpeaker` | Concrete Strategy | Implements traditional British “past/to/quarter/half” rules |
| `SpeakerContext` | Context | Holds and delegates to a selected `TimeSpeaker` implementation |
| `BritishTimeConverter` | Facade | Parses `HH:mm` strings, validates input, and delegates to the context |
| `Main` | Entry Point | Provides an interactive console interface |

---

## 🧮 Example Outputs

| Input | Output |
|--------|---------|
| `1:00` | one o'clock |
| `2:05` | five past two |
| `3:10` | ten past three |
| `4:15` | quarter past four |
| `5:20` | twenty past five |
| `6:25` | twenty five past six |
| `6:32` | thirty two past six |
| `7:30` | half past seven |
| `7:35` | twenty five to eight |
| `8:40` | twenty to nine |
| `9:45` | quarter to ten |
| `10:50` | ten to eleven |
| `11:55` | five to twelve |
| `00:00` | midnight |
| `12:00` | noon |

---

## 🛠️ Build & Run

### 🧾 Requirements
- **JDK 21** or later
- **Gradle 8.5+** (wrapper included)

### 🧪 Build & Run Tests
```bash
./gradlew clean test
```

### ▶️ Run the Application
```bash
./gradlew run
```

### 📈 Generate JaCoCo Report
```bash
./gradlew jacocoTestReport
# then open:
# build/reports/jacoco/test/html/index.html
```

---

## 🧰 Project Structure

```
src/
 ├─ main/java/com/andela/smartbear/britishtime/
 │   ├─ Main.java
 │   ├─ TimeSpeaker.java
 │   ├─ BritishTimeSpeaker.java
 │   ├─ SpeakerContext.java
 │   └─ BritishTimeConverter.java
 └─ test/java/com/andela/smartbear/britishtime/
     ├─ BritishTimeSpeakerTest.java
     └─ BritishTimeConverterTest.java
```

---

## 🧑‍💻 Development Notes

- Package root: `com.andela.smartbear.britishtime`
- Uses **consistent British spoken-time rules** (`past` / `to` / `quarter` / `half` / `noon` / `midnight`)
- `Main` class excluded from JaCoCo coverage (non-testable CLI logic)
- Follows **SOLID principles** and clean code conventions

---

## 🧪 Continuous Integration (GitHub Actions)

The workflow automatically:
1. Builds the project using Java 21
2. Runs JUnit 5 tests and Checkstyle
3. Generates and uploads JaCoCo HTML + XML coverage reports
4. Publishes JUnit results as build artifacts

File: `.github/workflows/ci.yml`

---

## 🧠 Extensibility

You can easily add new time-speaking styles by implementing additional strategies:

```java
public class DigitalTimeSpeaker implements TimeSpeaker {
    @Override
    public String speak(int hour, int minute) {
        return hour + " " + minute;
    }
}
```

and inject it at runtime:

```java
SpeakerContext context = new SpeakerContext(new DigitalTimeSpeaker());
```

---

## 📄 License

MIT License © 2025 — Developed by **Vaibhav Ghatge**
