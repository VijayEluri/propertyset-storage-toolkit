/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.atlassian.plugins.studio.storage.toolkit;

/**
 * Scope Bridge
 * <p/>
 * User: leonidmaslov
 * Date: 12/8/10
 * Time: 3:10 AM
 */
@SuppressWarnings({"JavaDoc"})
public interface Scope<U> {
    ScopeDescriptor getDescriptor();

    /**
     * Provides underlying PropertySet to delegate actual work to
     *
     * @param context scope context like Issue, Project, User
     * @return storage facade
     * @throws StorageException
     */
    StorageFacade<Scope<U>> load(U context) throws StorageException;


    /**
     * Removes ALL the related items for this particular scope object
     *
     * @param storage storage instance to delete
     * @throws StorageException
     */
    void remove(StorageFacade<Scope<U>> storage) throws StorageException;


    void remove(U context) throws StorageException;

    /**
     * removes    all the scope instances - like all Project configurations
     * <p/>
     * Note: please use with caution
     *
     * @throws StorageException
     */
    void removeAll() throws StorageException;
}
