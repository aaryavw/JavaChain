# JavaChain: A Custom Blockchain From Scratch

A lightweight, pure Java implementation of a blockchain built to demonstrate the foundational data structures and security mechanics of decentralized networks. 

## Features Completed
* **Cryptographic Ledger:** Created a custom `Block` class utilizing `SHA-256` hashing via `java.security.MessageDigest`.
* **Immutability Validation:** Implemented an automated validation check that traces hashes to ensure the ledger breaks if data is tampered with.
* **Proof-of-Work (PoW) Mining:** Added a adjustable difficulty target mechanism with a dynamic `nonce` loop to simulate network mining consensus.

## Technologies Used
* **Language:** Java 8+
* **Libraries:** Pure Standard Java Library (No external dependencies)
