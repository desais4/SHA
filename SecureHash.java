/**
Implementation of SHA-1 algorithm using Libraries(API).
*/
package hash;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.DigestUtils;
public class SecureHash {
	public static final String  ALGO = "SHA-1";
	public static void main(String[] args) {
		String originalMessage = "Sunday";
		String hashMessage = "";
		try{
			// select Hashing Algorithm 
			//MessageDigest myHash = MessageDigest.getInstance(ALGO);
			// reset digest for further use
			myHash.reset();
			// convert Message 
			myHash.update(originalMessage.getBytes());
			// store in String 
			hashMessage = DigestUtils.sha1Hex(originalMessage.getBytes());
			System.out.printf("Original Message:\t%s "
							+ "\nMessage Hash:\t\t%s\n"
								,originalMessage,hashMessage);
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
	}
}
/** OUTPUT
 *
 * Original Message:	Sunday 
 * Message Hash:		bc5dd045b8623ddfc4bd0bce98ca5fda42accf88
 */
