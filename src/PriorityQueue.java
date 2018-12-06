
public class PriorityQueue {
	int job;
    int priority;
    String fp;
 
    /* 
     * Constructor
     * @param job
     * @param priority
     * @param fp
     */
    public PriorityQueue(int job, int priority, String fp)
    {
        this.job = job;
        this.priority = priority; 
        this.fp = fp;
    }
    /* toString()
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() 
    {
        return fp + "," + job + "," + priority;
    }
}
 
/** 
 * Class PriorityQueue
 * @author David Meyer
 *
 */
class PriorityQueueMaker
{
    private PriorityQueue[] heap; 
    private int heapSize, capacity;
 
    /** 
     * Constructor
     * @param capacity
     */
    public PriorityQueueMaker(int capacity)
    {    
        this.capacity = capacity + 1;
        heap = new PriorityQueue[this.capacity];
        heapSize = 0;
    }
    /** 
     * function to clear
     * 
     */
    public void clear()
    {
        heap = new PriorityQueue[capacity];
        heapSize = 0;
    }
    /** 
     * function to check if empty
     * @return
     */
    public boolean isEmpty()
    {
        return heapSize == 0;
    }
    /** 
     * function to check if full 
     * @return
     */
    public boolean isFull()
    {
        return heapSize == capacity-1;
    }
    /**
     * function to peek() at heap
     * @return
     */
    public PriorityQueue peek() 
    {
    	 return heap[capacity - 1];
    }
    /** 
     * function to get Size
     * @return
     */
    public int size()
    {
        return heapSize;
    }
    /** 
     * function to insert task
     * @param job
     * @param priority
     * @param fp
     */
    public void insert(int job, int priority, String fp)
    {
    	PriorityQueue newJob = new PriorityQueue(job, priority, fp);
        heap[++heapSize] = newJob;
        int pos = heapSize;
        while (pos != 1 && newJob.priority > heap[pos/2].priority)
        {
            heap[pos] = heap[pos/2];
            pos /=2;
        }
        heap[pos] = newJob;    
    }
    /** 
     * function to remove task
     * @return
     */
    public PriorityQueue remove()
    {
        int parent, child;
        PriorityQueue item, temp;
        if (isEmpty() )
        {
            System.out.println("Heap is empty");
            return null;
        }
        item = heap[1];
        temp = heap[heapSize--];
        parent = 1;
        child = 2;
        while (child <= heapSize)
        {
            if (child < heapSize && heap[child].priority < heap[child + 1].priority)
                child++;
            if (temp.priority >= heap[child].priority)
                break;
            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;
        return item;
    }
}
