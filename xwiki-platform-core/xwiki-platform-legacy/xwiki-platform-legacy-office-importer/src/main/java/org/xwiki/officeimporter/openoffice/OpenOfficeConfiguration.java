/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.officeimporter.openoffice;

import org.xwiki.component.annotation.Role;
import org.xwiki.officeimporter.server.OfficeServerConfiguration;

/**
 * Configuration properties for office importer module.
 * <p>
 * These configuration properties are defined in XWiki's global configuration file using the prefix of "officeimporter".
 * </p>
 * 
 * @version $Id$
 * @since 1.8RC3
 * @deprecated since 5.0M2, use the {@link OfficeServerConfiguration} instead.
 */
@Role
@Deprecated
public interface OpenOfficeConfiguration extends OfficeServerConfiguration
{
    /**
     * Indicates an internally managed office server instance.
     */
    int SERVER_TYPE_INTERNAL = 0;

    /**
     * Indicates an externally managed locally deployed office server instance.
     */
    int SERVER_TYPE_EXTERNAL_LOCAL = 1;

    /**
     * Indicates an externally managed remotely deployed office server instance.
     */
    int SERVER_TYPE_EXTERNAL_REMOTE = 2;
}
