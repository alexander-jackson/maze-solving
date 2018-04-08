public class NodeMap {
    private int Width, Height;
    private Node[] Data;

    public NodeMap(int Width, int Height) {
        this.Data = new Node[Width * Height];
        this.Width = Width;
        this.Height = Height;
    }

    public Node Get(Coordinate C) {
        return this.Get(C.GetX(), C.GetY());
    }

    public Node Get(int x, int y) {
        return this.Data[x * this.Width + y];
    }

    public void Set(Coordinate C, Node N) {
        this.Set(C.GetX(), C.GetY(), N);
    }

    public void Set(int x, int y, Node N) {
        this.Data[x * this.Width + y] = N;
    }
}
