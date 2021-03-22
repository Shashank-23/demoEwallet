package fabricjavaclient;

import org.hyperledger.fabric.gateway.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class WalletCredit {

    static {
        System.setProperty("org.hyperledger.fabric.sdk.service_discovery.as_localhost", "true");
    }

    public String walletCreditSubmit(String UID,
                                     String agentId,
                                     String amount,
                                     String sourceType,
                                     String transactionId,
                                     String walletId) throws Exception {

        // Load a file system based wallet for managing identities.
        Path walletPath = Paths.get("wallet");
        Wallet wallet = Wallets.newFileSystemWallet(walletPath);
        // load a CCP
        Path networkConfigPath = Paths.
        get("/Users/shashankawasthi/Documents/Project/test-network/organizations/peerOrganizations/org1.example.com/connection-org1.yaml");
        Gateway.Builder builder = Gateway.createBuilder();
        builder.identity(wallet, "appUser").networkConfig(networkConfigPath).discovery(true);

        // create a gateway connection
        try (Gateway gateway = builder.connect()) {

            // get the network and contract

            Network network = gateway.getNetwork("mychannel");
            Contract contract = network.getContract("basic");

            contract.submitTransaction("walletCreditTrxn", UID,agentId,amount,sourceType,transactionId,walletId);

            System.out.println("Wallet Credit Transaction Successfullt committed to ledger");

            return "Wallet Credit Transaction Successfully committed to ledger";

        }

    }

    public String  queryTrxnByTrxnId(String transactionId) throws Exception {

        // Load a file system based wallet for managing identities.
        Path walletPath = Paths.get("wallet");
        Wallet wallet = Wallets.newFileSystemWallet(walletPath);
        // load a CCP
        Path networkConfigPath = Paths.
                get("/Users/shashankawasthi/Documents/Project/test-network/organizations/peerOrganizations/org1.example.com/connection-org1.yaml");
        Gateway.Builder builder = Gateway.createBuilder();
        builder.identity(wallet, "appUser").networkConfig(networkConfigPath).discovery(true);

        // create a gateway connection
        try (Gateway gateway = builder.connect()) {

            // get the network and contract

            Network network = gateway.getNetwork("mychannel");
            Contract contract = network.getContract("basic");

            byte result[];

            result = contract.evaluateTransaction("queryWalletCreditTrxn", transactionId);

            System.out.println(result);

            String s = new String(result);
            return s;

        }
    }
}
