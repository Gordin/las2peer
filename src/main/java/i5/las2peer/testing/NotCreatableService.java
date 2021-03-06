package i5.las2peer.testing;

import i5.las2peer.api.Service;
import i5.las2peer.execution.L2pServiceException;


/**
 * A simple <i>Service</i> for testing failures in the constructor of a service.
 * 
 * @author Holger Jan&szlig;en
 *
 */
public class NotCreatableService extends Service {

	/**
	 * simple constructor just throwing an Exception
	 * 
	 * @throws L2pServiceException
	 */
	public NotCreatableService () throws L2pServiceException {
		throw new L2pServiceException ( "Constructor is throwing an exception!");
	}
	
	
}
