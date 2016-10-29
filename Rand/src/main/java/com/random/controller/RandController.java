package com.random.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.random.data.QueueData;
import com.random.model.RandomGenerator;
import com.random.model.RandomJob;

@Controller
public class RandController {
	RandomGenerator randomGenerator = new RandomGenerator();
	
	RandomJob randomJob = new RandomJob();
	
    @RequestMapping("/load")
    public String load(String name, Model model) {
        return "load";
    }
    
    @RequestMapping("/home")
    public String home(String name, Model model) {
        return "home";
    }

    
    @RequestMapping("/loaddata")
    public String loaddata(@RequestParam(value="nos", required=false, defaultValue="1") String nos, Model model) {
    	Integer oInt = new Integer(nos);
    	boolean bFlag = randomGenerator.WriteData(oInt.intValue());
    	 if(bFlag){
         	model.addAttribute("message", "Data loaded in Queue Sucessfully");
         return "jobmsg";
         }else{
         	model.addAttribute("message", "Unable to load Data");
         	return "jobmsg";
         }
    }
    
    @RequestMapping("/process")
    public String process(String name, Model model) {
        boolean bFlag = randomJob.processJob();
        if(bFlag){
        	model.addAttribute("message", "Job completed sucessfully");
        }else{
        	model.addAttribute("message", "Job has some issues");
        }
        return "jobmsg";
    }
    
    @RequestMapping("/output")
    public String output(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
    	QueueData[] queuedata = randomGenerator.DisplayResult();
    	List<QueueData> alQueueData = new ArrayList<QueueData>();
    	if(null != queuedata){
    	int iQueuedata = queuedata.length;
    	for(int i= 0; i < iQueuedata ; i++){
    		if(null != queuedata[i] && queuedata[i].isProcessed()){
    			alQueueData.add(queuedata[i]);
    		}
    		}
    	}
    	model.addAttribute("QueueData", alQueueData);
    	return "output";
    }
   
}
