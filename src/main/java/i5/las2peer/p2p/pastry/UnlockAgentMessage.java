package i5.las2peer.p2p.pastry;

import java.util.Random;

import rice.p2p.commonapi.Message;
import rice.p2p.commonapi.NodeHandle;


/**
 * A request message where the target node should try to unlock the given agent with the given passphrase.
 * 
 * This passphrase is encrypted for the destination node.
 * 
 * @author Holger Jan&szlig;en
 *
 */
public class UnlockAgentMessage implements Message {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2335873629440223166L;

	private long messageId;
	
	private NodeHandle sender;
	private long agentId;
	private byte[] encryptedPass;
	
	
	/**
	 * create a new message
	 * 
	 * @param localHandle
	 * @param agentId
	 * @param encPass
	 */
	public UnlockAgentMessage(NodeHandle localHandle, long agentId, byte[] encPass) {
		this.sender = localHandle;
		this.agentId = agentId;
		this.encryptedPass = encPass;
		
		this.messageId = new Random().nextLong();
	}

	/**
	 * 
	 * @return handle of the sending node (for a success / failure answer)
	 */
	public NodeHandle getSendingNode() {
		return sender;
	}
	
	
	/**
	 * 
	 * @return encrypted passphrase
	 */
	public byte[] getEncryptedPass () { return encryptedPass; }
	
	
	/**
	 * 
	 * @return id of the agent to unlock
	 */
	public long getAgentId () { return agentId; }
	
	
	/**
	 * 
	 * @return the id of this message
	 */
	public long getMessageId () { return messageId; }
	
	
	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

}
