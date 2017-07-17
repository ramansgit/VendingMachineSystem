Vending Machine System Requirement.
You need to design and develop a Vending Machine for which

1.  Supplier should be able to add products, change quantity and set prices for products

2. The program should allow a consumer to select one or more products, choose/change quantity,

accept payment (cash), upon sufficient payment being tendered and user confirmation to

complete the transaction.

3. System should calculate change after accepting different tenders

4. The program should allow the supplier to collect/add cash with a statement of the items

purchased.

5.  Allow consumer to take refund by canceling the request.

6.  Allow reset operation for vending machine supplier.


Design Approach
The following 3 interface plays major role in system.

Consumer Interface - interaction between consumer and system will be done through this interface 
Supplier Interface - interaction between supplier and store ( product, cash and purchase) will be done through this interface
Dispenser Interface - interaction between user store ( cash, cart ) and supplier store ( item, cash and purchase) will be done through this interfacce. consumer can't interact with supplier store directtly it should be via this interface.

Controllers

ConsumerController - controller which implements and handles logic for consumer api interface
SupplierController - controller which implements and handles logic for supplier api interface
DispenserController - controller which implements and handles logic for dispenser api interface

Consumer.cart

SelectionCart - responsible for managing user cart selection, update, delete.
CashCollector - responsible for managing user cash during the purchase

Supplier.store
ProductStoreManager - manages product items inserted by supplier
CashStoreManager - manages cash store inserted by supplier
PurchaseManager - allows supplier to view the purchase and manages the purchase

POJO 
Item - pojo class which carries item information in the system
Purchase - pojo class which carries purchase information in the system
CashEnum - enum holds denominations for indian currency
DispenserItemAndChange - pojo for returning item and change when consumer confirms order

exceptions
NotFullPaidException - thrown when inserted cash less than payable amount
NotSufficientChangeException - thrown when system couldn't provide change for the purchase

test interface
TestVendingMachineInterface - invokes supplier and consumer interface for testing


Next Release focus ..
- not handled all exceptions in this version
- access specifiers can be restricted further.
- more test unit test cases 
- Purchase statement can be in better format
- this can be persisted in db. 
- more validations should be done
- Assumption only either consumer or supplier will access the system.
- concurrent access not tested 


