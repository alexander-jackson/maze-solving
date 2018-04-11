import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

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
        return this.Get(C.GetX(), C.GetY());
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
        this.Set(C.GetX(), C.GetY(), v);
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
     * Defines a method used to copy the current maze into a new Maze object (deep copy)
     * @return Returns a deep copy of the maze
     */
    public Maze Copy() {
        Maze CopiedMaze = new Maze(this.Width, this.Height);

        for (int x = 0; x < this.Width; x++) {
            for (int y = 0; y < this.Height; y++) {
                CopiedMaze.Set(x, y, this.Get(x, y));
            }
        }

        return CopiedMaze;
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
     * Values of 1 are displayed as ' ' and are an empty space
     * Values of 2 are displayed as '+' and are part of the path
     */
    public void PrettyDisplay() {
        for (int x = 0; x < this.Width; x++) {
            for (int y = 0; y < this.Height; y++) {
                char Output = '-';
                switch (this.Get(x, y)) {
                    case 1: Output = ' '; break;
                    case 2: Output = '+'; break;
                }
                System.out.print(Output + " ");
            }
            System.out.print("\n");
        }
    }

    public void WriteToImage(String Filepath) {
        try {
            BufferedImage Image = new BufferedImage(this.Width, this.Height, BufferedImage.TYPE_INT_RGB);
            File ToWrite = new File(Filepath);

            for (int x = 0; x < this.Width; x++) {
                for (int y = 0; y < this.Height; y++) {
                    int RGB = ToRGB(0, 0, 0);
                    switch (this.Get(x, y)) {
                        case 1: RGB = ToRGB(255, 255, 255); break;
                        case 2: RGB = ToRGB(0, 255, 0); break;
                    }
                    Image.setRGB(y, x, RGB);
                }
            }

            ImageIO.write(Image, "png", ToWrite);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private int ToRGB(int r, int g, int b) {
        return (r << 16) | (g << 8) | b;
    }
}
