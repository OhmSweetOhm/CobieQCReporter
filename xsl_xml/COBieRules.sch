<?xml version="1.0" encoding="utf-8"?>
<!--
8/22/2013
Due to inefficient calculation of the location attribute in the schematron svrl .xsl (iso_svrl_for_xslt2.xsl), the location of failed asserts and successful reports is injected as an element of the svrl:text.  A subsequent xslt will move the attributes back into their proper location as svrl:failed-assert or svrl:successful-report attributes

For Asserts:  Find(</iso:assert>), Replace(<xsl:element name="location"><xsl:value-of select="cfn:getLocation(., position())"/></xsl:element></iso:assert>)
For Reports:  Find(</iso:report>), Replace(<xsl:element name="location"><xsl:value-of select="cfn:getLocation(., position())"/></xsl:element></iso:report>)

Connection and Assembly Names unique
Get rid of "lite" keys.  Add category to Attribute key.
-->
<iso:schema xmlns="http://purl.oclc.org/dsdl/schematron" xmlns:iso="http://purl.oclc.org/dsdl/schematron" xmlns:cfn="http://docs.buildingsmartalliance.org/nbims03/cobie/schematron/functions" xmlns:xs="http://www.w3.org/2001/XMLSchema" queryBinding="xslt2" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" schemaVersion="ISO19757-3" defaultPhase="Construction">
	<iso:title>COBie Validation Rules:  includes design and construction</iso:title>
	<iso:phase id="Design">
		<iso:active pattern="COBieValidation.Information"/>
		<iso:active pattern="Design.COBieValidation.Errors"/>
	</iso:phase>
	<iso:phase id="Construction">
		<iso:active pattern="COBieValidation.Information"/>
		<iso:active pattern="Construction.COBieValidation.Errors"/>
	</iso:phase>
	<iso:pattern id="COBieValidation.Information">
		<iso:title>Worksheet Counts</iso:title>
		<iso:rule context="//Contacts" id="COBie.Contacts" role="WorksheetCount">
			<xsl:message terminate="no">Counting Worksheet Rows</xsl:message>
			<iso:assert id="Contacts.AtLeastOneContact" test="Contact">
				<value-of select="cfn:atLeastOneMessage('Contact','Contacts')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contacts.ReportNumberOf" test="Contact">
				<value-of select="cfn:reportNumberOfMessage('Contacts',count(Contact))"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Facilities" id="COBie.Facilities" role="WorksheetCount">
			<iso:report id="Facilities.ReportNumberOf" test="Facility">
				<value-of select="cfn:reportNumberOfMessage('Facilities',count(Facility))"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Floors" id="COBie.Floors" role="WorksheetCount">
			<iso:report id="Floors.ReportNumberOf" test="Floor">
				<value-of select="cfn:reportNumberOfMessage('Floors',count(Floor))"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Spaces" id="COBie.Spaces" role="WorksheetCount">
			<iso:report id="Spaces.ReportNumberOf" test="Space">
				<value-of select="cfn:reportNumberOfMessage('Spaces',count(Space))"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Zones" id="COBie.Zones" role="WorksheetCount">
			<iso:report id="Zones.ReportNumberOf" test="Zone">
				<value-of select="cfn:reportNumberOfMessage('Zones',count(Zone))"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Types" id="COBie.Types" role="WorksheetCount">
			<iso:report id="Types.ReportNumberOf" test="Type">
				<value-of select="cfn:reportNumberOfMessage('Types',count(Type))"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Components" id="COBie.Components" role="WorksheetCount">
			<iso:report id="Components.ReportNumberOf" test="Component">
				<value-of select="cfn:reportNumberOfMessage('Components',count(Component))"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Systems" id="COBie.Systems" role="WorksheetCount">
			<iso:report id="Systems.ReportNumberOf" test="System">
				<value-of select="cfn:reportNumberOfMessage('Systems',count(System))"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Assemblies" id="COBie.Assemblies" role="WorksheetCount">
			<iso:report id="Assemblies.ReportNumberOf" test="Assembly">
				<value-of select="cfn:reportNumberOfMessage('Assemblies',count(Assembly))"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Connections" id="COBie.Connections" role="WorksheetCount">
			<iso:report id="Connections.ReportNumberOf" test="Connection">
				<value-of select="cfn:reportNumberOfMessage('Connections',count(Connection))"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Spares" id="COBie.Spares" role="WorksheetCount">
			<iso:report id="Spares.ReportNumberOf" test="Spare">
				<value-of select="cfn:reportNumberOfMessage('Spares',count(Spare))"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Resources" id="COBie.Resources" role="WorksheetCount">
			<iso:report id="Resources.ReportNumberOf" test="Resource">
				<value-of select="cfn:reportNumberOfMessage('Resources',count(Resource))"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Jobs" id="COBie.Jobs" role="WorksheetCount">
			<iso:report id="Jobs.ReportNumberOf" test="Job">
				<value-of select="cfn:reportNumberOfMessage('Jobs',count(Job))"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Documents" id="COBie.Documents" role="WorksheetCount">
			<iso:report id="Documents.ReportNumberOf" test="Document">
				<value-of select="cfn:reportNumberOfMessage('Documents',count(Document))"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Attributes" id="COBie.Attributes" role="WorksheetCount">
			<iso:report id="Attributes.ReportNumberOf" test="Attribute">
				<value-of select="cfn:reportNumberOfMessage('Attributes',count(Attribute))"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
		</iso:rule>
	</iso:pattern>
	<iso:pattern id="Construction.COBieValidation.Errors">
		<iso:title>COBie Checking Rules</iso:title>
		<iso:rule abstract="true" id="COBie.Abstract.Name" role="WorksheetErrors">
			<iso:report id="Common.Name.Check" test="true()" flag="Name">Name.NotNotNull, Name.Unique<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Common.Name.NotNull" test="cfn:validString(@Name)" flag="Name">
				<value-of select="cfn:notNullMessage(.,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Common.Name.Unique" test="cfn:isKeyUnique(.)" flag="Name">
				<value-of select="cfn:uniqueNameMessage(.,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule abstract="true" id="COBie.Abstract.Created" role="WorksheetErrors">
			<iso:report id="Common.CreatedBy.Check" test="true()" flag="CreatedBy">CreatedBy.CrossReference (ToContact), CreatedBy.NotNull<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Common.CreatedBy.CrossReference" test="key('ContactKey',CreatedBy)" flag="CreatedBy">
				<value-of select="cfn:foreignKeyMessage(.,'CreatedBy','Contact','Email')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Common.CreatedBy.NotNull" test="cfn:validString(CreatedBy)" flag="CreatedBy">
				<value-of select="cfn:notNullMessage(.,'CreatedBy')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Common.CreatedOn.Check" test="true()" flag="CreatedOn">CreatedOn.NotNull, CreatedOn.Valid (Valid ISO DateTime)<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Common.CreatedOn.NotNull" test="cfn:validString(CreatedOn)" flag="CreatedOn">
				<value-of select="cfn:notNullMessage(.,'CreatedOn')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Common.CreatedOn.Valid" test="cfn:validDateTime(CreatedOn)" flag="CreatedOn">
				<value-of select="cfn:dateTimeFormatMessage(.,'CreatedOn')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule abstract="true" id="COBie.Abstract.External" role="WorksheetErrors">
			<iso:report id="Common.ExternalSystem.Check" test="true()" flag="ExtSystem">ExternalSystem.NotEmpty<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Common.ExternalSystem.NotEmpty" test="cfn:validStringOrNA(ExtSystem)" flag="ExtSystem">
				<value-of select="cfn:notEmptyMessage(.,'ExtSystem')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Common.ExternalObject.Check" test="true()" flag="ExtObject">ExternalObject.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Common.External.ObjectNotEmpty" test="cfn:validStringOrNA(ExtObject)" flag="ExtObject">
				<value-of select="cfn:notEmptyMessage(.,'ExtObject')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Common.ExternalIdentifier.Check" test="true()" flag="ExtIdentifier">ExtIdentifier.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Common.ExternalIdentifier.NotEmpty" test="cfn:validStringOrNA(ExtIdentifier)" flag="ExtIdentifier">
				<value-of select="cfn:notEmptyMessage(.,'ExtIdentifier')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule abstract="true" id="COBie.Abstract.Category" role="WorksheetErrors">
			<iso:report id="Common.Category.Check" test="true()" flag="Category">Category.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Common.Category.NotNull" test="cfn:validString(Category)" flag="Category">
				<value-of select="cfn:notNullMessage(.,'Category')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule abstract="true" id="COBie.Abstract.Description" role="WorksheetErrors">
			<iso:report id="Common.Description.Check" test="true()" flag="Description">Description.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Common.Description.NotEmpty" test="cfn:validStringOrNA(Description)" flag="Description">
				<value-of select="cfn:notEmptyMessage(.,'Description')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Contacts" id="COBie.Contacts" role="WorksheetErrors">
			<xsl:message terminate="no">Validating Contact Worksheet</xsl:message>
			<iso:report id="Contact.Count.Check" test="true()" flag="ContactSheet">Contacts.AtLeastOneRowPresent
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contacts.AtLeastOneRowPresent" test="Contact" flag="ContactSheet">
				<value-of select="cfn:atLeastOneMessage('Contact','Contacts')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Contacts/Contact" id="COBie.Contacts.Contact" role="WorksheetErrors">
			<iso:report id="Contact.Email.Check" test="true()" flag="Email">Email.Unique, Email.NotNull, Email.Format
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.Email.Unique" test="cfn:isKeyUnique(.)" flag="Email">
				<value-of select="cfn:uniqueNameMessage(.,'Email')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Contact.Email.NotNull" test="cfn:validString(Email)" flag="Email">
				<value-of select="cfn:notNullMessage(.,'Email')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Contact.Email.Format" test="cfn:validEmail(Email)" flag="Email">
				<value-of select="cfn:assertMsgPrefix(name(.),Email,'Email')"/> must be a valid e-mail format (XXX@YYY.ZZZ)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.CreatedBy.Check" test="true()" flag="CreatedBy">CreatedBy.CrossReference, CreatedBy.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.CreatedBy.CrossReference" test="key('ContactKey',CreatedBy)" flag="CreatedBy">
				<value-of select="cfn:foreignKeyMessage(.,'CreatedBy','Contact','Email')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Contact.CreatedBy.NotNull" test="cfn:validString(CreatedBy)" flag="CreatedBy">
				<value-of select="cfn:notNullMessage(.,'CreatedBy')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.CreatedOn.Check" test="true()" flag="CreatedOn">CreatedOn.NotNull, CreatedOn.Valid (ISO DateTime)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.CreatedOn.NotNull" test="cfn:validString(CreatedOn)" flag="CreatedOn">
				<value-of select="cfn:notNullMessage(.,'CreatedOn')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Contact.CreatedOn.Valid" test="cfn:validDateTime(CreatedOn)" flag="CreatedOn">
				<value-of select="cfn:dateTimeFormatMessage(.,'CreatedOn')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.ExternalSystem.Check" test="true()" flag="ExternalSystem">ExternalSystem.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="ExternalSystem.NotEmpty" test="cfn:validStringOrNA(ExternalSystem) or cfn:validStringOrNA(ExtSystem)" flag="ExternalSystem">
				<value-of select="cfn:notEmptyMessage(.,'ExternalSystem')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.ExternalObject.Check" test="true()" flag="ExternalObject">ExternalObject.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.ExternalObject.NotEmpty" test="cfn:validStringOrNA(ExternalObject) or cfn:validStringOrNA(ExtObject)" flag="ExternalObject">
				<value-of select="cfn:notEmptyMessage(.,'ExternalObject')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.ExternalIdentifier.Check" test="true()" flag="ExternalIdentifier">ExternalIdentifier.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.ExternalIdentifier.NotEmpty" test="cfn:validStringOrNA(ExternalIdentifier) or cfn:validStringOrNA(ExtIdentifier)" flag="ExternalIdentifier">
				<value-of select="cfn:notEmptyMessage(.,'ExternalIdentifier')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.Category.Check" test="true()" flag="Category">Category.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.Category.NotNull" test="cfn:validString(Category)" flag="Category">
				<value-of select="cfn:notNullMessage(.,'Category')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.Company.Check" test="true()" flag="Company">Company.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.Company.NotNull" test="cfn:validString(Company)" flag="Company">
				<value-of select="cfn:assertMsgPrefix(name(.),Email,'Company')"/>  must be provided (n/a is not acceptable)<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.Phone.Check" test="true()" flag="Phone">Phone.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.Phone.NotNull" test="cfn:validString(Phone)" flag="Phone">
				<value-of select="cfn:notNullMessage(.,'Phone')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.Department.Check" test="true()" flag="Department">Department.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.Department.NotEmpty" test="cfn:validStringOrNA(Department)" flag="Department">
				<value-of select="cfn:notEmptyMessage(.,'Department')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.OrganizationCode.Check" test="true()" flag="OrganizationCode">OrganizationCode.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.OrganizationCode.NotEmpty" test="cfn:validStringOrNA(OrganizationCode)" flag="OrganizationCode">
				<value-of select="cfn:notEmptyMessage(.,'OrganizationCode')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.GivenName.Check" test="true()" flag="GivenName">GivenName.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.GivenName.NotEmpty" test="cfn:validStringOrNA(GivenName)" flag="GivenName">
				<value-of select="cfn:notEmptyMessage(.,'GivenName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.FamilyName.Check" test="true()" flag="FamilyName">FamilyName.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.FamilyName.NotEmpty" test="cfn:validStringOrNA(FamilyName)" flag="FamilyName">
				<value-of select="cfn:notEmptyMessage(.,'FamilyName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.Street.Check" test="true()" flag="Street">Street.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.Street.NotEmpty" test="cfn:validStringOrNA(Street)" flag="Street">
				<value-of select="cfn:notEmptyMessage(.,'Street')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.PostalBox.Check" test="true()" flag="PostalBox">PostalBox.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.PostalBox.NotEmpty" test="cfn:validStringOrNA(PostalBox)" flag="PostalBox">
				<value-of select="cfn:notEmptyMessage(.,'PostalBox')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.Town.Check" test="true()" flag="Town">Town.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.Town.NotEmpty" test="cfn:validStringOrNA(Town)" flag="Town">
				<value-of select="cfn:notEmptyMessage(.,'Town')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.StateRegion.Check" test="true()" flag="StateRegion">StateRegion.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.StateRegion.NotEmpty" test="cfn:validStringOrNA(StateRegion)" flag="StateRegion">
				<value-of select="cfn:notEmptyMessage(.,'StateRegion')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.PostalCode.Check" test="true()" flag="PostalCode">PostalCode.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.PostalCode.NotEmpty" test="cfn:validStringOrNA(PostalCode)" flag="PostalCode">
				<value-of select="cfn:notEmptyMessage(.,'PostalCode')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.Country.Check" test="true()" flag="Country">Country.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.Country.NotEmpty" test="cfn:validStringOrNA(Country)" flag="Country">
				<value-of select="cfn:notEmptyMessage(.,'Country')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Facilities" id="COBie.Facilities" role="WorksheetErrors">
			<xsl:message terminate="no">Validating Facility Worksheet</xsl:message>
			<iso:report id="Facilities.AtLeastOne.Check" test="true()" flag="FacilitySheet">Facilities.OneAndOnlyOneFacilityFound
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facilites.OneAndOnlyOneFacilityFound" test="count(Facility)=1" flag="FacilitySheet">
				<value-of select="cfn:onlyOneMessage('Facility','Facilities')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Facilities/Facility" id="COBie.Facilities.Facility" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:report id="Facility.ProjectName.Check" test="true()" flag="ProjectName">ProjectName.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.ProjectName.NotNull" test="cfn:validString(ProjectName)" flag="ProjectName">
				<value-of select="cfn:notNullMessage(.,'ProjectName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Facility.SiteName.Check" test="true()" flag="SiteName">SiteName.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.SiteName.NotNull" test="cfn:validString(SiteName)" flag="SiteName">
				<value-of select="cfn:notNullMessage(.,'SiteName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Facility.LinearUnits.Check" test="true()" flag="LinearUnits">LinearUnits.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.LinearUnits.NotNull" test="cfn:validString(LinearUnits)" flag="LinearUnits">
				<value-of select="cfn:notNullMessage(.,'LinearUnits')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<!-- TODO Insert LinearUnits Picklist assert -->
			<iso:report id="Facility.AreaUnits.Check" test="true()" flag="AreaUnits">AreaUnits.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.AreaUnits.NotNull" test="cfn:validString(AreaUnits)" flag="AreaUnits">
				<value-of select="cfn:notNullMessage(.,'AreaUnits')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<!--TODO Insert AreaUnits Picklist assert -->
			<iso:report id="Facility.VolumeUnits.Check" test="true()" flag="VolumeUnits">VolumeUnits.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.VolumeUnits.NotNull" test="cfn:validString(VolumeUnits)" flag="VolumeUnits">
				<value-of select="cfn:notNullMessage(.,'VolumeUnits')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<!-- TODO Insert VolumeUnits Picklist assert -->
			<iso:report id="Facility.CurrencyUnit.Check" test="true()" flag="CurrencyUnit">Currency.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.Currency.NotNull" test="cfn:validString(CurrencyUnit)" flag="CurrencyUnit">
				<value-of select="cfn:notNullMessage(.,'CurrencyUnit')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<!-- TODO Currency Unit Picklist -->
			<iso:report id="Facility.AreaMeasurement.Check" test="true()" flag="AreaMeasurement">AreaMeasurement.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.AreaMeasurement.NotNull" test="cfn:validString(AreaMeasurement)" flag="AreaMeasurement">
				<value-of select="cfn:notNullMessage(.,'AreaMeasurement')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Facility.ExternalSystem.Check" test="true()" flag="ExternalSystem">ExternalSystem.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.ExternalSystem.NotEmpty" test="cfn:validStringOrNA(ExternalSystem)" flag="ExternalSystem">
				<value-of select="cfn:notEmptyMessage(.,'ExternalSystem')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Facility.ExternalProjectObject.Check" test="true()" flag="ExternalProjectObject">ExternalProjectObject.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.ExternalProjectObject.NotEmpty" test="cfn:validStringOrNA(ExternalProjectObject)" flag="ExternalProjectObject">
				<value-of select="cfn:notEmptyMessage(.,'ExternalProjectObject')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Facility.ExternalProjectIdentifier.Check" test="true()" flag="ExternalProjectIdentifier">ExternalProjectIdentifier.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.ProjectIdentifier.NotEmpty" test="cfn:validStringOrNA(ExternalProjectIdentifier)" flag="ExternalProjectIdentifier">
				<value-of select="cfn:notEmptyMessage(.,'ExternalProjectIdentifier')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Facility.ExternalSiteObject.Check" test="true()" flag="ExternalSiteObject">ExternalSiteObject.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.ExternalSiteObject.NotEmpty" test="cfn:validStringOrNA(ExternalSiteObject)" flag="ExternalSiteObject">
				<value-of select="cfn:notEmptyMessage(.,'ExternalSiteObject')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Facility.ExternalSiteIdentifier.Check" test="true()" flag="ExternalSiteIdentifier">ExternalSiteIdentifier.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.ExternalSiteIdentifier.NotEmpty" test="cfn:validStringOrNA(ExternalSiteIdentifier)" flag="ExternalSiteIdentifier">
				<value-of select="cfn:notEmptyMessage(.,'ExternalSiteIdentifier')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Facility.ExternalFacilityObject.Check" test="true()" flag="ExternalFacilityObject">ExternalFacilityObject.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="FacilityExternalFacilityObjectNotEmpty" test="cfn:validStringOrNA(ExternalFacilityObject)" flag="ExternalFacilityObject">
				<value-of select="cfn:notEmptyMessage(.,'ExternalFacilityObject')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Facility.ExternalFacilityIdentifier.Check" test="true()" flag="ExternalFacilityIdentifier">ExternalFacilityIdentifier.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.ExternalFacilityIdentifier.NotEmpty" test="cfn:validStringOrNA(ExternalFacilityIdentifier)" flag="ExternalFacilityIdentifier">
				<value-of select="cfn:notEmptyMessage(.,'ExternalFacilityIdentifier')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Floors" id="COBie.Floors" role="WorksheetErrors">
			<xsl:message terminate="no">Validating Floor Worksheet</xsl:message>
			<iso:report id="Floor.Count.Check" test="true()" flag="FloorSheet">Floors.AtLeastOneRowPresent
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Floors.AtLeastOneRowPresent" test="Floor">
				<cfn:value-of select="cfn:atLeastOneMessage('Floor','Floors')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Floors/Floor" id="COBie.Floors.Floor" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:report id="Floor.Elevation.Check" test="true()" flag="Elevation">Floor.Elevation.ValidNumberOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Floor.Elevation.ValidNumberOrNA" test="cfn:validNumber(Elevation)" flag="Elevation">
				<value-of select="cfn:notEmptyNumberMessage(.,'Elevation')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Floor.Height.Check" test="true()" flag="Height">Floor.Height.ZeroOrGreaterOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Floor.Height.ZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(Height)" flag="Height">
				<value-of select="cfn:notEmptyNumberMessage(.,'Height')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Spaces" id="COBie.Spaces" role="WorksheetErrors">
			<xsl:message terminate="no">Validating Space Worksheet</xsl:message>
			<iso:report id="Space.Count.Check" test="true()" flag="SpaceSheet">Spaces.AtLeastOneRowPresent
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Spaces.AtLeastOneRowPresent" test="Space">
				<name/> must have at least one entry<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Spaces/Space" id="COBie.Spaces.Space" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:report id="Space.FloorName.Check" test="true()" flag="FloorName">FloorName.NotNull, FloorName.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Space.FloorName.NotNull" test="cfn:validString(FloorName)" flag="FloorName">
				<value-of select="cfn:notNullMessage(.,'FloorName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Space.FloorName.CrossReference" test="key('FloorKey',FloorName)" flag="FloorName">
				<value-of select="cfn:foreignKeyMessage(.,'FloorName','Floor','Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Space.Description.Check" test="true()" flag="Description">Description.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Space.Description.NotNull" test="cfn:validString(Description)" flag="Description">
				<value-of select="cfn:notNullMessage(.,'Description')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Space.RoomTag.Check" test="true()" flag="RoomTag">RoomTag.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Space.RoomTag.NotEmpty" test="cfn:validStringOrNA(RoomTag)" flag="RoomTag">
				<value-of select="cfn:notEmptyMessage(.,'RoomTag')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Space.UsableHeight.Check" test="true()" flag="UsableHeight">UsableHeight.ZeroOrGreaterOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Space.UsableHeight.ZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(UsableHeight)" flag="UsableHeight">
				<value-of select="cfn:notEmptyNumberMessage(.,'UsableHeight')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Space.GrossArea.Check" test="true()" flag="GrossArea">GrossArea.ZeroOrGreaterOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Space.GrossArea.ZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(GrossArea)" flag="GrossArea">
				<value-of select="cfn:notEmptyNumberMessage(.,'GrossArea')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Space.NetArea.Check" test="true()" flag="NetArea">NetArea.ZeroOrGreaterOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Space.NetArea.ZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(NetArea)" flag="NetArea">
				<value-of select="cfn:notEmptyNumberMessage(.,'NetArea')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Zones">
			<xsl:message terminate="no">Validating Zone Worksheet</xsl:message>
		</iso:rule>
		<iso:rule context="//Zones/Zone" id="COBie.Zones.Zone" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:report id="Zone.Name.Check" test="true()" flag="Name">Name.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Zone.Name.NotNull" test="cfn:validString(@Name)" flag="Name">
				<value-of select="cfn:notNullMessage(.,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Zone.PrimaryKey.Check" test="true()" flag="PrimaryKey">PrimaryKey.Unique (Name, Category, SpaceNames)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Zone.PrimaryKey.Unique" test="cfn:isKeyUnique(.)" flag="PrimaryKey">
				<value-of select="cfn:uniqueNameMessage(.,'Name,Category,SpaceNames')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Zone.SpaceNames.Check" test="true()" flag="SpaceNames">SpaceNames.NotNull, SpaceNames.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Zone.SpaceNames.NotNull" test="cfn:validString(SpaceNames)" flag="SpaceNames">
				<value-of select="cfn:notNullMessage(.,'SpaceNames')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Zone.SpaceNames.CrossReference" test="cfn:delimListInKeys(SpaceNames,'Space',/)" flag="SpaceNames">
				<value-of select="cfn:foreignKeysMessage(.,'SpaceNames','Space','Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Types" id="COBie.Types" role="WorksheetErrors">
			<xsl:message terminate="no">Validating Type Worksheet</xsl:message>
			<iso:report id="Type.Count.Check" test="true()" flag="TypeSheet">Types.AtLeastOneRowPresent
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Types.AtLeastOneRowPresent" test="Type">
				<name/>:  At least one Type must be provided<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Types/Type" id="COBie.Types.Type" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:report id="Type.ComponentCount.Check" test="true()" flag="TypeComponentSheets">Type.Component.AComponentForEachType
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Component.AComponentForEachType" test="some $comp in ../../Components/Component satisfies ($comp/TypeName=@Name)" flag="Name">
				<name/>.<value-of select="@Name"/>: All Types must have at least one associated Component
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.AssetType.Check" test="true()" flag="AssetType">AssetType.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.AssetType.NotNull" test="cfn:validString(AssetType)" flag="AssetType">
				<value-of select="cfn:notNullMessage(.,'AssetType')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.Manufacturer.Check" test="true()" flag="Manufacturer">Manufacturer.NotNull, Manufacturer.CrossReference (Contact Sheet)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Manufacturer.NotNull" test="cfn:validString(Manufacturer)" flag="Manufacturer">
				<value-of select="cfn:notNullMessage(.,'Manufacturer')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Type.Manufacturer.CrossReference" test="key('ContactKey',Manufacturer)" flag="Manufacturer">
				<value-of select="cfn:foreignKeyMessage(.,'Manufacturer','Contact','Email')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.ModelNumber.Check" test="true()" flag="ModelNumber">ModelNumber.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.ModelNumber.NotNull" test="cfn:validString(ModelNumber)" flag="ModelNumber">
				<value-of select="cfn:notNullMessage(.,'ModelNumber')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.WarrantyGuarantorParts.Check" test="true()" flag="WarrantyGuarantorParts">WarrantyGuarantorParts.NotNull, WarrantyGuarantorParts.CrossReference (Contact Sheet)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.WarrantyGuarantorParts.NotNull" test="cfn:validString(WarrantyGuarantorParts)" flag="WarrantyGuarantorParts">
				<value-of select="cfn:notNullMessage(.,'WarrantyGuarantorParts')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Type.WarrantyGuarantorParts.CrossReference" test="key('ContactKey',WarrantyGuarantorParts)" flag="WarrantyGuarantorParts">
				<value-of select="cfn:foreignKeyMessage(.,'WarrantyGuarantorParts','Contact','Email')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.WarrantyDurationParts.Check" test="true()" flag="WarrantyDurationParts">WarrantyDurationParts.validNumberZeroOrGreaterOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.WarrantyDurationParts.validNumberZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(WarrantyDurationParts)" flag="WarrantyDurationParts">
				<value-of select="cfn:notEmptyNumberMessage(.,'WarrantyDurationParts')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.WarrantyGuarantorLabor.Check" test="true()" flag="WarrantyGuarantorLabor">WarrantyGuarantorLabor.NotNull, WarrantyGuarantorLabor.CrossReference (Contact Sheet)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.WarrantyGuarantorLabor.NotNull" test="cfn:validString(WarrantyGuarantorLabor)" flag="WarrantyGuarantorLabor">
				<value-of select="cfn:notNullMessage(.,'WarrantyGuarantorLabor')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Type.WarrantyGuarantorLabor.CrossReference" test="key('ContactKey',WarrantyGuarantorLabor)" flag="WarrantyGuarantorLabor">
				<value-of select="cfn:foreignKeyMessage(.,'WarrantyGuarantorLabor,','Contact','Email')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.WarrantyDurationLabor.Check" test="true()" flag="WarrantyDurationLabor">WarrantyDurationLabor.ZeroOrGreaterOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.WarrantyDurationLabor.ZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(WarrantyDurationLabor)" flag="WarrantyDurationLabor">
				<value-of select="cfn:notEmptyNumberMessage(.,'WarrantyDurationLabor')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.WarrantyDurationUnit.Check" test="true()" flag="WarrantyDurationUnit">WarrantyDurationUnit.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.WarrantyDurationUnit.NotNull" test="cfn:validString(WarrantyDurationUnit)" flag="WarrantyDurationUnit">
				<value-of select="cfn:notNullMessage(.,'WarrantyDurationUnit')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.ReplacementCost.Check" test="true()" flag="ReplacementCost">ReplacementCost.ZeroOrGreaterOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.ReplacementCost.ZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(ReplacementCost)" flag="ReplacementCost">
				<value-of select="cfn:notEmptyNumberMessage(.,'ReplacementCost')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.ExpectedLife.Check" test="true()" flag="ExpectedLife">ExpectedLife.ZeroOrGreaterOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.ExpectedLife.ZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(ExpectedLife)" flag="ExpectedLife">
				<value-of select="cfn:notEmptyNumberMessage(.,'ExpectedLife')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.DurationUnit.Check" test="true()" flag="DurationUnit">DurationUnit.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.DurationUnit.NotNull" test="cfn:validString(DurationUnit)" flag="DurationUnit">
				<value-of select="cfn:notNullMessage(.,'DurationUnit')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.WarrantyDescription.Check" test="true()" flag="WarrantyDescription">WarrantyDescription.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.WarrantyDescription.NotEmpty" test="cfn:validStringOrNA(WarrantyDescription)" flag="WarrantyDescription">
				<value-of select="cfn:notEmptyMessage(.,'WarrantyDescription')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.NominalLength.Check" test="true()" flag="NominalLength">NominalLength.ZeroOrGreaterOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.NominalLength.ZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(NominalLength)" flag="NominalLength">
				<value-of select="cfn:notEmptyNumberMessage(.,'NominalLength')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.NominalWidth.Check" test="true()" flag="NominalWidth">NominalWidth.ZeroOrGreaterOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.NominalWidth.ZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(NominalWidth)" flag="NominalWidth">
				<value-of select="cfn:notEmptyNumberMessage(.,'NominalWidth')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.NominalHeight.Check" test="true()" flag="NominalHeight">NominalHeight.ZeroOrGreater
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.NominalHeight.ZeroOrGreater" test="cfn:validNumberZeroOrGreater(NominalHeight)" flag="NominalHeight">
				<value-of select="cfn:notEmptyNumberMessage(.,'NominalHeight')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.ModelReference.Check" test="true()" flag="ModelReference">ModelReference.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.ModelReference.NotEmpty" test="cfn:validStringOrNA(ModelReference)" flag="ModelReference">
				<value-of select="cfn:notEmptyMessage(.,'ModelReference')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.Shape.Check" test="true()" flag="Shape">Shape.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Shape.NotEmpty" test="cfn:validStringOrNA(Shape)" flag="Shape">
				<value-of select="cfn:notEmptyMessage(.,'Shape')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.Size.Check" test="true()" flag="Size">Size.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Size.NotEmpty" test="cfn:validStringOrNA(Size)" flag="Size">
				<value-of select="cfn:notEmptyMessage(.,'Size')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.Color.Check" test="true()" flag="Color">Color.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Color.NotEmpty" test="cfn:validStringOrNA(Color)" flag="Color">
				<value-of select="cfn:notEmptyMessage(.,'Color')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.Finish.Check" test="true()" flag="Finish">Finish.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Finish.NotEmpty" test="cfn:validStringOrNA(Finish)" flag="Finish">
				<value-of select="cfn:notEmptyMessage(.,'Finish')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.Grade.Check" test="true()" flag="Grade">Grade.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Grade.NotEmpty" test="cfn:validStringOrNA(Grade)" flag="Grade">
				<value-of select="cfn:notEmptyMessage(.,'Grade')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.Material.Check" test="true()" flag="Material">Material.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Material.NotEmpty" test="cfn:validStringOrNA(Material)" flag="Material">
				<value-of select="cfn:notEmptyMessage(.,'Material')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.Constituents.Check" test="true()" flag="Constituents">Constituents.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Constituents.NotEmpty" test="cfn:validStringOrNA(Constituents)" flag="Constituents">
				<value-of select="cfn:notEmptyMessage(.,'Constituents')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.Features.Check" test="true()" flag="Features">Features.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Features.NotEmpty" test="cfn:validStringOrNA(Features)" flag="Features">
				<value-of select="cfn:notEmptyMessage(.,'Features')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.AccessibilityPerformance.Check" test="true()" flag="AccessibilityPerformance">AccessibilityPerformance.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.AccessibilityPerformance.NotEmpty" test="cfn:validStringOrNA(AccessibilityPerformance)" flag="AccessibilityPerformance">
				<value-of select="cfn:notEmptyMessage(.,'AccessibilityPerformance')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.CodePerformance.Check" test="true()" flag="CodePerformance">CodePerformance.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.CodePerformance.NotEmpty" test="cfn:validStringOrNA(CodePerformance)" flag="CodePerformance">
				<value-of select="cfn:notEmptyMessage(.,'CodePerformance')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.SustainabilityPerformance.Check" test="true()" flag="SustainabilityPerformance">SustainabilityPerformance.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.SustainabilityPerformance.NotEmpty" test="cfn:validStringOrNA(SustainabilityPerformance)" flag="SustainabilityPerformance">
				<value-of select="cfn:notEmptyMessage(.,'SustainabilityPerformance')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Components" id="COBie.Components" role="WorksheetErrors">
			<xsl:message terminate="no">Validating Component Worksheet</xsl:message>
			<iso:report id="Component.Count.Check" test="true()" flag="ComponentSheet">Components.AtLeastOneRowPresent
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Components.AtLeastOneRowPresent" test="Component">
				<name/>:  at least one Component must be provided.<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Components/Component" id="COBie.Components.Component" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:report id="Component.TypeName.Check" test="true()" flag="TypeName">TypeName.NotNull, TypeName.CrossReference (Type Worksheet)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Component.TypeName.NotNull" test="cfn:validString(TypeName)" flag="TypeName">
				<value-of select="cfn:notNullMessage(.,'TypeName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Component.TypeName.CrossReference" test="key('TypeKey',TypeName)" flag="TypeName">
				<value-of select="cfn:foreignKeyMessage(.,'TypeName','Type','Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Component.Space.Check" test="true()" flag="Space">Space.NotNull, Space.CrossReference (Component Worksheet)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Component.Space.NotNull" test="cfn:validString(Space)" flag="Space">
				<value-of select="cfn:notNullMessage(.,'Space')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Component.Space.CrossReference" test="cfn:componentSpaceKeyMatch(Space,ExtObject,/,.)" flag="Space">
				<value-of select="cfn:componentSpaceForeignKeyMessage(.,'Space','Space','Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Component.Description.Check" test="true()" flag="Description">Description.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Component.Description.NotNull" test="cfn:validString(Description)" flag="Description">
				<value-of select="cfn:notNullMessage(.,'Description')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Component.SerialNumber.Check" test="true()" flag="SerialNumber">SerialNumber.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Component.SerialNumber.NotEmpty" test="cfn:validStringOrNA(SerialNumber)" flag="SerialNumber">
				<value-of select="cfn:notEmptyMessage(.,'SerialNumber')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Component.InstallationDate.Check" test="true()" flag="InstallationDate">InstallationDate.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Component.InstallationDate.NotNull" test="cfn:validString(InstallationDate)" flag="InstallationDate">
				<value-of select="cfn:notNullMessage(.,'InstallationDate')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Component.WarrantyStartDate.Check" test="true()" flag="WarrantyStartDate">WarrantyStartDate.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Component.WarrantyStartDate.NotNull" test="cfn:validString(WarrantyStartDate)" flag="WarrantyStartDate">
				<value-of select="cfn:notNullMessage(.,'WarrantyStartDate')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Component.TagNumber.Check" test="true()" flag="TagNumber">TagNumber.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Component.TagNumber.NotEmpty" test="cfn:validStringOrNA(TagNumber)" flag="TagNumber">
				<value-of select="cfn:notEmptyMessage(.,'TagNumber')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Component.BarCode.Check" test="true()" flag="BarCode">BarCode.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Component.BarCode.NotEmpty" test="cfn:validStringOrNA(BarCode)" flag="BarCode">
				<value-of select="cfn:notEmptyMessage(.,'BarCode')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Component.AssetIdentifier.Check" test="true()" flag="AssetIdentifier">AssetIdentifier.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Component.AssetIdentifier.NotEmpty" test="cfn:validStringOrNA(AssetIdentifier)" flag="AssetIdentifier">
				<value-of select="cfn:notEmptyMessage(.,'AssetIdentifier')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Systems">
			<xsl:message terminate="no">Validating System Worksheet</xsl:message>
		</iso:rule>
		<iso:rule context="//Systems/System" id="COBie.Systems.System" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:report id="System.Name.Check" test="true()" flag="PrimaryKey">PrimaryKey.Unique (Name, Category, ComponentNames), Name.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="System.PrimaryKey.Unique" test="cfn:isKeyUnique(.)" flag="PrimaryKey">
				<value-of select="cfn:uniqueNameMessage(.,'Name,Category,ComponentNames')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="System.Name.NotNull" test="cfn:validString(@Name)" flag="Name">
				<value-of select="cfn:notNullMessage(.,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="System.ComponentNames.Check" test="true()" flag="ComponentNames">ComponentNames.NotNull, ComponentNames.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="System.ComponentNames.NotNull" test="cfn:validString(ComponentNames)" flag="ComponentNames">
				<value-of select="cfn:notNullMessage(.,'ComponentNames')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="System.ComponentNames.CrossReference" test="cfn:delimListInKeys(ComponentNames,'Component',/)" flag="ComponentNames">
				<value-of select="cfn:foreignKeyMessage(.,'ComponentNames','Component','Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Assemblies">
			<xsl:message terminate="no">Validating Assembly Worksheet</xsl:message>
		</iso:rule>
		<iso:rule context="//Assemblies/Assembly" id="COBie.Assemblies.Assembly" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:report id="Assembly.SheetName.Check" test="true()" flag="SheetName">SheetName.NotNull, SheetName.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Assembly.SheetName.NotNull" test="cfn:validString(SheetName)" flag="SheetName">
				<value-of select="cfn:notNullMessage(.,'SheetName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Assembly.SheetName.CrossReference" test="lower-case(SheetName)='component' or lower-case(SheetName)='type'" flag="SheetName">
				<value-of select="cfn:assertMsgPrefix(name(.),concat(@Name,',',SheetName,',',ParentName,',',ChildNames),'SheetName')"/>: SheetName may only be Component or type
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Assembly.ParentName.Check" test="true()" flag="ParentName">ParentName.NotNull, ParentName.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Assembly.ParentName.NotNull" test="cfn:validString(ParentName)" flag="ParentName">
				<value-of select="cfn:notNullMessage(.,'ParentName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Assembly.ParentName.Reference" test="cfn:keyMatch(SheetName,ParentName,/)" flag="ParentName">
				<value-of select="cfn:foreignKeyMessage(.,'ParentName',SheetName,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Assembly.ChildNames.Check" test="true()" flag="ChildNames">ChildNames.NotNull, ChildNames.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Assembly.ChildNames.NotNull" test="cfn:validString(ChildNames)" flag="ChildNames">
				<value-of select="cfn:notNullMessage(.,'ChildNames')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Assembly.ChildNames.CrossReference" test="cfn:delimListInKeys(ChildNames,SheetName,/)" flag="ChildNames">
				<value-of select="cfn:foreignKeyMessage(.,'ChildNames',SheetName,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Assembly.AssemblyType.Check" test="true()" flag="AssemblyType">AssemblyType.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Assembly.AssemblyType.NotNull" test="cfn:validString(AssemblyType)" flag="AssemblyType">
				<value-of select="cfn:notNullMessage(.,'AssemblyType')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Connections">
			<xsl:message terminate="no">Validating Connection Worksheet</xsl:message>
		</iso:rule>
		<iso:rule context="//Connections/Connection" id="COBie.Connections.Connection" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:report id="Connection.ConnectionType.Check" test="true()" flag="ConnectionType">ConnectionType.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Connection.ConnectionType.NotNull" test="cfn:validString(ConnectionType)" flag="ConnectionType">
				<value-of select="cfn:notNullMessage(.,'ConnectionType')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Connection.SheetName.Check" test="true()" flag="SheetName">SheetName.NotNull, SheetName.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Connection.SheetName.NotNull" test="cfn:validString(SheetName)" flag="SheetName">
				<value-of select="cfn:notNullMessage(.,'SheetName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Connection.SheetName.CrossReference" test="lower-case(SheetName)='type' or lower-case(SheetName)='component'" flag="SheetName">
				<value-of select="cfn:assertMsgPrefix(name(.),concat(@Name,',',ConnectionType,',',SheetName,',',RowName1,',',RowName2),'SheetName')"/>: SheetName must be Type or Component, <value-of select="SheetName"/> is not valid.<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Connection.RowName1.Check" test="true()" flag="RowName1">RowName1.NotNull, RowName1.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Connection.RowName1.NotNull" test="cfn:validString(RowName1)" flag="RowName1">
				<value-of select="cfn:notNullMessage(.,'RowName1')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Connection.RowName1.CrossReference" test="cfn:keyMatch(SheetName,RowName1,/)" flag="RowName1">
				<value-of select="cfn:foreignKeyMessage(.,'RowName1',SheetName,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Connection.RowName2.Check" test="true()" flag="RowName2">RowName2.NotNull, RowName2.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Connection.RowName2.NotNull" test="cfn:validString(RowName2)" flag="RowName2">
				<value-of select="cfn:notNullMessage(.,'RowName2')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Connection.RowName2.CrossReference" test="cfn:keyMatch(SheetName,RowName2,/)" flag="RowName2">
				<value-of select="cfn:foreignKeyMessage(.,'RowName2',SheetName,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Connection.RealizingElement.Check" test="true()" flag="RealizingElement">RealizingElement.NotEmpty, RealizingElement.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Connection.RealizingElement.NotEmpty" test="cfn:validStringOrNA(RealizingElement)" flag="RealizingElement">
				<value-of select="cfn:notEmptyMessage(.,'RealizingElement')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Connection.RealizingElement.CrossReference" test="cfn:keyMatch(SheetName,RealizingElement,/) or lower-case(RealizingElement)='n/a'" flag="RealizingElement">
				<value-of select="cfn:foreignKeyMessage(.,'RealizingElement',SheetName,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Connection.PortName1.Check" test="true()" flag="PortName1">PortName1.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Connection.PortName1.NotNull" test="cfn:validString(PortName1)" flag="PortName1">
				<value-of select="cfn:notNullMessage(.,'PortName1')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Connection.PortName2.Check" test="true()" flag="PortName2">PortName2.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Connection.PortName2.NotNull" test="cfn:validString(PortName2)" flag="PortName2">
				<value-of select="cfn:notNullMessage(.,'PortName2')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Spares">
			<xsl:message terminate="no">Validating Spare Worksheet</xsl:message>
		</iso:rule>
		<iso:rule context="//Spares/Spare" id="COBie.Spares.Spare" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:report id="Spare.Name.Check" test="true()" flag="Name">Name.NotNull<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Spare.Name.NotNull" test="cfn:validString(@Name)" flag="Name">
				<value-of select="cfn:notNullMessage(.,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Spare.PrimaryKey.Check" test="true()" flag="PrimaryKey">PrimaryKey.Unique (Name, TypeName)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Spare.PrimaryKey.Unique" test="cfn:isKeyUnique(.)" flag="PrimaryKey">
				<value-of select="cfn:uniqueNameMessage(.,'Name, TypeName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Spare.TypeName.Check" test="true()" flag="TypeName">TypeName.NotNull, TypeName.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Spare.TypeName.NotNull" test="cfn:validString(TypeName)" flag="TypeName">
				<value-of select="cfn:notNullMessage(.,'TypeName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Spare.TypeName.CrossReference" test="key('TypeKey',TypeName)" flag="TypeName">
				<value-of select="cfn:foreignKeyMessage(.,'TypeName','Type','Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Spare.Suppliers.Check" test="true()" flag="Suppliers">Suppliers.NotNull, Suppliers.CrossReference (Contact Sheet)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Spare.Suppliers.NotNull" test="cfn:validString(Suppliers)" flag="Suppliers">
				<value-of select="cfn:notNullMessage(.,'Suppliers')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Spare.Suppliers.CrossReference" test="cfn:delimListInKeys(Suppliers,'Contact',/)" flag="Suppliers">
				<value-of select="cfn:foreignKeyMessage(.,'Suppliers','Contact','Email')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Spare.SetNumber.Check" test="true()" flag="SetNumber">SetNumber.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Spare.SetNumber.NotEmpty" test="cfn:validStringOrNA(SetNumber)" flag="SetNumber">
				<value-of select="cfn:notEmptyMessage(.,'SetNumber')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Spare.PartNumber.Check" test="true()" flag="PartNumber">PartNumber.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Spare.PartNumber.NotEmpty" test="cfn:validStringOrNA(PartNumber)" flag="PartNumber">
				<value-of select="cfn:notEmptyMessage(.,'PartNumber')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Resources">
			<xsl:message terminate="no">Validating Resource Worksheet</xsl:message>
		</iso:rule>
		<iso:rule context="//Resources/Resource" id="COBie.Resources.Resource" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.Category"/>
		</iso:rule>
		<iso:rule context="//Jobs">
			<xsl:message terminate="no">Validating Job Worksheet</xsl:message>
		</iso:rule>
		<iso:rule context="//Jobs/Job" id="COBie.Jobs.Job" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:report id="Job.Name.Check" test="true()" flag="Name">Name.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.Name.NotNull" test="cfn:validString(@Name)" flag="Name">
				<value-of select="cfn:notNullMessage(.,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.PrimaryKey.Check" test="true()" flag="PrimaryKey">PrimaryKey.Unique (Name,TypeName,TaskNumber)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.PrimaryKey.Unique" test="cfn:isKeyUnique(.)" flag="PrimaryKey">
				<value-of select="cfn:uniqueNameMessage(.,'Name,TypeName,TaskNumber')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.Status.Check" test="true()" flag="Status">Status.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.Status.NotNull" test="cfn:validString(Status)" flag="Status">
				<value-of select="cfn:notNullMessage(.,'Status')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.TypeName.Check" test="true()" flag="TypeName">TypeName.NotNull, TypeName.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.TypeName.NotNull" test="cfn:validString(TypeName)" flag="TypeName">
				<value-of select="cfn:notNullMessage(.,'TypeName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Job.TypeName.CrossReference" test="key('TypeKey',TypeName)" flag="TypeName">
				<value-of select="cfn:foreignKeyMessage(.,'TypeName','Type','Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.Duration.Check" test="true()" flag="Duration">Duration.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.Duration.NotEmpty" test="cfn:validStringOrNA(Duration)" flag="Duration">
				<value-of select="cfn:notEmptyMessage(.,'Duration')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.DurationUnit.Check" test="true()" flag="DurationUnit">DurationUnit.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.DurationUnit.NotEmpty" test="cfn:validStringOrNA(DurationUnit)" flag="DurationUnit">
				<value-of select="cfn:notEmptyMessage(.,'DurationUnit')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.Start.Check" test="true()" flag="Start">Start.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.Start.NotEmpty" test="cfn:validStringOrNA(Start)" flag="Start">
				<value-of select="cfn:notEmptyMessage(.,'Start')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.TaskStartUnit.Check" test="true()" flag="TaskStartUnit">TaskStartUnit.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.TaskStartUnit.NotEmpty" test="cfn:validStringOrNA(TaskStartUnit)" flag="TaskStartUnit">
				<value-of select="cfn:notEmptyMessage(.,'TaskStartUnit')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.Frequency.Check" test="true()" flag="Frequency">Frequency.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.Frequency.NotEmpty" test="cfn:validStringOrNA(Frequency)" flag="Frequency">
				<value-of select="cfn:notEmptyMessage(.,'Frequency')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.FrequencyUnit.Check" test="true()" flag="FrequencyUnit">FrequencyUnit.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.FrequencyUnit.NotEmpty" test="cfn:validStringOrNA(FrequencyUnit)" flag="FrequencyUnit">
				<value-of select="cfn:notEmptyMessage(.,'FrequencyUnit')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.TaskNumber.Check" test="true()" flag="TaskNumber">TaskNumber.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.TaskNumber.NotEmpty" test="cfn:validStringOrNA(TaskNumber)" flag="TaskNumber">
				<value-of select="cfn:notEmptyMessage(.,'TaskNumber')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.Priors.Check" test="true()" flag="Priors">Priors.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.Priors.NotEmpty" test="cfn:validStringOrNA(Priors)" flag="Priors">
				<value-of select="cfn:notEmptyMessage(.,'Priors')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.ResourceNames.Check" test="true()" flag="ResourceNames">ResourceNames.NotEmpty, ResourceNames.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.ResourceNames.NotEmpty" test="cfn:validStringOrNA(ResourceNames)" flag="ResourceNames">
				<value-of select="cfn:notEmptyMessage(.,'ResourceNames')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Job.ResourceNames.CrossReference" test="ResourceNames='n/a' or cfn:delimListInKeys(ResourceNames,'Resource',/)" flag="ResourceNames">
				<value-of select="cfn:foreignKeyMessage(.,'ResourceNames','Resource','Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Documents">
			<xsl:message terminate="no">Validating Document Worksheet</xsl:message>
		</iso:rule>
		<iso:rule context="//Documents/Document" id="COBie.Documents.Document" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:report id="Document.PrimaryKey.Check" test="true()" flag="PrimaryKey">PrimaryKey.Unique (Name, Stage, SheetName, RowName)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Document.PrimaryKey.Unique" test="cfn:isDocumentKeyUnique(.)" flag="PrimaryKey">
				<value-of select="cfn:uniqueNameMessage(.,'Name,Stage,SheetName,RowName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Document.Name.Check" test="true()" flag="Name">Name.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Document.Name.NotNull" test="cfn:validString(@Name)" flag="Name">
				<value-of select="cfn:notNullMessage(.,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Document.ApprovalBy.Check" test="true()" flag="ApprovalBy">ApprovalBy.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Document.ApprovalBy.NotEmpty" test="cfn:validStringOrNA(ApprovalBy)" flag="ApprovalBy">
				<value-of select="cfn:notEmptyMessage(.,'ApprovalBy')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Document.Stage.Check" test="true()" flag="Stage">Stage.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Document.Stage.NotNull" test="cfn:validString(Stage)" flag="Stage">
				<value-of select="cfn:notNullMessage(.,'Stage')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Document.SheetName.Check" test="true()" flag="SheetName">SheetName.NotNull, SheetNameRowName.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Document.SheetName.NotNull" test="cfn:validString(SheetName)" flag="SheetName">
				<value-of select="cfn:notNullMessage(.,'SheetName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Document.SheetNameRowName.Reference" test="cfn:keyMatch(SheetName,RowName,/)" flag="RowName">
				<value-of select="cfn:foreignKeyMessage(.,'RowName',SheetName,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Document.RowName.Check" test="true()" flag="RowName">RowName.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Document.RowName.NotNull" test="cfn:validString(RowName)" flag="RowName">
				<value-of select="cfn:notNullMessage(.,'RowName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Document.Directory.Check" test="true()" flag="Directory">Directory.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Document.Directory.NotNull" test="cfn:validString(Directory)" flag="Directory">
				<value-of select="cfn:notNullMessage(.,'Directory')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Document.File.Check" test="true()" flag="File">File.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Document.File.NotNull" test="cfn:validString(File)" flag="File">
				<value-of select="cfn:notNullMessage(.,'File')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Document.Reference.Check" test="true()" flag="Reference">Reference.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Document.Reference.NotEmpty" test="cfn:validStringOrNA(Reference)" flag="Reference">
				<value-of select="cfn:notEmptyMessage(.,'Reference')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Attributes">
			<iso:report test="true()">
				<xsl:message terminate="no">Validating Attribute Worksheet</xsl:message>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
		</iso:rule>
		<iso:rule context="//Attributes/Attribute" id="COBie.Attributes.Attribute" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:report id="Attribute.PrimaryKey.Check" test="true()" flag="PrimaryKey">PrimaryKey.Unique (Name, SheetName, RowName) 
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Attribute.PrimaryKey.Unique" test="cfn:isAttributeKeyUnique(.)" flag="PrimaryKey">
				<value-of select="cfn:uniqueNameMessage(.,'Name,SheetName,RowName,Category')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Attribute.Name.Check" test="true()" flag="Name">Name.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Attribute.Name.NotNull" test="cfn:validString(@Name)" flag="Name">
				<value-of select="cfn:notNullMessage(.,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Attribute.SheetNameRowName.Check" test="true()" flag="SheetNameRowName">SheetNameRowName.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Attribute.SheetNameRowName.CrossReference" test="cfn:keyMatch(SheetName,RowName,/)" flag="RowName">
				<value-of select="cfn:foreignKeyMessage(.,'RowName',SheetName,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Attribute.Value.Check" test="true()" flag="Value">Value.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Attribute.Value.NotEmpty" test="cfn:validStringOrNA(Value)" flag="Value">
				<value-of select="cfn:notEmptyMessage(.,'Value')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Attribute.Unit.Check" test="true()" flag="Unit">Unit.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Attribute.Unit.NotEmpty" test="cfn:validStringOrNA(Unit)" flag="Unit">
				<value-of select="cfn:notEmptyMessage(.,'Unit')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Attribute.AllowedValues.Check" test="true()" flag="AllowedValues">AllowedValues.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Attribute.AllowedValues.NotEmpty" test="cfn:validStringOrNA(AllowedValues)" flag="AllowedValues">
				<value-of select="cfn:notEmptyMessage(.,'AllowedValues')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
	</iso:pattern>
	<iso:pattern id="Design.COBieValidation.Errors">
		<iso:title>COBie Checking Rules</iso:title>
		<iso:rule abstract="true" id="COBie.Abstract.Name" role="WorksheetErrors">
			<iso:report id="Common.Name.Check" test="true()" flag="Name">Name.NotNotNull, Name.Unique<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Common.Name.NotNull" test="cfn:validString(@Name)" flag="Name">
				<value-of select="cfn:notNullMessage(.,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Common.Name.Unique" test="cfn:isKeyUnique(.)" flag="Name">
				<value-of select="cfn:uniqueNameMessage(.,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule abstract="true" id="COBie.Abstract.Created" role="WorksheetErrors">
			<iso:report id="Common.CreatedBy.Check" test="true()" flag="CreatedBy">CreatedBy.CrossReference (ToContact), CreatedBy.NotNull<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Common.CreatedBy.CrossReference" test="key('ContactKey',CreatedBy)" flag="CreatedBy">
				<value-of select="cfn:foreignKeyMessage(.,'CreatedBy','Contact','Email')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Common.CreatedBy.NotNull" test="cfn:validString(CreatedBy)" flag="CreatedBy">
				<value-of select="cfn:notNullMessage(.,'CreatedBy')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Common.CreatedOn.Check" test="true()" flag="CreatedOn">CreatedOn.NotNull, CreatedOn.Valid (Valid ISO DateTime)<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Common.CreatedOn.NotNull" test="cfn:validString(CreatedOn)" flag="CreatedOn">
				<value-of select="cfn:notNullMessage(.,'CreatedOn')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Common.CreatedOn.Valid" test="cfn:validDateTime(CreatedOn)" flag="CreatedOn">
				<value-of select="cfn:dateTimeFormatMessage(.,'CreatedOn')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule abstract="true" id="COBie.Abstract.External" role="WorksheetErrors">
			<iso:report id="Common.ExternalSystem.Check" test="true()" flag="ExtSystem">ExternalSystem.NotEmpty<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Common.ExternalSystem.NotEmpty" test="cfn:validStringOrNA(ExtSystem)" flag="ExtSystem">
				<value-of select="cfn:notEmptyMessage(.,'ExtSystem')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Common.ExternalObject.Check" test="true()" flag="ExtObject">ExternalObject.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Common.External.ObjectNotEmpty" test="cfn:validStringOrNA(ExtObject)" flag="ExtObject">
				<value-of select="cfn:notEmptyMessage(.,'ExtObject')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Common.ExternalIdentifier.Check" test="true()" flag="ExtIdentifier">ExtIdentifier.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Common.ExternalIdentifier.NotEmpty" test="cfn:validStringOrNA(ExtIdentifier)" flag="ExtIdentifier">
				<value-of select="cfn:notEmptyMessage(.,'ExtIdentifier')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule abstract="true" id="COBie.Abstract.Category" role="WorksheetErrors">
			<iso:report id="Common.Category.Check" test="true()" flag="Category">Category.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Common.Category.NotNull" test="cfn:validString(Category)" flag="Category">
				<value-of select="cfn:notNullMessage(.,'Category')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule abstract="true" id="COBie.Abstract.Description" role="WorksheetErrors">
			<iso:report id="Common.Description.Check" test="true()" flag="Description">Description.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Common.Description.NotEmpty" test="cfn:validStringOrNA(Description)" flag="Description">
				<value-of select="cfn:notEmptyMessage(.,'Description')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Contacts" id="COBie.Contacts" role="WorksheetErrors">
			<xsl:message terminate="no">Validating Contact Worksheet</xsl:message>
			<iso:report id="Contact.Count.Check" test="true()" flag="ContactSheet">Contacts.AtLeastOneRowPresent
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contacts.AtLeastOneRowPresent" test="Contact" flag="ContactSheet">
				<value-of select="cfn:atLeastOneMessage('Contact','Contacts')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Contacts/Contact" id="COBie.Contacts.Contact" role="WorksheetErrors">
			<iso:report id="Contact.Email.Check" test="true()" flag="Email">Email.Unique, Email.NotNull, Email.Format
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.Email.Unique" test="cfn:isKeyUnique(.)" flag="Email">
				<value-of select="cfn:uniqueNameMessage(.,'Email')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Contact.Email.NotNull" test="cfn:validString(Email)" flag="Email">
				<value-of select="cfn:notNullMessage(.,'Email')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Contact.Email.Format" test="cfn:validEmail(Email)" flag="Email">
				<value-of select="cfn:assertMsgPrefix(name(.),Email,'Email')"/> must be a valid e-mail format (XXX@YYY.ZZZ)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.CreatedBy.Check" test="true()" flag="CreatedBy">CreatedBy.CrossReference, CreatedBy.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.CreatedBy.CrossReference" test="key('ContactKey',CreatedBy)" flag="CreatedBy">
				<value-of select="cfn:foreignKeyMessage(.,'CreatedBy','Contact','Email')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Contact.CreatedBy.NotNull" test="cfn:validString(CreatedBy)" flag="CreatedBy">
				<value-of select="cfn:notNullMessage(.,'CreatedBy')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.CreatedOn.Check" test="true()" flag="CreatedOn">CreatedOn.NotNull, CreatedOn.Valid (ISO DateTime)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.CreatedOn.NotNull" test="cfn:validString(CreatedOn)" flag="CreatedOn">
				<value-of select="cfn:notNullMessage(.,'CreatedOn')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Contact.CreatedOn.Valid" test="cfn:validDateTime(CreatedOn)" flag="CreatedOn">
				<value-of select="cfn:dateTimeFormatMessage(.,'CreatedOn')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.ExternalSystem.Check" test="true()" flag="ExternalSystem">ExternalSystem.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="ExternalSystem.NotEmpty" test="cfn:validStringOrNA(ExternalSystem) or cfn:validStringOrNA(ExtSystem)" flag="ExternalSystem">
				<value-of select="cfn:notEmptyMessage(.,'ExternalSystem')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.ExternalObject.Check" test="true()" flag="ExternalObject">ExternalObject.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.ExternalObject.NotEmpty" test="cfn:validStringOrNA(ExternalObject) or cfn:validStringOrNA(ExtObject)" flag="ExternalObject">
				<value-of select="cfn:notEmptyMessage(.,'ExternalObject')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.ExternalIdentifier.Check" test="true()" flag="ExternalIdentifier">ExternalIdentifier.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.ExternalIdentifier.NotEmpty" test="cfn:validStringOrNA(ExternalIdentifier) or cfn:validStringOrNA(ExtIdentifier)" flag="ExternalIdentifier">
				<value-of select="cfn:notEmptyMessage(.,'ExternalIdentifier')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.Category.Check" test="true()" flag="Category">Category.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.Category.NotNull" test="cfn:validString(Category)" flag="Category">
				<value-of select="cfn:notNullMessage(.,'Category')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.Company.Check" test="true()" flag="Company">Company.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.Company.NotNull" test="cfn:validString(Company)" flag="Company">
				<value-of select="cfn:assertMsgPrefix(name(.),Email,'Company')"/>  must be provided (n/a is not acceptable)<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.Phone.Check" test="true()" flag="Phone">Phone.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.Phone.NotNull" test="cfn:validString(Phone)" flag="Phone">
				<value-of select="cfn:notNullMessage(.,'Phone')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.Department.Check" test="true()" flag="Department">Department.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.Department.NotEmpty" test="cfn:validStringOrNA(Department)" flag="Department">
				<value-of select="cfn:notEmptyMessage(.,'Department')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.OrganizationCode.Check" test="true()" flag="OrganizationCode">OrganizationCode.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.OrganizationCode.NotEmpty" test="cfn:validStringOrNA(OrganizationCode)" flag="OrganizationCode">
				<value-of select="cfn:notEmptyMessage(.,'OrganizationCode')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.GivenName.Check" test="true()" flag="GivenName">GivenName.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.GivenName.NotEmpty" test="cfn:validStringOrNA(GivenName)" flag="GivenName">
				<value-of select="cfn:notEmptyMessage(.,'GivenName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.FamilyName.Check" test="true()" flag="FamilyName">FamilyName.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.FamilyName.NotEmpty" test="cfn:validStringOrNA(FamilyName)" flag="FamilyName">
				<value-of select="cfn:notEmptyMessage(.,'FamilyName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.Street.Check" test="true()" flag="Street">Street.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.Street.NotEmpty" test="cfn:validStringOrNA(Street)" flag="Street">
				<value-of select="cfn:notEmptyMessage(.,'Street')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.PostalBox.Check" test="true()" flag="PostalBox">PostalBox.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.PostalBox.NotEmpty" test="cfn:validStringOrNA(PostalBox)" flag="PostalBox">
				<value-of select="cfn:notEmptyMessage(.,'PostalBox')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.Town.Check" test="true()" flag="Town">Town.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.Town.NotEmpty" test="cfn:validStringOrNA(Town)" flag="Town">
				<value-of select="cfn:notEmptyMessage(.,'Town')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.StateRegion.Check" test="true()" flag="StateRegion">StateRegion.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.StateRegion.NotEmpty" test="cfn:validStringOrNA(StateRegion)" flag="StateRegion">
				<value-of select="cfn:notEmptyMessage(.,'StateRegion')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.PostalCode.Check" test="true()" flag="PostalCode">PostalCode.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.PostalCode.NotEmpty" test="cfn:validStringOrNA(PostalCode)" flag="PostalCode">
				<value-of select="cfn:notEmptyMessage(.,'PostalCode')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Contact.Country.Check" test="true()" flag="Country">Country.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Contact.Country.NotEmpty" test="cfn:validStringOrNA(Country)" flag="Country">
				<value-of select="cfn:notEmptyMessage(.,'Country')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Facilities" id="COBie.Facilities" role="WorksheetErrors">
			<xsl:message terminate="no">Validating Facility Worksheet</xsl:message>
			<iso:report id="Facilities.AtLeastOne.Check" test="true()" flag="FacilitySheet">Facilities.OneAndOnlyOneFacilityFound
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facilites.OneAndOnlyOneFacilityFound" test="count(Facility)=1" flag="FacilitySheet">
				<value-of select="cfn:onlyOneMessage('Facility','Facilities')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Facilities/Facility" id="COBie.Facilities.Facility" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:report id="Facility.ProjectName.Check" test="true()" flag="ProjectName">ProjectName.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.ProjectName.NotNull" test="cfn:validString(ProjectName)" flag="ProjectName">
				<value-of select="cfn:notNullMessage(.,'ProjectName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Facility.SiteName.Check" test="true()" flag="SiteName">SiteName.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.SiteName.NotNull" test="cfn:validString(SiteName)" flag="SiteName">
				<value-of select="cfn:notNullMessage(.,'SiteName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Facility.LinearUnits.Check" test="true()" flag="LinearUnits">LinearUnits.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.LinearUnits.NotNull" test="cfn:validString(LinearUnits)" flag="LinearUnits">
				<value-of select="cfn:notNullMessage(.,'LinearUnits')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<!-- TODO Insert LinearUnits Picklist assert -->
			<iso:report id="Facility.AreaUnits.Check" test="true()" flag="AreaUnits">AreaUnits.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.AreaUnits.NotNull" test="cfn:validString(AreaUnits)" flag="AreaUnits">
				<value-of select="cfn:notNullMessage(.,'AreaUnits')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<!--TODO Insert AreaUnits Picklist assert -->
			<iso:report id="Facility.VolumeUnits.Check" test="true()" flag="VolumeUnits">VolumeUnits.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.VolumeUnits.NotNull" test="cfn:validString(VolumeUnits)" flag="VolumeUnits">
				<value-of select="cfn:notNullMessage(.,'VolumeUnits')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<!-- TODO Insert VolumeUnits Picklist assert -->
			<iso:report id="Facility.CurrencyUnit.Check" test="true()" flag="CurrencyUnit">Currency.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.Currency.NotNull" test="cfn:validString(CurrencyUnit)" flag="CurrencyUnit">
				<value-of select="cfn:notNullMessage(.,'CurrencyUnit')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<!-- TODO Currency Unit Picklist -->
			<iso:report id="Facility.AreaMeasurement.Check" test="true()" flag="AreaMeasurement">AreaMeasurement.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.AreaMeasurement.NotNull" test="cfn:validString(AreaMeasurement)" flag="AreaMeasurement">
				<value-of select="cfn:notNullMessage(.,'AreaMeasurement')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Facility.ExternalSystem.Check" test="true()" flag="ExternalSystem">ExternalSystem.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.ExternalSystem.NotEmpty" test="cfn:validStringOrNA(ExternalSystem)" flag="ExternalSystem">
				<value-of select="cfn:notEmptyMessage(.,'ExternalSystem')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Facility.ExternalProjectObject.Check" test="true()" flag="ExternalProjectObject">ExternalProjectObject.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.ExternalProjectObject.NotEmpty" test="cfn:validStringOrNA(ExternalProjectObject)" flag="ExternalProjectObject">
				<value-of select="cfn:notEmptyMessage(.,'ExternalProjectObject')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Facility.ExternalProjectIdentifier.Check" test="true()" flag="ExternalProjectIdentifier">ExternalProjectIdentifier.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.ProjectIdentifier.NotEmpty" test="cfn:validStringOrNA(ExternalProjectIdentifier)" flag="ExternalProjectIdentifier">
				<value-of select="cfn:notEmptyMessage(.,'ExternalProjectIdentifier')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Facility.ExternalSiteObject.Check" test="true()" flag="ExternalSiteObject">ExternalSiteObject.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.ExternalSiteObject.NotEmpty" test="cfn:validStringOrNA(ExternalSiteObject)" flag="ExternalSiteObject">
				<value-of select="cfn:notEmptyMessage(.,'ExternalSiteObject')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Facility.ExternalSiteIdentifier.Check" test="true()" flag="ExternalSiteIdentifier">ExternalSiteIdentifier.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.ExternalSiteIdentifier.NotEmpty" test="cfn:validStringOrNA(ExternalSiteIdentifier)" flag="ExternalSiteIdentifier">
				<value-of select="cfn:notEmptyMessage(.,'ExternalSiteIdentifier')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Facility.ExternalFacilityObject.Check" test="true()" flag="ExternalFacilityObject">ExternalFacilityObject.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="FacilityExternalFacilityObjectNotEmpty" test="cfn:validStringOrNA(ExternalFacilityObject)" flag="ExternalFacilityObject">
				<value-of select="cfn:notEmptyMessage(.,'ExternalFacilityObject')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Facility.ExternalFacilityIdentifier.Check" test="true()" flag="ExternalFacilityIdentifier">ExternalFacilityIdentifier.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Facility.ExternalFacilityIdentifier.NotEmpty" test="cfn:validStringOrNA(ExternalFacilityIdentifier)" flag="ExternalFacilityIdentifier">
				<value-of select="cfn:notEmptyMessage(.,'ExternalFacilityIdentifier')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Floors" id="COBie.Floors" role="WorksheetErrors">
			<xsl:message terminate="no">Validating Floor Worksheet</xsl:message>
			<iso:report id="Floor.Count.Check" test="true()" flag="FloorSheet">Floors.AtLeastOneRowPresent
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Floors.AtLeastOneRowPresent" test="Floor">
				<cfn:value-of select="cfn:atLeastOneMessage('Floor','Floors')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Floors/Floor" id="COBie.Floors.Floor" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:report id="Floor.Elevation.Check" test="true()" flag="Elevation">Floor.Elevation.ValidNumberOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Floor.Elevation.ValidNumberOrNA" test="cfn:validNumber(Elevation)" flag="Elevation">
				<value-of select="cfn:notEmptyNumberMessage(.,'Elevation')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Floor.Height.Check" test="true()" flag="Height">Floor.Height.ZeroOrGreaterOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Floor.Height.ZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(Height)" flag="Height">
				<value-of select="cfn:notEmptyNumberMessage(.,'Height')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Spaces" id="COBie.Spaces" role="WorksheetErrors">
			<xsl:message terminate="no">Validating Space Worksheet</xsl:message>
			<iso:report id="Space.Count.Check" test="true()" flag="SpaceSheet">Spaces.AtLeastOneRowPresent
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Spaces.AtLeastOneRowPresent" test="Space">
				<name/> must have at least one entry<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Spaces/Space" id="COBie.Spaces.Space" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:report id="Space.FloorName.Check" test="true()" flag="FloorName">FloorName.NotNull, FloorName.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Space.FloorName.NotNull" test="cfn:validString(FloorName)" flag="FloorName">
				<value-of select="cfn:notNullMessage(.,'FloorName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Space.FloorName.CrossReference" test="key('FloorKey',FloorName)" flag="FloorName">
				<value-of select="cfn:foreignKeyMessage(.,'FloorName','Floor','Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Space.Description.Check" test="true()" flag="Description">Description.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Space.Description.NotNull" test="cfn:validString(Description)" flag="Description">
				<value-of select="cfn:notNullMessage(.,'Description')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Space.RoomTag.Check" test="true()" flag="RoomTag">RoomTag.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Space.RoomTag.NotEmpty" test="cfn:validStringOrNA(RoomTag)" flag="RoomTag">
				<value-of select="cfn:notEmptyMessage(.,'RoomTag')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Space.UsableHeight.Check" test="true()" flag="UsableHeight">UsableHeight.ZeroOrGreaterOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Space.UsableHeight.ZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(UsableHeight)" flag="UsableHeight">
				<value-of select="cfn:notEmptyNumberMessage(.,'UsableHeight')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Space.GrossArea.Check" test="true()" flag="GrossArea">GrossArea.ZeroOrGreaterOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Space.GrossArea.ZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(GrossArea)" flag="GrossArea">
				<value-of select="cfn:notEmptyNumberMessage(.,'GrossArea')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Space.NetArea.Check" test="true()" flag="NetArea">NetArea.ZeroOrGreaterOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Space.NetArea.ZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(NetArea)" flag="NetArea">
				<value-of select="cfn:notEmptyNumberMessage(.,'NetArea')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Zones">
			<xsl:message terminate="no">Validating Zone Worksheet</xsl:message>
		</iso:rule>
		<iso:rule context="//Zones/Zone" id="COBie.Zones.Zone" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:report id="Zone.Name.Check" test="true()" flag="Name">Name.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Zone.Name.NotNull" test="cfn:validString(@Name)" flag="Name">
				<value-of select="cfn:notNullMessage(.,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Zone.PrimaryKey.Check" test="true()" flag="PrimaryKey"> PrimaryKey.Unique (Name, Category, SpaceNames)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Zone.PrimaryKey.Unique" test="cfn:isKeyUnique(.)" flag="PrimaryKey">
				<value-of select="cfn:uniqueNameMessage(.,'Name,Category,SpaceNames')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Zone.SpaceNames.Check" test="true()" flag="SpaceNames">SpaceNames.NotNull, SpaceNames.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Zone.SpaceNames.NotNull" test="cfn:validString(SpaceNames)" flag="SpaceNames">
				<value-of select="cfn:notNullMessage(.,'SpaceNames')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Zone.SpaceNames.CrossReference" test="cfn:delimListInKeys(SpaceNames,'Space',/)" flag="SpaceNames">
				<value-of select="cfn:foreignKeysMessage(.,'SpaceNames','Space','Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Types" id="COBie.Types" role="WorksheetErrors">
			<xsl:message terminate="no">Validating Type Worksheet</xsl:message>
			<iso:report id="Type.Count.Check" test="true()" flag="TypeSheet">Types.AtLeastOneRowPresent
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Types.AtLeastOneRowPresent" test="Type">
				<name/>:  At least one Type must be provided<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Types/Type" id="COBie.Types.Type" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:report id="Type.ComponentCount.Check" test="true()" flag="TypeComponentSheets">Type.Component.AComponentForEachType
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Component.AComponentForEachType" test="some $comp in ../../Components/Component satisfies ($comp/TypeName=@Name)" flag="Name">
				<name/>.<value-of select="@Name"/>: All Types must have at least one associated Component
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.AssetType.Check" test="true()" flag="AssetType">AssetType.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.AssetType.NotNull" test="cfn:validString(AssetType)" flag="AssetType">
				<value-of select="cfn:notNullMessage(.,'AssetType')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.Manufacturer.Check" test="true()" flag="Manufacturer">Manufacturer.CrossReferenceOrNA(Contact Sheet)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Manufacturer.CrossReferenceOrNA" test="key('ContactKey',Manufacturer) or Manufacturer='n/a'" flag="Manufacturer">
				<value-of select="cfn:foreignKeyMessage(.,'Manufacturer','Contact','Email')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.ModelNumber.Check" test="true()" flag="ModelNumber">ModelNumber.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.ModelNumber.NotEmpty" test="cfn:validStringOrNA(ModelNumber)" flag="ModelNumber">
				<value-of select="cfn:notEmptyMessage(.,'ModelNumber')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.WarrantyGuarantorParts.Check" test="true()" flag="WarrantyGuarantorParts">WarrantyGuarantorParts.CrossReferenceOrNA (Contact Sheet)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.WarrantyGuarantorParts.CrossReferenceOrNA" test="key('ContactKey',WarrantyGuarantorParts) or WarrantyGuarantorParts='n/a'" flag="WarrantyGuarantorParts">
				<value-of select="cfn:foreignKeyMessage(.,'WarrantyGuarantorParts','Contact','Email')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.WarrantyDurationParts.Check" test="true()" flag="WarrantyDurationParts">WarrantyDurationParts.validNumberZeroOrGreaterOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.WarrantyDurationParts.validNumberZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(WarrantyDurationParts)" flag="WarrantyDurationParts">
				<value-of select="cfn:notEmptyNumberMessage(.,'WarrantyDurationParts')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.WarrantyGuarantorLabor.Check" test="true()" flag="WarrantyGuarantorLabor">WarrantyGuarantorLabor.CrossReferenceOrNA (Contact Sheet)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.WarrantyGuarantorLabor.CrossReferenceOrNA" test="key('ContactKey',WarrantyGuarantorLabor) or WarrantyGuarantorLabor='n/a'" flag="WarrantyGuarantorLabor">
				<value-of select="cfn:foreignKeyMessage(.,'WarrantyGuarantorLabor,','Contact','Email')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.WarrantyDurationLabor.Check" test="true()" flag="WarrantyDurationLabor">WarrantyDurationLabor.ZeroOrGreaterOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.WarrantyDurationLabor.ZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(WarrantyDurationLabor)" flag="WarrantyDurationLabor">
				<value-of select="cfn:notEmptyNumberMessage(.,'WarrantyDurationLabor')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.WarrantyDurationUnit.Check" test="true()" flag="WarrantyDurationUnit">WarrantyDurationUnit.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.WarrantyDurationUnit.NotEmpty" test="cfn:validStringOrNA(WarrantyDurationUnit)" flag="WarrantyDurationUnit">
				<value-of select="cfn:notEmptyMessage(.,'WarrantyDurationUnit')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.ReplacementCost.Check" test="true()" flag="ReplacementCost">ReplacementCost.ZeroOrGreaterOrNAr
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.ReplacementCost.ZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(ReplacementCost)" flag="ReplacementCost">
				<value-of select="cfn:notEmptyNumberMessage(.,'ReplacementCost')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.ExpectedLife.Check" test="true()" flag="ExpectedLife">ExpectedLife.ZeroOrGreaterOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.ExpectedLife.ZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(ExpectedLife)" flag="ExpectedLife">
				<value-of select="cfn:notEmptyNumberMessage(.,'ExpectedLife')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.DurationUnit.Check" test="true()" flag="DurationUnit">DurationUnit.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.DurationUnit.NotEmpty" test="cfn:validStringOrNA(DurationUnit)" flag="DurationUnit">
				<value-of select="cfn:notEmptyMessage(.,'DurationUnit')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.WarrantyDescription.Check" test="true()" flag="WarrantyDescription">WarrantyDescription.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.WarrantyDescription.NotEmpty" test="cfn:validStringOrNA(WarrantyDescription)" flag="WarrantyDescription">
				<value-of select="cfn:notEmptyMessage(.,'WarrantyDescription')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.NominalLength.Check" test="true()" flag="NominalLength">NominalLength.ZeroOrGreaterOrNA
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.NominalLength.ZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(NominalLength)" flag="NominalLength">
				<value-of select="cfn:notEmptyNumberMessage(.,'NominalLength')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.NominalWidth.Check" test="true()" flag="NominalWidth">NominalWidth.ZeroOrGreaterOrNA"
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.NominalWidth.ZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(NominalWidth)" flag="NominalWidth">
				<value-of select="cfn:notEmptyNumberMessage(.,'NominalWidth')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.NominalHeight.Check" test="true()" flag="NominalHeight">NominalHeight.ZeroOrGreater
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.NominalHeight.ZeroOrGreaterOrNA" test="cfn:validNumberZeroOrGreater(NominalHeight)" flag="NominalHeight">
				<value-of select="cfn:notEmptyNumberMessage(.,'NominalHeight')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.ModelReference.Check" test="true()" flag="ModelReference">ModelReference.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.ModelReference.NotEmpty" test="cfn:validStringOrNA(ModelReference)" flag="ModelReference">
				<value-of select="cfn:notEmptyMessage(.,'ModelReference')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.Shape.Check" test="true()" flag="Shape">Shape.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Shape.NotEmpty" test="cfn:validStringOrNA(Shape)" flag="Shape">
				<value-of select="cfn:notEmptyMessage(.,'Shape')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.Size.Check" test="true()" flag="Size">Size.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Size.NotEmpty" test="cfn:validStringOrNA(Size)" flag="Size">
				<value-of select="cfn:notEmptyMessage(.,'Size')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.Color.Check" test="true()" flag="Color">Color.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Color.NotEmpty" test="cfn:validStringOrNA(Color)" flag="Color">
				<value-of select="cfn:notEmptyMessage(.,'Color')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.Finish.Check" test="true()" flag="Finish">Finish.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Finish.NotEmpty" test="cfn:validStringOrNA(Finish)" flag="Finish">
				<value-of select="cfn:notEmptyMessage(.,'Finish')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.Grade.Check" test="true()" flag="Grade">Grade.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Grade.NotEmpty" test="cfn:validStringOrNA(Grade)" flag="Grade">
				<value-of select="cfn:notEmptyMessage(.,'Grade')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.Material.Check" test="true()" flag="Material">Material.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Material.NotEmpty" test="cfn:validStringOrNA(Material)" flag="Material">
				<value-of select="cfn:notEmptyMessage(.,'Material')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.Constituents.Check" test="true()" flag="Constituents">Constituents.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Constituents.NotEmpty" test="cfn:validStringOrNA(Constituents)" flag="Constituents">
				<value-of select="cfn:notEmptyMessage(.,'Constituents')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.Features.Check" test="true()" flag="Features">Features.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.Features.NotEmpty" test="cfn:validStringOrNA(Features)" flag="Features">
				<value-of select="cfn:notEmptyMessage(.,'Features')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.AccessibilityPerformance.Check" test="true()" flag="AccessibilityPerformance">AccessibilityPerformance.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.AccessibilityPerformance.NotEmpty" test="cfn:validStringOrNA(AccessibilityPerformance)" flag="AccessibilityPerformance">
				<value-of select="cfn:notEmptyMessage(.,'AccessibilityPerformance')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.CodePerformance.Check" test="true()" flag="CodePerformance">CodePerformance.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.CodePerformance.NotEmpty" test="cfn:validStringOrNA(CodePerformance)" flag="CodePerformance">
				<value-of select="cfn:notEmptyMessage(.,'CodePerformance')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Type.SustainabilityPerformance.Check" test="true()" flag="SustainabilityPerformance">SustainabilityPerformance.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Type.SustainabilityPerformance.NotEmpty" test="cfn:validStringOrNA(SustainabilityPerformance)" flag="SustainabilityPerformance">
				<value-of select="cfn:notEmptyMessage(.,'SustainabilityPerformance')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Components" id="COBie.Components" role="WorksheetErrors">
			<xsl:message terminate="no">Validating Component Worksheet</xsl:message>
			<iso:report id="Component.Count.Check" test="true()" flag="ComponentSheet">Components.AtLeastOneRowPresent
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Components.AtLeastOneRowPresent" test="Component">
				<name/>:  at least one Component must be provided.<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Components/Component" id="COBie.Components.Component" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:report id="Component.TypeName.Check" test="true()" flag="TypeName">TypeName.NotNull, TypeName.CrossReference (Type Worksheet)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Component.TypeName.NotNull" test="cfn:validString(TypeName)" flag="TypeName">
				<value-of select="cfn:notNullMessage(.,'TypeName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Component.TypeName.CrossReference" test="key('TypeKey',TypeName)" flag="TypeName">
				<value-of select="cfn:foreignKeyMessage(.,'TypeName','Type','Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Component.Space.Check" test="true()" flag="Space">Space.NotNull, Space.CrossReference (Component Worksheet)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Component.Space.NotNull" test="cfn:validString(Space)" flag="Space">
				<value-of select="cfn:notNullMessage(.,'Space')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Component.Space.CrossReference" test="cfn:componentSpaceKeyMatch(Space,ExtObject,/,.)" flag="Space">
				<value-of select="cfn:componentSpaceForeignKeyMessage(.,'Space','Space','Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Component.Description.Check" test="true()" flag="Description">Description.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Component.Description.NotNull" test="cfn:validString(Description)" flag="Description">
				<value-of select="cfn:notNullMessage(.,'Description')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Component.SerialNumber.Check" test="true()" flag="SerialNumber">SerialNumber.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Component.SerialNumber.NotEmpty" test="cfn:validStringOrNA(SerialNumber)" flag="SerialNumber">
				<value-of select="cfn:notEmptyMessage(.,'SerialNumber')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Component.InstallationDate.Check" test="true()" flag="InstallationDate">InstallationDate.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Component.InstallationDate.NotEmpty" test="cfn:validStringOrNA(InstallationDate)" flag="InstallationDate">
				<value-of select="cfn:notEmptyMessage(.,'InstallationDate')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Component.WarrantyStartDate.Check" test="true()" flag="WarrantyStartDate">WarrantyStartDate.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Component.WarrantyStartDate.NotEmpty" test="cfn:validStringOrNA(WarrantyStartDate)" flag="WarrantyStartDate">
				<value-of select="cfn:notEmptyMessage(.,'WarrantyStartDate')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Component.TagNumber.Check" test="true()" flag="TagNumber">TagNumber.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Component.TagNumber.NotEmpty" test="cfn:validStringOrNA(TagNumber)" flag="TagNumber">
				<value-of select="cfn:notEmptyMessage(.,'TagNumber')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Component.BarCode.Check" test="true()" flag="BarCode">BarCode.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Component.BarCode.NotEmpty" test="cfn:validStringOrNA(BarCode)" flag="BarCode">
				<value-of select="cfn:notEmptyMessage(.,'BarCode')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Component.AssetIdentifier.Check" test="true()" flag="AssetIdentifier">AssetIdentifier.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Component.AssetIdentifier.NotEmpty" test="cfn:validStringOrNA(AssetIdentifier)" flag="AssetIdentifier">
				<value-of select="cfn:notEmptyMessage(.,'AssetIdentifier')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Systems">
			<xsl:message terminate="no">Validating System Worksheet</xsl:message>
		</iso:rule>
		<iso:rule context="//Systems/System" id="COBie.Systems.System" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:report id="System.PrimaryKey.Check" test="true()" flag="PrimaryKey">PrimaryKey.Unique (Name, Category, ComponentNames)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="System.PrimaryKey.Unique" test="cfn:isKeyUnique(.)" flag="PrimaryKey">
				<value-of select="cfn:uniqueNameMessage(.,'Name,Category,ComponentNames')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="System.Name.Check" test="true()" flag="Name"> Name.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="System.Name.NotNull" test="cfn:validString(@Name)" flag="Name">
				<value-of select="cfn:notNullMessage(.,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="System.ComponentNames.Check" test="true()" flag="ComponentNames">ComponentNames.NotNull, ComponentNames.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="System.ComponentNames.NotNull" test="cfn:validString(ComponentNames)" flag="ComponentNames">
				<value-of select="cfn:notNullMessage(.,'ComponentNames')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="System.ComponentNames.CrossReference" test="cfn:delimListInKeys(ComponentNames,'Component',/)" flag="ComponentNames">
				<value-of select="cfn:foreignKeyMessage(.,'ComponentNames','Component','Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Assemblies">
			<xsl:message terminate="no">Validating Assembly Worksheet</xsl:message>
		</iso:rule>
		<iso:rule context="//Assemblies/Assembly" id="COBie.Assemblies.Assembly" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:report id="Assembly.SheetName.Check" test="true()" flag="SheetName">SheetName.NotNull, SheetName.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Assembly.SheetName.NotNull" test="cfn:validString(SheetName)" flag="SheetName">
				<value-of select="cfn:notNullMessage(.,'SheetName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Assembly.SheetName.CrossReference" test="lower-case(SheetName)='component' or lower-case(SheetName)='type'" flag="SheetName">
				<value-of select="cfn:assertMsgPrefix(name(.),concat(@Name,',',SheetName,',',ParentName,',',ChildNames),'SheetName')"/>: SheetName may only be Component or type
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Assembly.ParentName.Check" test="true()" flag="ParentName">ParentName.NotNull, ParentName.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Assembly.ParentName.NotNull" test="cfn:validString(ParentName)" flag="ParentName">
				<value-of select="cfn:notNullMessage(.,'ParentName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Assembly.ParentName.Reference" test="cfn:keyMatch(SheetName,ParentName,/)" flag="ParentName">
				<value-of select="cfn:foreignKeyMessage(.,'ParentName',SheetName,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Assembly.ChildNames.Check" test="true()" flag="ChildNames">ChildNames.NotNull, ChildNames.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Assembly.ChildNames.NotNull" test="cfn:validString(ChildNames)" flag="ChildNames">
				<value-of select="cfn:notNullMessage(.,'ChildNames')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Assembly.ChildNames.CrossReference" test="cfn:delimListInKeys(ChildNames,SheetName,/)" flag="ChildNames">
				<value-of select="cfn:foreignKeyMessage(.,'ChildNames',SheetName,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Assembly.AssemblyType.Check" test="true()" flag="AssemblyType">AssemblyType.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Assembly.AssemblyType.NotNull" test="cfn:validString(AssemblyType)" flag="AssemblyType">
				<value-of select="cfn:notNullMessage(.,'AssemblyType')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Connections">
			<xsl:message terminate="no">Validating Connection Worksheet</xsl:message>
		</iso:rule>
		<iso:rule context="//Connections/Connection" id="COBie.Connections.Connection" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:report id="Connection.ConnectionType.Check" test="true()" flag="ConnectionType">ConnectionType.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Connection.ConnectionType.NotNull" test="cfn:validString(ConnectionType)" flag="ConnectionType">
				<value-of select="cfn:notNullMessage(.,'ConnectionType')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Connection.SheetName.Check" test="true()" flag="SheetName">SheetName.NotNull, SheetName.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Connection.SheetName.NotNull" test="cfn:validString(SheetName)" flag="SheetName">
				<value-of select="cfn:notNullMessage(.,'SheetName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Connection.SheetName.CrossReference" test="lower-case(SheetName)='type' or lower-case(SheetName)='component'" flag="SheetName">
				<value-of select="cfn:assertMsgPrefix(name(.),concat(@Name,',',ConnectionType,',',SheetName,',',RowName1,',',RowName2),'SheetName')"/>: SheetName must be Type or Component, <value-of select="SheetName"/> is not valid.<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Connection.RowName1.Check" test="true()" flag="RowName1">RowName1.NotNull, RowName1.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Connection.RowName1.NotNull" test="cfn:validString(RowName1)" flag="RowName1">
				<value-of select="cfn:notNullMessage(.,'RowName1')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Connection.RowName1.CrossReference" test="cfn:keyMatch(SheetName,RowName1,/)" flag="RowName1">
				<value-of select="cfn:foreignKeyMessage(.,'RowName1',SheetName,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Connection.RowName2.Check" test="true()" flag="RowName2">RowName2.NotNull, RowName2.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Connection.RowName2.NotNull" test="cfn:validString(RowName2)" flag="RowName2">
				<value-of select="cfn:notNullMessage(.,'RowName2')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Connection.RowName2.CrossReference" test="cfn:keyMatch(SheetName,RowName2,/)" flag="RowName2">
				<value-of select="cfn:foreignKeyMessage(.,'RowName2',SheetName,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Connection.RealizingElement.Check" test="true()" flag="RealizingElement">RealizingElement.NotEmpty, RealizingElement.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Connection.RealizingElement.NotEmpty" test="cfn:validStringOrNA(RealizingElement)" flag="RealizingElement">
				<value-of select="cfn:notEmptyMessage(.,'RealizingElement')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Connection.RealizingElement.CrossReference" test="cfn:keyMatch(SheetName,RealizingElement,/) or lower-case(RealizingElement)='n/a'" flag="RealizingElement">
				<value-of select="cfn:foreignKeyMessage(.,'RealizingElement',SheetName,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Connection.PortName1.Check" test="true()" flag="PortName1">PortName1.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Connection.PortName1.NotNull" test="cfn:validString(PortName1)" flag="PortName1">
				<value-of select="cfn:notNullMessage(.,'PortName1')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Connection.PortName2.Check" test="true()" flag="PortName2">PortName2.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Connection.PortName2.NotNull" test="cfn:validString(PortName2)" flag="PortName2">
				<value-of select="cfn:notNullMessage(.,'PortName2')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Spares">
			<xsl:message terminate="no">Validating Spare Worksheet</xsl:message>
		</iso:rule>
		<iso:rule context="//Spares/Spare" id="COBie.Spares.Spare" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:report id="Spare.Name.Check" test="true()" flag="Name">Name.NotNull<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Spare.Name.NotNull" test="cfn:validString(@Name)" flag="Name">
				<value-of select="cfn:notNullMessage(.,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Spare.PrimaryKey.Check" test="true()" flag="PrimaryKey">PrimaryKey.Unique (Name, Category, TypeName)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Spare.PrimaryKey.Unique" test="cfn:isKeyUnique(.)" flag="PrimaryKey">
				<value-of select="cfn:uniqueNameMessage(.,'Name, TypeName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Spare.TypeName.Check" test="true()" flag="TypeName">TypeName.NotNull, TypeName.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Spare.TypeName.NotNull" test="cfn:validString(TypeName)" flag="TypeName">
				<value-of select="cfn:notNullMessage(.,'TypeName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Spare.TypeName.CrossReference" test="key('TypeKey',TypeName)" flag="TypeName">
				<value-of select="cfn:foreignKeyMessage(.,'TypeName','Type','Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Spare.Suppliers.Check" test="true()" flag="Suppliers">Suppliers.NotNull, Suppliers.CrossReference (Contact Sheet)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Spare.Suppliers.NotNull" test="cfn:validString(Suppliers)" flag="Suppliers">
				<value-of select="cfn:notNullMessage(.,'Suppliers')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Spare.Suppliers.CrossReference" test="cfn:delimListInKeys(Suppliers,'Contact',/)" flag="Suppliers">
				<value-of select="cfn:foreignKeyMessage(.,'Suppliers','Contact','Email')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Spare.SetNumber.Check" test="true()" flag="SetNumber">SetNumber.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Spare.SetNumber.NotEmpty" test="cfn:validStringOrNA(SetNumber)" flag="SetNumber">
				<value-of select="cfn:notEmptyMessage(.,'SetNumber')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Spare.PartNumber.Check" test="true()" flag="PartNumber">PartNumber.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Spare.PartNumber.NotEmpty" test="cfn:validStringOrNA(PartNumber)" flag="PartNumber">
				<value-of select="cfn:notEmptyMessage(.,'PartNumber')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Resources">
			<xsl:message terminate="no">Validating Resource Worksheet</xsl:message>
		</iso:rule>
		<iso:rule context="//Resources/Resource" id="COBie.Resources.Resource" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Name"/>
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.Category"/>
		</iso:rule>
		<iso:rule context="//Jobs">
			<xsl:message terminate="no">Validating Job Worksheet</xsl:message>
		</iso:rule>
		<iso:rule context="//Jobs/Job" id="COBie.Jobs.Job" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:report id="Job.Name.Check" test="true()" flag="Name">Name.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.Name.NotNull" test="cfn:validString(@Name)" flag="Name">
				<value-of select="cfn:notNullMessage(.,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.PrimaryKey.Check" test="true()" flag="PrimaryKey">PrimaryKey.Unique (Name,TypeName,TaskNumber)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.PrimaryKey.Unique" test="cfn:isKeyUnique(.)" flag="PrimaryKey">
				<value-of select="cfn:uniqueNameMessage(.,'Name,TypeName,TaskNumber')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.Status.Check" test="true()" flag="Status">Status.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.Status.NotNull" test="cfn:validString(Status)" flag="Status">
				<value-of select="cfn:notNullMessage(.,'Status')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.TypeName.Check" test="true()" flag="TypeName">TypeName.NotNull, TypeName.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.TypeName.NotNull" test="cfn:validString(TypeName)" flag="TypeName">
				<value-of select="cfn:notNullMessage(.,'TypeName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Job.TypeName.CrossReference" test="key('TypeKey',TypeName)" flag="TypeName">
				<value-of select="cfn:foreignKeyMessage(.,'TypeName','Type','Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.Duration.Check" test="true()" flag="Duration">Duration.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.Duration.NotEmpty" test="cfn:validStringOrNA(Duration)" flag="Duration">
				<value-of select="cfn:notEmptyMessage(.,'Duration')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.DurationUnit.Check" test="true()" flag="DurationUnit">DurationUnit.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.DurationUnit.NotEmpty" test="cfn:validStringOrNA(DurationUnit)" flag="DurationUnit">
				<value-of select="cfn:notEmptyMessage(.,'DurationUnit')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.Start.Check" test="true()" flag="Start">Start.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.Start.NotEmpty" test="cfn:validStringOrNA(Start)" flag="Start">
				<value-of select="cfn:notEmptyMessage(.,'Start')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.TaskStartUnit.Check" test="true()" flag="TaskStartUnit">TaskStartUnit.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.TaskStartUnit.NotEmpty" test="cfn:validStringOrNA(TaskStartUnit)" flag="TaskStartUnit">
				<value-of select="cfn:notEmptyMessage(.,'TaskStartUnit')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.Frequency.Check" test="true()" flag="Frequency">Frequency.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.Frequency.NotEmpty" test="cfn:validStringOrNA(Frequency)" flag="Frequency">
				<value-of select="cfn:notEmptyMessage(.,'Frequency')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.FrequencyUnit.Check" test="true()" flag="FrequencyUnit">FrequencyUnit.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.FrequencyUnit.NotEmpty" test="cfn:validStringOrNA(FrequencyUnit)" flag="FrequencyUnit">
				<value-of select="cfn:notEmptyMessage(.,'FrequencyUnit')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.TaskNumber.Check" test="true()" flag="TaskNumber">TaskNumber.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.TaskNumber.NotEmpty" test="cfn:validStringOrNA(TaskNumber)" flag="TaskNumber">
				<value-of select="cfn:notEmptyMessage(.,'TaskNumber')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.Priors.Check" test="true()" flag="Priors">Priors.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.Priors.NotEmpty" test="cfn:validStringOrNA(Priors)" flag="Priors">
				<value-of select="cfn:notEmptyMessage(.,'Priors')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Job.ResourceNames.Check" test="true()" flag="ResourceNames">ResourceNames.NotEmpty, ResourceNames.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Job.ResourceNames.NotEmpty" test="cfn:validStringOrNA(ResourceNames)" flag="ResourceNames">
				<value-of select="cfn:notEmptyMessage(.,'ResourceNames')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Job.ResourceNames.CrossReference" test="ResourceNames='n/a' or cfn:delimListInKeys(ResourceNames,'Resource',/)" flag="ResourceNames">
				<value-of select="cfn:foreignKeyMessage(.,'ResourceNames','Resource','Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Documents">
			<xsl:message terminate="no">Validating Document Worksheet</xsl:message>
		</iso:rule>
		<iso:rule context="//Documents/Document" id="COBie.Documents.Document" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:report id="Document.PrimaryKey.Check" test="true()" flag="PrimaryKey">PrimaryKey.Unique (Name, Stage, SheetName, RowName)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Document.PrimaryKey.Unique" test="cfn:isDocumentKeyUnique(.)" flag="PrimaryKey">
				<value-of select="cfn:uniqueNameMessage(.,'Name,Stage,SheetName,RowName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Document.Name.Check" test="true()" flag="Name">Name.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Document.Name.NotNull" test="cfn:validString(@Name)" flag="Name">
				<value-of select="cfn:notNullMessage(.,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Document.ApprovalBy.Check" test="true()" flag="ApprovalBy">ApprovalBy.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Document.ApprovalBy.NotEmpty" test="cfn:validStringOrNA(ApprovalBy)" flag="ApprovalBy">
				<value-of select="cfn:notEmptyMessage(.,'ApprovalBy')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Document.Stage.Check" test="true()" flag="Stage">Stage.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Document.Stage.NotNull" test="cfn:validString(Stage)" flag="Stage">
				<value-of select="cfn:notNullMessage(.,'Stage')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Document.SheetName.Check" test="true()" flag="SheetName">SheetName.NotNull, SheetNameRowName.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Document.SheetName.NotNull" test="cfn:validString(SheetName)" flag="SheetName">
				<value-of select="cfn:notNullMessage(.,'SheetName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:assert id="Document.SheetNameRowName.Reference" test="cfn:keyMatch(SheetName,RowName,/)" flag="RowName">
				<value-of select="cfn:foreignKeyMessage(.,'RowName',SheetName,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Document.RowName.Check" test="true()" flag="RowName">RowName.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Document.RowName.NotNull" test="cfn:validString(RowName)" flag="RowName">
				<value-of select="cfn:notNullMessage(.,'RowName')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Document.Directory.Check" test="true()" flag="Directory">Directory.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Document.Directory.NotEmpty" test="cfn:validStringOrNA(Directory)" flag="Directory">
				<value-of select="cfn:notEmptyMessage(.,'Directory')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Document.File.Check" test="true()" flag="File">File.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Document.File.NotEmpty" test="cfn:validStringOrNA(File)" flag="File">
				<value-of select="cfn:notEmptyMessage(.,'File')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Document.Reference.Check" test="true()" flag="Reference">Reference.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Document.Reference.NotEmpty" test="cfn:validStringOrNA(Reference)" flag="Reference">
				<value-of select="cfn:notEmptyMessage(.,'Reference')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
		<iso:rule context="//Attributes">
			<xsl:message terminate="no">Validating Attribute Worksheet</xsl:message>
		</iso:rule>
		<iso:rule context="//Attributes/Attribute" id="COBie.Attributes.Attribute" role="WorksheetErrors">
			<iso:extends rule="COBie.Abstract.Created"/>
			<iso:extends rule="COBie.Abstract.External"/>
			<iso:extends rule="COBie.Abstract.Description"/>
			<iso:extends rule="COBie.Abstract.Category"/>
			<iso:report id="Attribute.PrimaryKey.Check" test="true()" flag="PrimaryKey">PrimaryKey.Unique (Name, SheetName, RowName)
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Attribute.PrimaryKey.Unique" test="cfn:isAttributeKeyUnique(.)" flag="PrimaryKey">
				<value-of select="cfn:uniqueNameMessage(.,'Name,SheetName,RowName,Category')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Attribute.Name.Check" test="true()" flag="Name">Name.NotNull
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Attribute.Name.NotNull" test="cfn:validString(@Name)" flag="Name">
				<value-of select="cfn:notNullMessage(.,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Attribute.SheetNameRowName.Check" test="true()" flag="SheetNameRowName">SheetNameRowName.CrossReference
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Attribute.SheetNameRowName.CrossReference" test="cfn:keyMatch(SheetName,RowName,/)" flag="RowName">
				<value-of select="cfn:foreignKeyMessage(.,'RowName',SheetName,'Name')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Attribute.Value.Check" test="true()" flag="Value">Value.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Attribute.Value.NotEmpty" test="cfn:validStringOrNA(Value)" flag="Value">
				<value-of select="cfn:notEmptyMessage(.,'Value')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Attribute.Unit.Check" test="true()" flag="Unit">Unit.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Attribute.Unit.NotEmpty" test="cfn:validStringOrNA(Unit)" flag="Unit">
				<value-of select="cfn:notEmptyMessage(.,'Unit')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
			<iso:report id="Attribute.AllowedValues.Check" test="true()" flag="AllowedValues">AllowedValues.NotEmpty
			<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:report>
			<iso:assert id="Attribute.AllowedValues.NotEmpty" test="cfn:validStringOrNA(AllowedValues)" flag="AllowedValues">
				<value-of select="cfn:notEmptyMessage(.,'AllowedValues')"/>
				<xsl:element name="location">
					<xsl:value-of select="cfn:getLocation(., position())"/>
				</xsl:element>
			</iso:assert>
		</iso:rule>
	</iso:pattern>
</iso:schema>
