package com.random.util;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.random.data.Queue;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheUtil {
	@Cacheable("RandomQueue")
	public static Queue getCache(){
	Queue queue = null;
	CacheManager cm = CacheManager.getInstance(); 
	Cache cache = cm.getCache("RandomQueue");
	Element e1 = cache.get("RandQueue");
	if(null != e1){
		queue = (Queue) e1.getObjectValue();
	}
	 return queue;
	}
	
	@CachePut("RandomQueue")
	public static void putCache(Queue queue){
	CacheManager cm = CacheManager.getInstance(); 
	Cache cache = cm.getCache("RandomQueue");
	Element e1 = new Element("RandQueue", queue);
	cache.put(e1);
	}
	
}
