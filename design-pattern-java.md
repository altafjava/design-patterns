## Builder Design Pattern:

Builder is a creational design pattern that lets us construct complex objects step by step. The pattern allows us to produce different types and representations of an object using the same construction code.

### Problem:

Let’s say we want to create a `House` object. To build a simple house we need to construct 4 walls and 1 floor. Install a door, fit a pair of windows and build a roof. For that we shall have a class `House` like below.

```java
class House {
    private int walls;
    private int doors;
    private int windows;
    private boolean isFloor;
    private boolean isRoof;
}
```

As we know House building is a complex process that requires step by step process in the correct sequence of actions. First we need to construct walls then open doors & windows then construct the roof & floor. We cannot juts start the house creation with roof. The house must be build in an order mannner(correct sequence). Hence in terms of coding it requires step by step initialization of many fields and nested objects. Now the question is how can we perform these initialization. We have 2 ways. Either we can do by using setter methods or by using constructor. So let first try with setter methods.

```java
class House {

   	public void setWalls(int walls) {
		this.walls = walls;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public void setWindows(int windows) {
		this.windows = windows;
	}

    public void setRoof(boolean isRoof) {
		this.isRoof = isRoof;
	}

	public void setFloor(boolean isFloor) {
		this.isFloor = isFloor;
	}
}
```

What is the problem if we go for setter methods? In real world after building a house can we modify it? Intially we had 4 walls, can we modify with 10 walls? No this is not possible but this can be possible in programming world if we use setter methods to implement builder design pattern. In programming world this is called 'Immutability' and as we know we can achieve Immutability only if we use constructors for initialization.

```java
class House {

    public House(int walls, int doors, int windows, boolean isFloor, boolean isRoof) {
		this.walls = walls;
		this.doors = doors;
		this.windows = windows;
		this.isFloor = isFloor;
		this.isRoof = isRoof;
	}
}
```

What is the problem if we use constructor to initialize the fields? For a simple house we are good to go but what if we want a bigger, brighter house with a backyard, swimming pool and other goodies like a heating system, plumbing, and electrical wiring?

```java
public class House {
	private int walls;
	private int doors;
	private int windows;
	private boolean isRoof;
	private boolean isFloor;
	private boolean isGarden;
	private boolean isSwimmingPool;

    // for simple House
	public House(int walls, int doors, int windows, boolean isRoof, boolean isFloor) {
		this.walls = walls;
		this.doors = doors;
		this.windows = windows;
		this.isRoof = isRoof;
		this.isFloor = isFloor;
		this.isGarden = isGarden;
		this.isSwimmingPool = isSwimmingPool;
	}

    // A simple House which includes garden & swimming pool
	public House(int walls, int doors, int windows, boolean isRoof, boolean isFloor, boolean isGarden,
			boolean isSwimmingPool) {
		this.walls = walls;
		this.doors = doors;
		this.windows = windows;
		this.isRoof = isRoof;
		this.isFloor = isFloor;
		this.isGarden = isGarden;
		this.isSwimmingPool = isSwimmingPool;
	}

    // A simple House with swimming pool
	public House(int walls, int doors, int windows, boolean isRoof, boolean isFloor, boolean isSwimmingPool) {
		super();
		this.walls = walls;
		this.doors = doors;
		this.windows = windows;
		this.isRoof = isRoof;
		this.isFloor = isFloor;
		this.isSwimmingPool = isSwimmingPool;
	}

    // A simple House with garden
	public House(int walls, int doors, int windows, boolean isRoof, boolean isFloor, boolean isGarden) {
		this.walls = walls;
		this.doors = doors;
		this.windows = windows;
		this.isRoof = isRoof;
		this.isFloor = isFloor;
		this.isGarden = isGarden;
	}
}
```

We end up wiriting multiple constructors with multiple parameters(telescopic constructor) because we have to provide all these informations to the object in the constructor itself. Now having a method or constructor that needs a lot of arguments is considered a bad code in practice because anyone who is using such methods has to find out what all those parameters so that they can pass the correct values in correct sequence. And the problem is compounded if our arguments are of similar or same data type. For example in the above code we have 2 constructors with same arguments which is not allowed in Java. This will give compilation error.

```java
public House(int walls, int doors, int windows, boolean isRoof, boolean isFloor, boolean isSwimmingPool) {
}

public House(int walls, int doors, int windows, boolean isRoof, boolean isFloor, boolean isGarden) {
}
```

In most cases most of the parameters will be unused, making the constructor calls pretty ugly. For instance, only a fraction of houses have swimming pools, so the parameters related to swimming pools will be useless nine times out of ten.

## Solution:

Builder pattern let us construct complex objects step by step and doesn't allow to use until it is completely built. The Builder pattern suggests to extract the object construction code out of its own class and move it to separate class called builder. The pattern organizes object construction into a set of steps (buildWalls, buildDoor, etc). To create an object we need to execute a series of these steps on a builder object. The important part is that we don't need to call all of these steps. We can call only those steps that are necessary for producing a particular configuration of an object(Simple House, House with garden, House with swimming pool, etc). Some of the construction steps might require different implementation when we need to build various representations of the product. For example: walls of a cabin may be built of wood, but the castle walls must be built with stone. In this case, we can create several different builder classes that implements the same set of building steps, but in a different manner. Then we can use these builders in the construction process to produce different kinds of objects. For example, imagine a builder that builds everything from wood and glass, a second one that builds everything with stone and iron and a third one that uses gold and diamonds. By calling the same set of steps, we get a regular house from the first builder, a small castle from the second and a palace from the third. However this would only work if the client code that calls the building steps is able to interact with builders using a common interface.

constructor, we have 4 different numbers that need to be passed.

This is a creation and design pattern. Lets understand the problem first.
Here we have a simple class `Product`.

```java
class Product {
    public Product(int weight, double price, int shippingVolume, int shippingCode){
        // Initialize
    }
    // other code
}
```

Let's say we have a requirement that object of this class should be immutable and as we know immutable object is an object whose state or properties cannot be changed once that object is created. `String` class is a good example. It is an inbuilt Java class. Objects of String class are immutable. So once we create a string object, we cannot change/modify/update its value.

### Problem1:

When we are writing immutable classes, we often end up wiriting constructors with multiple parameters because we have to provide all this information for the object in the constructor itself. Now having a method or constructor that needs a lot of arguments is considered a bad code in practice because anyone who is using such methods has to find out what all those parameters so that they can pass the correct values in correct sequence. And the problem is compounded if our arguments are of similar or same data type. For example, in the above `Product` constructor, we have 4 different numbers that need to be passed.

### Question: Don't you think the parameter name itself can be a documentation like weight, price, etc?

Usually we distribute our code in a compiled format, in a jar file to other developers. So the parameter name itself is of no use. The only way they can find out about these parameters is to refer the documentation. Here Builder design pattern can help us in these situations. It can help us in two ways.

1. It will make it easy to use such constructors so that we can create objects of this class.
2. It will help us to avoid writing such constructors in first place and still have our objects immutable.

### Problem2:

Lets look at this class. This `User` class is also immutable.

```java
class User {
    public User(String name, Address address, LocalDate birthDate, List<Role> roles) {
        //Initialize
    }
}
```

We simply cannot create the object this class. To create object of this class first we need to create object of `Address` class then we need to create a `List` object and add the `Role` object. Sometimes object creation is not so easy. It depends on some other objects or other factors. So again this problem can be solved by the Builder design pattern.

### What is Builder Design pattern?

So whenever we have a complex process to create an object and the complexity could be because of the no of arguments that the constructor needs or the complexity may be because of the steps that are needed in order to create the object. So in this pattern we remove the logic of creating object and abstract into multiple separate classes so that the user/client of our object can easily create the object.
