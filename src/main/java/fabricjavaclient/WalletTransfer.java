package fabricjavaclient;

import org.hyperledger.fabric.gateway.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class WalletTransfer {

    static {
        System.setProperty("org.hyperledger.fabric.sdk.service_discovery.as_localhost", "true");
    }

    public String walletTransferSubmit(String UID,
                                       String amount,
                                       String destinationAgentId,
                                       String sourceAgentId,
                                       String sourceType) throws Exception {

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

            contract.submitTransaction("walletTransferTrxn", UID, amount,destinationAgentId,sourceAgentId,sourceType);

            System.out.println("Wallet Transfer Transaction Successfully committed to ledger");

            return "Wallet Transfer Transaction Successfully committed to ledger";

        }

    }

    public String  queryTrxnBySourceAgentId(String UID) throws Exception {

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

            result = contract.evaluateTransaction("queryWalletCreditTrxn", UID);

            System.out.println(result);

            String s = new String(result);
            return s;

        }
    }
}

