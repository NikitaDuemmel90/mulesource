/*
 * generated by Xtext 2.19.0
 */
package de.ubt.ai1.mule.ui.internal;

import java.util.Collections;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;
import org.osgi.framework.BundleContext;

import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ubt.ai1.mule.MuLERuntimeModule;
import de.ubt.ai1.mule.ui.MuLEUiModule;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class MuleActivator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "de.ubt.ai1.mule.ui";
	public static final String DE_UBT_AI1_MULE_MULE = "de.ubt.ai1.mule.MuLE";
	
	private static final Logger logger = Logger.getLogger(MuleActivator.class);
	
	private static MuleActivator INSTANCE;
	
	private Map<String, Injector> injectors = Collections.synchronizedMap(Maps.<String, Injector> newHashMapWithExpectedSize(1));
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().resetPerspective();
		} catch (Exception e) {
		}
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().resetPerspective();
		} catch (Exception e) {
		}
		injectors.clear();
		INSTANCE = null;
		super.stop(context);
	}
	
	public static MuleActivator getInstance() {
		return INSTANCE;
	}
	
	public Injector getInjector(String language) {
		synchronized (injectors) {
			Injector injector = injectors.get(language);
			if (injector == null) {
				injectors.put(language, injector = createInjector(language));
			}
			return injector;
		}
	}
	
	protected Injector createInjector(String language) {
		try {
			com.google.inject.Module runtimeModule = getRuntimeModule(language);
			com.google.inject.Module sharedStateModule = getSharedStateModule();
			com.google.inject.Module uiModule = getUiModule(language);
			com.google.inject.Module mergedModule = Modules2.mixin(runtimeModule, sharedStateModule, uiModule);
			return Guice.createInjector(mergedModule);
		} catch (Exception e) {
			logger.error("Failed to create injector for " + language);
			logger.error(e.getMessage(), e);
			throw new RuntimeException("Failed to create injector for " + language, e);
		}
	}
	
	protected com.google.inject.Module getRuntimeModule(String grammar) {
		if (DE_UBT_AI1_MULE_MULE.equals(grammar)) {
			return new MuLERuntimeModule();
		}
		throw new IllegalArgumentException(grammar);
	}
	
	protected com.google.inject.Module getUiModule(String grammar) {
		if (DE_UBT_AI1_MULE_MULE.equals(grammar)) {
			return new MuLEUiModule(this);
		}
		throw new IllegalArgumentException(grammar);
	}
	
	protected com.google.inject.Module getSharedStateModule() {
		return new SharedStateModule();
	}
	
	
}
