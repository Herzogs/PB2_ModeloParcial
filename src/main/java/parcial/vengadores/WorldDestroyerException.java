package parcial.vengadores;

public class WorldDestroyerException extends Exception{

    private String msg;

    public WorldDestroyerException(String message) {
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return this.msg;
    }
}
