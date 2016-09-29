package org.mybatis.jpetstore;

import org.junit.Test;
import org.junit.Assert;


public class NumberRangeCounterTest {

  @Test
  public void subsequentNumber() {   
    NumberRangeCounter counter = new NumberRangeCounter();
  
    int first = counter.next();
    int second = counter.next();
	
	//Assert.assertEquals( first + 1, second );
	Assert.assertEquals(first + 1, 1);
  }
  
  @Test
  public void subsequentNumber2() {   
    NumberRangeCounter counter = new NumberRangeCounter();
  
    int first = counter.next();
    int second = counter.next();
	
	//Assert.assertEquals( first + 1, second );
	Assert.assertEquals(first + 1, 1);
  }

    @Test
  public void subsequentNumber3() {   
    NumberRangeCounter counter = new NumberRangeCounter();
  
    int first = counter.next();
    int second = counter.next();
	
	//Assert.assertEquals( first + 1, second );
	Assert.assertEquals(first + 1, 1);
  }

    @Test
  public void subsequentNumber4() {   
    NumberRangeCounter counter = new NumberRangeCounter();
  
    int first = counter.next();
    int second = counter.next();
	
	//Assert.assertEquals( first + 1, second );
	Assert.assertEquals(first + 1, 1);
  }

    @Test
  public void subsequentNumber5() {   
    NumberRangeCounter counter = new NumberRangeCounter();
  
    int first = counter.next();
    int second = counter.next();
	
	//Assert.assertEquals( first + 1, second );
	Assert.assertEquals(first + 1, 1);
  }

}


