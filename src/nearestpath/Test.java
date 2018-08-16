package nearestpath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {    
    /*1. Flatlands (. or @ or X);
    2. Forest (*);
    3. Mountain (^);
    4. Water (~);
    */
    
    String strFlatlands = ".";
    String strForest = "*";
    String strMountain = "^";
    String strWater = "~";    
    
    
    
    public static void main(String args[]) throws FileNotFoundException
    {
        
        List<List<String>> mainList = new ArrayList<List<String>>();
        List<List<String>> tmpList = new ArrayList<List<String>>();
        List<List<String>> mainOutputList = new ArrayList<List<String>>();
            
        Scanner data = new Scanner(new File("C:\\Users\\Srimanth\\Desktop\\large_map.txt"));      

        while (data.hasNextLine()) {          
            List<String> lineInts = new ArrayList<String>();
            Scanner lineData = new Scanner(data.nextLine());

            while (lineData.hasNext()) {
                lineInts.add(lineData.next());
            }

            mainList.add(lineInts);
            tmpList.add(lineInts);
        }

        //System.out.println(mainList);
        
        /*for (int i=0;i < mainList.size();i++)
        {                       
            List<String> lineOutputInts = new ArrayList<String>();            
            for (int j=0; j < mainList.get(i).size(); j++)
            {                
                String cmpStr = mainList.get(i).get(j);
                System.out.print("i:"+i+":j:"+j+" "+cmpStr+"    ");               
                if(cmpStr.equalsIgnoreCase("*") || cmpStr.equalsIgnoreCase(".") || cmpStr.equalsIgnoreCase("^")){
                    lineOutputInts.add("#");
                }
                else{
                    lineOutputInts.add(cmpStr);
                }
            }            
            mainOutputList.add(lineOutputInts);
            System.out.println();            
        }*/
        
        /*
        for (int i=0;i < mainList.size();i++)
        {                       
            List<String> lineOutputInts = new ArrayList<String>();            
            for (int j=0; j < mainList.get(i).size(); j++)
            {         
                String tmpStr1 = "", tmpStr2 = "", tmpStr3 = "";
                String cmpStr = mainList.get(i).get(j);
                System.out.print("i:"+i+":j:"+j+" "+cmpStr+" ");              
                
                if(cmpStr.equalsIgnoreCase("@") || cmpStr.equalsIgnoreCase("X")){
                    lineOutputInts.add(cmpStr);
                }
                else{ 
                    if(cmpStr.equalsIgnoreCase("~")){                    
                        lineOutputInts.add(cmpStr);
                    }
                    else{
                        
                        if(i+1 < mainList.size()){
                                                        
                            if(j>0){                                
                                tmpStr3 = mainList.get(i+1).get(j-1);                                                   
                            }
                            else{
                                tmpStr3 = "";
                            }
                            
                            if(j+1 < mainList.get(i).size()){
                                tmpStr1 = mainList.get(i+1).get(j+1);
                            }
                            else{
                                tmpStr1 = "";
                            }
                            
                            tmpStr2 = mainList.get(i+1).get(j);
                            
                            if(tmpStr1!="" && checkValue(tmpStr1)){
                                lineOutputInts.add("#");
                                //break;
                            }
                            else if(checkValue(tmpStr2)){
                                lineOutputInts.add("#");
                                //break;
                            }     
                            else if(tmpStr3!="" && checkValue(tmpStr3)){
                                lineOutputInts.add("#");
                                //break;
                            }
                            else{
                                tmpStr1 = mainList.get(i).get(j+1);
                                if(checkValue(tmpStr1)){
                                    lineOutputInts.add("#");
                                    //break;
                                }
                                else{
                                    lineOutputInts.add(tmpStr1);
                                }
                            }                             
                        }
                        else{
                            
                            if(j+1 < mainList.get(i).size()){
                                tmpStr1 = mainList.get(i).get(j+1);
                            }
                            else{
                                tmpStr1 = "";
                            }
                            
                            tmpStr2 = mainList.get(i).get(j);
                            
                            if(tmpStr1!="" && checkValue(tmpStr1)){
                                lineOutputInts.add("#");
                            }
                            else if(checkValue(tmpStr2)){
                                lineOutputInts.add("#");
                            }
                            else{
                                lineOutputInts.add(tmpStr1);
                            }
                        }
                    }
                }
            }            
            
            mainOutputList.add(lineOutputInts);
            System.out.println();            
        }
        */
        
        for (int i=0;i < mainList.size();i++)
        {                       
            int k=0;
            List<String> lineOutputInts = new ArrayList<String>();            
            for (int j=0; j < mainList.get(i).size(); j++)
            {         
                String tmpStr1 = "", tmpStr2 = "", tmpStr3 = "";
                String cmpStr = mainList.get(i).get(j);
                        
                if(cmpStr.equalsIgnoreCase("@") || cmpStr.equalsIgnoreCase("X")){
                    lineOutputInts.add(cmpStr);
                }
                else{ 
                    if(cmpStr.equalsIgnoreCase("~")){                    
                        lineOutputInts.add(cmpStr);
                    }
                    else{
                        
                        if(i+1 < mainList.size()){
                                                        
                            if(j>0){                                
                                tmpStr3 = mainList.get(i+1).get(j-1);                                                   
                            }
                            else{
                                tmpStr3 = "";
                            }
                            
                            if(j+1 < mainList.get(i).size()){
                                tmpStr1 = mainList.get(i+1).get(j+1);
                            }
                            else{
                                tmpStr1 = "";
                            }
                            
                            tmpStr2 = mainList.get(i+1).get(j);
                            
                            if(tmpStr1!="" && checkValue(tmpStr1)){
                                lineOutputInts.add("#");
                                tmpList.get(i+1).set(j+1,"#");
                                k = j+1;

                                //break;
                            }
                            else if(checkValue(tmpStr2)){
                                lineOutputInts.add("#");
                                tmpList.get(i+1).set(j,"#");
                                k = j;
                                //break;
                            }     
                            else if(tmpStr3!="" && checkValue(tmpStr3)){
                                lineOutputInts.add("#");
                                tmpList.get(i+1).set(j-1,"#");
                                k = j-1;
                                //break;
                            }
                            else{
                                tmpStr1 = mainList.get(i).get(j);
                                if(checkValue(tmpStr1)){
                                    lineOutputInts.add("#");
                                    tmpList.get(i).set(j,"#");  
                                    k = j;
                                    //break;
                                }
                                else{
                                    lineOutputInts.add(tmpStr1);                                     
                                }
                            }                             
                        }
                        else{
                            
                            if(j+1 < mainList.get(i).size()){
                                tmpStr1 = mainList.get(i).get(j+1);
                            }
                            else{
                                tmpStr1 = "";
                            }
                            
                            tmpStr2 = mainList.get(i).get(j);
                            
                            if(tmpStr1!="" && checkValue(tmpStr1)){
                                lineOutputInts.add("#");
                                tmpList.get(i).set(j+1,"#"); 
                                k = j+1;
                                //break;
                            }
                            else if(checkValue(tmpStr2)){
                                lineOutputInts.add("#");
                                tmpList.get(i).set(j,"#");
                                k = j;
                                ///break;
                            }
                            else{
                                lineOutputInts.add(tmpStr1); 
                            }
                        }
                    }
                }
            }  
            
            
            //if(k>0){
           /* System.out.println("k:"+k);            
                for(int x=k; x < mainList.get(i).size(); x++){
                    lineOutputInts.add(mainList.get(i).get(x)); 
                }*/
            //}
            
            mainOutputList.add(lineOutputInts);
            System.out.println();            
        }
        
        
        
        //////////////////////////////////////
        
        System.out.println("Output");
        for (int i=0;i < mainOutputList.size();i++)
        {                                         
            for (int j=0; j < mainOutputList.get(i).size(); j++)
            {                
                String cmpStr = mainOutputList.get(i).get(j);
                System.out.print(" "+cmpStr+" ");                 
            }         
            System.out.println();
        }   
        
        
        
        //System.out.println("tmpList");
        //System.out.println(tmpList);
        
    
    }
    
    static boolean checkValue(String strTmp){
        String strTmp1 = strTmp;
        if(strTmp.equalsIgnoreCase(".") || strTmp.equalsIgnoreCase("*") || strTmp.equalsIgnoreCase("^")){            
            return true;
        }
        else{
            return false;
        }        
    }
    
    
    
}