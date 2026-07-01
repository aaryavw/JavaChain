public class Main {
    public static void main(String[] args) {
        
        // Set how hard the puzzle is. 4 or 5 is perfect for a laptop. 
        // Warning: Don't set this higher than 6 or your computer might freeze for a long time!
        int difficulty = 4;

        Block genesisBlock = new Block("Genesis Data", "0");
        genesisBlock.mineBlock(difficulty);

        Block secondBlock = new Block("Transaction: Alice sends 5 BTC to Bob", genesisBlock.hash);
        secondBlock.mineBlock(difficulty);

        Block thirdBlock = new Block("Transaction: Bob sends 2 BTC to Charlie", secondBlock.hash);
        thirdBlock.mineBlock(difficulty);
    }
}
