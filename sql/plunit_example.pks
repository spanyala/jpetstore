SET DEFINE OFF;
DROP PACKAGE PLUNIT_EXAMPLE
/

CREATE OR REPLACE PACKAGE plunit_example AS

FUNCTION calc_comm_percent(p_salary IN number, p_comm IN number) RETURN number;


-- *******************************************
-- PL/Unit tests are implemented as packages
-- *******************************************
PROCEDURE setup;
PROCEDURE teardown;

PROCEDURE t_call_function;
-- unit tests are public procedures that have no parameters
-- their names must begin with t_

PROCEDURE t_zero_salary;
PROCEDURE t_zero_comm;
PROCEDURE t_zero_both;
PROCEDURE t_database_call;


END;
/
SHOW ERRORS;
