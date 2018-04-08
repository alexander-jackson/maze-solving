public class UnsolvableMazeException extends Exception {
    public UnsolvableMazeException() {
        super();
    }

    public UnsolvableMazeException(String Message) {
        super(Message);
    }

    public UnsolvableMazeException(Throwable Throw) {
        super(Throw);
    }

    public UnsolvableMazeException(String Message, Throwable Throw) {
        super(Message, Throw);
    }
}
