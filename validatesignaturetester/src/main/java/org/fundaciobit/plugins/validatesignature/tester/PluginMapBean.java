package org.fundaciobit.plugins.validatesignature.tester;

import org.fundaciobit.pluginsib.validatesignature.api.IValidateSignaturePlugin;
import org.fundaciobit.pluginsib.core.v3.utils.PluginsManager;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

@Named
@ApplicationScoped
public class PluginMapBean {

    private static final Logger LOG = Logger.getLogger(PluginMapBean.class.getName());

    private final Map<String, IValidateSignaturePlugin> pluginMap = new HashMap<>();

    @PostConstruct
    protected void init() {
        String configDir = System.getProperty("org.fundaciobit.pluginsib.validatesignature.path");
        Properties properties = new Properties();
        try (var inputStream = new FileInputStream(configDir + "/plugin.properties")) {
            properties.load(inputStream);
        } catch (IOException ioException) {
            throw new RuntimeException("Error llegint plugin.properties", ioException);
        }

        String[] pluginNames = properties.getProperty("plugins.validatesignature").split(",");
        for (String pluginName : pluginNames) {
            String classProperty = "pluginsib.validatesignature." + pluginName + ".class";
            IValidateSignaturePlugin plugin = (IValidateSignaturePlugin) PluginsManager
                    .instancePluginByProperty(classProperty, "", properties);
            pluginMap.put(pluginName, plugin);
            LOG.info("Inicialitzat: " + pluginName);
        }
    }

    public IValidateSignaturePlugin getPlugin(String pluginName) {
        return pluginMap.get(pluginName);
    }

    public boolean containsPlugin(String pluginName) {
        return pluginMap.containsKey(pluginName);
    }

    public Set<String> getPluginNames() {
        return pluginMap.keySet();
    }
}
