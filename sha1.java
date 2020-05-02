import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.Security;
import org.apache.commons.codec.digest.DigestUtils;
import java.io.*;



public class sha
{
  public static void main(String[] args) throws Exception 
  {
	 FileInputStream fstream = new FileInputStream("/home/it-oslpc-34/Desktop/textfile.txt");
     String Message= "";
     String inMessage="";
	 DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new      InputStreamReader(in));
  String strLine;
  strLine = br.readLine();
            
    byte[] input = strLine.getBytes();
    System.out.println("input     : " + new String(input));    
    MessageDigest hash = MessageDigest.getInstance("SHA1");

ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input);
    DigestInputStream digestInputStream = new DigestInputStream(byteArrayInputStream, hash);
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    int ch;
    
while ((ch = digestInputStream.read()) >= 0) {
      byteArrayOutputStream.write(ch);
    }

    byte[] newInput = byteArrayOutputStream.toByteArray();
    System.out.println("in digest : " + new String(digestInputStream.getMessageDigest().digest()));
    inMessage=DigestUtils.sha256Hex(digestInputStream.getMessageDigest().digest());
    System.out.println("hex input: "+ inMessage);
    byteArrayOutputStream = new ByteArrayOutputStream();
    DigestOutputStream digestOutputStream = new DigestOutputStream(byteArrayOutputStream, hash);
    digestOutputStream.write(newInput);
    digestOutputStream.close();
    
    System.out.println("out digest: " + new String(digestOutputStream.getMessageDigest().digest()));
    Message=DigestUtils.sha256Hex(digestOutputStream.getMessageDigest().digest());
    System.out.println("hex output: "+ Message);
  }
}


/*output:

input     : welcome hi
in digest : �c�4��2c휿LE_��	
hex input: 533b8c444f951e83eff7305e3807b66ce0005de0a2d0a44873c130895a3be6aa
out digest: �c�4��2c휿LE_��	
hex output: 533b8c444f951e83eff7305e3807b66ce0005de0a2d0a44873c130895a3be6aa */


