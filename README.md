#Invoice bot exercise

The goal of the exercise is to read 3 csv files:
 - Customers.csv: Customer information (Id, Name, Discount and Address)
 - Items.csv: Product information (ID, Name and Price)
 - Order.csv: Order information (CustomerId, ItemId and Quantity)

 
The order file references customer and product info from the other to tables.

The exercise is made of 3 parts and consists of 4 tests. 
The execise is completed when ALL tests pass, but you should focus on making one test pass
at a time in the correct order.

Each test reads the data files from the src/main/resources/testX folders.
The expected output of each test is in the corresponding src/test/resources/testX folders.

Use the printer instance in the InvoiceBot to print.

Test 0: Print the text "No orders" since the orders.csv contains no orders.

Test 1: Print a single order for a single customer.

Test 2: Print multiple orders for a single customer.

Test 3: Print multiple orders from multiple customers.


##### Hints:
Create data classes for Customer, Item and Order.
Create a FileHandler class that takes a LineHandler class.
The LineHandler is a interface and has 3 implementations: 
CustomerBuilder, ItemBuilder and OrderBuilder.
The builders should create instances of its respective class (Customer, Item, Order)
Organize the data in a suitable form to print the information.
Make print functions in the data classes to print the invoice details.