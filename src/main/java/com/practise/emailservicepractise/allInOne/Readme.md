--------------------
## Problem statement:
	- This is a dummy User Registration.
	- so when you receive a user object from the controller, it is validated in chains. 
	- in the final chain (after validation is successful) database gets a user entry.
	- also, a verification email is sent to the user's email after registration is successful.
	
	

## DESIGN AND STRUCTURE:
---------------------
	- EmailProcessor is an Abstract class
	
	- chain 1, 2, 3 extend the abstract class.
	
	- EmailChainCreator will set up the chains, make the chain accessible through a method.
	
	- The above provided method will be used in the @Service to create chain. And to pass the request to the chains.
	







