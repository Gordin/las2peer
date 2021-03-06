package i5.las2peer.tools;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Base64;


/**
 * <i>Static</i> class as collection of serialization and deserialization methods.
 * 
 * @author Holger Jan&szlig;en
 *
 */
public class SerializeTools {
	
	
	/**
	 * serialize a single object into a byte array
	 * @param s
	 * @return	serialized content as binary (byte array)
	 * @throws SerializationException
	 */
	public static byte[] serialize ( Serializable s ) throws SerializationException {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream ( baos );
			oos.writeObject ( s );
			oos.close();
			
			return baos.toByteArray();
		} catch ( IOException e ){
			throw new SerializationException("IO Exception!", e );
		}		
	}
	
	/**
	 * serialize the given Serializable object and encode the resulting byte array into Base64
	 * 
	 * @param s
	 * @return	base64 encoded String
	 * @throws SerializationException
	 */
	public static String serializeToBase64 ( Serializable s ) throws SerializationException {
		return Base64.encodeBase64String( serialize( s ));
	}
		
	/**
	 * deserialize a single Object from a byte array 
	 * 
	 * @param bytes
	 * @return deseriaized object
	 * @throws SerializationException
	 */
	public static Serializable deserialize ( byte[] bytes ) throws SerializationException {
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois;
			ois = new ObjectInputStream(bais);

			return (Serializable) ois.readObject();
		} catch (IOException e) {
			throw new SerializationException ("IO problems", e);
		} catch ( ClassNotFoundException  e ){
			// should not occur since the SecretKey class should be known here
			throw new SerializationException ( "Class not found ?!?!", e);
		}
	}
	
	/**
	 * decodes a given base64 encoded string and deserializes it into a java object 
	 * 
	 * @param base64
	 * @return deserialized object
	 * @throws SerializationException 
	 */
	public static Serializable deserializeBase64 ( String base64 ) throws SerializationException {
		return deserialize ( Base64.decodeBase64(base64));
	}
	
	/**
	 * try to deserialize a single Key from the given byte array
	 *  
	 * @param bytes
	 * @return	deserialized key 
	 * @throws SerializationException
	 */
	public static SecretKey deserializeKey ( byte[] bytes ) throws SerializationException  {
		try {
			return (SecretKey) deserialize ( bytes );
		} catch ( ClassCastException e ) {
			throw new SerializationException("Not a Key!", e );
		}
	}
}
