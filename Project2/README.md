# OOAD Project2 - Garage

## Tavishi Priyam and Manan Khasgiwale

### Repository Comments
Project2 contains the Java code for a garage full of vehicles. There are four different types of vehicles in the garage including Motorcycle, Car,Truck and Boat.
Each type of vehicle has subclasses as follows: Motorcycle-Bike, Trike, Sidecar; Car-Hatchback, SUV, Wagon, Convertible; Truck-Pickup, Delivery, Monster; Boat-Lifeboat, Fishingboat. 
Each vehicle has been instantiated atleast twice. The class files for this project are:
* **Garage.java:** 
* **Vehicle.java:**
* **GarageEmployee.java:**
* **Mechanic.java:**
* **Motorcycle.java:**
* **Car.java:**
* **Truck.java:**
* **Boat.java:**
* **Bike.java:**
* **Trike.java:**
* **Sidecar.java:**
* **Hatchback.java:**
* **SUV.java:**
* **Wagon.java:**
* **Convertible.java:**
* **Pickup.java:**
* **Delivery.java:**
* **Monster.java:**
* **LifeBoat.java:**
* **FishingBoat.java:**

### Project Comments
This project is a virtual garage. Using this project, one can complete the following tasks:
* Add vehicles to garage
* Remove vehicles from the garage
* Add mechanic to the garage
* Remove mechanic from the garage
* Perform tasks on the vehicles including: unlock, wash, tuneUp, testDrive, lockUp
* Perform these tasks for n number of days

### Assumptions
* There a limited number of mechanics working in the garage
* Only one mechanic can work in the garage at once
* One mechanic can work on only one vehicle at once

### Issues encountered
* One issue that we encountered was figuring out how to remove mechanic from the garage once monster crashes and make the next one pick up where the last one left off. 
* This was resolved by making use of a list to store all the mechanics and removing instance from the list everytime a mechanic stops working

### Execution instructions
* Select the Garage.java file and click on the run button.
* Enter the number of days to run the program. 

