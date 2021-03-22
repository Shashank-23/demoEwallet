package fabricjavaclient;

import org.hyperledger.fabric.gateway.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class BillPayment {

    static {
        System.setProperty("org.hyperledger.fabric.sdk.service_discovery.as_localhost", "true");
    }

    public String billPaymentSubmit(final String UID,
                                    final String agentId,
                                    final String amount,
                                    final String billId,
                                    final String consumerAccountId,
                                    final String consumerName,
                                    final String discom,
                                    final String division,
                                    final String divisionCode,
                                    final String mobile,
                                    final String referenceTransactionId,
                                    final String sourceType,
                                    final String type,
                                    final String vanNo,
                                    final String walletId) throws Exception {

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

            contract.submitTransaction("billPaymentTrxn", UID, agentId,  amount, billId, consumerAccountId, consumerName, discom,division,
                    divisionCode,mobile,referenceTransactionId,sourceType,type,vanNo,walletId);

            System.out.println("Bill Payment Transaction Successfully committed to ledger");

            return "Bill Payment Transaction Successfully committed to ledger";

        }

    }

    public String  queryTrxnByBillId(String billId) throws Exception {

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

            result = contract.evaluateTransaction("queryWalletCreditTrxn", billId);

            System.out.println(result);

            String s = new String(result);
            return s;

        }
    }
}

