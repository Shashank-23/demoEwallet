package fabricjavaclient;

import org.hyperledger.fabric.gateway.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class clientapp {
	static {
		System.setProperty("org.hyperledger.fabric.sdk.service_discovery.as_localhost", "true");
	}
	
	public static void main(String[] args) throws Exception {
		// Load a file system based wallet for managing identities.
		Path walletPath = Paths.get("wallet");
		Wallet wallet = Wallets.newFileSystemWallet(walletPath);
		// load a CCP
		Path networkConfigPath = Paths.
//				get("..", "..", "test-network", "organizations", "peerOrganizations", "org1.example.com", "connection-org1.yaml");
//				get("/Users/shashankawasthi/Documents/Project/test-network/organizations/peerOrganizations/org1.example.com/connection-org1.json");
				get("/Users/shashankawasthi/Documents/Project/test-network/organizations/peerOrganizations/org1.example.com/connection-org1.yaml");
		Gateway.Builder builder = Gateway.createBuilder();
		builder.identity(wallet, "appuser").networkConfig(networkConfigPath).discovery(true);

		// create a gateway connection
		try (Gateway gateway = builder.connect()) {

			// get the network and contract

			Network network = gateway.getNetwork("mychannel");
			Contract contract = network.getContract("basic");

			byte[] result;

			contract.submitTransaction("newTrxn", "13", "bank", "100", "100");

			result = contract.evaluateTransaction("queryById", "13");
			System.out.println(new String(result));

		}

	}

}
