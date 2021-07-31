package Others;

public class Singleton_1 {

    private Singleton_1(){

    }

    private static class Holder{
        private static Singleton_1 singleton_1=new Singleton_1();
    }

    public static Singleton_1 getInstance(){
        return Holder.singleton_1;
    }
}
