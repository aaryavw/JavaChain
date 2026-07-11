public class Main {
    public static void main(String[] args) {
        
        int difficulty = 4;

        Block genesisBlock = new Block("Genesis Data", "0");
        genesisBlock.mineBlock(difficulty);

        Block secondBlock = new Block("Transaction: Alice sends 5 BTC to Bob", genesisBlock.hash);
        secondBlock.mineBlock(difficulty);

        Block thirdBlock = new Block("Transaction: Bob sends 2 BTC to Charlie", secondBlock.hash);
        thirdBlock.mineBlock(difficulty);
    }
}
