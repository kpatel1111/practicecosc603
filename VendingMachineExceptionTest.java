//
/**
 * 
 */
package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class VendingMachineExceptionTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	VendingMachineException vme;
	
	@Before
	public void setUp() throws Exception {
		vme = new VendingMachineException();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		vme=null;
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineException#VendingMachineException()}.
	 */
	@Test
	public void testVendingMachineException() {
		vme = new VendingMachineException();
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineException#VendingMachineException(java.lang.String)}.
	 */
	@Test
	public void testVendingMachineExceptionString() {
        VendingMachineException exception = new VendingMachineException("VendingMachineException");
        assertEquals("VendingMachineException"
        		, exception.getMessage());
	}

}
