package PreRequisites;

public class Reusable {
    public static void Sleep(int t){
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
