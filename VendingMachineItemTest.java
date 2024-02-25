
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
public class VendingMachineItemTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	VendingMachineItem vmi;
	VendingMachine vm;
	@Before
	public void setUp() throws Exception {
		//Create a new vending machine item.
		vmi = new VendingMachineItem("chocolate",3.50);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		//Set the vending machine item object instance to null.
		vmi=null;
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem#VendingMachineItem(java.lang.String, double)}.
	 */
	@Test (expected = VendingMachineException.class)
	public void testVendingMachineItemPriceException() throws VendingMachineException {
		//Tries to insert an item object with price less than 0. So, this test method will produce an vending machine exception.
		new VendingMachineItem("chips",-1);
	}
	
	
	@Test(expected = VendingMachineException.class)
	public void testVendingMachineItemNameException() throws VendingMachineException{
		//Tries to insert an item object with name = null. So, this will produce an vending machine exception. (New Functionality).
		new VendingMachineItem(null,1);
		
	}
	
	
	@Test
	public void testVendingMachineItem() {
		//Creates a new item object, which will be created successfully.
		vmi = new VendingMachineItem("soda",2.40);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem#getName()}.
	 */
	@Test
	public void testGetName() {
		//Checks to verify if the name stored in the vmi object is equal to chocolate or not. In this case, it will return as true.
		assertEquals("chocolate",vmi.getName());
	}
	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem#getPrice()}.
	 */
	@Test
	public void testGetPrice() {
		//Check to verify if the price stored in the vmi object is equal to 3.50.
		//Therefore, in this case, it will return true.
		assertEquals(3.50,vmi.getPrice(),0.01);
	}

}
