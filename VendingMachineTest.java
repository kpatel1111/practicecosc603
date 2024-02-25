
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
public class VendingMachineTest {

	/**
	 * @throws java.lang.Exception
	 */
	//Object Declarations
	VendingMachine v;
	VendingMachineItem item;
	
	@Before
	public void setUp() throws Exception {
		//initialize the Vending Machine with Vending Machine Item.
		
		//Initializes all the item slots (A,B,C,D) to null in the itemArray, and set the balance = initial_balance(0).
		v = new VendingMachine();
		//Create a new item called chips, with a price of 1.50 type Double.
		item = new VendingMachineItem("chips", 1.50);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		v=null;
		item=null;
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#VendingMachine()}.
	 */
	@Test
	public void testVendingMachine() {
		//activates the vending machine constructor to set the itemArray with null values.
		v = new VendingMachine();
	}

	@Test(expected=VendingMachineException.class)
	public void testNullNameException() {
		v.addItem(new VendingMachineItem(null,1.0), "A");
	}
	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem, java.lang.String)}.
	 */
	@Test
	public void testAddItem() {
		//add item to the itemArray array.
		v.addItem(item, "A");
		//Check if the item matches the item stored in the A slot of the itemArray. (Evaluates to true)
		assertEquals(item,v.getItem("A"));
	}
	
	@Test(expected = VendingMachineException.class)
	public void testAddItemPriceException() throws VendingMachineException {
		//add item to the itemArray array.
		VendingMachineItem test = new VendingMachineItem("soda",-1);
		v.addItem(test, "A");
		//Check if the item matches the item stored in the A slot of the itemArray. (Evaluates to true)
		assertEquals(VendingMachineException.class,v.getItem("A"));
	}
	
	@Test (expected = VendingMachineException.class)
	public void testAddItemOccupiedSlot()  throws VendingMachineException{
		VendingMachineItem test = new VendingMachineItem("chocolate",4.48);
		//add item to the itemArray array for slot A.
		v.addItem(item, "A");
		//Slot A already has item object stored in it, but in the same A slot, the next line is trying to add test object item.
		//So, VendingMachineException will occur.
		v.addItem(test, "A");
		
	}

	@Test (expected = VendingMachineException.class)
	public void testAddItemInvalidSlot() throws VendingMachineException{
		//add item to the itemArray array for slot K, which does not exist.
		//So, vending machine exception will be produced.
		v.addItem(item, "K");
	}
	
	@Test
	public void testAddItemSlotB() {
		//add item to the itemArray array for slot B, and check if the same item is returned from slot B.
		v.addItem(item, "B");
		assertEquals(item,v.getItem("B"));
		
	}
	
	@Test
	public void testAddItemSlotC() {
		//add item to the itemArray array for slot C, and check if the same item is returned from slot C.
		v.addItem(item, "C");
		assertEquals(item,v.getItem("C"));
		
	}
	
	@Test
	public void testAddItemSlotD() {
		//add item to the itemArray array for slot D, and check if the same item is returned from slot D.
		v.addItem(item, "D");
		assertEquals(item,v.getItem("D"));
		
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#getItem(java.lang.String)}.
	 */
	@Test
	public void testGetItem() {
		//Declare and initialize a new item.
		VendingMachineItem test = new VendingMachineItem("chocolate",4.48);
		//Add the test item to the slot A.
		v.addItem(test, "A");
		//Check to see if the test is returned when calling v.getItem from the slot A. (Evaluates to true).
		assertEquals(test,v.getItem("A"));
		
	}
	
	@Test(expected = VendingMachineException.class)
	public void testGetItemFromInvalidSlot()  throws VendingMachineException{
		//Trying to get an item stored in slot k, which does not exist.
		//Produces an vending machine exception because no such slot exists.
		v.getItem("k");
		
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#removeItem(java.lang.String)}.
	 */
	@Test
	public void testRemoveItem() {
		//Add an item to slot A.
		v.addItem(item, "A");
		//removes the item from slot A and checks to see if it matches with the expected item. (Evaluates to true)
		assertEquals(item, v.removeItem("A"));
	}
	
	@Test (expected = VendingMachineException.class)
	public void testRemoveItemFromEmptySlot()  throws VendingMachineException{
		//Add an item to slot A.
		v.addItem(item, "A");
		//Removes the item from slot A.
		v.removeItem("A");
		//Now it again tries to remove item from slot A, which is already removed by the above line of code.
		//So, it will produce an vending machine exception because there is no item to remove from slot A, since it is already null or empty.
		v.removeItem("A");
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#insertMoney(double)}.
	 */
	@Test
	public void testInsertMoney() {
		//Insert 100 dollars into the balance variable.
		v.insertMoney(100);
		//Verifies if the money inserted is stored in the balance variable by using v.getBalance(). 
		//Evaluates to true.
		assertEquals(100,v.getBalance(),0.01);
	}
	
	@Test (expected = VendingMachineException.class)
	public void testInsertMoneyInvalidAmount() throws VendingMachineException {
		//Insert -1 dollar into the balance variable, which is not valid, so will generate an vending machine exception.
		v.insertMoney(-1);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#getBalance()}.
	 */
	@Test
	public void testGetBalancePreCondition() {
		//Since the initial balance is set to 0, when performing getBalance() function, it will also return 0.
		//So, this test case evaluates to true.
		assertEquals(0,v.getBalance(),0.01);
	}
	
	@Test
	public void testGetBalancePostCondition() {
		//Insert 400 dollars into the initial balance, which is 0.
		v.insertMoney(400);
		//Insert another 100 dollars into the existing balance amount.
		v.insertMoney(100);
		//Check to see if v.getBalance() returns 500 (expected behavior) because 0+400+100=500.
		//Evaluates to true.
		assertEquals(500,v.getBalance(),0.01);
	}


	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 */
	@Test
	public void testMakePurchase() {
		//Add item in slot A.
		v.addItem(item, "A");
		//Insert money into the vending machine to make a purchase.
		v.insertMoney(50);
		//Check if the user can purchase the item from slot A, by verifying if the item exists in the slot A, 
		//and the money inserted must be greater than or equal to the price of the item to make a successful purchase.
		assertEquals(true,v.makePurchase("A"));
	}
	
	@Test
	public void testMakePurchaseItemIsNull() {
		//Add item in slot A.
		v.addItem(item, "A");
		//Insert money into the vending machine to make a purchase.
		v.insertMoney(50);
		//Remove the item from slot A.
		v.removeItem("A");
		//Purchase the item from slot A, even though it is null because it is removed from the vending machine.
		//Evaluates to false because item == null.
		assertEquals(false,v.makePurchase("A"));
	}
	
	@Test
	public void testMakePurchaseLessBalance() {
		//Add item in slot A.
		v.addItem(item, "A");
		//Insert money to into the vending machine to make a purchase.
		v.insertMoney(1);
		//Purchase the item from slot A, but the we only inserted 1 dollar into the machine.
		//So, the balance is only 1, but the price of the item (Chips) is 1.50.
		//So, the second condition this.balance >= item.getPrice() evaluates to false.
		//Thus, the entire test case evaluates to false.
		assertEquals(false,v.makePurchase("A"));
	}
	
	@Test
	public void testMakePurchaseLessBalanceAndItemNull() {
		//Add item in slot A.
		v.addItem(item, "A");
		//Insert money to into the vending machine to make a purchase.
		v.insertMoney(1);
		//Remove item from the slot A.
		v.removeItem("A");
		//Evaluates to false because both conditions item != null and this.balance >= item.getPrice(0 evaluates to false.
		assertEquals(false,v.makePurchase("A"));
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#returnChange()}.
	 */
	@Test
	public void testReturnChange() {
		//add item in slot B.
		v.addItem(item, "B");
		//insert 2 dollar into the vending machine to make purchase.
		v.insertMoney(2);
		//Purchase item from slot B.
		v.makePurchase("B");
		//Call the return change function to verify if it equals to the expected behavior of 0.5 because 2 - 1.5 = 0.5.
		//So, the test case evaluates to true.
		assertEquals(0.5,v.returnChange(),0.01);
	}
	
}
