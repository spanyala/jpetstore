SET DEFINE OFF;
DROP PROCEDURE PLUNIT_RUN_TESTS
/

CREATE OR REPLACE PROCEDURE plunit_run_tests authid current_user as

  v_test_names_out varchar2(1000);
  v_has_setup      boolean;
  v_has_teardown   boolean;
  v_owner          varchar2(100);
  v_package_name   varchar2(100);
  v_db_name        varchar2(100);
  v_banner         varchar2(500) := '****** P L / U N I T   T E S T S ***********************************************************************';
  v_success        boolean;
  v_sqlerrm        varchar2(2000);
  v_failures       boolean;


begin
  v_failures := false;

  -- Get the schema and set the banner
  select user into v_owner from dual;
  v_banner := '***********  SCHEMA: ' || v_owner|| '   ' || v_banner;
  

  -- Get the database
  select global_name into v_db_name from global_name;
  -- Bypass for CAT and PROD
  if v_db_name in ('QPROGREG','PPROGREG','QPROGREG.USPS.GOV','PPROGREG.USPS.GOV') then
    dbms_output.put_line(v_banner);
    dbms_output.put_line('      PLUNIT Test will only execute in Non-PROD environments: ' || v_db_name);
    dbms_output.put_line(v_banner);
    return;
  end if;  
  

  -- Begin PLUNIT TESTS
  dbms_output.put_line(v_banner);
  dbms_output.put_line(' ');


  -- Loop through all the packages
  for rec in (select object_name from user_objects where object_type='PACKAGE') loop

    -- See if any tests exist for the package  
    v_package_name := rec.object_name;
    plunit.get_all_tests(owner=>v_owner, 
                         package_name=>v_package_name, 
                         test_names_out=>v_test_names_out,
                         has_setup=>v_has_setup,
                         has_teardown=>v_has_teardown);
--    dbms_output.put_line('Package: ' || rpad(v_package_name,32) || ' "T_*" Test Procedure(s): ' || nvl(v_test_names_out,'none'));
    -- If tests exist, run them all
    if v_test_names_out is not null then
      dbms_output.put_line('.');
      dbms_output.put_line('Package: ' || rpad(v_package_name,32));
      dbms_output.put_line('-----------------------------------');
      begin
        v_success := plunit.run_all_tests(owner=>v_owner, package_name=>v_package_name);
        if v_success = false then
          dbms_output.put_line('PLUNIT: Failed for package: ' || v_package_name);
          v_failures := true;           
        end if;
      exception
        when others then
          v_sqlerrm := sqlerrm;
          dbms_output.put_line('      *** ERROR RUNNING PLUNIT TESTS: ' || v_sqlerrm);
          dbms_output.put_line('PLUNIT: Failed for package: ' || v_package_name || ' with error: ' || v_sqlerrm);
          v_failures := true;           
      end;
      dbms_output.put_line('.');
    end if;

  end loop;
 
  -- Ending banner
  dbms_output.put_line('.');
  dbms_output.put_line(v_banner);
  dbms_output.put_line('.');

  if v_failures then
    raise_application_error(-20000,'PLUNIT Failures Detected');
  end if;

end plunit_run_tests;
/

SHOW ERRORS;


GRANT EXECUTE ON PLUNIT_RUN_TESTS TO PUBLIC
/
