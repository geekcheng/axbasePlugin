package info.axbase.plugin;

import dalvik.system.DexClassLoader;

public class PluginClassLoader extends DexClassLoader {
	
	PluginInfo plugin;
	
	public PluginClassLoader(String dexPath, String optimizedDirectory,
			String libraryPath, ClassLoader parent) {
		super(dexPath, optimizedDirectory, libraryPath, parent);
	}

}
