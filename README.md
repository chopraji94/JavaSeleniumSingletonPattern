Markdown

# Java Selenium Singleton Design Pattern

This repository demonstrates the implementation of the **Singleton Design Pattern** in a Selenium Automation Framework. The primary goal of this project is to manage the **WebDriver** instance efficiently, ensuring that only one browser instance is created and shared across the test execution lifecycle.


## 🎯 Why Singleton Pattern?

In Test Automation, managing the `WebDriver` instance is critical. Without a proper design pattern:
* Multiple unnecessary browser windows may open.
* System memory usage increases significantly.
* Tests may become flaky due to unmanaged driver states.

**The Singleton Pattern resolves this by:**
1.  **Lazy Initialization**: The browser is only launched when the first test requests it.
2.  **Single Instance**: Ensuring strictly one instance of the `WebDriver` exists per execution thread.
3.  **Global Access**: Providing a global point of access to the driver instance via a static method.

## 🛠️ Tech Stack

* **Language**: Java (JDK 8+)
* **Automation**: Selenium WebDriver
* **Test Runner**: TestNG
* **Build Tool**: Maven

## 📂 Project Structure

```text
JavaSeleniumSingletonPattern
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── singleton
│   │               └── DriverSingleton.java  # The Singleton Class (Core Logic)
│   ├── test
│   │   └── java
│   │       └── com
│   │           └── tests
│   │               └── GoogleSearchTest.java # Test Class consuming the Singleton
├── pom.xml                                   # Dependencies
└── testng.xml                                # Test Configuration
```

⚙️ How It Works
The core logic resides in the DriverSingleton class. Here is a conceptual overview of the implementation:

Private Constructor: Prevents any external class from instantiating new DriverSingleton().

Private Static Instance: Holds the single instance of the class (or the Driver).

Public Static Method: Checks if the instance is null. If it is, it initializes the driver; otherwise, it returns the existing instance.

Usage in Tests
Instead of creating a new driver in every test (WebDriver driver = new ChromeDriver();), you simply call the static instance:

Java

// In your Test Class
@Test
public void testSearch() {
    // Get the single instance of the driver
    WebDriver driver = DriverSingleton.getDriverInstance();
    
    driver.get("[https://www.google.com](https://www.google.com)");
    // ... perform actions
}
📦 Dependencies
Ensure your pom.xml contains the following:

selenium-java

testng

webdrivermanager (Optional, but recommended for driver setup)

🏃‍♂️ How to Run
Using Maven
To run the tests from the command line:

Bash

mvn clean test
Using IDE (IntelliJ / Eclipse)
Open testng.xml or the specific Test class (GoogleSearchTest.java).

Right-click and select Run.

🤝 Contributing
Fork the repository.

Create your feature branch (git checkout -b feature/NewSingletonFeature).

Commit your changes.

Push to the branch.

Open a Pull Request.

📚 References
Singleton Pattern - GeeksforGeeks

Selenium WebDriver Documentation
