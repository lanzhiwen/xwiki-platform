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
package org.xwiki.notifications.filters.watch;

import org.xwiki.component.annotation.Role;
import org.xwiki.model.reference.DocumentReference;
import org.xwiki.notifications.NotificationException;
import org.xwiki.stability.Unstable;

/**
 * Manage the watched entities.
 * We call `Watched Entities` the locations or the users for that we receive all events.
 *
 * @version $Id$
 * @since 9.8RC1
 */
@Unstable
@Role
public interface WatchedEntitiesManager
{
    /**
     * Add a filter to watch the specified entity.
     *
     * @param user user that will watch the entity
     * @param entity the entity to watch
     * @throws NotificationException if an error happens
     */
    void watchEntity(DocumentReference user, WatchedEntityReference entity) throws NotificationException;

    /**
     * @param user a user
     * @param entity the entity
     * @return either or not the entity is already watched by the given user
     * @throws NotificationException if an error happens
     */
    boolean isEntityWatched(DocumentReference user, WatchedEntityReference entity) throws NotificationException;
}