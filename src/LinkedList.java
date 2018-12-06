/**
 * @author David Meyer
 *
 */
public class LinkedList {

	/**
	 * @author David Meyer
	 * creates the node class to be used to help add items to list
	 */
	class Node	{
		String data;
		int delim;
		Node next;
		}
	
	//variable declaration
	private Node head;
	private int size;

	public LinkedList() {
	head = null;
	size = 0;
	}

	/**
	 * @param can
	 * adds new canMeyer object to the list
	 */
	public void add(String data){
	Node node = new Node();
	node.data = data;
	if(isEmpty()){
		head = node;
	}
	else
	{
		Node temp = head;

		if(head.next == null){
			head.next = node;
		}
		else
		{
			while(temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = node;
		}
		}
		size++;
	}
	/**
	 * @return
	 * returns size of the list
	 */
	public int getSize(){
	return size;
	}

	/**
	 * @return
	 * returns True if the list is empty
	 */
	public boolean isEmpty(){
	return size==0;
	}
	
	public boolean isFull() {
		return size!=0;
	}

	/**
	 * @param can
	 * removes an item from the list
	 */
	public void remove(String data){
		if(!isEmpty())	{
			if(head.data == data)
				head = head.next;
			else{
				Node temp = head;
				if(temp.next != null)
				{
					if(temp.next.data == data)	{
						temp.next = temp.next.next;
					}
				}
			}
			size--;
		}
	}

	/**
	 * @return
	 * returns the first item on the list
	 */
	public String peek(){
		if(!isEmpty())
			return head.data;
		else return null;
	}

	/**
	 * prints out the items in the list
	 */
	public void print(){
		Node temp = head;
		while(temp != null)	{
		System.out.println(temp.data);
		temp = temp.next;
		}

	}

}

