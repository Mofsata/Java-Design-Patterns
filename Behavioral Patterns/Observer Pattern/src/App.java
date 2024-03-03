import java.util.ArrayList;
import java.util.List;

interface ISubscriber {
    public void notifySubscriber(int i);
}

class Subscriber1 implements ISubscriber{
    @Override
    public void notifySubscriber(int i) {
        System.out.println("Subscriber1 is notified, value changed to " + i);
    }    
}

class Subscriber2 implements ISubscriber{
    @Override
    public void notifySubscriber(int i) {
        System.out.println("Subscriber2 is notified, value changed to " + i);
    }    
}

class Publisher{
    private int value;
    private List<ISubscriber> subsList= new ArrayList<>();

    public int getValue(){
        return this.value;
    }

    public void setValue(int i){
        this.value = i;
        this.notifyAll(i);
    }

    public void follow(ISubscriber sub){
        subsList.add(sub);
    }

    public void unfollow(ISubscriber sub){
        subsList.remove(sub);
    }

    public void notifyAll(int i){
        for (ISubscriber sub : subsList) {
            sub.notifySubscriber(i);
        }
    }
}

class App {
    public static void main(String[] args) throws Exception {
        Publisher droosOnline = new Publisher();
        Subscriber1 mostafa = new Subscriber1();
        Subscriber2 moaz = new Subscriber2();

        droosOnline.follow(moaz);
        droosOnline.setValue(5);

        System.out.println("############################################");

        droosOnline.follow(mostafa);
        droosOnline.setValue(10);

        System.out.println("############################################");

        droosOnline.unfollow(moaz);
        droosOnline.setValue(15);
    }
}
