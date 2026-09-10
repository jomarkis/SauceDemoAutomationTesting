# SauceDemo Test Automation Framework

> **Quick Language Switch:**  
> [🇬🇧 English Version](#-english-version) &nbsp;|&nbsp; [🇬🇷 Ελληνική Έκδοση](#-ελληνική-έκδοση)

---

## 🇬🇧 English Version

An end-to-end BDD Test Automation Framework for the [SauceDemo](https://www.saucedemo.com/) web application, architected with a focus on stability, maintainability, and seamless CI/CD pipeline integration.

### Tech Stack & Tools

* **Java (JDK 21+)**: Core programming language used for framework development.
* **Selenium WebDriver**: Browser automation engine (`FirefoxDriver`).
* **Selenium IDE**: Web element inspection, locator prototyping, and strategy validation (`ID`, `XPath`, `CSS`).
* **Cucumber BDD (Gherkin)**: Human-readable acceptance test scenarios (`.feature` files).
* **JUnit**: Test execution engine and assertion library.
* **Maven**: Build automation, dependency management, and lifecycle execution.
* **Jenkins**: Continuous Integration server supporting Parameterized Builds (targeted test runs via tags: `@smoke`, `@regression`, `@checkout`).
* **Cucumber HTML Reports**: Automated rich reporting with automatic screenshot capture on test failures (managed via `@After` hooks).

---

### Architecture: Pages & Steps

The framework strictly follows the **Page Object Model (POM)** design pattern decoupled from BDD step implementations:

* **Pages (`pages/`)**: Encapsulate web element locators and user interactions for each individual screen (`LoginPage`, `ProductsPage`, `CartPage`, `CheckoutPage`), keeping DOM queries isolated from test logic.
* **Steps (`stepdefinitions/`)**: Map Gherkin steps to concrete Java automation logic (`LoginSteps`, `CheckoutSteps`), driving user journeys across pages.
* **Hooks (`Hooks.java`)**: Manage browser lifecycle (`@Before` / `@After`) and automatically attach full-page screenshots directly to reports upon any test assertion failure.

---

### Jenkins CI/CD & Parameterized Execution

The Jenkins pipeline is configured with parameterized builds, allowing dynamic execution of specific test suites:

* **Supported Tag Filters**: `@smoke`, `@regression`, `@checkout`, or a complete suite execution.
<BR>
* You can check the Jenkins parameterized build configuration from the screenshots in the folder **screenshots**.
---

### Test Execution Reports

Comprehensive test execution artifacts detail scenario statuses, step execution times, and failure evidence
<br>
You can find the reports in the **docs** folder. (pdf or html format)



---

### How to Run the Tests

#### Prerequisites
* **Java JDK 21+** installed
* **Mozilla Firefox** browser installed (used by default WebDriver)
* **Maven** installed (optional if running directly via IDE)

---

#### Option 1: Via Terminal / CLI (Recommended)

Run the entire test suite:
```bash
mvn clean test
```

Run specific test tags (e.g., `@smoke`, `@regression`, `@checkout`):
```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

> **Note:** If `mvn` is not configured in your system's PATH, you can use the Maven Wrapper:
> * **Windows:** `.\mvnw.cmd clean test`
> * **Linux / macOS:** `./mvnw clean test`

---

#### Option 2: Via IDE (IntelliJ IDEA / Eclipse)

1. Open the project folder in your IDE as a **Maven Project** (wait for dependencies to download).
2. Navigate to:  
   `src/test/java/.../runners/TestRunner.java` (or your JUnit runner class).
3. Right-click on the runner file and select **Run 'TestRunner'**.
4. *(Optional via IntelliJ Maven Tool)*: Open the **Maven** sidebar tab on the right $\rightarrow$ **Lifecycle** $\rightarrow$ double-click **test**


<br>

---
---

<br>

## 🇬🇷 Ελληνική Έκδοση

Ένα ολοκληρωμένο BDD Test Automation Framework για την web εφαρμογή [SauceDemo](https://www.saucedemo.com/), σχεδιασμένο με γνώμονα τη σταθερότητα, την επεκτασιμότητα και την ενσωμάτωση σε CI/CD pipeline.

### Τεχνολογίες & Εργαλεία

* **Java (JDK 21+)**: Βασική γλώσσα ανάπτυξης του framework.
* **Selenium WebDriver**: Αυτοματοποίηση ενεργειών στον browser (`FirefoxDriver`).
* **Selenium IDE**: Εντοπισμός, εξαγωγή και αρχική επαλήθευση στοιχείων (Locators: `ID`, `XPath`, `CSS`).
* **Cucumber BDD (Gherkin)**: Σύνταξη σεναρίων δοκιμών σε φυσική γλώσσα (`.feature` files).
* **JUnit**: Runner και assertions για την επαλήθευση των αποτελεσμάτων.
* **Maven**: Διαχείριση εξαρτήσεων (dependencies), lifecycle και εκτέλεση tests.
* **Jenkins**: CI/CD αυτοματισμός με υποστήριξη Parameterized Builds (εκτέλεση ανά tag: `@smoke`, `@regression`, `@checkout`).
* **Cucumber HTML Reports**: Παραγωγή αναλυτικών αναφορών εκτέλεσης με αυτόματη λήψη screenshots σε περίπτωση αποτυχίας (μέσω `@After` hooks).

---

### Αρχιτεκτονική: Pages & Steps

Το framework υλοποιεί το πρότυπο σχεδίασης **Page Object Model (POM)**, διαχωρίζοντας πλήρως τα web στοιχεία από τη λογική των ελέγχων:

* **Pages (`pages/`)**: Περιλαμβάνουν τους locators και τις ενέργειες κάθε οθόνης ξεχωριστά (`LoginPage`, `ProductsPage`, `CartPage`, `CheckoutPage`), εξασφαλίζοντας εύκολη συντήρηση σε τυχόν αλλαγές του UI.
* **Steps (`stepdefinitions/`)**: Υλοποιούν τα βήματα Gherkin σε εκτελέσιμο κώδικα Java (`LoginSteps`, `CheckoutSteps`), συντονίζοντας τη ροή των σεναρίων μεταξύ των σελίδων.
* **Hooks (`Hooks.java`)**: Διαχειρίζονται τον κύκλο ζωής του driver (`@Before` / `@After`) και αναλαμβάνουν την αυτόματη λήψη και ενσωμάτωση screenshot στην αναφορά σε περίπτωση αποτυχίας (Failed assertions).

---

### Jenkins CI/CD & Παραμετροποίηση

Το pipeline στο Jenkins υποστηρίζει δυναμική εκτέλεση επιλεγμένων σεναρίων μέσω παραμέτρων:


* **Επιλογές Tags**: `@smoke`, `@regression`, `@checkout` ή πλήρης εκτέλεση όλων των σεναρίων.

* Μπορείτε να ελέγξετε τη διαμόρφωση παραμετροποιημένης έκδοσης Jenkins από τα στιγμιότυπα οθόνης στον φάκελο **screenshots**.


---

### Test Execution Reports

Οι αναλυτικές αναφορές εκτέλεσης των δοκιμών περιλαμβάνουν κατάσταση σεναρίων, χρόνους απόκρισης και screenshots από τυχόν αποτυχίες.
<br>
Μπορείτε να βρείτε τις αναφορές στον φάκελο **docs**. (σε μορφή pdf ή html)

---

### Πώς να Εκτελέσετε τις Δοκιμές

#### Προαπαιτούμενα
* Εγκατεστημένο **Java JDK 21+**
* Εγκατεστημένος browser **Mozilla Firefox**
* Εγκατεστημένο **Maven** (προαιρετικό εάν η εκτέλεση γίνει μέσω IDE)

---

#### Επιλογή 1: Μέσω Τερματικού / CLI

Εκτέλεση όλων των σεναρίων:
```bash
mvn clean test
```

Εκτέλεση συγκεκριμένων tags (π.χ. `@smoke`, `@regression`, `@checkout`):
```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

> **Σημείωση:** Εάν το `mvn` δεν είναι δηλωμένο στο PATH του συστήματος, μπορείτε να χρησιμοποιήσετε τον Maven Wrapper:
> * **Windows:** `.\mvnw.cmd clean test`
> * **Linux / macOS:** `./mvnw clean test`

---

#### Επιλογή 2: Μέσω IDE (IntelliJ IDEA / Eclipse)

1. Ανοίξτε τον φάκελο του project στο περιβάλλον ανάπτυξης ως **Maven Project** (περιμένετε να ολοκληρωθεί το downloading των dependencies).
2. Μεταβείτε στη διαδρομή:  
   `src/test/java/.../runners/TestRunner.java` (ή στην αντίστοιχη κλάση του JUnit Runner).
3. Κάντε δεξί κλικ στο αρχείο του Runner και επιλέξτε **Run 'TestRunner'**.
4. *(Εναλλακτικά στο IntelliJ)*: Ανοίξτε την καρτέλα **Maven** στα δεξιά $\rightarrow$ **Lifecycle** $\rightarrow$ διπλό κλικ στο **test**.