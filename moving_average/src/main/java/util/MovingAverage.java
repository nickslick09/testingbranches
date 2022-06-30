package util;

public class MovingAverage<T extends Number> {

    private final int windowSize;
    private final FixedCircularList<T> fixedCircularList;

    public MovingAverage(int listSize){
        windowSize = listSize;
        fixedCircularList = new FixedCircularList<>(listSize);
    }

    public double mean() {
        double sum = 0d;
        for (T i : fixedCircularList) {
            sum += i.doubleValue();
        }
        return sum / windowSize;
    }

    public void add(T value){
        fixedCircularList.add(value);
    }

    public int size(){
        return fixedCircularList.size();
    }
}
