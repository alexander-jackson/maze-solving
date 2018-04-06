public class Maze {
    // The Width and Height of the Maze
    private int Width, Height;
    // The Maze itself as an array of integers
    private int[] Data;

    /**
     * Defines a function that initialises a maze object
     * Sets the values of Width and Height and creates a new array of integers
     * to store the values of each cell
     * Also checks whether the Maze is of a valid size
     * @param Width  The Width of the Maze. This will be corrected to be an odd number (rounded upwards)
     * @param Height The Height of the Maze. This will also be corrected to an odd number
     */
    public Maze(int Width, int Height) {
        this.Width = (Width % 2 == 0) ? Width + 1 : Width;
        this.Height = (Height % 2 == 0) ? Height + 1 : Height;
        this.Data = new int[this.Width * this.Height];
    }

    /**
     * Defines a simple Get method to index the Maze object and get the value of it
     * @param  x The x coordinate being accessed
     * @param  y The y coordinate being accessed
     * @return   Returns the value at that coordinate
     */
    public int Get(int x, int y) {
        return this.Data[x * this.Width + y];
    }

    /**
     * Defines a simple Get method to index the Maze object and get the value of it
     * using a Coordinate structure
     * @param  C The coordinate being accessed
     * @return   Returns the value at that coordinate
     */
    public int Get(Coordinate C) {
        return this.Get(C.x, C.y);
    }

    /**
     * Defines a simple Set method to index the Maze object and set the value of it
     * @param x The x coordinate being set
     * @param y The y coordinate being set
     * @param v The value to set this coordinate to
     */
    public void Set(int x, int y, int v) {
        this.Data[x * this.Width + y] = v;
    }

    /**
     * Defines a simple Set method to index the Maze object and set the value of it
     * using a Coordinate structure
     * @param C The coordinate being set
     * @param v The value to set this coordinate to
     */
    public void Set(Coordinate C, int v) {
        this.Set(C.x, C.y, v);
    }

    /**
     * Defines a simple get method for the width of the maze
     * @return The width of the maze
     */
    public int GetWidth() {
        return this.Width;
    }

    /**
     * Defines a simple get method for the height of the maze
     * @return The height of the maze
     */
    public int GetHeight() {
        return this.Height;
    }

    /**
     * Defines a method that displays the current content of the maze in numbers
     */
    public void Display() {
        for (int x = 0; x < this.Width; x++) {
            for (int y = 0; y < this.Height; y++) {
                System.out.print(this.Get(x, y) + " ");
            }
            System.out.print("\n");
        }
    }

    /**
     * Defines a method that displays the current content of the Maze in a more readable fashion
     * Values of 0 are displayed as '-' and are a wall
     * Any other value is displayed as an empty space
     */
    public void PrettyDisplay() {
        for (int x = 0; x < this.Width; x++) {
            for (int y = 0; y < this.Height; y++) {
                System.out.print((this.Get(x, y) == 0 ? '-' : ' ')  + " ");
            }
            System.out.print("\n");
        }
    }
}
