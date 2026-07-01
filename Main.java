public class Main {
    public static void main(String[] args) {
        
        // The first block in a blockchain is called the Genesis Block.
        // It has no previous block, so we pass "0" as its previous hash.
        Block genesisBlock = new Block("First block data", "0");
        System.out.println("Genesis Block Hash: " + genesisBlock.hash);

        // The second block takes the hash of the Genesis block
        Block secondBlock = new Block("Second block data", genesisBlock.hash);
        System.out.println("Second Block Hash:  " + secondBlock.hash);

        // The third block takes the hash of the second block
        Block thirdBlock = new Block("Third block data", secondBlock.hash);
        System.out.println("Third Block Hash:   " + thirdBlock.hash);
    }
}
