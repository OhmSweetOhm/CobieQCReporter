package org.bimserver.shared.interfaces;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import org.bimserver.interfaces.objects.SServerSettings;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import java.util.List;

@WebService(name = "SettingsInterface", targetNamespace="org.bimserver")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface SettingsInterface extends PublicInterface {
	/**
	 * @return The current address used for sending e-mails
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getEmailSenderAddress")
	String getEmailSenderAddress() throws Exception;

	/**
	 * @param emailSenderAddress The new e-mail address e-mail will be sent from
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setEmailSenderAddress")
	void setEmailSenderAddress(
       @WebParam(name = "emailSenderAddress", partName = "setEmailSenderAddress.emailSenderAddress")
           String emailSenderAddress) throws Exception;

	/**
	 * @return The port on which the ProtocolBuffers server runs
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getProtocolBuffersPort")
	Integer getProtocolBuffersPort() throws Exception;

	/**
	 * @param port Set the port the ProtocolBuffers server runs on
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setProtocolBuffersPort")
	void setProtocolBuffersPort(@WebParam(name = "port", partName = "setProtocolBuffersPort.port") Integer port) throws
																																					 Exception;
	
	/**
	 * @return The address the BIMserver is running on (used for links in e-mail for example)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSiteAddress")
	String getSiteAddress() throws Exception;

	/**
	 * @param siteAddress The new address the BIMserver is running on (used for links in e-mail for example)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSiteAddress")
	void setSiteAddress(@WebParam(name = "siteAddress", partName = "setSiteAddress.siteAddress") String siteAddress) throws
																																						  Exception;

	/**
	 * @return Address of the SMTP server used for sending e-mails
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSmtpServer")
	String getSmtpServer() throws Exception;

	/**
	 * @param smtpServer New address of the SMTP server used for sending e-mails
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSmtpServer")
	void setSmtpServer(@WebParam(name = "smtpServer", partName = "setSmtpServer.smtpServer") String smtpServer) throws
																																					Exception;

	/**
	 * @return Whether self-registration is enabled
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isAllowSelfRegistration")
	Boolean isAllowSelfRegistration() throws Exception;

	/**
	 * @param allowSelfRegistration Change whether self-registration is enabled
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setAllowSelfRegistration")
	void setAllowSelfRegistration(
       @WebParam(name = "allowSelfRegistration", partName = "setAllowSelfRegistration.allowSelfRegistration")
           Boolean allowSelfRegistration) throws Exception;

	/**
	 * @return Whether to hide user lists (pricacy)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isHideUserListForNonAdmin")
	Boolean isHideUserListForNonAdmin() throws Exception;

	/**
	 * @param hideUserListForNonAdmin Set whether user lists should be hidden (privacy)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setHideUserListForNonAdmin")
	void setHideUserListForNonAdmin(
       @WebParam(name = "hideUserListForNonAdmin", partName = "setHideUserListForNonAdmin.hideUserListForNonAdmin")
           Boolean hideUserListForNonAdmin) throws Exception;

	/**
	 * @return Whether a user can create top level projects
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isAllowUsersToCreateTopLevelProjects")
	Boolean isAllowUsersToCreateTopLevelProjects() throws Exception;

	/**
	 * @param allowUsersToCreateTopLevelProjects Set if users can create top level projects
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setAllowUsersToCreateTopLevelProjects")
	void setAllowUsersToCreateTopLevelProjects(@WebParam(name = "allowUsersToCreateTopLevelProjects",
                                                        partName = "setAllowUsersToCreateTopLevelProjects.allowUsersToCreateTopLevelProjects")
                                                  Boolean allowUsersToCreateTopLevelProjects) throws Exception;

	/**
	 * @return Whether the BIMserver should do checkin merging (warning: this will alter your models)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isCheckinMergingEnabled")
	Boolean isCheckinMergingEnabled() throws Exception;

	/**
	 * @param checkinMergingEnabled Set whether the BIMserver should do checkin merging (warning: this wil alter your models)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setCheckinMergingEnabled")
	void setCheckinMergingEnabled(
       @WebParam(name = "checkinMergingEnabled", partName = "setCheckinMergingEnabled.checkinMergingEnabled")
           Boolean checkinMergingEnabled) throws Exception;

	/**
	 * @return Whether a confirmation e-mail should be send after registration
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isSendConfirmationEmailAfterRegistration")
	Boolean isSendConfirmationEmailAfterRegistration() throws Exception;

	/**
	 * @param sendConfirmationEmailAfterRegistration Set whether a confirmation e-mail should be send after registration
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSendConfirmationEmailAfterRegistration")
	void setSendConfirmationEmailAfterRegistration(@WebParam(name = "sendConfirmationEmailAfterRegistration",
                                                            partName = "setSendConfirmationEmailAfterRegistration.sendConfirmationEmailAfterRegistration")
                                                      Boolean sendConfirmationEmailAfterRegistration) throws Exception;

	/**
	 * @return Whether output files (serialized version) should be cached on disk
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isCacheOutputFiles")
	Boolean isCacheOutputFiles() throws Exception;

	/**
	 * @return Whether output files (serialized version) should be cached on disk
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isGenerateGeometryOnCheckin")
	Boolean isGenerateGeometryOnCheckin() throws Exception;
	
	/**
	 * @param cacheOutputFiles Set whether output files (serialized version) should be cached on disk
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setCacheOutputFiles")
	void setCacheOutputFiles(
       @WebParam(name = "cacheOutputFiles", partName = "setCacheOutputFiles.cacheOutputFiles") Boolean cacheOutputFiles) throws
																																								 Exception;

	/**
	 * @param cacheOutputFiles Set whether output files (serialized version) should be cached on disk
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setGenerateGeometryOnCheckin")
	void setGenerateGeometryOnCheckin(@WebParam(name = "generateGeometryOnCheckin",
                                               partName = "setGenerateGeometryOnCheckin.generateGeometryOnCheckin")
                                         Boolean generateGeometryOnCheckin) throws Exception;

	/**
	 * @return The current service repository server address
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getServiceRepositoryUrl")
	String getServiceRepositoryUrl() throws Exception;

	/**
	 * @param url A new URL pointing to a server acting as a services repository
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="setServiceRepositoryUrl")
	void setServiceRepositoryUrl(@WebParam(name = "url", partName = "setServiceRepositoryUrl.url") String url) throws
																																				  Exception;
	
	/**
	 * @return The current server settings
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getServerSettings")
	SServerSettings getServerSettings() throws Exception;

	/**
	 * With this method you can set all server settings at once
	 * @param serverSettings
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "setServerSettings")
	void setServerSettings(
       @WebParam(name = "serverSettings", partName = "setServerSettings.serverSettings") SServerSettings serverSettings) throws
																																								 Exception;
	
	/**
	 * Sets the domains that are whitelisted to connect to the different API endpoints. This is only a CORS (http://en.wikipedia.org/wiki/Cross-origin_resource_sharing) protection
	 * @param domains
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "setWhiteListedDomains")
	void setWhiteListedDomains(
       @WebParam(name = "domains", partName = "setWhiteListedDomains.domains") List<String> domains) throws Exception;
}