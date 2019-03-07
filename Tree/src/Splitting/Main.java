package Splitting;
import java.util.*;

public class Main
{

      public static List<Object> removeDuplicates(List<String[]> l)
      {
          Set<String[]> s = new TreeSet<String[]>(new Comparator<String[]>() 
											          {
											        	  @Override
											              public int compare(String[] o1, String[] o2) 
											              {                  
											                  return Arrays.equals(o1, o2)?0:1;
											              }
											          }
        		  								);
        
          s.addAll(l);   
          List<Object> res = Arrays.asList(s.toArray()); // returns object as it acts as bridge between Collection based and List based API.//can use toArray(String[] a) which will return array of string type
          return res;
      }
      
      public static String[][] slice2DArray(String[][] o, int start, int end) 
      {            

        List<String[]> data = new ArrayList<>();
        int c = 0;
        for (int i = 0; i < o.length; i++)
        {
              try 
              {
                    data.add(Arrays.copyOfRange(o[i], start, end));
              }
              catch(Exception e) 
              {
            	  
              }
        }
        
        List<String[]> tmp = new ArrayList<>();
        
        for(String[] sarr : data)
        {
            if(Arrays.asList(sarr).contains(null)) 
            {
                  tmp.add(sarr);
            }
        }
        
        data.removeAll(tmp);
        
        String[][] result = new String[removeDuplicates(data).size()][];
        return removeDuplicates(data).toArray(result);
       
      }     
      
      public static void main(String args[]) 
      {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of inputs");
        int n = Integer.parseInt(sc.nextLine());
        
        String[][] inputs = new String[n][];//array of string array //n rows //cols unknown
        
        for (int i = 0; i < n; i++) 
        {                          
              inputs[i] = sc.nextLine().trim().split("[\\\\]");
            //  inputs[i] = sc.nextLine().trim().split("[.]");
        }
        
        Node root = new Node(inputs[0][0]);
                    
        System.out.println(root.getLabel());
        
        int maxLength = 0;
        
        for(String[] arr: inputs) 
        {
              if(maxLength < arr.length) 
              {
                    maxLength = arr.length;
              }
        }
        
        System.out.println("Maxlength: " + maxLength);
                
        for(int i = 0; i < maxLength - 1; i++) 
        {
          String[][] prev = slice2DArray(inputs, 0, i+1); //parents
                            
          for(String[] s : prev) 
          {
                System.out.println("Parent: " + Arrays.toString(s));                    
                Set<String> childList = new TreeSet<>();
                for(String[] x : inputs) 
                {                            
                      if(Arrays.equals(Arrays.copyOfRange(x, 0, i+1),s)) 
                      {
                            try
                            {
                                  childList.add(x[i+1]);
                            }
                            catch(Exception e) {}
                      }
                }
                System.out.println("Children: " + childList);
                System.out.println("*****************************");
                
                Node current = root;                      
                
                for(int k = 1; k < s.length; k++)
                {
                      current = current.getChildByLabel(s[k]);
                }//GETTING THE LAST NODE TO WHICH THE CHILDREN SHOULD BE TAGGED
                
                for(String childLabel : childList) 
                {
                      if(current.getChildByLabel(childLabel) == null) 
                      {
                            current.addChild(new Node(childLabel));
                      }
                }
           	}
        }
        System.out.println("******************************");
        int i=0,size,j=0;Node c=root;
        do
        {
        	
        	if(j==0)
        	{
        		System.out.println("\t"+root.getLabel());
        		
        		root.displaychild();
        	}
        	size=root.getChildList().size();
        	/*for(i=0;i<size;i++)
        	{
        		root=root.getChildList().get(i);
        		root.displaychild();
        	}*/
        	for(Node child:c.childList)
        	{
        		root=c.getChildList().get(i++);
        		System.out.println();
        		root.displaychild();
        	}
        	j++;
        }while(false);
      }
}
      // System.out.println("MAIN ENDS");
      //root,childlist
      /* line 126
      System.out.println("\t"+current.getLabel());
       int childlength=current.getChildList().size();
       int j=0;
       for(i=0;i<s.length;i++)
       {
          	if(j<childlength)
         	{
           		current.displaychild();
          	}
          	else
           {
          		break;
           	j++;
           }
       }*/

