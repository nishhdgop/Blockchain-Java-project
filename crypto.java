package gui;
import java.util.Random;
public class crypto {

	   public static final String zeros = " Rs/-";
	 
	   private String name;
	   private String id;
	   
	   String p="";
	   public crypto ()
	   {
	      name = "";
	      id   = "";
	   }
	   Random random = new Random();
	   public crypto (String name, String id)  throws cryptoExecption
	   {
	      // Remove elading and trailing spaces, tabs.
	      name = name.trim ();
	      id   = id.trim ();

	      if (name.length () == 0)
	      {
	         //JOptionPane.showMessageDialog (null, "Error: name cannot be blank.");
	         throw new cryptoExecption ("Error: Token name cannot be blank.");
	      }

	      else if (id.length () == 0)
	      {
	         //JOptionPane.showMessageDialog (null, "Error: Id cannot be blank.");
	         throw new cryptoExecption ("Error: Id cannot be blank.");
	      }

	      else
	      {
	         // All is OK, set class data to the values passed in.
	    	  
	         this.name = name;
	         
	         
	  	     int k =  (random.nextInt(325590)+1);
	  	     p =Integer.toString(k);
	        // this.id = p;
	         this.id=id;
	         
	      }
	   }

	   public String getName ()
	   {
	      return name;
	   }

	   public String getId ()
	   {
	      return id;
	   }

	   public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public void setName (String name)
	   {
	      this.name = name;
	   }

	   public void setId (String id)
	   {
		   int n=Integer.parseInt(id);
		   int k = (random.nextInt(325590)+1);
		   p =Integer.toString(k);
	      this.id = id;
	   }

	 //  int i=0;
	   @Override
	   public String toString ()
	   {
		  // Integer.parseInt(id)*0)+(i)
		  // i=i+1;
	      return  id+"\t" + name + "\t" + p +zeros;
	    
	   }

	} 

