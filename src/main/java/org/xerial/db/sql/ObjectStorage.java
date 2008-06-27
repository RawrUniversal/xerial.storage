/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *--------------------------------------------------------------------------*/
//--------------------------------------
// XerialJ
//
// ObjectStorage.java
// Since: Jun 26, 2008 2:33:25 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.sql;

import java.util.Collection;
import java.util.List;

import org.xerial.db.DBException;

/**
 * Ruby on Rails-Style Relational Database Access Interface
 * 
 * Conventions used in the {@link ObjectStorage}:
 * 
 * <ul>
 * <li> column name id (setId(), getId()) is considered as an integer primary
 * key (auto-increment) value. </li>
 * <li> createdAt, updatedAt column names correspond to {@link DateTimeType} ({@link java.util.Date} )
 * of the creation, update time of the instance, respectively. </li>
 * <li> one-to-many relationship
 * 
 * </li>
 * </ul>
 * 
 * @author leo
 * 
 */
public interface ObjectStorage
{

    /**
     * Register a class type that can be used as save/load unit to the table.
     * That is each row in the table corresponds to an instance of the given
     * classType.
     * 
     * If no such table exists in the database, this method creates a new table
     * for the given class type.
     * 
     * @param <T>
     * @param tableName
     *            the table Name
     * @param classType
     *            class type corresponding to each row of the table
     * @throws DBException
     */
    public <T> void register(String tableName, Class<T> classType) throws DBException;

    /**
     * Register a class type that can be used as save/load unit to the table.
     * That is each row in the table corresponds to an instance of the given
     * classType.
     * 
     * The table name is classType.getName().toLowerCase();
     * 
     * If no such table exists in the database, this method creates a new table
     * for the given class type.
     * 
     * @param <T>
     * @param classType
     * @throws DBException
     */
    public <T> void register(Class<T> classType) throws DBException;

    /**
     * Associate type T to type U with one-to-one relationship
     * 
     * @param <T>
     * @param <U>
     * @param from
     * @param to
     * @throws DBException
     */
    public <T, U> void oneToOne(Class<T> from, Class<U> to) throws DBException;

    /**
     * Associate type T to type U with one-to-many relationship. That means T
     * and U has the following table structure:
     * 
     * <pre>
     * T: (id, ...)
     * U: (id, TId, ...) 
     * </pre>
     * 
     * For example, when T = Student and U is report, the table structure will
     * be as follows:
     * 
     * <pre>
     * Student (id, name, ...)
     * Report  (id, studentId, ...)
     * </pre>
     * 
     * 
     * 
     * @param <T>
     * @param <U>
     * @param from
     * @param many
     * @throws DBException
     */
    public <T, U> void oneToMany(Class<T> from, Class<U> to) throws DBException;

    public <T, U> U getOne(T startPoint, Class<U> associatedType) throws DBException;

    public <T, U> U getOne(T startPoint, Class<U> associatedType, int idOfU) throws DBException;

    public <T, U> U getOne(Class<T> startPointClass, int idOfT, Class<U> associatedType) throws DBException;

    public <T, U> U getOne(Class<T> startPointClass, int idOfT, Class<U> associatedType, int idOfU) throws DBException;

    public <T, U> List<U> getAll(T startPoint, Class<U> associatedType) throws DBException;

    public <T, U> List<U> getAll(T startPoint, Class<U> associatedType, String additionlWhereClauseCondition)
            throws DBException;

    public <T, U> List<U> getAll(Class<T> startPointClass, int idOfT, Class<U> associtedType) throws DBException;

    public <T, U> List<U> getAll(Class<T> startPointClass, int idOfT, Class<U> associtedType,
            String additionalWhereCondition) throws DBException;

    public <T, U> T getParent(U child) throws DBException;

    public <T, U> T getParent(Class<U> childClass, int idOfU) throws DBException;

    public <S, T, U> List<S> join(Class<T> left, Class<U> right, Class<S> targetType) throws DBException;

    /**
     * Create a new object of the type U associated with the given parent object
     * 
     * @param <T>
     * @param <U>
     * @param parentBean
     * @param associatedObject
     */
    public <T, U> U create(T parentObject, U associatedObject) throws DBException;

    /**
     * Create a new row in the database. The returned object is the same
     * instance with the given one but its ID attribute is set (using setId()
     * method) to the ID of the newly created object.
     * 
     * @param <T>
     * @param the
     *            object initial value of the object (id attribute is ignored)
     * @return the given object instance whose ID is set.
     */
    public <T> T create(T object) throws DBException;

    /**
     * Save the object data in the database
     * 
     * @param <T>
     * @param object
     *            the object to be stored in the database
     */
    public <T> void save(T object) throws DBException;

    /**
     * Save the all objects in the given collection
     * 
     * @param <T>
     * @param classType
     *            the object type to be saved
     * @param object
     *            the collection of the objects to be saved
     * @throws DBException
     */
    public <T> void saveAll(Class<T> classType, Collection<T> object) throws DBException;

    /**
     * Retrieves the object from the database that matches the given id value
     * 
     * @param <T>
     * @param id
     *            the ID of the object
     * @return the retrieved object, or null if not found
     * @throws DBException
     */
    public <T> T get(Class<T> classType, int id) throws DBException;

    /**
     * Retrieves an object using an SQL statement
     * 
     * @param <T>
     * @param classType
     *            the object type to be retrieved
     * @param sql
     *            the SQL statment
     * @return the retrieved object. or null if not found
     * @throws DBException
     */
    public <T> T get(Class<T> classType, String sql) throws DBException;

    /**
     * Retrives all object instances in the corresponding table
     * 
     * @param <T>
     * @param classType
     *            the object type to be retrieved
     * @return the list of objects of the specified type
     * @throws DBException
     */
    public <T> List<T> getAll(Class<T> classType) throws DBException;

    /**
     * Retrives object instances using an SQL statment.
     * 
     * @param <T>
     * @param classType
     *            the object type to be retrieved
     * @param sql
     *            the SQL statement
     * @return
     * @throws DBException
     */
    public <T> List<T> getAll(Class<T> classType, String sql) throws DBException;

}