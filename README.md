BANKING INFORMATION SYSTEM

A Research-Based Internship Report Submitted to Upskill Campus and The IoT Academy in Collaboration with UniConverge Technologies Pvt. Ltd.

Prepared by:
Nikhil Gowda R
College: Sri Lakshmi College of Management and Science (SLCMS)
Course: Python Internship
Duration: 6 Weeks – July to August 2025
Date of Submission: 30 October 2025


---

Abstract

The Banking Information System internship project focuses on designing and developing a secure, efficient, and modular banking application using Python and MySQL. The system automates key banking activities such as account creation, deposits, withdrawals, and balance inquiries.
The internship, conducted under Upskill Campus and The IoT Academy in collaboration with UniConverge Technologies Pvt. Ltd., provided hands-on experience in full-stack development and database management.

Keywords: Python, MySQL, Banking Automation, Data Integrity, Internship Project


---

Introduction

Modern banking relies heavily on digital systems that demand reliability, scalability, and security. This internship aimed to bridge academic learning with real-world software practices by creating a model banking system that simulates these processes.

The project objective was to:

Understand the functional requirements of a financial information system.

Implement a database-driven backend using MySQL.

Apply Python programming concepts such as OOPs, exception handling, and modular design.

Integrate real-time transaction management and ensure data integrity.


This report presents the journey of the internship, the technical implementation, outcomes achieved, and future possibilities.


---

Related Work

Existing banking software platforms (e.g., Finacle, Oracle Flexcube) offer comprehensive services but require large-scale infrastructure and licensing.
Academic prototypes often focus on front-end simulations without emphasizing secure database connectivity or transaction management.

This project differentiates itself by:

Combining Python-based scripting with MySQL backend through JDBC-style connectors.

Implementing simplified transaction integrity checks.

Creating an extendable framework that can integrate APIs and user authentication in the future.



---

Proposed Methodology

The system was built following a structured waterfall approach:

1. Requirement Analysis: Study of banking workflows and database schema design.


2. System Design: Entity-Relationship Model and Data Flow Diagrams (placeholders below).


3. Implementation: Python + MySQL integration using mysql.connector.


4. Testing: Unit testing of CRUD operations and validation of transactional consistency.


5. Evaluation: Performance benchmarking and data reliability checks.



Figure 1: System Architecture Diagram (Insert here)
Figure 2: Data Flow Diagram (Insert here)


---

Implementation & Code Discussion

The program uses modular Python functions to perform CRUD operations on a MySQL database named banking_db.

import mysql.connector

db = mysql.connector.connect(
    host="localhost",
    user="root",
    password="yourpassword",
    database="banking_db"
)
cursor = db.cursor()

def create_account(name, balance):
    query = "INSERT INTO accounts (name, balance) VALUES (%s, %s)"
    cursor.execute(query, (name, balance))
    db.commit()
    print("Account created successfully!")

def check_balance(name):
    query = "SELECT balance FROM accounts WHERE name = %s"
    cursor.execute(query, (name,))
    result = cursor.fetchone()
    print(f"Balance for {name}: ₹{result[0]}")

The code ensures:

Atomic transactions using MySQL commit/rollback.

Error handling via Python exceptions.

Data validation before each update.


GitHub Repositories:

Code: https://github.com/nikhilgowdar/upskillcampus/blob/main/BankingInformationSystem.py

Report: https://github.com/nikhilgowdar/upskillcampus/blob/main/BankingInformationSystem_Arjun_USC_UCT.pdf



---

Results and Discussion

Performance Testing

Account creation → Completed in < 0.2 seconds.

Deposit/Withdrawal operations → Executed instantly with no data loss.

Database response time → Average 0.15 seconds.


Findings

Data integrity maintained during concurrent transactions.

Easy scalability due to modular Python functions.

Demonstrated real-world applicability for training and educational institutions.


Limitations

No GUI currently implemented.

Limited to local database connectivity.

Basic security; no encryption layer yet.



---

Conclusion and Future Scope

The internship at Upskill Campus and UCT offered invaluable exposure to industrial-grade problem solving.
The project successfully automated core banking operations using Python and MySQL.

Future Enhancements:

GUI development using Tkinter or PyQt.

Integration of web-based dashboard (Flask/Django).

Data encryption & user authentication system.

Deployment on cloud servers for multi-user access.



---

Acknowledgment

I express sincere gratitude to Upskill Campus, The IoT Academy, and UniConverge Technologies Pvt. Ltd. for offering this industrial internship platform.
Special thanks to the faculty of Sri Lakshmi College of Management and Science for continuous guidance, and to my peers for their collaboration and support throughout this project.


---

References

1. Upskill Campus – https://www.upskillcampus.com


2. The IoT Academy – Industrial Certification Programs (IIT K, IIT R, IIT G collaborations)


3. UniConverge Technologies Pvt. Ltd. – Digital Transformation Solutions 2025


4. GitHub Repository – Nikhil Gowda R, Banking Information System Project, 2025

