/*
 * Axbase Project
 * Copyright (c) 2016 chunquedong
 * Licensed under the LGPL(http://www.gnu.org/licenses/lgpl.txt), Version 3
 */
package info.axbase.plugin;

import java.util.Map;

class AppClassLoader extends ClassLoader {
	private AxPluginManager pluginManager;
	
	AppClassLoader(ClassLoader parentLoader, AxPluginManager pluginManager) {
		super(parentLoader);
		this.pluginManager = pluginManager;
	}

	private Class<?> safeLoader(String className, ClassLoader loader) {
		try {
			return loader.loadClass(className);
		} catch (ClassNotFoundException e) {
		}
		return null;
	}

	private Class<?> tryLoadClassInPlugin(String className) {
		Class<?> clazz = null;
		// find in all plugin
		if (className != null) {
			for (Map.Entry<String, PluginInfo> entry : pluginManager
					.getPluginInfoMap().entrySet()) {
				clazz = safeLoader(className, entry.getValue().getClassLoader());
				if (clazz != null)
					return clazz;
			}
		}
		return null;
	}

	@Override
	public Class<?> loadClass(String className) throws ClassNotFoundException {
		try {
			return super.loadClass(className);
		} catch (ClassNotFoundException e) {
			Class<?> clazz = null;
			synchronized(pluginManager) {
				clazz = tryLoadClassInPlugin(className);
			}
			if (clazz == null) {
				throw e;
			} else {
				return clazz;
			}
		}
	}
}
