/**
 * Defines an interface for Maze Generators, specifying the methods they must implement
 */
public interface IMazeGenerator {
    /**
     * Defines that Maze Generators must have a GenerateMaze method
     * @return Returns a maze that the generator generated
     */
    public Maze GenerateMaze();
}
