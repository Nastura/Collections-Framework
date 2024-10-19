public class NotRegisteredException  extends RuntimeException{
    public NotRegisteredException(String s) {
        super(s);
        System.out.println(s);
    }

}
