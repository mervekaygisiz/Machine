# Machine



## Problem

Consider an infinite grid of white and black squares. The grid is initially all white and there is a machine in one cell facing right. It will move based on the following rules:

* If the machine is in a white square, turn 90° clockwise and move forward 1 unit;

* If the machine is in a black square, turn 90° counter-clockwise and move forward 1 unit;

* At every move flip the color of the base square.

Implement an application that will receive HTTP PUT requests with a number of steps the simulation should run, always starting from the same conditions, and output the resulting grid to a file.

That problem is known as Langton’s Ant. Langton's ant is a two-dimensional universal Turing machine. 

For more information: [link](https://en.wikipedia.org/wiki/Langton%27s_ant) 


## Usage

### Postman:

![Postman](/images/postman.png)



### Terminal:

```curl -X PUT "http://localhost:8082/machine?size=3000"```



## Technologies that I Used

Java 11, Spring Boot, Maven, JUnit. 
Also I like to use of advantage of SonarLint and I strongly recommend it to every developer.


## Approach of OOP

### Representing the Grid: 

According to the problem, the squares of our Grid can be white or black. Because the grid is initially all white, just knowing the coordinates to be painted black is enough at that time. 
So we can store only black squares in Grid. Like that we don’t need to keep the knowledge of squares’ color. As a structure I decided to use HashSet to store the black squares (x, y). That help me to minimize the complexity of searching, adding and removing operations in grid. (O(1) for each.)

### Representing the Direction of Machine:

For representing the direction followed by the Machine, I defined a Direction enum which has NORTH, EAST, SOUTH, WEST values. Also I defined clockwise90 and counterClockwise90 methods to provide the movement of machine.


### Representing the Machine:

This class has:
* x and y integers representing the coordinates of the Machine in the Grid
* direction representing the current direction of Machine.

### Representing the Step:

I needed to write a step class representing a step of the Machine in the Grid passed as an input.

The purpose of the algorithm is to move forward the machine using rules that I mentioned above and color the final situation of the grid to file. So I chose to keep only black squares in HashSet. The machine begins moving from (0,0) coordinates, following the right direction on while square. That’s why I add these coordinates into the grid because it will be black when the machine moves. Because the current square is white, machine will turn 90°  clockwise. Then the machine will move forward 1 unit. 
If the new square coordinates already in the grid, I would remove that coordinates from the grid because its color will be white after walking on it. 
If the new square coordinates do not exist in the grid, then I will add the coordinates into the grid because it’s color white and will be black in the next step. 

Eventually, new coordinates will assign to current coordinates. 

This move will continue up to the number of steps.

### Painting the Output Grid to File:

I used Graphics2D library of Java to paint it into the file. File path is:
**System.getProperty("user.dir") + "/machine.png"**




## Complexity

To store the coordinates of black squares, I use HashSet.The underlying data structure for HashSet is hashtable. 
So amortize (average or usual case) time complexity for add, remove and look-up (contains method) operation of HashSet takes **O(1)** time.

The algorithm repeats up to the number of steps. So total complexity of the problem will be **O(n)**.




## What I Learnt

To optimize the usage of memory and time complexity I need to use right data structure for the problem. Also keeping grid size up to the number of black squares is a good choice for the complexity.
Like that I reduced the complexity from O(n*n) to O(n) compare to my previous study.

I learnt that this is well-known Turing machine problem invented by Chris Langton in 1986.




## Improvements We Can Do

* Test codes for service class,
* Lifetime simulation,
* More than one machine in the grid,
* To limit step size. (@Max annotation of Java)





## Example Outputs

![50 Step](/images/50.png)

![1000 Step](/images/1000.png)

![12000 Step](/images/12000.png)

![15000 Step](/images/15000.png)


