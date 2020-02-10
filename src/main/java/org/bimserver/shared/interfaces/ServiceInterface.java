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

import org.bimserver.interfaces.objects.*;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.bind.annotation.XmlMimeType;
import java.util.List;
import java.util.Set;

@WebService(name = "ServiceInterface", targetNamespace="org.bimserver")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface ServiceInterface extends PublicInterface {
	/**
	 * Checkin a new model by sending a serialized form
	 * 
	 * @param poid The Project's ObjectID
	 * @param comment A comment
	 * @param deserializerOid ObjectId of the deserializer to use, use getAllDeserializers to get a list of available deserializers
	 * @param fileSize The size of the file in bytes
	 * @param file The actual file
	 * @param merge Whether to use checkin merging (this will alter your model!)
	 * @param sync Whether the call should return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getCheckinState method
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "checkin")
	Long checkin(@WebParam(name = "poid", partName = "checkin.poid") Long poid,
                @WebParam(name = "comment", partName = "checkin.comment") String comment,
                @WebParam(name = "deserializerOid", partName = "checkin.deserializerOid") Long deserializerOid,
                @WebParam(name = "fileSize", partName = "checkin.fileSize") Long fileSize,
                @WebParam(name = "fileName", partName = "checkin.fileName") String fileName,
                @WebParam(name = "data", partName = "checkin.data") @XmlMimeType("application/octet-stream")
                    DataHandler data,
                @WebParam(name = "merge", partName = "checkin.merge") Boolean merge,
                @WebParam(name = "sync", partName = "checkin.sync") Boolean sync) throws Exception;

	/**
	 * Checkin a new model by sending a serialized form
	 * 
	 * @param poid The Project's ObjectID
	 * @param comment A comment
	 * @param deserializerOid ObjectId of the deserializer to use, use getAllDeserializers to get a list of available deserializers
	 * @param url A URL to the file
	 * @param merge Whether to use checkin merging (this will alter your model!)
	 * @param sync Whether the call should return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getCheckinState method
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "checkinFromUrl")
	Long checkinFromUrl(@WebParam(name = "poid", partName = "checkinFromUrl.poid") Long poid,
                       @WebParam(name = "comment", partName = "checkinFromUrl.comment") String comment,
                       @WebParam(name = "deserializerOid", partName = "checkinFromUrl.deserializerOid")
                           Long deserializerOid,
                       @WebParam(name = "fileName", partName = "checkinFromUrl.fileName") String fileName,
                       @WebParam(name = "url", partName = "checkinFromUrl.url") String url,
                       @WebParam(name = "merge", partName = "checkinFromUrl.merge") Boolean merge,
                       @WebParam(name = "sync", partName = "checkinFromUrl.sync") Boolean sync) throws Exception;

	/**
	 * Download a compare of a model
	 * 
	 * @param roid1
	 * @param roid2
	 * @param identifier
	 * @param type
	 * @param sync
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "downloadCompareResults")
	Long downloadCompareResults(
       @WebParam(name = "serializerOid", partName = "download.serializerOid") Long serializerOid,
       @WebParam(name = "roid1", partName = "downloadByOids.roid1") Long roid1,
       @WebParam(name = "roid2", partName = "downloadByOids.roid2") Long roid2,
       @WebParam(name = "mcid", partName = "downloadByOids.mcid") Long mcid,
       @WebParam(name = "type", partName = "downloadByOids.type") SCompareType type,
       @WebParam(name = "sync", partName = "downloadByOids.sync") Boolean sync) throws Exception;

	/**
	 * Add a new user
	 * 
	 * @param username The username (must be a valid e-mail address)
	 * @param name The name (e.g. "Bill Gates")
	 * @param type Type of user
	 * @param selfRegistration Whether this is a self-registration (for example e-mails will be different)
	 * @return The ObjectID of the created User object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addUser")
	SUser addUser(@WebParam(name = "username", partName = "addUser.username") String username,
                 @WebParam(name = "name", partName = "addUser.name") String name,
                 @WebParam(name = "type", partName = "addUser.type") SUserType type,
                 @WebParam(name = "selfRegistration", partName = "addUser.selfRegistration") Boolean selfRegistration,
                 @WebParam(name = "resetUrl", partName = "addUser.resetUrl") String resetUrl) throws Exception;

	/**
	 * Add a new user with a given password
	 * 
	 * @param username The username (must be a valid e-mail address)
	 * @param name The name (e.g. "Bill Gates")
	 * @param type Type of user
	 * @param selfRegistration Whether this is a self-registration (for example e-mails will be different)
	 * @return The ObjectID of the created User object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addUserWithPassword")
	SUser addUserWithPassword(@WebParam(name = "username", partName = "addUser.username") String username,
                             @WebParam(name = "password", partName = "addUser.password") String password,
                             @WebParam(name = "name", partName = "addUser.name") String name,
                             @WebParam(name = "type", partName = "addUser.type") SUserType type,
                             @WebParam(name = "selfRegistration", partName = "addUser.selfRegistration")
                                 Boolean selfRegistration,
                             @WebParam(name = "resetUrl", partName = "addUser.resetUrl") String resetUrl) throws
																																			 Exception;

	/**
	 * Change the type of a user
	 * 
	 * @param uoid The User's ObjectID
	 * @param userType The new type
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "changeUserType")
	void changeUserType(@WebParam(name = "uoid", partName = "changeUserType.uoid") Long uoid,
                       @WebParam(name = "userType", partName = "changeUserType.userType") SUserType userType) throws
																																				  Exception;

	/**
	 * Update project properties, the only three properties that can be updated with this call are "name", "description" and "exportLengthMeasurePrefix"
	 * 
	 * @param sProject A Project object containing the new properties
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateProject")
	void updateProject(@WebParam(name = "sProject", partName = "updateProject.sProject") SProject sProject) throws
																																			  Exception;

	/**
	 * Update a revision, not much can be changed afterwards, actually only the tag
	 * 
	 * @param sRevision The Revision object containing the new properties
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateRevision")
	void updateRevision(@WebParam(name = "sRevision", partName = "updateRevision.sRevision") SRevision sRevision) throws
																																					  Exception;

	/**
	 * Add a user to a project (authorization wise)
	 * 
	 * @param uoid The ObejctID of the User
	 * @param poid The ObjectID of the Project
	 * @return Whether the User has been added to the Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addUserToProject")
	Boolean addUserToProject(@WebParam(name = "uoid", partName = "addUserToProject.uoid") Long uoid,
                            @WebParam(name = "poid", partName = "addUserToProject.poid") Long poid) throws Exception;

	/**
	 * Remove a user from a project (authorization wise)
	 * 
	 * @param uoid ObjectID of the User
	 * @param poid ObjectID of the Project
	 * @return Whether the User has been removed from the Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "removeUserFromProject")
	Boolean removeUserFromProject(@WebParam(name = "uoid", partName = "removeProjectFromUser.uoid") Long uoid,
                                 @WebParam(name = "poid", partName = "removeUserFromProject.poid") Long poid) throws
																																				  Exception;

	/**
	 * Delete a User, Users van be undeleted with the undeleteUser method
	 * 
	 * @param uoid ObjectID of the User
	 * @return Whether the User has been deleted
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteUser")
	Boolean deleteUser(@WebParam(name = "uoid", partName = "deleteUser.uoid") Long uoid) throws Exception;

	/**
	 * Get a list of all Projects the user is authorized for to read from
	 * 
	 * @return A list of all projects that are readable for the current user
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllReadableProjects")
	List<SProject> getAllReadableProjects() throws Exception;

	/**
	 * Get a list of all Projects the user is authorized for to write to
	 * 
	 * @return A list of all projects that are writeable for the current user
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllWritableProjects")
	List<SProject> getAllWritableProjects() throws Exception;

	/**
	 * Get a list of all users
	 * 
	 * @return All users
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getAllUsers")
	List<SUser> getAllUsers() throws Exception;

	/**
	 * Get a list of all the services attached to the given project
	 * 
	 * @param poid Project-ID of the Project
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getAllServicesOfProject")
	List<SService> getAllServicesOfProject(
       @WebParam(name = "poid", partName = "getAllServicesOfProject.poid") Long poid) throws Exception;

	/**
	 * Get a list of all the model checkers attached to the given Project
	 * 
	 * @param poid Project-ID of the Project
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getAllModelCheckersOfProject")
	List<SModelCheckerInstance> getAllModelCheckersOfProject(
       @WebParam(name = "poid", partName = "getAllModelCheckersOfProject.poid") Long poid) throws Exception;
	
	/**
	 * Get all checkouts of the given project
	 * 
	 * @param poid The ObjectID of the Project
	 * @return A list of Checkouts belonging to this Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllCheckoutsOfProject")
	List<SCheckout> getAllCheckoutsOfProject(
       @WebParam(name = "poid", partName = "getAllCheckoutsOfProject.poid") Long poid) throws Exception;

	/**
	 * Get a list of revisions a user has committed
	 * 
	 * @param uoid ObjectID of the Project
	 * @return A list of Revisions belonging to this Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllRevisionsByUser")
	List<SRevision> getAllRevisionsByUser(
       @WebParam(name = "uoid", partName = "getAllRevisionsOfUser.uoid") Long uoid) throws Exception;

	/**
	 * Get a list of checkouts by the given user
	 * 
	 * @param uoid ObjectID of the User
	 * @return A list of Checkouts belonging to the given User
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllCheckoutsByUser")
	List<SCheckout> getAllCheckoutsByUser(
       @WebParam(name = "uoid", partName = "getAllCheckoutsByUser.uoid") Long uoid) throws Exception;

	/**
	 * Get a list of checkouts on the given revision
	 * 
	 * @param roid ObjectID of the Revision
	 * @return A list of Checkouts belonging to the given Revision
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllCheckoutsOfRevision")
	List<SCheckout> getAllCheckoutsOfRevision(
       @WebParam(name = "roid", partName = "getAllCheckoutsOfRevision.roid") Long roid) throws Exception;

	/**
	 * Returns a list of all available classes
	 * 
	 * @return A list of available classes in the BIMserver, only classes from the IFC model will be returned
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAvailableClasses")
	List<String> getAvailableClasses() throws Exception;

	/**
	 * Returns a list of all the classes that are used in the given revision
	 * 
	 * @param roid ObjectID of the Revision
	 * @return A list of classes of which a least one instance is available in the given Revision
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAvailableClassesInRevision")
	List<String> getAvailableClassesInRevision(
       @WebParam(name = "roid", partName = "getAvailableClassesInRevision.roid") Long roid) throws Exception;

	/**
	 * Get a list of all Projects the given User does not have authorization for
	 * 
	 * @param uoid
	 * @return The list of Users
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllNonAuthorizedProjectsOfUser")
	List<SProject> getAllNonAuthorizedProjectsOfUser(
       @WebParam(name = "uoid", partName = "getAllNonAuthorizedProjectsOfUser.uoid") Long uoid) throws Exception;

	/**
	 * Get a User by its UserNmae (e-mail address)
	 * 
	 * @param username The username (must be a valid e-mail address)
	 * @return The SUser Object if found, otherwise null
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getUserByUserName")
	SUser getUserByUserName(@WebParam(name = "username", partName = "getUserByUserName.username") String username) throws
																																						Exception;

	/**
	 * Undelete a previously deleted User, Users can be deleted with the deleteUser method
	 * 
	 * @param uoid
	 * @return Whether the deletion was successfull
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "undeleteUser")
	Boolean undeleteUser(@WebParam(name = "uoid", partName = "undeleteUser.uoid") Long uoid) throws Exception;

	/**
	 * Compare two models
	 * 
	 * @param roid1 The ObjectID of the first Revision
	 * @param roid2 The ObjectID of the second Revision
	 * @param sCompareType How to compare (All, Only Added, Only Modified or Only Deleted)
	 * @param sCompareIdentifier How to identify equal objects (by Guid or by Name)
	 * @return The result of the compare
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "compare")
	SCompareResult compare(@WebParam(name = "roid1", partName = "compare.roid1") Long roid1,
                          @WebParam(name = "roid2", partName = "compare.roid2") Long roid2,
                          @WebParam(name = "sCompareType", partName = "compare.sCompareType") SCompareType sCompareType,
                          @WebParam(name = "mcid", partName = "compare.mcid") Long mcid) throws Exception;

	/**
	 * Get a revision summary
	 * 
	 * @param roid ObjectID of the Revision
	 * @return A summary of the given Revision
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getRevisionSummary")
	SRevisionSummary getRevisionSummary(@WebParam(name = "roid", partName = "getRevisionSummary.roid") Long roid) throws
																																					  Exception;		

	/**
	 * Check whether the given user has rights on the given project
	 * 
	 * @param poid ObjectID of the Project
	 * @return Whether the current use has checkin rights on the given Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "userHasCheckinRights")
	Boolean userHasCheckinRights(@WebParam(name = "uoid", partName = "userHasCheckinRights.uoid") Long uoid,
                                @WebParam(name = "poid", partName = "userHasCheckinRights.poid") Long poid) throws
																																				Exception;

	/**
	 * Checkout warnings are given to users when checkouts are done by other users
	 * 
	 * @param poid ObjectID of the Project
	 * @return A set of String containing possible warnings for this Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getCheckoutWarnings")
	Set<String> getCheckoutWarnings(@WebParam(name = "poid", partName = "getCheckoutWarnings.poid") Long poid) throws
																																				  Exception;

	/**
	 * Returns whether the currents user has rights on the given project
	 * 
	 * @param poid ObjectID of the Project
	 * @return Whether the current User has rights on the given Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "userHasRights")
	Boolean userHasRights(@WebParam(name = "poid", partName = "userHasRights.poid") Long poid) throws Exception;

	/**
	 * Get the GeoTag attached to the given Project
	 * 
	 * @param goid The ObjectID of the GeoTag
	 * @return The GeoTag object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getGeoTag")
	SGeoTag getGeoTag(@WebParam(name = "goid", partName = "getGeoTag.goid") Long goid) throws Exception;

	/**
	 * Update the GeoTag of a project
	 * 
	 * @param sGeoTag A GeoTag object containing the new properties
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateGeoTag")
	void updateGeoTag(@WebParam(name = "sGeoTag", partName = "updateGeoTag.sGeoTag") SGeoTag sGeoTag) throws Exception;

	/**
	 * Get a user by its User ObjectID
	 * 
	 * @param uoid The ObjectID of the User
	 * @return The User with the given User ObjectID
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getUserByUoid")
	SUser getUserByUoid(@WebParam(name = "uoid", partName = "getUserByUoid.uoid") Long uoid) throws Exception;

	/**
	 * Get a list of all Users not authoriazed on the given Project
	 * 
	 * @param poid The ObjectID of the Project
	 * @return A list of Users
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllNonAuthorizedUsersOfProject")
	List<SUser> getAllNonAuthorizedUsersOfProject(
       @WebParam(name = "poid", partName = "getAllNonAuthorizedUsersOfProject.poid") Long poid) throws Exception;

	/**
	 * Get a list of users that have been authorized on the given project
	 * 
	 * @param poid
	 * @return A list of all users authorized on the given project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllAuthorizedUsersOfProject")
	List<SUser> getAllAuthorizedUsersOfProject(
       @WebParam(name = "poid", partName = "getAllAuthorizedUsersOfProject.poid") Long poid) throws Exception;

	/**
	 * Get a list of projects a user is authorized on
	 * 
	 * @param uoid
	 * @return A list of projects a user has been authorized for
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getUsersProjects")
	List<SProject> getUsersProjects(@WebParam(name = "uoid", partName = "getUsersProjects.uoid") Long uoid) throws
																																			  Exception;

	/**
	 * Set a tag on a specific revision
	 * 
	 * @param roid The Revision ObjectID
	 * @param tag Tag
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setRevisionTag")
	void setRevisionTag(@WebParam(name = "roid", partName = "setRevisionTag.roid") Long roid,
                       @WebParam(name = "tag", partName = "setRevisionTag.tag") String tag) throws Exception;

	/**
	 * Get a list of all checkouts of the given project and it's sub projects
	 * 
	 * @param poid Project-ID of the given Project
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getAllCheckoutsOfProjectAndSubProjects")
	List<SCheckout> getAllCheckoutsOfProjectAndSubProjects(
       @WebParam(name = "poid", partName = "getAllCheckoutsOfProjectAndSubProjects.poid") Long poid) throws Exception;

	/**
	 * Send an e-mail with the results of a compare
	 * 
	 * @param sCompareType How to compare (All, Only Added, Only Modified or Only Deleted)
	 * @param sCompareIdentifier How to identify equal objects (by Guid or by Name)
	 * @param poid The ObjectID of the Project
	 * @param roid1 The ObjectID of the first Revision
	 * @param roid2 The ObjectID of the second Revision
	 * @param address The e-mail address to send the e-mail to
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "sendCompareEmail")
	void sendCompareEmail(
       @WebParam(name = "sCompareType", partName = "sendClashesEmail.sCompareType") SCompareType sCompareType,
       @WebParam(name = "mcid", partName = "sendClashesEmail.mcid") Long mcid,
       @WebParam(name = "poid", partName = "sendClashesEmail.poid") Long poid,
       @WebParam(name = "roid1", partName = "sendClashesEmail.roid1") Long roid1,
       @WebParam(name = "roid2", partName = "sendClashesEmail.roid2") Long roid2,
       @WebParam(name = "address", partName = "sendClashesEmail.address") String address) throws Exception;
	
	/**
	 * Get a list of query engine example keys (which you can then use for getQueryEngineExample)
	 * 
	 * @param onlyEnabled Whether to only include enabled query engines
	 * @return A list of QueryEngines
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getQueryEngineExampleKeys")
	List<String> getQueryEngineExampleKeys(
       @WebParam(name = "qeid", partName = "getQueryEngineExampleKeys.qeid") Long qeid) throws Exception;

	/**
	 * Returns a query engine example (get the key from getQueryEngineExampleKeys)
	 * 
	 * @param onlyEnabled Whether to only include enabled query engines
	 * @return A list of QueryEngines
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getQueryEngineExample")
	String getQueryEngineExample(@WebParam(name = "qeid", partName = "getQueryEngineExample.qeid") Long qeid,
                                @WebParam(name = "key", partName = "getQueryEngineExample.key") String key) throws
																																				Exception;

	/**
	 * Add an extended data schema. 
	 * 
	 * @param extendedDataSchema ExtendedDataSchema to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addExtendedDataSchema")
	Long addExtendedDataSchema(
       @WebParam(name = "extendedDataSchema", partName = "addExtendedDataSchema.extendedDataSchema")
           SExtendedDataSchema extendedDataSchema) throws Exception;

	/**
	 * @param uoid ObjectID of the User
	 * @param edsid ObjectID of the ExtendedDataSchema
	 * @throws UserException 
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addUserToExtendedDataSchema")
	void addUserToExtendedDataSchema(@WebParam(name = "uoid", partName = "addUserToExtendedDataSchema.uoid") Long uoid,
                                    @WebParam(name = "edsid", partName = "addUserToExtendedDataSchema.edsid")
                                        Long edsid) throws Exception;
	
	/**
	 * @param uoid ObjectID of the User
	 * @param edsid ObjectID of the ExtendedDataSchema
	 * @throws UserException 
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "removeUserFromExtendedDataSchema")
	void removeUserFromExtendedDataSchema(
       @WebParam(name = "uoid", partName = "removeUserFromExtendedDataSchema.uoid") Long uoid,
       @WebParam(name = "edsid", partName = "removeUserFromExtendedDataSchema.edsid") Long edsid) throws Exception;
	
	@WebMethod(action = "getExtendedDataSchemaFromRepository")
	SExtendedDataSchema getExtendedDataSchemaFromRepository(
       @WebParam(name = "namespace", partName = "getExtendedDataSchemaFromRepository.namespace")
           String namespace) throws Exception;
	
	/**
	 * @param roid ObjectID of the Revision
	 * @param extendedData ExtendedData to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addExtendedDataToProject")
	void addExtendedDataToProject(@WebParam(name = "poid", partName = "addExtendedDataToProject.poid") Long poid,
                                 @WebParam(name = "extendedData", partName = "addExtendedDataToProject.extendedData")
                                     SExtendedData extendedData) throws Exception;

	/**
	 * Checkin warnings are given to users
	 * @param poid ObjectID of the Project
	 * @return A set of String containing possible warnings for this Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getCheckinWarnings")
	Set<String> getCheckinWarnings(@WebParam(name = "poid", partName = "getCheckinWarnings.poid") Long poid) throws
																																				Exception;
	
	/**
	 * @return A list of ExtendedDataSchemas
	 * @throws ServerException, UserException
	 */
	/**
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getAllExtendedDataSchemas")
	List<SExtendedDataSchema> getAllExtendedDataSchemas() throws Exception;

	/**
	 * @param baseUrl
	 * @param serviceIdentifier
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getServiceDescriptor")
	SServiceDescriptor getServiceDescriptor(
       @WebParam(name = "baseUrl", partName = "getServiceDescriptor.baseUrl") String baseUrl,
       @WebParam(name = "serviceIdentifier", partName = "getServiceDescriptor.serviceIdentifier")
           String serviceIdentifier) throws Exception;
	
	/**
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getAllServiceDescriptors")
	List<SServiceDescriptor> getAllServiceDescriptors() throws Exception;

	/**
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getAllRepositoryExtendedDataSchemas")
	List<SExtendedDataSchema> getAllRepositoryExtendedDataSchemas() throws Exception;

	/**
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getAllRepositoryModelCheckers")
	List<SModelCheckerInstance> getAllRepositoryModelCheckers() throws Exception;

	/**
	 * @param notificationsUrl
	 * @param serviceIdentifier
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getAllPublicProfiles")
	List<SProfileDescriptor> getAllPublicProfiles(
       @WebParam(name = "notificationsUrl", partName = "getAllPublicProfiles.notificationsUrl") String notificationsUrl,
       @WebParam(name = "serviceIdentifier", partName = "getAllPublicProfiles.serviceIdentifier")
           String serviceIdentifier) throws Exception;

	/**
	 * @param poid
	 * @param sService
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="addServiceToProject")
	Long addServiceToProject(@WebParam(name = "poid", partName = "addServiceToProject.poid") Long poid,
                            @WebParam(name = "sService", partName = "addServiceToProject.sService")
                                org.bimserver.interfaces.objects.SService sService) throws Exception;

	/**
	 * @param oid
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="deleteService")
	void deleteService(@WebParam(name = "oid", partName = "deleteService.oid") Long oid) throws Exception;

	/**
	 * @param soid
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getService")
	org.bimserver.interfaces.objects.SService getService(
       @WebParam(name = "soid", partName = "getService.soid") Long soid) throws Exception;

	/**
	 * @param notificationsUrl
	 * @param serviceIdentifier
	 * @param token
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getAllPrivateProfiles")
	List<SProfileDescriptor> getAllPrivateProfiles(
       @WebParam(name = "notificationsUrl", partName = "getAllPrivateProfiles.notificationsUrl")
           String notificationsUrl,
       @WebParam(name = "serviceIdentifier", partName = "getAllPrivateProfiles.serviceIdentifier")
           String serviceIdentifier,
       @WebParam(name = "token", partName = "getAllPrivateProfiles.token") String token) throws Exception;
	
	/**
	 * @param file
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "uploadFile")
	Long uploadFile(@WebParam(name = "file", partName = "uploadFile.file") SFile file) throws Exception;

	/**
	 * @param fileId
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getFile")
	SFile getFile(@WebParam(name = "fileId", partName = "getFile.fileId") Long fileId) throws Exception;
	
	/**
	 * @param roid
	 * @param soid
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "triggerNewRevision")
	void triggerNewRevision(@WebParam(name = "roid", partName = "triggerNewRevision.roid") Long roid,
                           @WebParam(name = "soid", partName = "triggerNewRevision.soid") Long soid) throws Exception;

	/**
	 * @param edid
	 * @param soid
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "triggerNewExtendedData")
	void triggerNewExtendedData(@WebParam(name = "edid", partName = "triggerNewExtendedData.edid") Long edid,
                               @WebParam(name = "soid", partName = "triggerNewExtendedData.soid") Long soid) throws
																																				 Exception;

	/**
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getAllLocalServiceDescriptors")
	List<SServiceDescriptor> getAllLocalServiceDescriptors() throws Exception;

	/**
	 * @param serviceIdentifier
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getAllLocalProfiles")
	List<SProfileDescriptor> getAllLocalProfiles(
       @WebParam(name = "serviceIdentifier", partName = "getAllLocalProfiles.serviceIdentifier")
           String serviceIdentifier) throws Exception;

	/**
	 * Add a local service to a project
	 * 
	 * @param poid
	 * @param sService
	 * @param internalServiceOid
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "addLocalServiceToProject")
	void addLocalServiceToProject(@WebParam(name = "poid", partName = "addLocalServiceToProject.poid") Long poid,
                                 @WebParam(name = "sService", partName = "addLocalServiceToProject.sService")
                                     SService sService,
                                 @WebParam(name = "internalServiceOid",
                                           partName = "addLocalServiceToProject.internalServiceOid")
                                     Long internalServiceOid) throws Exception;
	
	/**
	 * Share a revision
	 * 
	 * @param roid
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "shareRevision")
	String shareRevision(@WebParam(name = "roid", partName = "shareRevision.roid") Long roid) throws Exception;

	/**
	 * Get the oid of the given GUID, will throw a UserException if the GUID was not found
	 * 
	 * @param roid Revision in which to look
	 * @param guid GUID
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getOidByGuid")
	Long getOidByGuid(@WebParam(name = "roid", partName = "getOidByGuid.roid") Long roid,
                     @WebParam(name = "guid", partName = "getOidByGuid.guid") String guid) throws Exception;

	/**
	 * Cleanup a long running action, this is important to keep memory usage of BIMserver down
	 * 
	 * @param actionId
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "cleanupLongAction")
	void cleanupLongAction(@WebParam(name = "actionId", partName = "cleanupLongAction.actionId") Long actionId) throws
																																					Exception;
	
	/**
	 * Get the user settings of the current user
	 * 
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getUserSettings")
	SUserSettings getUserSettings() throws Exception;

	/**
	 * Get all log entries linked to the given user
	 * 
	 * @param uoid
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getUserRelatedLogs")
	List<SLogAction> getUserRelatedLogs(@WebParam(name = "uoid", partName = "getUserRelatedLogs.uoid") Long uoid) throws
																																					  Exception;

	/**
	 * Get a list of a project's related projects. Will search through all the parent/child relations, recursively
	 * 
	 * @param poid The projectID of the project
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getAllRelatedProjects")
	List<SProjectSmall> getAllRelatedProjects(
       @WebParam(name = "poid", partName = "getAllRelatedProjects.poid") Long poid) throws Exception;

	/**
	 * Get all model checkers
	 * 
	 * @return A list of model checkers
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getAllModelCheckers")
	List<SModelCheckerInstance> getAllModelCheckers() throws Exception;
	
	/**
	 * @param modelCheckerInstance
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "addModelChecker")
	Long addModelChecker(@WebParam(name = "modelCheckerInstance", partName = "addModelChecker.modelCheckerInstance")
                            SModelCheckerInstance modelCheckerInstance) throws Exception;

	/**
	 * @param modelCheckerInstance
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "updateModelChecker")
	void updateModelChecker(
       @WebParam(name = "modelCheckerInstance", partName = "updateModelChecker.modelCheckerInstance")
           SModelCheckerInstance modelCheckerInstance) throws Exception;

	/**
	 * Validate a model checker
	 * 
	 * @param oid
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "validateModelChecker")
	void validateModelChecker(@WebParam(name = "oid", partName = "validateModelChecker.oid") Long oid) throws Exception;

	/**
	 * Add a model checker to a project
	 * 
	 * @param poid Project-ID
	 * @param modelCheckerOid ModelChecker ID
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="addModelCheckerToProject")
	void addModelCheckerToProject(@WebParam(name = "poid", partName = "addModelCheckerToProject.poid") Long poid,
                                 @WebParam(name = "modelCheckerOid",
                                           partName = "addModelCheckerToProject.modelCheckerOid")
                                     Long modelCheckerOid) throws Exception;
	
	/**
	 * Get a model checker instance by it's id
	 * 
	 * @param mcioid
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getModelCheckerInstance")
	SModelCheckerInstance getModelCheckerInstance(
       @WebParam(name = "mcioid", partName = "getModelCheckerInstance.mcioid") Long mcioid) throws Exception;
	
	/**
	 * Remove the given model checker from the given project
	 * 
	 * @param poid Project-ID
	 * @param modelCheckerOid Model Checker ID
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "removeModelCheckerFromProject")
	void removeModelCheckerFromProject(
       @WebParam(name = "poid", partName = "removeModelCheckerFromProject.poid") Long poid,
       @WebParam(name = "modelCheckerOid", partName = "removeModelCheckerFromProject.modelCheckerOid")
           Long modelCheckerOid) throws Exception;

	/**
	 * Remove the given service from the given project
	 * 
	 * @param poid Project-ID
	 * @param serviceOid Service-ID
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "removeServiceFromProject")
	void removeServiceFromProject(@WebParam(name = "poid", partName = "removeServiceFromProject.poid") Long poid,
                                 @WebParam(name = "serviceOid", partName = "removeServiceFromProject.serviceOid")
                                     Long serviceOid) throws Exception;
	
	/**
	 * Import data from another BIMserver, mainly used for migrations. EXPERIMENTAL CODE!
	 * 
	 * @param address Address of the other BIMserver (http(s)://host:port/[contextpath])
	 * @param username Username of the admin user on the remote server
	 * @param password Password of the admin user on the remote server
	 * @param path A local path pointing to a copy of the incoming directory of the original server
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "importData")
	void importData(@WebParam(name = "address", partName = "importData.address") String address,
                   @WebParam(name = "username", partName = "importData.username") String username,
                   @WebParam(name = "password", partName = "importData.password") String password,
                   @WebParam(name = "path", partName = "importData.path") String path) throws Exception;
	
	/**
	 * Get the IfcHeader of the given ConcreteRevision-ID
	 * 
	 * @param croid
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getIfcHeader")
	SIfcHeader getIfcHeader(@WebParam(name = "croid", partName = "getIfcHeader.croid") Long croid) throws Exception;
	
	/**
	 * Get the area of the given object
	 * 
	 * @param roid Revision-ID of the revision this object belongs to
	 * @param oid Object-ID of the object
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getArea")
	Double getArea(@WebParam(name = "roid", partName = "getArea.roid") Long roid,
                  @WebParam(name = "oid", partName = "getArea.oid") Long oid) throws Exception;

	/**
	 * Get the volume of the given object
	 * 
	 * @param roid Revision-ID of the revision this object belongs to
	 * @param oid Object-ID of the object
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getVolume")
	Double getVolume(@WebParam(name = "roid", partName = "getVolume.roid") Long roid,
                    @WebParam(name = "oid", partName = "getVolume.oid") Long oid) throws Exception;
}