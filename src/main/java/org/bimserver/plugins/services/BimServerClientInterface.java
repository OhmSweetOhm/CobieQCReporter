package org.bimserver.plugins.services;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.ServiceHolder;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1RemoteServiceInterface;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;

public interface BimServerClientInterface extends ServiceHolder {

	IfcModelInterface getModel(SProject project,
                              long roid,
                              boolean deep,
                              boolean recordChanges,
                              boolean includeGeometry) throws Exception;
	IfcModelInterface getModel(SProject project, long roid, boolean deep, boolean recordChanges) throws Exception;

	IfcModelInterface newModel(SProject newProject, boolean recordChanges) throws Exception;

	void commit(IfcModelInterface model, String comment);
	
	void download(long roid, long serializerOid, OutputStream outputStream) throws Exception;
	void download(long roid, long serializerOid, Path file) throws IOException;
	
	long checkin(long poid, String string, long deserializerOid, boolean merge, boolean sync, Path file) throws
                                                                                                        Exception;
	
	/**
	 * Convenience method that given you the InputStream belonging to an already started download
	 * 
	 * @param download
	 * @param serializerOid
	 * @return
	 * @throws IOException
	 */
	InputStream getDownloadData(long download, long serializerOid) throws IOException;
	
	void setAuthentication(AuthenticationInfo authenticationInfo) throws Exception;
	
	/**
	 * Get the geometry for the given revision/product, this method is not tested
	 * 
	 * @param roid
	 * @param ifcProduct
	 * @return
	 */
	Geometry getGeometry(long roid, IfcProduct ifcProduct) throws Exception;

	AuthInterface getBimServerAuthInterface() throws PublicInterfaceNotFoundException;
	Bimsie1RemoteServiceInterface getRemoteServiceInterface() throws PublicInterfaceNotFoundException;

	/**
	 * This will close all the connections, call this method as soon as you are done using this BimServerClient
	 */
	void disconnect();
}