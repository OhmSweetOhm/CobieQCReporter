package org.bimserver.plugins.web;

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

import org.bimserver.plugins.Plugin;

import javax.servlet.http.HttpServletResponse;

public interface WebModulePlugin extends Plugin {

	/**
	 * Handles the individual requests, just like a servlet
	 * 
	 * @param request The HTTP request
	 * @param response The HTTP response
	 */
	boolean service(String requestUrl, HttpServletResponse response);
}