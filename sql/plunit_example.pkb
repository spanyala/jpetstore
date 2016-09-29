SET DEFINE OFF;
DROP PACKAGE BODY PLUNIT_EXAMPLE
/

CREATE OR REPLACE PACKAGE BODY plunit_example AS


FUNCTION calc_comm_percent(p_salary IN number, p_comm IN number) RETURN number IS
BEGIN
  RETURN p_comm/p_salary;
EXCEPTION
  WHEN ZERO_DIVIDE
    THEN
      IF p_comm = 0
        THEN RETURN 0;
        ELSE RETURN 1;
      END IF;
END;



PROCEDURE setup IS
BEGIN
  INSERT INTO emp VALUES (1, 'SMITH', 'CODER', 7782, to_date('23-JAN-82'), 1000, 100, 10);
END;

PROCEDURE teardown IS
BEGIN
  ROLLBACK;
END;


PROCEDURE t_call_function IS
-- we write our test logic in the package body
BEGIN
  -- our call to assert equals is taking 3 parameters.  
  -- The first is the value we expect, the second is the actual value (our function result)
  -- the third is the optional error message to supply if the test fails.
  plunit.assert_equals(0.10, calc_comm_percent(1000, 100), 'Commission percent is wrong');
END;

PROCEDURE t_zero_salary IS
BEGIN
  -- we'll assume that with no salary, the commission makes up 100% of the salary
  plunit.assert_equals(1, calc_comm_percent(0, 100), 'Commission is 100% when no salary');
END;

PROCEDURE t_zero_comm IS
BEGIN
  -- with no commission, the percentage should be zero
  plunit.assert_equals(0, calc_comm_percent(1000, 0), 'With no commission, the percentage should be zero');
END;

PROCEDURE t_zero_both IS
BEGIN
  -- with no commission and no salary, the percentage should be zero
  plunit.assert_equals(0, calc_comm_percent(0, 0), 'With no commission and no salary, the percentage should be zero');
END;

PROCEDURE t_database_call IS
BEGIN
  plunit.assert_query_equals_value('select plunit_example.calc_comm_percent(sal, comm) from emp where empno = 1', 0.1, 'Wrong commission percent returned');
END;


END;
/
SHOW ERRORS;
