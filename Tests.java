public class Tests {

    static final int Width = 70;
    static final int Height = 70;

    public static void main(String[] args) {
        DepthFirstMazeGenerator DFMG = new DepthFirstMazeGenerator(Width, Height);
        Maze m = DFMG.GenerateMaze();
        m.PrettyDisplay();

        AStarMazeSolver ASMS = new AStarMazeSolver(m);
        Coordinate Start = new Coordinate(1, 1);
        Coordinate End = new Coordinate(m.GetWidth() - 2, m.GetHeight() - 2);
        Maze Solved = ASMS.SolveMaze(Start, End);
        Solved.PrettyDisplay();
    }
}
