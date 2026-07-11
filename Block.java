import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Date;

public class Block {
    
    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp;
    private int nonce;

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); 
    }

    public String calculateHash() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            String input = previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data;
            
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
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

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); 
        
        System.out.println("Mining block with data: [" + data + "]...");
        
        while(!hash.substring(0, difficulty).equals(target)) {
            nonce++;             // Increment the number used once
            hash = calculateHash(); // Try a completely new hash calculation
        }
        
        System.out.println("Block Mined successfully! Hash: " + hash);
    }
}
