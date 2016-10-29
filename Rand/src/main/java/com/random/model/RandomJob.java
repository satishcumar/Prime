package com.random.model;

import java.util.ArrayList;

import com.random.data.Queue;
import com.random.data.QueueData;
import com.random.util.CacheUtil;

public class RandomJob {
	public boolean processJob(){
		boolean bProcess = false;
		int iQueueSize = 0;
		Queue queue = CacheUtil.getCache();
		ArrayList<QueueData> alQueueData = new ArrayList<QueueData>();
		QueueData qdata = null;
		if(null != queue){
			iQueueSize = queue.queueSize();
			for(int i = 0; i < iQueueSize ; i++){
				qdata = queue.dequeue();
				if(null != qdata){
				alQueueData.add(qdata);
				}
			}
			int alSize = alQueueData.size();
			QueueData queueData2 = null;
			Queue queue1 = new Queue();
			for(int j = 0 ; j < alSize ; j++){
				queueData2 = alQueueData.get(j);
				int iData = queueData2.getiData();
				System.out.println("Data -->" + iData);
				if(iData !=0 && null != queueData2 && !queueData2.isProcessed()){
					queueData2.setbResult(checkPrime(queueData2.getiData()));
					queueData2.setProcessed(true);
					queue1.enqueue(queueData2);
				}
			}
			CacheUtil.putCache(queue1);
			bProcess = true;
		}
		
		return bProcess;
	}

	private boolean checkPrime(int iNum){
		boolean isPrime = true;
		if(iNum == 0 || iNum == 1){
			isPrime = false;
		}else{
		for(int j = 2 ; j < iNum/2 ; j++){
			if(iNum % j == 0){
				isPrime = false;
				return isPrime;
			}
		}
		}
		return isPrime;
	}
}
