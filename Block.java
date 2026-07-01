import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Date;

public class Block {
    
    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp;
    private int nonce; // NEW: The variable that changes during mining

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); 
    }

    // UPDATED: Added + nonce to the input string
    public String calculateHash() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            // The nonce must be included in the hash calculation!
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

    // NEW: The Proof-of-Work Mining Loop
    public void mineBlock(int difficulty) {
        // Create a target string of zeros (e.g., difficulty of 4 turns into "0000")
        String target = new String(new char[difficulty]).replace('\0', '0'); 
        
        System.out.println("Mining block with data: [" + data + "]...");
        
        // Loop runs until the first 'X' characters of our hash match the target zeros
        while(!hash.substring(0, difficulty).equals(target)) {
            nonce++;             // Increment the number used once
            hash = calculateHash(); // Try a completely new hash calculation
        }
        
        System.out.println("Block Mined successfully! Hash: " + hash);
    }
}
