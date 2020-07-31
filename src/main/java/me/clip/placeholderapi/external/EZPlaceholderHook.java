/*
 * This file is part of PlaceholderAPI
 *
 * PlaceholderAPI
 * Copyright (c) 2015 - 2020 PlaceholderAPI Team
 *
 * PlaceholderAPI free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlaceholderAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package me.clip.placeholderapi.external;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.apache.commons.lang.Validate;
import org.bukkit.plugin.Plugin;

public abstract class EZPlaceholderHook extends PlaceholderExpansion {

    private final String identifier;
    private final Plugin plugin;
    private final String pluginName;

    public EZPlaceholderHook(Plugin plugin, String identifier) {
        Validate.notNull(plugin, "Plugin can not be null!");
        Validate.isTrue(identifier != null && !identifier.isEmpty(), "Placeholder name can not be null or empty!");
        this.identifier = identifier;
        this.pluginName = plugin.getName();
        this.plugin = plugin;
    }

    @Override
    public boolean persist(){
        return true;
    }

    @Override
    public boolean canRegister(){
        return true;
    }

    @Override
    public String getAuthor(){
        return plugin.getDescription().getAuthors().toString();
    }

    @Override
    public String getIdentifier(){
        return this.identifier;
    }

    @Override
    public String getVersion(){
        return plugin.getDescription().getVersion();
    }

    //Old methods
    public boolean isHooked() {
        return isRegistered();
    }

    public boolean hook() {
        return register();
    }

    public String getPlaceholderName() {
        return this.identifier;
    }

    public String getPluginName() {
        return this.pluginName;
    }
}

