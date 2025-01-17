Zoo Application Backend

The Zoo Application Backend is a Java-based system that simulates the operations and management of a zoo. It allows users to manage zookeepers, enclosures, animals, and food resources, providing a comprehensive backend for zoo administration.

Features
Core Components
-Zookeepers: Manage zookeeper entities and assign them to enclosures or specific animals.
-Enclosures: Create and manage animal enclosures with customizable properties.
-Animals: Add, remove, and assign animals to enclosures or zookeepers. Animals age, eat, and behave realistically over time.
-Food Store: Manage a centralized food inventory for the zoo.
-Food Containers: Store food for enclosures or specific animal diets.
Functionalities
-Add and remove zookeepers, enclosures, and animals.
-Assign animals to enclosures and zookeepers.
-Simulate the passage of time automatically:
A dedicated thread invokes the aMonthPasses() method every 10 seconds, simulating monthly zoo operations.
-Animals age, eat, and process waste.
-Enclosures manage waste accumulation and food consumption.
-Zookeepers oversee assigned areas and animals.
-Interactive menu system to facilitate transactions and manage operations.
