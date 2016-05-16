/*
 * Axbase Project
 * Copyright (c) 2016 chunquedong
 * Licensed under the LGPL(http://www.gnu.org/licenses/lgpl.txt), Version 3
 */
package info.axbase.app;

public class Config {
	public String hostUrl = null;
	public boolean updateWhenLaunch = false;
	public boolean forceRestart = false;
	public boolean updateOnlyWifi = true;
	public boolean isDebug = false;
	public boolean copyAsset = true;
	public long checkUpdateTime = 15 * 60 * 1000;
}
