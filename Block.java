import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Date;

public class Block {
    
    // 1. The structural data fields of a block
    public String hash;             // The digital signature of THIS block
    public String previousHash;     // The digital signature of the PREVIOUS block
    private String data;            // The message or transaction details stored inside
    private long timeStamp;         // The exact time the block was created

    // 2. The Constructor used to initialize a new block
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); // Calculate the hash automatically upon creation
    }

    // 3. The Cryptographic Hashing Function (SHA-256)
    public String calculateHash() {
        try {
            // Initialize the SHA-256 cryptographic tool
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            // Combine all the unique elements of the block into a single text string
            String input = previousHash + Long.toString(timeStamp) + data;
            
            // Perform the cryptographic math to generate a byte array
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            
            // Convert the byte array into a readable hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
