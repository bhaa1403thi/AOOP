# Bank Account Management System (Java)

A beginner-friendly Java OOP practical project demonstrating:
- Money value object
- Bank account and account status
- Deposit and withdrawal validation
- Overdraft limit checking
- Freeze, unfreeze, and close operations
- Fund transfer with an in-memory compensating rollback
- Immutable ledger entries and transaction history

## Requirements
- JDK 21 (or Java 11+)

## Open in VS Code
1. Extract this ZIP file.
2. Open the `BankAccountManagementSystem` folder in VS Code.
3. Open Terminal > New Terminal.
4. Make sure the terminal is in the project root folder.

## Compile
In PowerShell:

```powershell
javac -d out src\*.java
```

## Run
```powershell
java -cp out Main
```

Or on Windows, double-click `run.bat` or run `.un.bat` from PowerShell.

## Important note
This is an educational, in-memory demonstration. The ledger is stored only while the program runs.
The transfer rollback demonstrates compensation for an application exception; it is not a substitute
for a real database transaction. A production banking system needs durable database transactions,
concurrency control, authentication, audit logging, and recovery handling.
