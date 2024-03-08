package week2;

public class QueueBasedStack<Data> {
    private Queue<Data> q1;
    private Queue<Data> q2;

    public QueueBasedStack() {
        q1 = new Queue<>();
        q2 = new Queue<>();
    }

    public void push(Data data) {
        if(q1.isEmpty()){
            q1.enqueue(data);
        }

        else{
            q2.enqueue(data);

            while(!q1.isEmpty()){
                Data dequeNode = q1.dequeue();
                q2.enqueue(dequeNode);
            }

            Queue<Data> temp = new Queue<>();
            temp = q1;
            q1 = q2;
            q2 = temp;

            while(!q2.isEmpty()){
                q2.dequeue();
            }
        }
    }

    public Data pop() {
        return q1.dequeue();
    }

    public Data peek() {
        return q1.peek();
    }

    public int size() {
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.size() == 0;
    }
}
