package Splitting;

import java.util.*;

public class Node {
      
      String label;
      List<Node> childList;
      
      public String getLabel() {
            return label;
      }



      public void setLabel(String label) {
            this.label = label;
      }



      public List<Node> getChildList() {
            return childList;
      }



      public void setChildList(List<Node> childList) {
            this.childList = childList;
      }



      public void addChild(Node child) {
            childList.add(child);
      }
      
      public Node(String label) 
      {
          this.label = label;
          this.childList = new ArrayList<>();
      }
    
    public Node getChildByLabel(String l)
    {
          
          for(Node child : childList) 
          {
                if(child.getLabel().equals(l)) 
                {
                      return child;
                }
          }
          
          return null; 
    }
    public void displaychild()
    {
  	  for(Node child:childList)
  	  {
  		  System.out.print(child.label+" ");
  	  }
  	  //System.out.println();
    }
}


