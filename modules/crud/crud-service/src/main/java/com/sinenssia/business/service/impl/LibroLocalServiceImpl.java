/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sinenssia.business.service.impl;

import com.sinenssia.business.model.Libro;
import com.sinenssia.business.model.impl.LibroImpl;
import com.sinenssia.business.service.base.LibroLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
public class LibroLocalServiceImpl extends LibroLocalServiceBaseImpl {
	
	public void addNewLibro(long groupId, long companyId, long userId,
			String userName, String titulo, String genero
			) {
			final Libro libro = new LibroImpl();
			libro.setLibroId(counterLocalService.increment());
			libro.setGroupId(groupId);
			libro.setCompanyId(companyId);
			libro.setUserId(userId);
			libro.setUserName(userName);
			libro.setTitulo(titulo);
			libro.setGenero(genero);

			addLibro(libro);
			//Cuando hagamos un build este método se generará
			//LibroLocalServiceUtil
	}
	
}