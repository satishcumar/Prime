package com.random.model;

import com.random.data.Queue;
import com.random.data.QueueData;
import com.random.util.CacheUtil;

public class RandomGenerator {

	public boolean WriteData(int iRandomSize){
		boolean bWrite = false;
		int i = 0;
		int iNumb = 0;
		try{
		Queue queue =  CacheUtil.getCache();
		if(null == queue){
			queue = new Queue();
		}
		while(i< iRandomSize){		
		Double d = Math.random();
		 iNumb = (int) (d*100);
		 QueueData queueData = new QueueData();
		 queueData.setiData(iNumb);
		 i++;
		 queue.enqueue(queueData);
		}
		 bWrite = true;
		 CacheUtil.putCache(queue);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	    return bWrite;	
	}
	 public QueueData[] DisplayResult(){
		 QueueData[] queueData = null;
		 Queue queue = CacheUtil.getCache();
		 if(null != queue){
		 int iQueLen = queue.queueSize();
		 queueData = new QueueData[iQueLen];
		 for(int i = 0; i < iQueLen ; i++){
			  queueData[i] = queue.dequeue();
			  /*if(null != queueData[i] && !queueData[i].isProcessed()){
				  queue.enqueue(queueData[i]);
			  }*/
		 }
		 }
		 return queueData;
		 
	 }
	
}
