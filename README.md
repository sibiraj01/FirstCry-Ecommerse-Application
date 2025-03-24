# Automated Testing Framework - FirstCry E-commerce

## 📌 Project Overview
This is an automated testing framework developed using **Selenium WebDriver, TestNG, and Java** to test the functionalities of the FirstCry e-commerce website. The framework includes various test cases such as:
- Navigating to the website
- Verifying page elements
- Searching for products
- Handling multiple windows
- Validating product details
- Adding products to the cart
- Cart page validation

## 🛠 Technologies Used
- **Java** (Programming Language)
- **Selenium WebDriver** (UI Automation)
- **TestNG** (Test Execution & Reporting)
- **Log4j** (Logging)
- **WebDriverManager** (Browser Driver Management)
- **Apache Maven** (Build Management)

## 📂 Project Structure
```
├── src/test/java/steps
│   ├── Login.java  (Test case implementation)
│   ├── ScreenShotsUtils.java  (Screenshot utility)
│   ├── WindowUtils.java  (Window handling utility)
│   ├── ActionUtils.java  (Scroll & UI actions utility)
│   ├── waitUtils.java  (Explicit wait utilities)
│
├── src/test/resources
│   ├── Xpath.properties  (Locators for elements)
│
├── pom.xml  (Maven dependencies)
├── testng.xml  (TestNG suite configuration)
├── README.md  (Project documentation)
```

## 🚀 Setup & Installation
### **Prerequisites:**
Ensure you have the following installed on your system:
- Java JDK 8 or later
- Maven
- Google Chrome (latest version)
- IntelliJ IDEA / Eclipse

### **Steps to Setup the Project:**
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/your-repo.git
   ```
2. Navigate to the project folder:
   ```sh
   cd your-repo
   ```
3. Install dependencies:
   ```sh
   mvn clean install
   ```
4. Run the test suite:
   ```sh
   mvn test
   ```

## 📝 Test Execution
- **Run all test cases:**
  ```sh
  mvn test
  ```
- **Run a specific test class:**
  ```sh
  mvn -Dtest=Login test
  ```

## 📸 Screenshots
Screenshots are automatically captured for every test and stored in the `screenshots` folder for debugging purposes.

## 📌 Reporting
Test reports are generated using TestNG and can be found under:
```
./test-output/index.html
```
Open this file in a browser to view the test results.

## 🔍 Troubleshooting
- If tests fail due to missing ChromeDriver, ensure WebDriverManager is correctly set up.
- If elements are not found, update the `Xpath.properties` file with the latest locators.
- Always run `mvn clean install` before executing tests to refresh dependencies.

## 🏆 Contributions
Feel free to contribute to this project by forking the repository and submitting pull requests.

## 📧 Contact
For any queries, reach out at: **sibir0252@gmail.com**

