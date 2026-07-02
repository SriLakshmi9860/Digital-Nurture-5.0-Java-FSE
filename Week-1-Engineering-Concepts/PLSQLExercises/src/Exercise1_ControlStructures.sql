/*
==========================================
Cognizant Digital Nurture 5.0
Week 1 - PL/SQL

Exercise 1 : Control Structures

Developed by:
Vundela Srilakshmi
==========================================
*/
-- Scenario 1
-- Apply 1% discount to loan interest rates
-- for customers above 60 years.

BEGIN

FOR cust IN
    (
        SELECT CustomerID,
               FLOOR(MONTHS_BETWEEN(SYSDATE, DOB)/12) AS Age
        FROM Customers
    )

    LOOP

        IF cust.Age > 60 THEN

UPDATE Loans
SET InterestRate = InterestRate - 1
WHERE CustomerID = cust.CustomerID;

END IF;

END LOOP;

COMMIT;

END;
/

ALTER TABLE Customers
    ADD IsVIP CHAR(1);

-- Scenario 2
-- Mark customers as VIP
-- if balance exceeds $10,000.

BEGIN

FOR cust IN
    (
        SELECT CustomerID,
               Balance
        FROM Customers
    )

    LOOP

        IF cust.Balance > 10000 THEN

UPDATE Customers
SET IsVIP='Y'
WHERE CustomerID=cust.CustomerID;

END IF;

END LOOP;

COMMIT;

END;
/

-- Scenario 3
-- Print reminder for loans
-- due within next 30 days.

BEGIN

FOR loan IN
    (

        SELECT c.Name,
               l.EndDate

        FROM Customers c

        JOIN Loans l

        ON c.CustomerID=l.CustomerID

        WHERE l.EndDate <= SYSDATE + 30

    )

    LOOP

        DBMS_OUTPUT.PUT_LINE
        (

            'Reminder: Loan due for '

            || loan.Name ||

            ' on '

            || TO_CHAR(loan.EndDate,'DD-MON-YYYY')

        );

END LOOP;

END;
/
