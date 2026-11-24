# Java Library Management System (OOP)

A clean, modular Java console application demonstrating core **Object-Oriented Programming (OOP)** principles:
- **Abstraction & Inheritance:** `LibraryItem` abstract base class extended by `Book` and `DVD`; `Member` extended by `Student` and `Staff`.
- **Polymorphism:** Overridden `calculateLateFee(int daysLate)` behavior across item types.
- **Encapsulation & Validation:** Private fields, guarded setters/methods, and defensive input checks with clear exceptions.

## Project Structure
- `src/lms/model/` — Domain models (`LibraryItem`, `Book`, `DVD`, `Member`, `Student`, `Staff`)
- `src/lms/service/` — Catalog and member management (`Library`)
- `src/lms/Main.java` — Sample execution and validation demo

## How to Compile and Run
```bash
javac -d out $(find src -name "*.java")
java -cp out lms.Main
```
