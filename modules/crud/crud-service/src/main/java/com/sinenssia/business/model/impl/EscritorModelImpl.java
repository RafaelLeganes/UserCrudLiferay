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

package com.sinenssia.business.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;

import com.sinenssia.business.model.Escritor;
import com.sinenssia.business.model.EscritorModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Escritor service. Represents a row in the &quot;LIBRO_Escritor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EscritorModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EscritorImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EscritorImpl
 * @generated
 */
public class EscritorModelImpl
	extends BaseModelImpl<Escritor> implements EscritorModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a escritor model instance should use the <code>Escritor</code> interface instead.
	 */
	public static final String TABLE_NAME = "LIBRO_Escritor";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"escritorId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"nombre", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("escritorId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("nombre", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table LIBRO_Escritor (uuid_ VARCHAR(75) null,escritorId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,nombre VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table LIBRO_Escritor";

	public static final String ORDER_BY_JPQL = " ORDER BY escritor.nombre ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY LIBRO_Escritor.nombre ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.sinenssia.business.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.sinenssia.business.model.Escritor"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.sinenssia.business.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.sinenssia.business.model.Escritor"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.sinenssia.business.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.sinenssia.business.model.Escritor"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long NOMBRE_COLUMN_BITMASK = 4L;

	public static final long UUID_COLUMN_BITMASK = 8L;

	public static final String MAPPING_TABLE_LIBRO_LIBROS_ESCRITORES_NAME =
		"LIBRO_Libros_Escritores";

	public static final Object[][]
		MAPPING_TABLE_LIBRO_LIBROS_ESCRITORES_COLUMNS = {
			{"companyId", Types.BIGINT}, {"escritorId", Types.BIGINT},
			{"libroId", Types.BIGINT}
		};

	public static final String
		MAPPING_TABLE_LIBRO_LIBROS_ESCRITORES_SQL_CREATE =
			"create table LIBRO_Libros_Escritores (companyId LONG not null,escritorId LONG not null,libroId LONG not null,primary key (escritorId, libroId))";

	public static final boolean FINDER_CACHE_ENABLED_LIBRO_LIBROS_ESCRITORES =
		GetterUtil.getBoolean(
			com.sinenssia.business.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.LIBRO_Libros_Escritores"),
			true);

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.sinenssia.business.service.util.ServiceProps.get(
			"lock.expiration.time.com.sinenssia.business.model.Escritor"));

	public EscritorModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _escritorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEscritorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _escritorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Escritor.class;
	}

	@Override
	public String getModelClassName() {
		return Escritor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Escritor, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Escritor, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Escritor, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Escritor)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Escritor, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Escritor, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Escritor)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Escritor, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Escritor, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Escritor>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Escritor.class.getClassLoader(), Escritor.class,
			ModelWrapper.class);

		try {
			Constructor<Escritor> constructor =
				(Constructor<Escritor>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Escritor, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Escritor, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Escritor, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Escritor, Object>>();
		Map<String, BiConsumer<Escritor, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Escritor, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<Escritor, Object>() {

				@Override
				public Object apply(Escritor escritor) {
					return escritor.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<Escritor, Object>() {

				@Override
				public void accept(Escritor escritor, Object uuidObject) {
					escritor.setUuid((String)uuidObject);
				}

			});
		attributeGetterFunctions.put(
			"escritorId",
			new Function<Escritor, Object>() {

				@Override
				public Object apply(Escritor escritor) {
					return escritor.getEscritorId();
				}

			});
		attributeSetterBiConsumers.put(
			"escritorId",
			new BiConsumer<Escritor, Object>() {

				@Override
				public void accept(Escritor escritor, Object escritorIdObject) {
					escritor.setEscritorId((Long)escritorIdObject);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<Escritor, Object>() {

				@Override
				public Object apply(Escritor escritor) {
					return escritor.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<Escritor, Object>() {

				@Override
				public void accept(Escritor escritor, Object groupIdObject) {
					escritor.setGroupId((Long)groupIdObject);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<Escritor, Object>() {

				@Override
				public Object apply(Escritor escritor) {
					return escritor.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<Escritor, Object>() {

				@Override
				public void accept(Escritor escritor, Object companyIdObject) {
					escritor.setCompanyId((Long)companyIdObject);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<Escritor, Object>() {

				@Override
				public Object apply(Escritor escritor) {
					return escritor.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<Escritor, Object>() {

				@Override
				public void accept(Escritor escritor, Object userIdObject) {
					escritor.setUserId((Long)userIdObject);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<Escritor, Object>() {

				@Override
				public Object apply(Escritor escritor) {
					return escritor.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<Escritor, Object>() {

				@Override
				public void accept(Escritor escritor, Object userNameObject) {
					escritor.setUserName((String)userNameObject);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<Escritor, Object>() {

				@Override
				public Object apply(Escritor escritor) {
					return escritor.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<Escritor, Object>() {

				@Override
				public void accept(Escritor escritor, Object createDateObject) {
					escritor.setCreateDate((Date)createDateObject);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<Escritor, Object>() {

				@Override
				public Object apply(Escritor escritor) {
					return escritor.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<Escritor, Object>() {

				@Override
				public void accept(
					Escritor escritor, Object modifiedDateObject) {

					escritor.setModifiedDate((Date)modifiedDateObject);
				}

			});
		attributeGetterFunctions.put(
			"nombre",
			new Function<Escritor, Object>() {

				@Override
				public Object apply(Escritor escritor) {
					return escritor.getNombre();
				}

			});
		attributeSetterBiConsumers.put(
			"nombre",
			new BiConsumer<Escritor, Object>() {

				@Override
				public void accept(Escritor escritor, Object nombreObject) {
					escritor.setNombre((String)nombreObject);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getEscritorId() {
		return _escritorId;
	}

	@Override
	public void setEscritorId(long escritorId) {
		_escritorId = escritorId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getNombre() {
		if (_nombre == null) {
			return "";
		}
		else {
			return _nombre;
		}
	}

	@Override
	public void setNombre(String nombre) {
		_columnBitmask = -1L;

		if (_originalNombre == null) {
			_originalNombre = _nombre;
		}

		_nombre = nombre;
	}

	public String getOriginalNombre() {
		return GetterUtil.getString(_originalNombre);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Escritor.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Escritor.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Escritor toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Escritor>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EscritorImpl escritorImpl = new EscritorImpl();

		escritorImpl.setUuid(getUuid());
		escritorImpl.setEscritorId(getEscritorId());
		escritorImpl.setGroupId(getGroupId());
		escritorImpl.setCompanyId(getCompanyId());
		escritorImpl.setUserId(getUserId());
		escritorImpl.setUserName(getUserName());
		escritorImpl.setCreateDate(getCreateDate());
		escritorImpl.setModifiedDate(getModifiedDate());
		escritorImpl.setNombre(getNombre());

		escritorImpl.resetOriginalValues();

		return escritorImpl;
	}

	@Override
	public int compareTo(Escritor escritor) {
		int value = 0;

		value = getNombre().compareTo(escritor.getNombre());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Escritor)) {
			return false;
		}

		Escritor escritor = (Escritor)object;

		long primaryKey = escritor.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		_originalUuid = _uuid;

		_originalGroupId = _groupId;

		_setOriginalGroupId = false;

		_originalCompanyId = _companyId;

		_setOriginalCompanyId = false;

		_setModifiedDate = false;
		_originalNombre = _nombre;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Escritor> toCacheModel() {
		EscritorCacheModel escritorCacheModel = new EscritorCacheModel();

		escritorCacheModel.uuid = getUuid();

		String uuid = escritorCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			escritorCacheModel.uuid = null;
		}

		escritorCacheModel.escritorId = getEscritorId();

		escritorCacheModel.groupId = getGroupId();

		escritorCacheModel.companyId = getCompanyId();

		escritorCacheModel.userId = getUserId();

		escritorCacheModel.userName = getUserName();

		String userName = escritorCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			escritorCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			escritorCacheModel.createDate = createDate.getTime();
		}
		else {
			escritorCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			escritorCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			escritorCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		escritorCacheModel.nombre = getNombre();

		String nombre = escritorCacheModel.nombre;

		if ((nombre != null) && (nombre.length() == 0)) {
			escritorCacheModel.nombre = null;
		}

		return escritorCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Escritor, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Escritor, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Escritor, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Escritor)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Escritor, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Escritor, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Escritor, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Escritor)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Escritor>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _escritorId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _nombre;
	private String _originalNombre;
	private long _columnBitmask;
	private Escritor _escapedModel;

}