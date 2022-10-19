
package gui;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.LineBorder;
public class WelcomePage extends JFrame
{
   public static int sum=0,sum1=0,c=0;
   JTextArea  cryptoTextArea   = new JTextArea ();
   JLabel     idLabel           = new JLabel     ("Id ");
   JTextField idTextField       = new JTextField (10);
   JLabel     nameLabel         = new JLabel     ("Name: ");
   JTextField nameTextField     = new JTextField (10);
   JButton    addButton         = new JButton ("Get");
   JButton    deleteButton      = new JButton ("Sell");
   JButton     NftButton        = new JButton ("NFT");
   JButton    TotalButton    = new JButton ("Account");
   JButton    displayAllButton  = new JButton ("Crypto Dashboard");
   JButton    CryptoButton        = new JButton ("Cryptos");
   JButton   Logout        = new JButton ("Logout");
   Random rn = new Random();
   int no =(int) rn.nextInt(100);
   String fname = "/Users/javaminiprojectnft/name"+no+".txt";
   File f=new File(fname);
    LinkedList<crypto> cryptoLinkedList = new LinkedList<crypto>();
   
   public WelcomePage ()
   {
      JPanel flow1Panel = new JPanel (new FlowLayout (FlowLayout.CENTER));
      JPanel flow2Panel = new JPanel (new FlowLayout (FlowLayout.CENTER));
      JPanel flow3Panel = new JPanel (new FlowLayout (FlowLayout.CENTER));
      JPanel gridPanel  = new JPanel (new GridLayout (3, 1));
     
      
      cryptoTextArea.setText(menue());
    
      cryptoTextArea.setEditable (false);

      
      
      flow1Panel.add (idLabel);
      flow1Panel.add (idTextField);
      flow1Panel.add (nameLabel);
      flow1Panel.add (nameTextField);
      flow2Panel.add (addButton);
      flow2Panel.add (NftButton);
      flow3Panel.add (TotalButton);
      flow2Panel.add (deleteButton);
      flow3Panel.add (displayAllButton);
      flow2Panel.add (CryptoButton);
      flow3Panel.add (Logout);
      gridPanel.add (flow1Panel);
      gridPanel.add (flow2Panel);
      gridPanel.add (flow3Panel);
    
      add (cryptoTextArea, BorderLayout.CENTER);
      add (gridPanel,       BorderLayout.SOUTH);

      
      addButton.addActionListener(event -> addCrypto ());
     
      displayAllButton.addActionListener(event -> displayAll1 ());
    NftButton.addActionListener(event -> nftAccount());
      TotalButton.addActionListener(event -> Total());
     CryptoButton.addActionListener(event ->cryptoMenue());
    Logout.addActionListener(event -> Logout());
      deleteButton.addActionListener(event -> deleteCrypto ());
      setSize(620,650);
      setVisible(true);
      setTitle ("Crypto Trading Interface");
     setBackground(Color.RED);
     setLocationRelativeTo(null);
     
     
      }




public void nftAccount() {
	// TODO Auto-generated method stub
	int q=0;
	
	 for (crypto crypto1: cryptoLinkedList)
     {
		 if(Integer.parseInt(crypto1.getId())> 10) {
   	  q=Integer.parseInt(crypto1.getP());
   
   	  sum=q-sum;
   	cryptoTextArea.setText("\n\n  This license has made the purchase of "+crypto1.getName()+" valid and the ownership \n for the purchase authority has been digitally minted by the minter \n by paying "+crypto1.getP()+" price valued token \n by NFT trade \n\n");
	cryptoTextArea.append("\t\n\nThe document has been saved in your device");
   	try {
        if (!f.exists()) {
            f.createNewFile();
        }
        Writer output = new FileWriter(fname, true);
        output.append("\n\n  This license has made the purchase of "+crypto1.getName()+" valid and the ownership \n for the purchase authority has been digitally minted by the minter \n by paying "+crypto1.getP()+" price valued token \n by NFT trade \n\n");
        output.append("\n************************************************************************************************\n");
        output.close();

    } catch (IOException p) {
        p.printStackTrace();
    }

		 }else if(Integer.parseInt(crypto1.getId())<= 10){
   	
   		cryptoTextArea.setText("\t\t\n\n NFT is valid for only NFT purchases \n This purchase has not been validated as crypto purchase was made");
   	  }else {
   		cryptoTextArea.setText("\t\t\n\n This purchase has not been validated as due to insufficient tokens");
   	  }
   	  
     
	 
	//  LinkedList<Integer> nftLinkedList = new LinkedList<Integer>();
	      }
	  
}
  public void cryptoMenue() {
		// TODO Auto-generated method stub
		 
	  cryptoTextArea.setText(menue());
		//  LinkedList<Integer> nftLinkedList = new LinkedList<Integer>();
		  
	}
public static String menue() {
	return "\t\tCryptoTrading\n1.Bitcoin\n\n2.Shibha-Inu\n\n3.Etherium\n\n4.Doge-Coin\n\n5.Cosmos\n\n6.Solona\n\n7.Tether\n\n 8.Cardano\n\n9.Avalanche\n\n10.Cardano\n\n\t\tNFT Trading\n\n\n11.Electronics\n12.Commodities\n13.Art\n14.PhotoGraphy\n15.Music";
}

public boolean isCryptoIdInLinkedList (String idStr)
   {
      boolean inList = false;

      for (crypto crypto1: cryptoLinkedList)
      {
         if (crypto1.getId ().compareToIgnoreCase (idStr) == 0)
         {
            inList = true;
         }
      }

      return inList;
   }

   public void addCrypto ()
   {
      if (isCryptoIdInLinkedList (idTextField.getText()) == true)
      {
         JOptionPane.showMessageDialog (WelcomePage.this,
                              "Error: Crypto ID is already in the database.");
      }
      else
      {
         try
         {
            crypto crypto1 = new crypto(nameTextField.getText(),
                                                  idTextField.getText());

            cryptoLinkedList.add (crypto1);

            displayAll ();

            nameTextField.setText("");
            idTextField.setText("");


         }
         catch (cryptoExecption error)
         {
            JOptionPane.showMessageDialog (WelcomePage.this, error.toString ());
            // myLabel.setText (error.toString ());


         }

      }
   }


   public void Logout() 
   {
	   
	    dispose();
	    
	   IDandPasswords idandPasswords = new IDandPasswords();
		
		LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());

   }
   public void deleteCrypto ()
   {
      if ( cryptoLinkedList.size() == 0)
      {
         JOptionPane.showMessageDialog (WelcomePage.this,
                                        "Error: Buy crypto there are no crypto Tokens.");
      }
      else if (isCryptoIdInLinkedList (idTextField.getText()) == false)
      {
         JOptionPane.showMessageDialog (WelcomePage.this,
                                       "Error: Crypto Id  is not identified.");
      }
      else
      {
         for (int s = 0; s <  cryptoLinkedList.size(); s++)
         {
            String currId =  cryptoLinkedList.get (s).getId ();

            if (currId.compareToIgnoreCase(idTextField.getText()) == 0)
            {
            	 cryptoLinkedList.remove (s);
            }
         }

         displayAll ();

         nameTextField.setText("");
         idTextField.setText("");
      }
   }
   public void displayAll ()
   {	
	  
	   
	   cryptoTextArea.setText ("");

      for (crypto crypto1: cryptoLinkedList)
      {
    	 
    	  cryptoTextArea.append (crypto1 + "\n");
    	  
      }
      
     
   }
   public void displayAll1 ()
   {	
	  
	  int n1=0;
	   cryptoTextArea.setText ("");
	   

      for (crypto crypto1: cryptoLinkedList)
      {
    	 if(Integer.parseInt(crypto1.getId())<=10) {
    	
    	  cryptoTextArea .append (crypto1 + "\n");
    	  n1=Integer.parseInt(crypto1.getP());
    	  sum1=sum1+n1;
    	 c++;
    	 }
    	  
      }
      
      cryptoTextArea.append("The total cryptos are "+c+"  and the value is "+((sum))+" Rs/- ");
   }
   public void Total() {
	   int n=0;sum=0;c=0;
	   displayAll();
	   for (crypto crypto1: cryptoLinkedList)
	      {
	    	  n=Integer.parseInt(crypto1.getP());
	    	  sum=sum+n;
	    	// c++;
	      }

	      cryptoTextArea.append("The total net worth is "+((sum))+" Rs/- ");
   }
   
   
   
}


   



