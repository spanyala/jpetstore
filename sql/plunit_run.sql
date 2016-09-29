set serveroutput on
set linesize 2000

whenever sqlerror exit sql.sqlcode

begin
  plunit_run_tests;
--exception
--  when others then
--    null;
end;
/
