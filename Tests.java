public class Tests {

    static int Width = 50;
    static int Height = 50;

    public static void main(String[] args) {
        if (args.length > 0) {
            // There are arguments passed to the program
            for (int i = 0; i < args.length; i++) {
                String[] Split = args[i].split("=");
                switch (Split[0].toLowerCase()) {
                    case "width": Width = Integer.parseInt(Split[1]); break;
                    case "height": Height = Integer.parseInt(Split[1]); break;
                }
            }
        }

        DepthFirstMazeGenerator DFMG = new DepthFirstMazeGenerator(Width, Height);
        Maze m = DFMG.GenerateMaze();
        m.PrettyDisplay();

        AStarMazeSolver ASMS = new AStarMazeSolver(m);
        Coordinate Start = new Coordinate(1, 1);
        Coordinate End = new Coordinate(m.GetWidth() - 2, m.GetHeight() - 2);
        Maze Solved = ASMS.SolveMaze(Start, End);
        Solved.PrettyDisplay();
        Solved.WriteToImage("Solved.png");
    }
}
