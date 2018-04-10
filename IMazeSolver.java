public interface IMazeSolver {
    public Maze SolveMaze(Coordinate Start, Coordinate End) throws UnsolvableMazeException;
}
