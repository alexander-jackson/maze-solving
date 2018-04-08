public interface IMazeSolver {
    public Maze SolveMaze(Maze M, Coordinate Start, Coordinate End) throws UnsolvableMazeException;
}
