package com.random.data;

public class Queue {

	 private int capacity = 10;
	 QueueData queueArr[];
	    int front = 0;
	    int rear = -1;
	    int currentSize = 0;
	     
	    public Queue(){
	        queueArr = new QueueData[this.capacity];
	    }
	    
	 
	    /**
	     * this method adds element at the end of the queue.
	     * @param item
	     */
	    public void enqueue(QueueData item) {
	         
	        if (isQueueFull()) {
	            System.out.println("Queue is full, increase capacity...");
	            increaseCapacity();
	        }
	        rear++;
	        if(rear >= queueArr.length && currentSize != queueArr.length){
	            rear = 0;
	        }
	        if(null != item){
	        queueArr[rear] = item;
	        }
	        currentSize++;
	        System.out.println("Adding: " + item);
	    }
	 
	    /**
	     * this method removes an element from the top of the queue
	     */
	    public QueueData dequeue() {
	    	if(null != queueArr ){
	    		currentSize = queueArr.length;
	    	}
	    	QueueData queueData = null;
	        if (isQueueEmpty()) {
	            System.out.println("Underflow ! Unable to remove element from Queue");
	        } else {
	            front++;
	            if(front > queueArr.length-1){
	            	queueData = queueArr[front-1];
	                System.out.println("removed: "+queueArr[front-1]);
	                front = 0;
	            } else {
	            	queueData = queueArr[front-1];
	                System.out.println("removed: "+queueArr[front-1]);
	            }
	            currentSize--;
	        }
	        return queueData;
	    }
	 
	    /**
	     * This method checks whether the queue is full or not
	     * @return boolean
	     */
	    public boolean isQueueFull(){
	        boolean status = false;
	        if (currentSize == queueArr.length){
	            status = true;
	        }
	        return status;
	    }
	     
	    /**
	     * This method checks whether the queue is empty or not
	     * @return
	     */
	    public boolean isQueueEmpty(){
	        boolean status = false;
	        if (currentSize == 0){
	            status = true;
	        }
	        return status;
	    }
	    public int queueSize(){
	    	int i = 0;
	    	 if(null != queueArr){
	    		 i = queueArr.length;
	    	 }
	    	 return i;
	    }
	     
	    private void increaseCapacity(){
	         
	        //create new array with double size as the current one.
	        int newCapacity = this.queueArr.length*2;
	        QueueData[] newArr = new QueueData[newCapacity];
	        //copy elements to new array, copy from rear to front
	        int tmpFront = front;
	        int index = -1;
	        while(true){
	            newArr[++index] = this.queueArr[tmpFront];
	            tmpFront++;
	            if(tmpFront == this.queueArr.length){
	                tmpFront = 0;
	            }
	            if(currentSize == index+1){
	                break;
	            }
	        }
	        //make new array as queue
	        this.queueArr = newArr;
	        System.out.println("New array capacity: "+this.queueArr.length);
	        //reset front & rear values
	        this.front = 0;
	        this.rear = index;
	    }
	     
}
