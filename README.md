# 🕒 British Spoken Time (Strategy + Factory Pattern)

## 🧭 Overview
**British Spoken Time** is a Java 21 application that converts digital time (HH:mm) into its **British spoken form**, e.g.  
`5:45 → "quarter to six"`, `12:00 → "noon"`, `00:00 → "midnight"`.

This project demonstrates clean code architecture using the **Strategy** and **Factory** design patterns to handle various time conversion rules dynamically.

---

## 🧠 Architecture

### 🔹 Design Patterns Used
- **Strategy Pattern:**  
  Encapsulates each time conversion rule (e.g., quarter past, half past, exact hour) into its own class implementing a shared interface.

- **Factory Pattern:**  
  Determines at runtime which strategy should handle the given hour and minute combination (e.g., `QuarterToStrategy`, `NoonStrategy`, etc.).

---


### 🔹 Class Structure
---
```
src/main/java/com/andela/smartbear/britishtime
│
├── strategy
│ ├── TimeSpeakerStrategy.java
│ ├── ExactHourStrategy.java
│ ├── QuarterPastStrategy.java
│ ├── HalfPastStrategy.java
│ ├── QuarterToStrategy.java
│ ├── MinutesPastStrategy.java
│ ├── MinutesToStrategy.java
│ ├── MidnightStrategy.java
│ └── NoonStrategy.java
│
├── factory
│ └── TimeSpeakerFactory.java
│
└── TimeConverter.java
```

---

## ⚙️ How It Works

The `TimeConverter` delegates time interpretation to the `TimeSpeakerFactory`,  
which dynamically picks a strategy class that implements `TimeSpeakerStrategy`.

Each strategy provides its own implementation of `convert(int hour, int minute)`.

Example:
- `00:00` → handled by `MidnightStrategy`
- `12:00` → handled by `NoonStrategy`
- `5:15` → handled by `QuarterPastStrategy`
- `5:31` → handled by `MinutesToStrategy`

---

### Example JUnit Test Snippet

```java
@Test
void testQuarterTo() {
    BritishTimeSpeaker converter = new BritishTimeSpeaker();
    assertEquals("quarter to six", converter.convertToBritishTime(5, 45));
}
```
```java
BritishTimeSpeaker converter = new BritishTimeSpeaker();

System.out.println(converter.convertToBritishTime(5, 0));   // five o'clock
System.out.println(converter.convertToBritishTime(5, 15));  // quarter past five
System.out.println(converter.convertToBritishTime(12, 0));  // noon
System.out.println(converter.convertToBritishTime(0, 0));   // midnight
```
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

## 📄 License
MIT License © 2025 — Developed by **Vaibhav Ghatge**


