public class AStarMazeSolver implements IMazeSolver {
    private Maze Original, Solved;
    private NodeMap MazeMap;
    private ArrayList<Node> OpenList, ClosedList;

    public AStarMazeSolver(Maze ToSolve) {
        this.Original = ToSolve;
        this.Solved = this.Original.Copy();
    }

    public Maze SolveMaze(Coordinate Start, Coordinate End) {
        MapMaze(End);
        OpenList = new ArrayList<>();
        ClosedList = new ArrayList<>();

        Node StartNode = MazeMap.Get(Start);
        StartNode.SetGCost(0);
        Node EndNode = MazeMap.Get(End);
        Node Current = new Node();

        OpenList.Add(StartNode);

        while (!OpenList.IsEmpty()) {
            Current = GetLowestFCost();

            if (Current.equals(EndNode)) break;

            // Make the get neighbours method return nodes with the right FCost values already
            ArrayList<Node> Neighbours = GetNeighbours(Current);

            for (int i = 0; i < Neighbours.GetSize(); i++) {
                Node Successor = Neighbours.Get(i);
                int MoveCost = Current.GetGCost() + CalculateMoveCost(Current, Successor);

                if (OpenList.Contains(Successor)) {
                    Node ToUpdate = OpenList.Get(OpenList.Find(Successor));
                    if (ToUpdate.GetGCost() > MoveCost) {
                        ToUpdate.SetGCost(MoveCost);
                        ToUpdate.SetParent(Current);
                    }
                }
                else if (ClosedList.Contains(Successor)) {
                    Node ToUpdate = ClosedList.Get(ClosedList.Find(Successor));
                    if (ToUpdate.GetGCost() > MoveCost) {
                        ToUpdate.SetGCost(MoveCost);
                        ToUpdate.SetParent(Current);
                        ClosedList.Remove(ToUpdate);
                        OpenList.Add(ToUpdate);
                    }
                }
                else {
                    Successor.SetGCost(MoveCost);
                    Successor.SetParent(Current);
                    OpenList.Add(Successor);
                }
            }

            OpenList.Remove(Current);
            ClosedList.Add(Current);
        }

        if (Current.equals(EndNode)) {
            System.out.println("Found the end.");
        }

        if (OpenList.GetSize() == 0) {
            System.out.println("OpenList is empty.");
        }

        while (!Current.equals(StartNode)) {
            Solved.Set(Current.GetLocation(), 2);
            Current = Current.GetParent();
        }

        return this.Solved;
    }

    private void MapMaze(Coordinate End) {
        MazeMap = new NodeMap(Original.GetWidth(), Original.GetHeight());

        for (int x = 0; x < Original.GetWidth(); x++) {
            for (int y = 0; y < Original.GetHeight(); y++) {
                Node Current = new Node(x, y);
                Current.CalculateHeuristic(End);
                MazeMap.Set(x, y, Current);
            }
        }
    }

    private Node GetLowestFCost() {
        Node Lowest = new Node();
        Lowest.SetFCost(Integer.MAX_VALUE);

        for (int i = 0; i < OpenList.GetSize(); i++) {
            if (OpenList.Get(i).GetFCost() < Lowest.GetFCost()) {
                Lowest = OpenList.Get(i);
            }
        }

        return Lowest;
    }

    private ArrayList<Node> GetNeighbours(Node Current) {
        ArrayList<Node> Neighbours = new ArrayList<>();
        Coordinate CurrentCoordinate = Current.GetLocation();
        int cx = CurrentCoordinate.GetX();
        int cy = CurrentCoordinate.GetY();

        for (int i = cx - 1; i <= cx + 1; i++) {
            for (int j = cy - 1; j <= cy + 1; j++) {
                if (!(i == cx && j == cy) && ValidNeighbour(i, j)) {
                    Neighbours.Add(MazeMap.Get(i, j));
                }
            }
        }

        return Neighbours;
    }

    private boolean ValidNeighbour(int i, int j) {
        if (i < 0 || Original.GetWidth() <= i || j < 0 || Original.GetHeight() <= j) return false;
        if (Original.Get(i, j) == 0 || ClosedList.Contains(new Node(i, j))) return false;
        return true;
    }

    private int CalculateMoveCost(Node Current, Node Successor) {
        Coordinate CurrentCoordinate = Current.GetLocation();
        Coordinate SuccessorCoordinate = Successor.GetLocation();
        int dx = Math.abs(CurrentCoordinate.GetX() - SuccessorCoordinate.GetX());
        int dy = Math.abs(CurrentCoordinate.GetY() - SuccessorCoordinate.GetY());

        return (dx == 0 || dy == 0) ? 10 : 14;
    }

    /*
    public Maze SolveMaze(Coordinate Start, Coordinate End) throws UnsolvableMazeException {
        if (ToSolve.Get(Start) == 0 || ToSolve.Get(End) == 0) {
            throw new UnsolvableMazeException("The input maze has a wall at the start or end point and therefore cannot be solved.");
        }

        this.MazeMap = MapMaze(Original, End);
        Node StartNode = this.MazeMap.Get(Start);
        StartNode.SetGCost(0);
        StartNode.CalculateFCost();
        Node EndNode = this.MazeMap.Get(End);
        Node Current;

        OpenList = new ArrayList<>();
        ClosedList = new ArrayList<>();
        OpenList.Add(StartNode);

        while (!OpenList.IsEmpty()) {
            Current = GetLowestFCost(OpenList);

            if (Current.equals(EndNode)) {
                break;
            }

            ArrayList<Node> Neighbours = GetNeighbours(Current);

            for (int i = 0; i < Neighbours.GetSize(); i++) {
                Node Successor = Neighbours.Get(i);
                int MoveCost = CalculateMoveCost(Current, Successor);
                Successor.SetGCost(Current.GetGCost() + MoveCost);
                Successor.SetParent(Current);

                if (OpenList.Contains(Successor)) {
                    int CurrentCost = OpenList.Get(OpenList.Find(Successor)).GetGCost();
                    if (Successor.GetGCost() <= CurrentCost) {
                        OpenList
                    }
                } else if (ClosedList.Contains(Successor)) {

                } else {

                }
            }

            ClosedList.Add(Current);
        }

        return M;
    }

    private NodeMap MapMaze(Maze M, Coordinate End) {
        NodeMap MazeMap = new NodeMap(M.GetWidth(), M.GetHeight());

        for (int x = 0; x < M.GetWidth(); x++) {
            for (int y = 0; y < M.GetHeight(); y++) {
                Node StartNode = new Node(x, y);
                StartNode.CalculateHeuristic(End);
                MazeMap.Set(x, y, StartNode);
            }
        }

        return MazeMap;
    }

    private Node GetLowestFCost(ArrayList<Node> OpenList) {
        Node Lowest = new Node();
        Lowest.SetFCost(Integer.MAX_VALUE);

        for (int i = 0; i < OpenList.GetSize(); i++) {
            if (OpenList.Get(i).GetFCost() < Lowest.GetFCost()) {
                Lowest = OpenList.Get(i);
            }
        }

        return Lowest;
    }

    private ArrayList<Node> GetNeighbours(Node Current, Maze M, ArrayList<Node> ClosedList) {
        ArrayList<Node> Neighbours = new ArrayList<>();
        Coordinate CurrentCoordinate = Current.GetLocation();
        int cx = CurrentCoordinate.GetX();
        int cy = CurrentCoordinate.GetY();

        for (int i = cx - 1; i <= cx + 1; i++) {
            for (int j = cy - 1; j <= cy + 1; j++) {
                if (!(i == cx && j == cy) && ValidNeighbour(i, j, Current, M, ClosedList)) {
                    Neighbours.Add(NodeMap.Get(i, j));
                }
            }
        }

        return Neighbours;
    }

    private boolean ValidNeighbour(int i, int j, Node Current, Maze M, ArrayList<Node> ClosedList) {
        if (i < 0 || M.GetWidth() <= i || j < 0 || M.GetHeight() <= j) return false;
        if (M.Get(i, j) == 0 || ClosedList.Contains(new Node(i, j))) return false;
        return true;
    }

    private int CalculateMoveCost(Node Current, Node Successor) {
        Coordinate CurrentCoordinate = Current.GetLocation();
        Coordinate SuccessorCoordinate = Successor.GetLocation();
        int dx = Math.abs(CurrentCoordinate.GetX() - SuccessorCoordinate.GetX());
        int dy = Math.abs(CurrentCoordinate.GetY() - SuccessorCoordinate.GetY());

        return (dx == 0 || dy == 0) ? 10 : 14;
    }
    */
}
