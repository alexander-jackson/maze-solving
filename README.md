# Maze Generation and Solving in Java

This project will generate mazes of given sizes through the use of the Depth First Search traversal and then solve them using the A* Algorithm. Once it has been solved, it will write the data of the maze to **Solved.png** with black squares for walls, white squares for open squares and green squares for the path.

## Getting Started

### Prerequisites

This project requires only the Java runtime to be installed, and does not use any external libraries.

### Installing

A simple clone of the repository should result in a working copy of the code, although the files will need to be run through **javac** to compile them.

```
javac *.java
java Tests
```

### Program Arguments

Arguments can be passed through to the program to alter the size of the maze if needed. For example,

```
java Tests width=20 height=20
```

will create a 20x20 maze instead of the default 50x50 variant.
