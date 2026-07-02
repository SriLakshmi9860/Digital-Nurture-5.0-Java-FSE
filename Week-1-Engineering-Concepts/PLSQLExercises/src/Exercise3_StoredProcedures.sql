CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
UPDATE Accounts
SET Balance = Balance + (Balance * 0.01)
WHERE AccountType = 'Savings';

COMMIT;

DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully.');
END;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonusPercent IN NUMBER
)
AS
BEGIN
UPDATE Employees
SET Salary = Salary + (Salary * p_bonusPercent / 100)
WHERE Department = p_department;

COMMIT;

DBMS_OUTPUT.PUT_LINE('Bonus updated successfully for department: ' || p_department);
END;
/
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_fromAccount IN NUMBER,
    p_toAccount IN NUMBER,
    p_amount IN NUMBER
)
AS
    v_balance NUMBER;
BEGIN
    -- Get source account balance
SELECT Balance
INTO v_balance
FROM Accounts
WHERE AccountID = p_fromAccount;

-- Check sufficient balance
IF v_balance >= p_amount THEN

UPDATE Accounts
SET Balance = Balance - p_amount
WHERE AccountID = p_fromAccount;

UPDATE Accounts
SET Balance = Balance + p_amount
WHERE AccountID = p_toAccount;

COMMIT;

DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');

ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient Balance.');

END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Account not found.');

WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

-- ==========================
-- TEST PROCEDURES
-- ==========================

BEGIN
    ProcessMonthlyInterest;
END;
/

BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/

BEGIN
    TransferFunds(1, 2, 200);
END;
/